package com.example.privaterecipes;

/**
 * 菜谱详情类
 */
public class MenuDetails {
    private String detailsMenuImg;
    private String detailsMenuName;
    private String detailsMenuType;
    private String detailsMenuLikeNumber;
    private String detailsMenuMeterial;
    private String detailsMenuSteps;
    private String detailsMenuCommonts;
    private String detailsPersonalComments;
    public MenuDetails(){

    }
    public MenuDetails(String detailsMenuImg, String detailsMenuName, String detailsMenuType, String detailsMenuLikeNumber, String detailsMenuMeterial, String detailsMenuSteps, String detailsMenuCommonts, String detailsPersonalComments) {
        this.detailsMenuImg = detailsMenuImg;
        this.detailsMenuName = detailsMenuName;
        this.detailsMenuType = detailsMenuType;
        this.detailsMenuLikeNumber = detailsMenuLikeNumber;
        this.detailsMenuMeterial = detailsMenuMeterial;
        this.detailsMenuSteps = detailsMenuSteps;
        this.detailsMenuCommonts = detailsMenuCommonts;
        this.detailsPersonalComments = detailsPersonalComments;
    }

    public String getDetailsMenuImg() {
        return detailsMenuImg;
    }

    public void setDetailsMenuImg(String detailsMenuImg) {
        this.detailsMenuImg = detailsMenuImg;
    }

    public String getDetailsMenuName() {
        return detailsMenuName;
    }

    public void setDetailsMenuName(String detailsMenuName) {
        this.detailsMenuName = detailsMenuName;
    }

    public String getDetailsMenuType() {
        return detailsMenuType;
    }

    public void setDetailsMenuType(String detailsMenuType) {
        this.detailsMenuType = detailsMenuType;
    }

    public String getDetailsMenuLikeNumber() {
        return detailsMenuLikeNumber;
    }

    public void setDetailsMenuLikeNumber(String detailsMenuLikeNumber) {
        this.detailsMenuLikeNumber = detailsMenuLikeNumber;
    }

    public String getDetailsMenuMeterial() {
        return detailsMenuMeterial;
    }

    public void setDetailsMenuMeterial(String detailsMenuMeterial) {
        this.detailsMenuMeterial = detailsMenuMeterial;
    }

    public String getDetailsMenuSteps() {
        return detailsMenuSteps;
    }

    public void setDetailsMenuSteps(String detailsMenuSteps) {
        this.detailsMenuSteps = detailsMenuSteps;
    }

    public String getDetailsMenuCommonts() {
        return detailsMenuCommonts;
    }

    public void setDetailsMenuCommonts(String detailsMenuCommonts) {
        this.detailsMenuCommonts = detailsMenuCommonts;
    }

    public String getDetailsPersonalComments() {
        return detailsPersonalComments;
    }

    public void setDetailsPersonalComments(String detailsPersonalComments) {
        this.detailsPersonalComments = detailsPersonalComments;
    }
}
