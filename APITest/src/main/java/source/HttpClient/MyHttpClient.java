package source.HttpClient;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;
import source.control.GetCases;
import source.extentReport.ReportTemplate;
import source.utls.GetTime;
import source.utls.OperationFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MyHttpClient {

    private static CookieStore cookieStore = new BasicCookieStore();
    private static CloseableHttpClient httpClient = HttpClients.custom()
            .setConnectionTimeToLive(6000, TimeUnit.MILLISECONDS).build();
    private static HttpGet httpGet;
    private static HttpPost httpPost;
    private static HttpResponse response;
    private static String result;
    private static String reportTemplateStartTime;
    private static String reportTemplateEndTime;
    private static String reportTemplateTakenTime;
    private static String reportPath = ReportTemplate.filePath + "接口测试报告" + GetTime.getNowTime(GetTime.dateFormat3) + ".html";

/*    public static void main(String[] args) throws Exception {
        forTest();
    }*/

    @Test
    public static void doT() throws Exception{
        forTest();
    }

    public static void forTest() throws Exception{
        HttpClientContext httpClientContext = HttpClientContext.create();
        httpClientContext.setCookieStore(cookieStore);
        String apiTableName = "umAddress";
        //写入测试报告第一段
        OperationFile.write(reportPath, ReportTemplate.tp1);
        goAPI(apiTableName);
        OperationFile.write(reportPath, ReportTemplate.getlastHTML());
        String lastReportHtml = OperationFile.getFileValue(reportPath);
        lastReportHtml = lastReportHtml.replace("caseNumFail", "" + ReportTemplate.caseNumFail);
        lastReportHtml = lastReportHtml.replace("caseNumSuccess", "" + ReportTemplate.caseNumSuccess);
        OperationFile.clearFile(reportPath);
        OperationFile.write(reportPath, lastReportHtml.replace("Linebreak", "\n"));
    }


    public static void goAPI(String apiTableName) throws Exception {
        MyHttpClient myHttpClient = new MyHttpClient();
        List<Map<String, Map<String, Object>>> apiMapList = GetCases.getTestCases(apiTableName);
        int apiCount = apiMapList.size();
        for (int i=1; i<apiCount; i++) {
            myHttpClient.operationRequest(apiMapList,i);
        }
    }

    public void operationRequest(List<Map<String, Map<String, Object>>> apiMapList,int apiNum) throws Exception{
        Map<String, Map<String, Object>> apiMap;
        apiMap = apiMapList.get(apiNum);
        String url = apiMapList.get(0).get("caseMsgMap").get("api_url") + apiMap.get("caseMsgMap").get("api_url").toString();
        String casesTableName = apiMap.get("caseMsgMap").get("api_casesTableName").toString();
        List<Map<String, Map<String, Object>>> casesMapList = GetCases.getTestCases(casesTableName);
        for (Map<String, Map<String, Object>> requestMap : casesMapList) {
            Map<String, Object> caseMsgMap;
            Map<String, Object> requestParamMap;
            Map<String, Object> requestParamMapNew = new HashMap<String, Object>();
            caseMsgMap = requestMap.get("caseMsgMap");
            requestParamMap = requestMap.get("requestParamMap");
            requestParamMapNew.put("param", requestParamMap);
            requestParamMapNew.put("url", url);
            requestParamMapNew.put("api_requestmethod",apiMap.get("caseMsgMap").get("api_requestmethod"));
            MyHttpClient myHttpClient = new MyHttpClient();
            List<Object> resultList = myHttpClient.doRequest(requestParamMapNew);
            myHttpClient.verify(resultList, caseMsgMap);
            caseMsgMap.put("reportTemplateStartTime", reportTemplateStartTime);
            caseMsgMap.put("reportTemplateEndTime", reportTemplateEndTime);
            reportTemplateTakenTime = GetTime.getTimeDifference(reportTemplateStartTime, reportTemplateEndTime);
            caseMsgMap.put("reportTemplateTakenTime", reportTemplateTakenTime);
            caseMsgMap.put("api_id", apiMap.get("caseMsgMap").get("api_id"));
            caseMsgMap.put("api_description", apiMap.get("caseMsgMap").get("api_description"));
            caseMsgMap.put("api_url", apiMap.get("caseMsgMap").get("api_url"));
            caseMsgMap.put("requestParamMap", requestParamMap);
            System.out.println("校验结果：" + caseMsgMap);
            String reportHtml = ReportTemplate.getTemplate(caseMsgMap);
            //写入测试报告每次的结果
            OperationFile.write(reportPath, reportHtml);
        }
    }

    //校验接口响应结果，并将结果记录在caseMsgMap中
    public void verify(List<Object> resultList, Map<String, Object> caseMsgMap) {
        Boolean verifyStatus;
        String resultStr = resultList.get(1).toString();
        if (caseMsgMap.get("cases_verifytype").equals("contains")) {
            verifyStatus = resultStr.contains(caseMsgMap.get("cases_expect").toString());
            caseMsgMap.put("resultVerify", verifyStatus);
            caseMsgMap.put("resultActual", resultStr);
        } else {
            System.out.println("无法找到用例中的verifytype字段或其对应的值不包含在已定义的范围内。");
        }
    }

    public List<Object> doRequest(Map<String, Object> requestMap) throws Exception {
        reportTemplateStartTime = GetTime.getNowTime(GetTime.dateFormat2);
        String url = requestMap.get("url").toString();
        String requestMethod = requestMap.get("api_requestmethod").toString();
        if (requestMethod.equals("postJson")){
            doPostJson(url,requestMap);
        }else if (requestMethod.equals("getParam")) {
            doGet(url,requestMap);
        }
        reportTemplateEndTime = GetTime.getNowTime(GetTime.dateFormat2);
        result = EntityUtils.toString(response.getEntity(), "UTF-8");
        List<Object> resultList = new ArrayList<Object>();
        resultList.add(response);
        resultList.add(result);
        return resultList;
    }

    public void doGet(String url ,Map<String, Object> requestMap) throws Exception{
        Map<String ,Object> paramMap = (Map<String, Object>) requestMap.get("param");
        String getParam = "?";
        for (String key :paramMap.keySet()) {
            getParam = getParam + key + "=" + paramMap.get(key) + "&";
        }
        httpGet = new HttpGet(url + getParam);
        response = httpClient.execute(httpGet);
    }

    public void doPostJson(String url ,Map<String, Object> requestMap) throws Exception{
        JSONObject param = new JSONObject(requestMap.get("param").toString().replace("=", ":"));
        httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type", "application/json");
        String paramStr = param.toString().replace(":null", "");
        StringEntity entiy = new StringEntity(paramStr, "UTF-8");
        httpPost.setEntity(entiy);
        response = httpClient.execute(httpPost);
    }

}
