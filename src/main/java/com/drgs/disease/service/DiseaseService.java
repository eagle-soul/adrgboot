package com.drgs.disease.service;

import com.drgs.vo.DiseaseVo;
import com.drgs.vo.MDCVo;
import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface DiseaseService {
    String importDiseaseData(MultipartFile[] file) throws Exception;

    String importMDCData(MultipartFile[] file) throws Exception;

    PageInfo<DiseaseVo> getDiseaseList(Map<String, Object> params)throws Exception;

    DiseaseVo getDiseaseInfoByRecord(Map<String, Object> params)throws Exception;

    PageInfo<MDCVo> getMCDData(Map<String, Object> params)throws Exception;

    void updateDiseaseNum()throws Exception;
}
