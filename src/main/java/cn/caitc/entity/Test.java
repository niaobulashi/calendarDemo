package cn.caitc.entity;

import okhttp3.*;

import javax.net.ssl.*;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * description: Test
 * date: 2023/12/12 16:47
 * author: HuLang
 * version: 1.0
 */
public class Test {
    public static void main(String[] args) throws IOException {
        // 请求URL
        /*String url = "https://113.200.102.163/web-preview/api/verify/exists/file";
        // 请求头
        String contentType = "application/json";
        // 请求体
        String requestBody = "{\"type\":\"UPLOAD\",\"id\":\"1cbb0ef0cd0d413683ff8008b5e9f6a9\"}";
        // 发送POST请求，忽略SSL证书验证
        HttpResponse response = HttpRequest.post(url)
                .header("Content-Type", contentType)
                .body(requestBody)
                .execute();
        // 打印响应信息
        System.out.println("HTTP 状态码: " + response.getStatus());
        System.out.println("响应内容: " + response.body());*/

        /*OkHttpClient client = new OkHttpClient().newBuilder()
                .sslSocketFactory(createSSLSocketFactory(), new TrustAllCerts())
                .hostnameVerifier(new TrustAllHostnameVerifier())
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\r\n    \"type\": \"UPLOAD\",\r\n    \"id\": \"1cbb0ef0cd0d413683ff8008b5e9f6a9\"\r\n}");
        Request request = new Request.Builder()
                .url("https://113.200.102.163/web-preview/api/verify/exists/file")
                .method("POST", body)
                .build();
        System.out.println("请求报文：" + request.toString());
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());*/


        OkHttpClient client = new OkHttpClient().newBuilder()
                .sslSocketFactory(createSSLSocketFactory(), new TrustAllCerts())
                .hostnameVerifier(new TrustAllHostnameVerifier())
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("file","C:\\Users\\ladyh\\Downloads\\胡浪-家族系统4.4.0版本上线技术文档清单-dubbo.docx",
                        RequestBody.create(MediaType.parse("application/octet-stream"),
                                new File("C:\\Users\\ladyh\\Downloads\\胡浪-家族系统4.4.0版本上线技术文档清单-dubbo.docx")))
                .build();
        Request request = new Request.Builder()
                .url("https://113.200.102.163/web-preview/api/upload")
                .method("POST", body)
                .build();
        System.out.println("请求报文：" + request.toString());
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }

    private static class TrustAllCerts implements X509TrustManager {
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
        public X509Certificate[] getAcceptedIssuers() {return new X509Certificate[0];}
    }

    private static class TrustAllHostnameVerifier implements HostnameVerifier {
        public boolean verify(String hostname, SSLSession session) { return true; }
    }

    private static SSLSocketFactory createSSLSocketFactory() {
        SSLSocketFactory ssfFactory = null;
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, new TrustManager[]{new TrustAllCerts()}, new SecureRandom());
            ssfFactory = sc.getSocketFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ssfFactory;
    }
}
