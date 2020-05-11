package com.drgs.vo;

import java.util.Date;

public class DiseaseVo {

    private String patientId;//患者ID
    private String patientName;//患者姓名
    private String medicalRecord;//病案号
    private String sex;//性别
    private String hospitalizedNum;//住院次数
    private String age;//年龄
    private String province;//居住省
    private String city;//居住市
    private String county;//居住县区
    private String admissionWay;//入院途径
    private String admissionTime;//入院时间
    private String admissionDepartmentId;//入院科室ID
    private String admissionDepartmentName;//入院科室名称
    private String leaveWay;//离院方式
    private String leaveTime;//出院时间
    private String leaveDepartmentId;//离院科室ID
    private String leaveDepartmentName;//离院科室名称
    private String mainDiagnosisId;//主要诊断编码
    private String mainDiagnosisName;//主要诊断名称
    private String otherDiagnosis;//其他诊断
    private String surgery;//手术操作
    private String hospitalizedDays;//住院天数
    private String hospitalizedCost;//住院费用
    private String medicalPayment;//医疗付款方式
    private String overallAmount;//统筹金额
    private String newbornBirthDay;//新生儿出生天数
    private String newbornAdmissionWeight;//新生儿入院体重（克）
    private String ventilatorUseTime;//呼吸机使用时间（小时）
    private String directorId;//科主任ID
    private String directorName;//科主任姓名
    private String chiefPhysicianId;//主任（副主任医师）医师ID
    private String chiefPhysicianName;//主任（副主任医师）医师姓名
    private String attendingPhysicianId;//主治医师ID
    private String attendingPhysicianName;//主治医师姓名
    private String residentId;//住院医师ID
    private String residentName;//住院医师姓名
    private String generalMedicalServicesFee;//一般医疗服务费
    private String generalTreatmentOperationFee;//一般治疗操作费
    private String nursingFee;//护理费
    private String otherFee;//其他费用
    private String pathologyDiagnosisFee;//病理诊断费
    private String laboratoryDiagnosticFee;//实验室诊断费
    private String imagingDiagnosisFee;//影像学诊断费
    private String clinicalDiagnosisFee;//临床诊断项目费
    private String nonSurgicalTreatmentItemFee;//非手术治疗项目费
    private String clinicalPhysiotherapyFee;//临床物理治疗费
    private String costOfSurgery;//手术治疗费
    private String anesthesiaFee;//麻醉费
    private String surgicalFee;//手术费
    private String rehabilitationFee;//康复费
    private String TcmTreatmentFee;//中医治疗费
    private String westernMedicineFee;//西药费
    private String antibacterialFee;//抗菌药物费
    private String chinesePatentMedicineFee;//中成药费
    private String chineseHerbalMedicineFee;//中草药费
    private String bloodFee;//血费
    private String albuminProductsFee;//白蛋白类制品费
    private String globulinProductsFee;//球蛋白类制品费
    private String coagulationFactorProductsFee;//凝血因子类制品费
    private String cytokineProductsFee;//细胞因子类制品费
    private String EFDMMFInspection;//检查用一次性医用材料费
    private String EFDMMFTreatment;//治疗用一次性医用材料费
    private String EFDMMFSurgery;//手术用一次性医用材料费
    private String otherCost;//其他费

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(String medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHospitalizedNum() {
        return hospitalizedNum;
    }

    public void setHospitalizedNum(String hospitalizedNum) {
        this.hospitalizedNum = hospitalizedNum;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getAdmissionWay() {
        return admissionWay;
    }

    public void setAdmissionWay(String admissionWay) {
        this.admissionWay = admissionWay;
    }


    public String getAdmissionDepartmentId() {
        return admissionDepartmentId;
    }

    public void setAdmissionDepartmentId(String admissionDepartmentId) {
        this.admissionDepartmentId = admissionDepartmentId;
    }

    public String getAdmissionDepartmentName() {
        return admissionDepartmentName;
    }

    public String getAdmissionTime() {
        return admissionTime;
    }

    public void setAdmissionTime(String admissionTime) {
        this.admissionTime = admissionTime;
    }

    public String getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(String leaveTime) {
        this.leaveTime = leaveTime;
    }

    public void setAdmissionDepartmentName(String admissionDepartmentName) {
        this.admissionDepartmentName = admissionDepartmentName;
    }

    public String getLeaveWay() {
        return leaveWay;
    }

    public void setLeaveWay(String leaveWay) {
        this.leaveWay = leaveWay;
    }



    public String getLeaveDepartmentId() {
        return leaveDepartmentId;
    }

    public void setLeaveDepartmentId(String leaveDepartmentId) {
        this.leaveDepartmentId = leaveDepartmentId;
    }

    public String getLeaveDepartmentName() {
        return leaveDepartmentName;
    }

    public void setLeaveDepartmentName(String leaveDepartmentName) {
        this.leaveDepartmentName = leaveDepartmentName;
    }

    public String getMainDiagnosisId() {
        return mainDiagnosisId;
    }

    public void setMainDiagnosisId(String mainDiagnosisId) {
        this.mainDiagnosisId = mainDiagnosisId;
    }

    public String getMainDiagnosisName() {
        return mainDiagnosisName;
    }

    public void setMainDiagnosisName(String mainDiagnosisName) {
        this.mainDiagnosisName = mainDiagnosisName;
    }

    public String getOtherDiagnosis() {
        return otherDiagnosis;
    }

    public void setOtherDiagnosis(String otherDiagnosis) {
        this.otherDiagnosis = otherDiagnosis;
    }

    public String getSurgery() {
        return surgery;
    }

    public void setSurgery(String surgery) {
        this.surgery = surgery;
    }

    public String getHospitalizedDays() {
        return hospitalizedDays;
    }

    public void setHospitalizedDays(String hospitalizedDays) {
        this.hospitalizedDays = hospitalizedDays;
    }

    public String getHospitalizedCost() {
        return hospitalizedCost;
    }

    public void setHospitalizedCost(String hospitalizedCost) {
        this.hospitalizedCost = hospitalizedCost;
    }

    public String getMedicalPayment() {
        return medicalPayment;
    }

    public void setMedicalPayment(String medicalPayment) {
        this.medicalPayment = medicalPayment;
    }

    public String getOverallAmount() {
        return overallAmount;
    }

    public void setOverallAmount(String overallAmount) {
        this.overallAmount = overallAmount;
    }


    public String getDirectorId() {
        return directorId;
    }

    public String getNewbornBirthDay() {
        return newbornBirthDay;
    }

    public void setNewbornBirthDay(String newbornBirthDay) {
        this.newbornBirthDay = newbornBirthDay;
    }

    public String getNewbornAdmissionWeight() {
        return newbornAdmissionWeight;
    }

    public void setNewbornAdmissionWeight(String newbornAdmissionWeight) {
        this.newbornAdmissionWeight = newbornAdmissionWeight;
    }

    public String getVentilatorUseTime() {
        return ventilatorUseTime;
    }

    public void setVentilatorUseTime(String ventilatorUseTime) {
        this.ventilatorUseTime = ventilatorUseTime;
    }

    public void setDirectorId(String directorId) {
        this.directorId = directorId;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getChiefPhysicianId() {
        return chiefPhysicianId;
    }

    public void setChiefPhysicianId(String chiefPhysicianId) {
        this.chiefPhysicianId = chiefPhysicianId;
    }

    public String getChiefPhysicianName() {
        return chiefPhysicianName;
    }

    public void setChiefPhysicianName(String chiefPhysicianName) {
        this.chiefPhysicianName = chiefPhysicianName;
    }

    public String getAttendingPhysicianId() {
        return attendingPhysicianId;
    }

    public void setAttendingPhysicianId(String attendingPhysicianId) {
        this.attendingPhysicianId = attendingPhysicianId;
    }

    public String getAttendingPhysicianName() {
        return attendingPhysicianName;
    }

    public void setAttendingPhysicianName(String attendingPhysicianName) {
        this.attendingPhysicianName = attendingPhysicianName;
    }

    public String getResidentId() {
        return residentId;
    }

    public void setResidentId(String residentId) {
        this.residentId = residentId;
    }

    public String getResidentName() {
        return residentName;
    }

    public void setResidentName(String residentName) {
        this.residentName = residentName;
    }

    public String getGeneralMedicalServicesFee() {
        return generalMedicalServicesFee;
    }

    public void setGeneralMedicalServicesFee(String generalMedicalServicesFee) {
        this.generalMedicalServicesFee = generalMedicalServicesFee;
    }

    public String getGeneralTreatmentOperationFee() {
        return generalTreatmentOperationFee;
    }

    public void setGeneralTreatmentOperationFee(String generalTreatmentOperationFee) {
        this.generalTreatmentOperationFee = generalTreatmentOperationFee;
    }

    public String getNursingFee() {
        return nursingFee;
    }

    public void setNursingFee(String nursingFee) {
        this.nursingFee = nursingFee;
    }

    public String getOtherFee() {
        return otherFee;
    }

    public void setOtherFee(String otherFee) {
        this.otherFee = otherFee;
    }

    public String getPathologyDiagnosisFee() {
        return pathologyDiagnosisFee;
    }

    public void setPathologyDiagnosisFee(String pathologyDiagnosisFee) {
        this.pathologyDiagnosisFee = pathologyDiagnosisFee;
    }

    public String getLaboratoryDiagnosticFee() {
        return laboratoryDiagnosticFee;
    }

    public void setLaboratoryDiagnosticFee(String laboratoryDiagnosticFee) {
        this.laboratoryDiagnosticFee = laboratoryDiagnosticFee;
    }

    public String getImagingDiagnosisFee() {
        return imagingDiagnosisFee;
    }

    public void setImagingDiagnosisFee(String imagingDiagnosisFee) {
        this.imagingDiagnosisFee = imagingDiagnosisFee;
    }

    public String getClinicalDiagnosisFee() {
        return clinicalDiagnosisFee;
    }

    public void setClinicalDiagnosisFee(String clinicalDiagnosisFee) {
        this.clinicalDiagnosisFee = clinicalDiagnosisFee;
    }

    public String getNonSurgicalTreatmentItemFee() {
        return nonSurgicalTreatmentItemFee;
    }

    public void setNonSurgicalTreatmentItemFee(String nonSurgicalTreatmentItemFee) {
        this.nonSurgicalTreatmentItemFee = nonSurgicalTreatmentItemFee;
    }

    public String getClinicalPhysiotherapyFee() {
        return clinicalPhysiotherapyFee;
    }

    public void setClinicalPhysiotherapyFee(String clinicalPhysiotherapyFee) {
        this.clinicalPhysiotherapyFee = clinicalPhysiotherapyFee;
    }

    public String getCostOfSurgery() {
        return costOfSurgery;
    }

    public void setCostOfSurgery(String costOfSurgery) {
        this.costOfSurgery = costOfSurgery;
    }

    public String getAnesthesiaFee() {
        return anesthesiaFee;
    }

    public void setAnesthesiaFee(String anesthesiaFee) {
        this.anesthesiaFee = anesthesiaFee;
    }

    public String getSurgicalFee() {
        return surgicalFee;
    }

    public void setSurgicalFee(String surgicalFee) {
        this.surgicalFee = surgicalFee;
    }

    public String getRehabilitationFee() {
        return rehabilitationFee;
    }

    public void setRehabilitationFee(String rehabilitationFee) {
        this.rehabilitationFee = rehabilitationFee;
    }

    public String getTcmTreatmentFee() {
        return TcmTreatmentFee;
    }

    public void setTcmTreatmentFee(String tcmTreatmentFee) {
        TcmTreatmentFee = tcmTreatmentFee;
    }

    public String getWesternMedicineFee() {
        return westernMedicineFee;
    }

    public void setWesternMedicineFee(String westernMedicineFee) {
        this.westernMedicineFee = westernMedicineFee;
    }

    public String getAntibacterialFee() {
        return antibacterialFee;
    }

    public void setAntibacterialFee(String antibacterialFee) {
        this.antibacterialFee = antibacterialFee;
    }

    public String getChinesePatentMedicineFee() {
        return chinesePatentMedicineFee;
    }

    public void setChinesePatentMedicineFee(String chinesePatentMedicineFee) {
        this.chinesePatentMedicineFee = chinesePatentMedicineFee;
    }

    public String getChineseHerbalMedicineFee() {
        return chineseHerbalMedicineFee;
    }

    public void setChineseHerbalMedicineFee(String chineseHerbalMedicineFee) {
        this.chineseHerbalMedicineFee = chineseHerbalMedicineFee;
    }

    public String getBloodFee() {
        return bloodFee;
    }

    public void setBloodFee(String bloodFee) {
        this.bloodFee = bloodFee;
    }

    public String getAlbuminProductsFee() {
        return albuminProductsFee;
    }

    public void setAlbuminProductsFee(String albuminProductsFee) {
        this.albuminProductsFee = albuminProductsFee;
    }

    public String getGlobulinProductsFee() {
        return globulinProductsFee;
    }

    public void setGlobulinProductsFee(String globulinProductsFee) {
        this.globulinProductsFee = globulinProductsFee;
    }

    public String getCoagulationFactorProductsFee() {
        return coagulationFactorProductsFee;
    }

    public void setCoagulationFactorProductsFee(String coagulationFactorProductsFee) {
        this.coagulationFactorProductsFee = coagulationFactorProductsFee;
    }

    public String getCytokineProductsFee() {
        return cytokineProductsFee;
    }

    public void setCytokineProductsFee(String cytokineProductsFee) {
        this.cytokineProductsFee = cytokineProductsFee;
    }

    public String getEFDMMFInspection() {
        return EFDMMFInspection;
    }

    public void setEFDMMFInspection(String EFDMMFInspection) {
        this.EFDMMFInspection = EFDMMFInspection;
    }

    public String getEFDMMFTreatment() {
        return EFDMMFTreatment;
    }

    public void setEFDMMFTreatment(String EFDMMFTreatment) {
        this.EFDMMFTreatment = EFDMMFTreatment;
    }

    public String getEFDMMFSurgery() {
        return EFDMMFSurgery;
    }

    public void setEFDMMFSurgery(String EFDMMFSurgery) {
        this.EFDMMFSurgery = EFDMMFSurgery;
    }

    public String getOtherCost() {
        return otherCost;
    }

    public void setOtherCost(String otherCost) {
        this.otherCost = otherCost;
    }

    @Override
    public String toString() {
        return "DiseaseVo{" +
                "sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", otherDiagnosis='" + otherDiagnosis + '\'' +
                '}';
    }
}