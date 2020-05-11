package com.drgs.disease.controller;

import com.drgs.disease.service.DiseaseService;
import com.drgs.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RequestMapping("/disease")
@CrossOrigin
@RestController
public class DiseaseController {
    @Autowired
    private DiseaseService diseaseService;

    @RequestMapping("/importDiseaseData")
    public JsonResult importDiseaseData(@RequestParam("file")MultipartFile[] fileList) throws Exception {
        final JsonResult jsonResult = new JsonResult();
        try{
            jsonResult.setResult(JsonResult.SUCCESS);
            jsonResult.setMsg(diseaseService.importDiseaseData(fileList));
        }catch (Exception e){
            e.printStackTrace();
            jsonResult.setResult(JsonResult.FAIL);
            jsonResult.setMsg(diseaseService.importDiseaseData(fileList));
        }
        return jsonResult;
    }

    @RequestMapping("/importMDCData")
    public JsonResult importMCDData(@RequestParam("file")MultipartFile[] fileList) throws Exception{
        final JsonResult jsonResult = new JsonResult();
        try{
            jsonResult.setResult(JsonResult.SUCCESS);
            jsonResult.setMsg(diseaseService.importMDCData(fileList));
        }catch (Exception e){
            e.printStackTrace();
            jsonResult.setResult(JsonResult.FAIL);
            jsonResult.setMsg(diseaseService.importMDCData(fileList));
        }
        return jsonResult;
    }

    @RequestMapping("/getDiseaseList")
    public JsonResult getDiseaseList(@RequestBody Map<String, Object> params) throws Exception{
        final JsonResult jsonResult = new JsonResult();
        try{
            jsonResult.setResult(JsonResult.SUCCESS);
            jsonResult.setInfo(diseaseService.getDiseaseList(params));

        }catch (Exception e){
            e.printStackTrace();
            jsonResult.setResult(JsonResult.FAIL);
            jsonResult.setInfo(diseaseService.getDiseaseList(params));
        }
        return jsonResult;
    }

    @RequestMapping("/getDiseaseInfoByRecord")
    public JsonResult getDiseaseInfoByRecord(@RequestBody Map<String, Object> params) throws Exception{
        final JsonResult jsonResult = new JsonResult();
        try{
            jsonResult.setResult(JsonResult.SUCCESS);
            jsonResult.setInfo(diseaseService.getDiseaseInfoByRecord(params));

        }catch (Exception e){
            e.printStackTrace();
            jsonResult.setResult(JsonResult.FAIL);
            jsonResult.setInfo(diseaseService.getDiseaseInfoByRecord(params));
        }
        return jsonResult;
    }
    @RequestMapping("/getMDCData")
    public JsonResult getMCDData(@RequestBody Map<String, Object> params) throws Exception{
        final JsonResult jsonResult = new JsonResult();
        try{
            jsonResult.setResult(JsonResult.SUCCESS);
            jsonResult.setInfo(diseaseService.getMCDData(params));
        }catch (Exception e){
            e.printStackTrace();
            jsonResult.setResult(JsonResult.FAIL);
            jsonResult.setInfo(diseaseService.getMCDData(params));
        }
        return jsonResult;
    }

    @RequestMapping("/updateDiseaseNum")
    public JsonResult updateDiseaseNum() throws Exception{
        final JsonResult jsonResult = new JsonResult();
        try{
            jsonResult.setResult(JsonResult.SUCCESS);
            diseaseService.updateDiseaseNum();
        }catch (Exception e){
            e.printStackTrace();
            jsonResult.setResult(JsonResult.FAIL);
        }
        return jsonResult;
    }
}
