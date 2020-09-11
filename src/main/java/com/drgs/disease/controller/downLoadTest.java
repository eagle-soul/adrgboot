package com.drgs.disease.controller;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;


public class downLoadTest {
    public static void main(String[] args) {
        try {
            InputStream inputStream= downLoadTest.downloadFileByUrl("http://10.15.255.20:8089","/fastdfs-center/file/download","f2b17d8ffbc41747912d9dcec7572dfd@19513");
            String result = CharStreams.toString(new InputStreamReader(inputStream, Charsets.UTF_8));
            System.out.println(inputStream);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static InputStream downloadFileByUrl(String ip, String url, String md5Path) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse httpResponse = null;
        InputStream inputStream = null;
        try {
            HttpPost httppost = new HttpPost("http://10.15.255.20:8089/fastdfs-center/file/download?m=b6d66c21f1eca0d8d3cfeb939f719547@151583&p=1");
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            //设置浏览器兼容模式
            builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
            //设置请求的编码格式
            builder.setCharset(Consts.UTF_8);
            builder.setContentType(ContentType.APPLICATION_JSON);
            //添加文件

            HttpEntity reqEntity = builder.build();
            httppost.setEntity(reqEntity);
            httpResponse = httpClient.execute(httppost);
            inputStream=httpResponse.getEntity().getContent();

        } catch (Exception e) {
            throw new Exception("获取附件失败！");
        }
        return inputStream;
    }
}
