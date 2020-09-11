package com.drgs.disease.controller;

import com.alibaba.fastjson.JSON;

import com.drgs.vo.JsonResult;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;

@RestController
@RequestMapping("/testCtrl")
public class TestCtrl {

    @PostMapping("/savePersonInfo")
    @ResponseBody
    public JsonResult savePersonInfo(HttpServletRequest httpServletRequest) {

        try {
//            byte[] buffer=map.get("Filedata").getBytes();
            System.out.println(httpServletRequest.getParameter("userId"));
            System.out.println(httpServletRequest.getParameter("unitCode"));
            System.out.println(httpServletRequest.getParameter("unit"));
            System.out.println(httpServletRequest.getParameter("userName"));
            System.out.println(httpServletRequest.getParameter("filesrcname"));
            System.out.println(httpServletRequest.getParameter("sex"));
            System.out.println(httpServletRequest.getParameter("position"));
            System.out.println(httpServletRequest.getParameter("telephone"));
            System.out.println(httpServletRequest.getParameter("mobile"));
            System.out.println(httpServletRequest.getParameter("email"));
//            System.out.println(httpServletRequest.getParameter("file"));
//            System.out.println(httpServletRequest.getParameter("ResponseType"));
//            System.out.println(httpServletRequest.getParameter("Type"));
//            System.out.println(httpServletRequest.getPart("file"));
//            InputStream inputStream = httpServletRequest.getPart("file").getInputStream();
//            System.out.println(inputStream);
            Integer integer = 1;
//            System.out.println(map.get("Filedata"));

//            System.out.println(map.get("userId"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JsonResult(200,"访问成功","测试info");
    }
}












