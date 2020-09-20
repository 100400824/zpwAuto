package source.HttpClient;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import source.control.GetCases;
import source.extentReport.ReportTemplate;
import source.utls.GetConfig;
import source.utls.GetTime;
import source.utls.OperationFile;

import java.util.*;

public class MyHttpClient {

    private CookieStore cookieStore = new BasicCookieStore();
    private DefaultHttpClient httpClient = new DefaultHttpClient();
    private HttpGet httpGet;
    private HttpPost httpPost;
    private HttpResponse response;
    private String result;
    private static String reportTemplateStartTime;
    private static String reportTemplateEndTime;
    private static String reportTemplateTakenTime;
    public static String reportPath = ReportTemplate.filePath + "接口测试报告" + GetTime.getNowTime(GetTime.dateFormat3) + ".html";

    public static void main(String[] args) throws Exception {
        //写入测试报告第一段
        OperationFile.write(reportPath, ReportTemplate.tp1);
        for (int i=1;i<=10;i++) {
            goAPI();
        }
        OperationFile.write(reportPath, ReportTemplate.getlastHTML());
        String lastReportHtml = OperationFile.getFileValue(reportPath);
        lastReportHtml = lastReportHtml.replace("caseNumFail", "" + ReportTemplate.caseNumFail);
        lastReportHtml = lastReportHtml.replace("caseNumSuccess", "" + ReportTemplate.caseNumSuccess);
        OperationFile.clearFile(reportPath);
        OperationFile.write(reportPath, lastReportHtml.replace("Linebreak", "\n"));
    }

    public static void goAPI() throws Exception {
        String apiTableName = "umAddress";
        List<Map<String, Map<String, Object>>> apiMapList = GetCases.getTestCases(apiTableName);
        Map<String, Map<String, Object>> apiMap;
        apiMap = apiMapList.get(1);
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
            MyHttpClient myHttpClient = new MyHttpClient();
            List<Object> resultList = myHttpClient.doPostJson(requestParamMapNew);
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

    public List<Object> doPostJson(Map<String, Object> requestMap) throws Exception {
        httpClient.setCookieStore(cookieStore);
        String url = requestMap.get("url").toString();
        JSONObject param = new JSONObject(requestMap.get("param").toString().replace("=", ":"));
        httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type", "application/json");
        String paramStr = param.toString().replace(":null", "");
        StringEntity entiy = new StringEntity(paramStr, "UTF-8");
        httpPost.setEntity(entiy);
        reportTemplateStartTime = GetTime.getNowTime(GetTime.dateFormat2);
        response = httpClient.execute(httpPost);
        reportTemplateEndTime = GetTime.getNowTime(GetTime.dateFormat2);
        result = EntityUtils.toString(response.getEntity(), "UTF-8");
        List<Object> resultList = new ArrayList<Object>();
        resultList.add(response);
        resultList.add(result);
        return resultList;
    }

}
