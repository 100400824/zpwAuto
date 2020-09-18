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

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyHttpClient {

    private String url, uri;
    private CookieStore cookieStore = new BasicCookieStore();
    private DefaultHttpClient client = new DefaultHttpClient();
    private HttpGet httpGet;
    private HttpPost httpPost;
    private HttpResponse response;
    private String result;

    @BeforeClass
    public void getParameter() {
        ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
        uri = bundle.getString("test.uri");
    }

    //get请求
    @Test
    public void test1() throws Exception {
        client.setCookieStore(cookieStore);
        httpGet = new HttpGet(url + uri);
        response = client.execute(httpGet);
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(response);

        this.cookieStore = client.getCookieStore();
        List<Cookie> cookies = this.cookieStore.getCookies();
        System.out.println(cookies.size());
//        System.out.println(result);

    }

    //post json
    @Test
    public void doPostJson() throws Exception {

        httpPost = new HttpPost("http://localhost:7127/doTest");
        JSONObject param = new JSONObject();
        param.put("one","wo");
        param.put("two","ni");
        StringEntity entiy = new StringEntity(param.toString(),"UTF-8");
        httpPost.setEntity(entiy);
        response = client.execute(httpPost);
        result = EntityUtils.toString(response.getEntity(),"UTF-8");
        System.out.println(result);
        param = new JSONObject(result);
        System.out.println(param.get("code"));

    }

}
