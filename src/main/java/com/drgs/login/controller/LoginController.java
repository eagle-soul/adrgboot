package com.drgs.login.controller;

import com.drgs.commom.ZTBConstants;
import com.drgs.commom.ZTBGyUtils;
import com.drgs.login.service.LoginService;
import com.drgs.vo.JsonResult;
import com.drgs.vo.UserVo;
import com.github.pagehelper.PageInfo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    @ResponseBody
    public JsonResult login(@RequestBody Map<String, Object> params) throws Exception {
        final JsonResult<Integer> jsonResult = new JsonResult<Integer>();
        try{
            jsonResult.setResult(JsonResult.SUCCESS);
            jsonResult.setMsg(ZTBConstants.CX_SUCCESS);
            jsonResult.setInfo(loginService.login(params));
        }catch (Exception e){
            e.printStackTrace();
            jsonResult.setResult(JsonResult.FAIL);
            jsonResult.setMsg(ZTBConstants.CX_FAIL);
        }
        return jsonResult;
    }
}
