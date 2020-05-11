package com.drgs.disease.mapper;

import com.drgs.vo.DiseaseVo;
import com.drgs.vo.MDCVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface DiseaseMapper {
    //调入病历数据
    void insertDiseaseData(DiseaseVo diseaseVo)throws Exception;
    //更新病历数据
    void updateDiseaseData(List<DiseaseVo> updateList)throws Exception;
    //根据id查询病历信息是否存在
    int countDiseaseById(String medicalRecord)throws Exception;
    //导入MDC数据
    void insertMDCData(MDCVo mdcVo) throws Exception;
    //获取病历列表
    List<DiseaseVo> getDiseaseList(Map<String, Object> params) throws Exception;
    //根据病历号获取病历信息
    DiseaseVo getDiseaseInfoByRecord(Map<String, Object> params) throws Exception;
    //根据id查询MDC数据是否存在
    int countMDCById(MDCVo mdcVo) throws Exception;

    List<MDCVo> getMCDData(Map<String, Object> params)throws Exception;

    void updateMDCNum(MDCVo mdcVo)throws Exception;

    void resetMDCNum()throws Exception;

    MDCVo getMCDByMDId(Map<String, Object> params)throws Exception;
}
