package cn.caitc.entity;

import com.alibaba.fastjson.JSONObject;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

/**
 * description: ToKenDataTest
 * date: 2023/12/13 10:12
 * author: HuLang
 * version: 1.0
 */
public class ToKenDataTest {

    protected static Logger log = LoggerFactory.getLogger(ToKenDataTest.class);

    public static void main(String[] args) {
        //uri
        String uri = "https://113.200.102.163/web-preview/api/verify/exists/file";
        //头
        Map<String, String> headerMap = new HashMap<>();
        //体
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("type", "UPLOAD");
        paramMap.put("id", "1cbb0ef0cd0d413683ff8008b5e9f6a9");
        String requestBody = "{\"type\":\"UPLOAD\",\"id\":\"1cbb0ef0cd0d413683ff8008b5e9f6a9\"}";

        //post 请求 获得token
        String httpPostToken = getHttpPost(uri, headerMap, paramMap);
        //
        System.out.println("---httpPostToken:" + httpPostToken);

    }

    private static String getHttpPost(String uri, Map<String, String> headerMap, Map<String, String> paramMap) {
        HttpClient httpClient = wrapClient();//创建HttpClient,关键点一
        //uri,这里决定用 post,还是用其他方式
        HttpGet httpGet = new HttpGet(uri);
        HttpPost httpPost = new HttpPost(uri);
        HttpDelete httpDelete = new HttpDelete(uri);
        HttpPut httpPut = new HttpPut(uri);
        //头
        for (Map.Entry<String, String> entry : headerMap.entrySet()) {
            httpPost.addHeader(entry.getKey(), entry.getValue());
        }
        //体
        httpPost.setEntity(new StringEntity(JSONObject.toJSONString(paramMap), ContentType.create("application/json", "utf-8")));
        System.setProperty("jsse.enableSNIExtension", "false");//ssl免检  关键点二
        //访问
        HttpResponse httpResponse;
        String entity = null;
        try {
            httpResponse = httpClient.execute(httpPost);
            entity = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return entity;
    }

    public static HttpClient wrapClient() {//关键点三
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            X509TrustManager tm = new X509TrustManager() {
                @Override
                public void checkClientTrusted(
                        X509Certificate[] x509Certificates, String s) {
                }

                @Override
                public void checkServerTrusted(
                        X509Certificate[] x509Certificates, String s) {
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            sc.init(null, new TrustManager[] {tm}, null);
            SSLConnectionSocketFactory ssf = new SSLConnectionSocketFactory(sc, NoopHostnameVerifier.INSTANCE);
            return HttpClients.custom().setSSLSocketFactory(ssf).build();
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            return HttpClients.createDefault();
        }
    }
}
