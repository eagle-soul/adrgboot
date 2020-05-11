package com.drgs.vo;

public class MDCVo {

    private String MDC;
    private String MDCName;
    private String ADRG;
    private String ADRGName;
    private String MainDiagnosisId;
    private String MainDiagnosisName;
    private int num;
    private int maleNum;
    private int femaleNum;
    private int tenNum;
    private int twentyNum;
    private int thirtyNum;
    private int fortyNum;
    private int fiftyNum;
    private int sixtyNum;
    private int seventyNum;
    private int eightNum;
    private int otherNum;

    public int getNum() {
        return this.femaleNum+this.maleNum;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getMDC() {
        return MDC;
    }

    public void setMDC(String MDC) {
        this.MDC = MDC;
    }

    public String getMDCName() {
        return MDCName;
    }

    public void setMDCName(String MDCName) {
        this.MDCName = MDCName;
    }

    public String getADRG() {
        return ADRG;
    }

    public void setADRG(String ADRG) {
        this.ADRG = ADRG;
    }

    public String getADRGName() {
        return ADRGName;
    }

    public void setADRGName(String ADRGName) {
        this.ADRGName = ADRGName;
    }

    public String getMainDiagnosisId() {
        return MainDiagnosisId;
    }

    public void setMainDiagnosisId(String mainDiagnosisId) {
        MainDiagnosisId = mainDiagnosisId;
    }

    public String getMainDiagnosisName() {
        return MainDiagnosisName;
    }

    public void setMainDiagnosisName(String mainDiagnosisName) {
        MainDiagnosisName = mainDiagnosisName;
    }

    public int getMaleNum() {
        return maleNum;
    }

    public void setMaleNum(int maleNum) {
        this.maleNum = maleNum;
    }

    public int getFemaleNum() {
        return femaleNum;
    }

    @Override
    public String toString() {
        return "MDCVo{" +
                "MDC='" + MDC + '\'' +
                ", MDCName='" + MDCName + '\'' +
                ", ADRG='" + ADRG + '\'' +
                ", ADRGName='" + ADRGName + '\'' +
                ", MainDiagnosisId='" + MainDiagnosisId + '\'' +
                ", MainDiagnosisName='" + MainDiagnosisName + '\'' +
                ", maleNum=" + maleNum +
                ", femaleNum=" + femaleNum +
                ", tenNum=" + tenNum +
                ", twentyNum=" + twentyNum +
                ", thirtyNum=" + thirtyNum +
                ", fortyNum=" + fortyNum +
                ", fiftyNum=" + fiftyNum +
                ", sixtyNum=" + sixtyNum +
                ", seventyNum=" + seventyNum +
                ", eightNum=" + eightNum +
                ", otherNum=" + otherNum +
                '}';
    }

    public void setFemaleNum(int femaleNum) {
        this.femaleNum = femaleNum;
    }

    public int getTenNum() {
        return tenNum;
    }

    public void setTenNum(int tenNum) {
        this.tenNum = tenNum;
    }

    public int getTwentyNum() {
        return twentyNum;
    }

    public void setTwentyNum(int twentyNum) {
        this.twentyNum = twentyNum;
    }

    public int getThirtyNum() {
        return thirtyNum;
    }

    public void setThirtyNum(int thirtyNum) {
        this.thirtyNum = thirtyNum;
    }

    public int getFortyNum() {
        return fortyNum;
    }

    public void setFortyNum(int fortyNum) {
        this.fortyNum = fortyNum;
    }

    public int getFiftyNum() {
        return fiftyNum;
    }

    public void setFiftyNum(int fiftyNum) {
        this.fiftyNum = fiftyNum;
    }

    public int getSixtyNum() {
        return sixtyNum;
    }

    public void setSixtyNum(int sixtyNum) {
        this.sixtyNum = sixtyNum;
    }

    public int getSeventyNum() {
        return seventyNum;
    }

    public void setSeventyNum(int seventyNum) {
        this.seventyNum = seventyNum;
    }

    public int getEightNum() {
        return eightNum;
    }

    public void setEightNum(int eightNum) {
        this.eightNum = eightNum;
    }

    public int getOtherNum() {
        return otherNum;
    }

    public void setOtherNum(int otherNum) {
        this.otherNum = otherNum;
    }
}
