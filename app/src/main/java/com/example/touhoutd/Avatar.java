package com.example.touhoutd;

import org.litepal.crud.DataSupport;

public class Avatar extends DataSupport {

    private int id;

    private String rarity;

    private String name;

    private int imageIconId;

    private int imageId;

    private String skillName1;

    private String skillDes1;

    private String skillName2;

    private String skillDes2;

    private String skillName3;

    private String skillDes3;

    private String skillName4;

    private String skillDes4;

    private String pyts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageIconId() {
        return imageIconId;
    }

    public void setImageIconId(int imageIconId) {
        this.imageIconId = imageIconId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getSkillName1() {
        return skillName1;
    }

    public void setSkillName1(String skillName) {
        this.skillName1 = skillName;
    }

    public String getSkillDes1() {
        return skillDes1;
    }

    public void setSkillDes1(String skillDes) {
        this.skillDes1 = skillDes;
    }

    public String getSkillName2() {
        return skillName2;
    }

    public void setSkillName2(String skillName) {
        this.skillName2 = skillName;
    }

    public String getSkillDes2() {
        return skillDes2;
    }

    public void setSkillDes2(String skillDes) {
        this.skillDes2 = skillDes;
    }

    public String getSkillName3() {
        return skillName3;
    }

    public void setSkillName3(String skillName) {
        this.skillName3 = skillName;
    }

    public String getSkillDes3() {
        return skillDes3;
    }

    public void setSkillDes3(String skillDes) {
        this.skillDes3 = skillDes;
    }

    public String getSkillName4() {
        return skillName4;
    }

    public void setSkillName4(String skillName) {
        this.skillName4 = skillName;
    }

    public String getSkillDes4() {
        return skillDes4;
    }

    public void setSkillDes4(String skillDes) {
        this.skillDes4 = skillDes;
    }

    public String getPyts() {
        return pyts;
    }

    public void setPyts(String pyts) {
        this.pyts = pyts;
    }
}
