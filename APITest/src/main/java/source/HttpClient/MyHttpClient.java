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
import source.utls.GetConfig;

import java.util.*;

public class MyHttpClient {

    private String url, uri;
    private CookieStore cookieStore = new BasicCookieStore();
    private DefaultHttpClient client = new DefaultHttpClient();
    private HttpGet httpGet;
    private HttpPost httpPost;
    private HttpResponse response;
    private String result;

    public static void main(String[] args) throws Exception {
        String url = "http://localhost:7127/userManage/login";
        String tableName = "logincases";
        List<Map<String, Map<String, Object>>> resultMapList = GetCases.getTestCases(tableName);
        for (Map<String, Map<String, Object>> requestMap : resultMapList) {
            Map<String, Object> caseMsgMap;
            Map<String, Object> requestParamMap;
            Map<String, Object> requestParamMapNew = new HashMap<String, Object>();
            caseMsgMap = requestMap.get("caseMsgMap");
            requestParamMap = requestMap.get("requestParamMap");
            requestParamMapNew.put("param", requestParamMap);
            requestParamMapNew.put("url", url);
            MyHttpClient myHttpClient = new MyHttpClient();
            List<Object> resultList = myHttpClient.doPostJson(requestParamMapNew);
//            System.out.println(resultList);
            myHttpClient.verify(resultList, caseMsgMap);
        }
    }

    public void verify(List<Object> resultList, Map<String, Object> caseMsgMap) {
        Boolean verifyStatus = null;
        String resultStr = resultList.get(1).toString();
        if (caseMsgMap.get("verifytype").equals("contains")) {
            verifyStatus = resultStr.contains(caseMsgMap.get("expect").toString());
            caseMsgMap.put("resultVerify", verifyStatus);
            caseMsgMap.put("resultActual", resultStr);
        } else {
            System.out.println("无法找到用例中的verifytype字段或其对应的值不包含在已定义的范围内。");
        }
        System.out.println("校验结果：" + caseMsgMap);
    }

    public List<Object> doPostJson(Map<String, Object> requestMap) throws Exception {
        String url = requestMap.get("url").toString();
        JSONObject param = new JSONObject(requestMap.get("param").toString().replace("=", ":"));
        httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type", "application/json");
        StringEntity entiy = new StringEntity(param.toString(), "UTF-8");
        httpPost.setEntity(entiy);
        response = client.execute(httpPost);
        result = EntityUtils.toString(response.getEntity(), "UTF-8");
        List<Object> resultList = new ArrayList<Object>();
        resultList.add(response);
        resultList.add(result);
        return resultList;
    }

}
