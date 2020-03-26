package com.canvia.smartview.core.entity.dto;

public class CompanyConfigDto {

    private Long companyId;
    private String companyName;
    private String mainColor;
    private String secondaryColor;
    private String logo;
    private String backgroundImage;
    private String cmsSitename;

    public CompanyConfigDto(Long companyId,
                            String companyName,
                            String mainColor,
                            String secondaryColor,
                            String logo,
                            String backgroundImage,
                            String cmsSitename){
        this.companyId=companyId;
        this.companyName=companyName;
        this.mainColor=mainColor;
        this.secondaryColor=secondaryColor;
        this.logo=logo;
        this.backgroundImage=backgroundImage;
        this.cmsSitename=cmsSitename;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getMainColor() {
        return mainColor;
    }

    public void setMainColor(String mainColor) {
        this.mainColor = mainColor;
    }

    public String getSecondaryColor() {
        return secondaryColor;
    }

    public void setSecondaryColor(String secondaryColor) {
        this.secondaryColor = secondaryColor;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public String getCmsSitename() {
        return cmsSitename;
    }

    public void setCmsSitename(String cmsSitename) {
        this.cmsSitename = cmsSitename;
    }
}
