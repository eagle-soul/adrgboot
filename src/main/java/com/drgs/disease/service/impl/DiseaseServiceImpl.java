package com.drgs.disease.service.impl;

import com.drgs.commom.*;
import com.drgs.disease.mapper.DiseaseMapper;
import com.drgs.disease.service.DiseaseService;
import com.drgs.vo.DiseaseVo;
import com.drgs.vo.MDCVo;
import com.github.pagehelper.PageInfo;
import com.qiniu.util.Md5;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
//import com.drgs.commom.cellToString.;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class DiseaseServiceImpl implements DiseaseService {
    @Autowired
    private DiseaseMapper diseaseMapper;

    private String CellToString(Cell cell) {
        if (cell == null) {
            return "";
        } else {
            return cell.toString();
        }
    }

    @Override
    public String importDiseaseData(MultipartFile[] fileList) throws Exception {
        List<DiseaseVo> insertList = new ArrayList<DiseaseVo>();
        List<DiseaseVo> updateList = new ArrayList<DiseaseVo>();
        for (MultipartFile file : fileList) {
            Workbook wb = null;// excel对象
            try {
                wb = ExcelImportUtil.readExcel(file);
            } catch (Exception e) {
                return "无法读取文件";
            }
            // sheet页数量
            Sheet sheet = wb.getSheetAt(0);// sheet页对象
            String sheetName = wb.getSheetName(0);// sheet页名称
            int diseaseFlag = 0;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
            for (int j = 1; j < sheet.getLastRowNum() + 1; j++) {
                DiseaseVo diseaseVo = new DiseaseVo();
                Row row = sheet.getRow(j);
                String medicalRecord = CellToString(row.getCell(0));
                String hospitalizedNum = CellToString(row.getCell(1));
                String patientName = CellToString(row.getCell(2));
                String sex = CellToString(row.getCell(3));
                String age = CellToString(row.getCell(4));
                String province = CellToString(row.getCell(5));
                String city = CellToString(row.getCell(6));
                String county = CellToString(row.getCell(7));
                String admissionWay = CellToString(row.getCell(8));
                String admissionTime = CellToString(row.getCell(9));
                String admissionDepartmentId = CellToString(row.getCell(10));
                String admissionDepartmentName = CellToString(row.getCell(11));
                String leaveWay = CellToString(row.getCell(12));
                String leaveTime = CellToString(row.getCell(13));
                String leaveDepartmentId = CellToString(row.getCell(14));
                String leaveDepartmentName = CellToString(row.getCell(15));
                String mainDiagnosisId = CellToString(row.getCell(16));
                String mainDiagnosisName = CellToString(row.getCell(17));
                String otherDiagnosis = CellToString(row.getCell(18));
                String surgery = CellToString(row.getCell(19));
                String hospitalizedDays = CellToString(row.getCell(20));
                String hospitalizedCost = CellToString(row.getCell(21));
                String medicalPayment = CellToString(row.getCell(22));
                String overallAmount = CellToString(row.getCell(23));
                String newbornBirthDay = CellToString(row.getCell(24));
                String newbornAdmissionWeight = CellToString(row.getCell(25));
                String ventilatorUseTime = CellToString(row.getCell(26));
                String directorId = CellToString(row.getCell(27));
                String directorName = CellToString(row.getCell(28));
                String chiefPhysicianId = CellToString(row.getCell(29));
                String chiefPhysicianName = CellToString(row.getCell(30));
                String attendingPhysicianId = CellToString(row.getCell(31));
                String attendingPhysicianName = CellToString(row.getCell(32));
                String residentId = CellToString(row.getCell(33));
                String residentName = CellToString(row.getCell(34));
                String generalMedicalServicesFee = CellToString(row.getCell(35));
                String generalTreatmentOperationFee = CellToString(row.getCell(36));
                String nursingFee = CellToString(row.getCell(37));
                String otherFee = CellToString(row.getCell(38));
                String pathologyDiagnosisFee = CellToString(row.getCell(39));
                String laboratoryDiagnosticFee = CellToString(row.getCell(40));
                String imagingDiagnosisFee = CellToString(row.getCell(41));
                String clinicalDiagnosisFee = CellToString(row.getCell(42));
                String nonSurgicalTreatmentItemFee = CellToString(row.getCell(43));
                String clinicalPhysiotherapyFee = CellToString(row.getCell(44));
                String costOfSurgery = CellToString(row.getCell(45));
                String anesthesiaFee = CellToString(row.getCell(46));
                String surgicalFee = CellToString(row.getCell(47));
                String rehabilitationFee = CellToString(row.getCell(48));
                String TcmTreatmentFee = CellToString(row.getCell(49));
                String westernMedicineFee = CellToString(row.getCell(50));
                String antibacterialFee = CellToString(row.getCell(51));
                String chinesePatentMedicineFee = CellToString(row.getCell(52));
                String chineseHerbalMedicineFee = CellToString(row.getCell(53));
                String bloodFee = CellToString(row.getCell(54));
                String albuminProductsFee = CellToString(row.getCell(55));
                String globulinProductsFee = CellToString(row.getCell(56));
                String coagulationFactorProductsFee = CellToString(row.getCell(57));
                String cytokineProductsFee = CellToString(row.getCell(58));
                String EFDMMFInspection = CellToString(row.getCell(59));
                String EFDMMFTreatment = CellToString(row.getCell(60));
                String EFDMMFSurgery = CellToString(row.getCell(61));
                String otherCost = CellToString(row.getCell(62));
                diseaseVo.setMedicalRecord(medicalRecord);
                diseaseVo.setPatientName(patientName);
                diseaseVo.setSex(sex);
                diseaseVo.setHospitalizedNum(hospitalizedNum);
                diseaseVo.setAge(age);
                diseaseVo.setProvince(province);
                diseaseVo.setCity(city);
                diseaseVo.setCounty(county);
                diseaseVo.setAdmissionWay(admissionWay);
                diseaseVo.setAdmissionTime(admissionTime);
                diseaseVo.setAdmissionDepartmentId(admissionDepartmentId);
                diseaseVo.setAdmissionDepartmentName(admissionDepartmentName);
                diseaseVo.setLeaveWay(leaveWay);
                diseaseVo.setLeaveTime(leaveTime);
                diseaseVo.setLeaveDepartmentId(leaveDepartmentId);
                diseaseVo.setLeaveDepartmentName(leaveDepartmentName);
                diseaseVo.setMainDiagnosisId(mainDiagnosisId);
                diseaseVo.setMainDiagnosisName(mainDiagnosisName);
                diseaseVo.setOtherDiagnosis(otherDiagnosis);
                diseaseVo.setSurgery(surgery);
                diseaseVo.setHospitalizedDays(hospitalizedDays);
                diseaseVo.setHospitalizedCost(hospitalizedCost);
                diseaseVo.setMedicalPayment(medicalPayment);
                diseaseVo.setOverallAmount(overallAmount);
                diseaseVo.setNewbornBirthDay(newbornBirthDay);
                diseaseVo.setNewbornAdmissionWeight(newbornAdmissionWeight);
                diseaseVo.setVentilatorUseTime(ventilatorUseTime);
                diseaseVo.setDirectorId(directorId);
                diseaseVo.setDirectorName(directorName);
                diseaseVo.setChiefPhysicianId(chiefPhysicianId);
                diseaseVo.setChiefPhysicianName(chiefPhysicianName);
                diseaseVo.setAttendingPhysicianId(attendingPhysicianId);
                diseaseVo.setAttendingPhysicianName(attendingPhysicianName);
                diseaseVo.setResidentId(residentId);
                diseaseVo.setResidentName(residentName);
                diseaseVo.setGeneralMedicalServicesFee(generalMedicalServicesFee);
                diseaseVo.setGeneralTreatmentOperationFee(generalTreatmentOperationFee);
                diseaseVo.setNursingFee(nursingFee);
                diseaseVo.setOtherFee(otherFee);
                diseaseVo.setPathologyDiagnosisFee(pathologyDiagnosisFee);
                diseaseVo.setLaboratoryDiagnosticFee(laboratoryDiagnosticFee);
                diseaseVo.setImagingDiagnosisFee(imagingDiagnosisFee);
                diseaseVo.setClinicalDiagnosisFee(clinicalDiagnosisFee);
                diseaseVo.setClinicalPhysiotherapyFee(clinicalPhysiotherapyFee);
                diseaseVo.setNonSurgicalTreatmentItemFee(nonSurgicalTreatmentItemFee);
                diseaseVo.setCostOfSurgery(costOfSurgery);
                diseaseVo.setAnesthesiaFee(anesthesiaFee);
                diseaseVo.setSurgicalFee(surgicalFee);
                diseaseVo.setRehabilitationFee(rehabilitationFee);
                diseaseVo.setTcmTreatmentFee(TcmTreatmentFee);
                diseaseVo.setWesternMedicineFee(westernMedicineFee);
                diseaseVo.setAntibacterialFee(antibacterialFee);
                diseaseVo.setChineseHerbalMedicineFee(chineseHerbalMedicineFee);
                diseaseVo.setChinesePatentMedicineFee(chinesePatentMedicineFee);
                diseaseVo.setBloodFee(bloodFee);
                diseaseVo.setAlbuminProductsFee(albuminProductsFee);
                diseaseVo.setGlobulinProductsFee(globulinProductsFee);
                diseaseVo.setCoagulationFactorProductsFee(coagulationFactorProductsFee);
                diseaseVo.setCytokineProductsFee(cytokineProductsFee);
                diseaseVo.setEFDMMFInspection(EFDMMFInspection);
                diseaseVo.setEFDMMFSurgery(EFDMMFSurgery);
                diseaseVo.setEFDMMFTreatment(EFDMMFTreatment);
                diseaseVo.setOtherCost(otherCost);
                diseaseFlag = diseaseMapper.countDiseaseById(medicalRecord);
                if (diseaseFlag == 0) {
                    diseaseMapper.insertDiseaseData(diseaseVo);
                }
            }
        }
        return "导入成功！";
    }

    @Override
    public String importMDCData(MultipartFile[] fileList) throws Exception {
        List<MDCVo> insertList = new ArrayList<MDCVo>();
        for (MultipartFile file : fileList) {
            Workbook wb = null;// excel对象
            try {
                wb = ExcelImportUtil.readExcel(file);
            } catch (Exception e) {
                return "无法读取文件";
            }
            // sheet页数量
            Sheet sheet = wb.getSheetAt(0);// sheet页对象
            String sheetName = wb.getSheetName(0);// sheet页名称
            String[] Cell_MDC = new String[2];
            String[] Cell_ADRG = new String[2];
            String[] Cell_Main_Diagnosis = new String[2];
            String[] Cell_Main_Diagnosis_Temp;
            int MDCFlag = 0;
            for (int j = 1; j < sheet.getLastRowNum() + 1; j++) {
                MDCVo mdcVo = new MDCVo();
                Row row = sheet.getRow(j);
                //获取第一列数据
                if (row.getCell(0) != null) {
                    try {
                        Cell_MDC[0] = row.getCell(0).toString().substring(0, 4);
                    } catch (StringIndexOutOfBoundsException e) {
                        Cell_MDC[0] = Cell_MDC[0];
                    }
                    if (row.getCell(0).toString().length() > 4) {
                        Cell_MDC[1] = row.getCell(0).toString().substring(4).trim();
                    }
                }
                //获取第二列数据
                if (row.getCell(1) != null) {
                    try {
                        Cell_ADRG[0] = row.getCell(1).toString().substring(0, 3);
                    } catch (StringIndexOutOfBoundsException e) {
                        Cell_ADRG[0] = Cell_ADRG[0];
                    }
                    if (row.getCell(1).toString().length() > 3) {
                        Cell_ADRG[1] = row.getCell(1).toString().substring(3).trim();
                    }
                }
                if (row.getCell(2) == null) {
                    continue;
                } else {
                    Cell_Main_Diagnosis_Temp = row.getCell(2).toString().split(" ");
                    if (Cell_Main_Diagnosis_Temp.length == 1) {
                        try {
                            Cell_Main_Diagnosis[0] = InterceptStr.InterceptCharacter(row.getCell(2).toString());
                            Cell_Main_Diagnosis[1] = InterceptStr.InterceptCNCharacter(row.getCell(2).toString());
                        } catch (StringIndexOutOfBoundsException e) {
                        }
                    } else {
                        try {
                            Cell_Main_Diagnosis = row.getCell(2).toString().split(" ");
                        } catch (Exception e) {
                        }
                    }
                }
                mdcVo.setMDC(Cell_MDC[0]);
                mdcVo.setMDCName(Cell_MDC[1]);
                mdcVo.setADRG(Cell_ADRG[0]);
                mdcVo.setADRGName(Cell_ADRG[1]);
                mdcVo.setMainDiagnosisId(Cell_Main_Diagnosis[0]);
                int index = Cell_Main_Diagnosis.length;
                StringBuilder MainName = new StringBuilder();
                for (int i = 1; i < index; i++) {
                    MainName.append(Cell_Main_Diagnosis[i]);
                }
                mdcVo.setMainDiagnosisName(MainName.toString());
                MDCFlag = diseaseMapper.countMDCById(mdcVo);
                if (MDCFlag == 0) {
                    diseaseMapper.insertMDCData(mdcVo);
                }
            }
        }
        return "导入成功";
    }

    @Override
    public PageInfo<DiseaseVo> getDiseaseList(Map<String, Object> params) throws Exception {
        ZTBGyUtils.setPageInfo(params);
        List<DiseaseVo> diseaseVoList = diseaseMapper.getDiseaseList(params);
        return new PageInfo<>(diseaseVoList);
    }

    @Override
    public DiseaseVo getDiseaseInfoByRecord(Map<String, Object> params) throws Exception {
        DiseaseVo diseaseVo = diseaseMapper.getDiseaseInfoByRecord(params);
        return diseaseVo;
    }

    @Override
    public PageInfo<MDCVo> getMCDData(Map<String, Object> params) throws Exception {
        ZTBGyUtils.setPageInfo(params);
        List<MDCVo> mdcVoList = diseaseMapper.getMCDData(params);
        return new PageInfo<>(mdcVoList);
    }

    @Override
    public void updateDiseaseNum() throws Exception {
        diseaseMapper.resetMDCNum();
        Map<String, Object> params = new HashMap<>();
        List<DiseaseVo> list = diseaseMapper.getDiseaseList(params);
        for (DiseaseVo diseaseVo : list) {
            if (diseaseVo.getOtherDiagnosis()==null||diseaseVo.getOtherDiagnosis().equals("")){
                continue;
            }
            String[] otherDiagnosisList = diseaseVo.getOtherDiagnosis().split("；");
            for (int i = 0; i < otherDiagnosisList.length; i++) {
                params.put("MainDiagnosisId", otherDiagnosisList[i].split("-")[0]);
                List<MDCVo> mdcVos = diseaseMapper.getMCDData(params);
                for (MDCVo mdcVo : mdcVos) {
                    if (diseaseVo.getSex() != null) {//修改性别数量
                        if (diseaseVo.getSex().trim().equals("男")) {
                            mdcVo.setMaleNum(mdcVo.getMaleNum() + 1);
                        } else {
                            mdcVo.setFemaleNum(mdcVo.getFemaleNum() + 1);
                        }
                    }
                    if (diseaseVo.getAge() != null) {//修改年龄数量
                        int age = AgeTool.StrToInt(diseaseVo.getAge());
                        if (age <= 10) {
                            mdcVo.setTenNum(mdcVo.getTenNum() + 1);
                        } else if (age <= 20) {
                            mdcVo.setTwentyNum(mdcVo.getTwentyNum() + 1);
                        } else if (age <= 30) {
                            mdcVo.setThirtyNum(mdcVo.getThirtyNum() + 1);
                        } else if (age <= 40) {
                            mdcVo.setFortyNum(mdcVo.getFortyNum() + 1);
                        } else if (age <= 50) {
                            mdcVo.setFiftyNum(mdcVo.getFiftyNum() + 1);
                        } else if (age <= 60) {
                            mdcVo.setSixtyNum(mdcVo.getSixtyNum() + 1);
                        } else if (age <= 70) {
                            mdcVo.setSeventyNum(mdcVo.getSeventyNum() + 1);
                        } else if (age <= 80) {
                            mdcVo.setEightNum(mdcVo.getEightNum() + 1);
                        } else {
                            mdcVo.setOtherNum(mdcVo.getOtherNum() + 1);
                        }
                    }
                    diseaseMapper.updateMDCNum(mdcVo);
                }
            }
        }
    }
}
