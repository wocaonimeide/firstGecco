package com.gecco.firstgecco.entities;

import java.io.Serializable;

/**
 * food_level
 * @author 
 */
public class FoodLevel implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 字典表id
     */
    private Integer dicId;

    /**
     * 食物名称
     */
    private String foodName;

    /**
     * 孕妇能不能吃
     */
    private String gravidaLevel;

    /**
     * 产妇能不能吃
     */
    private String puerperaLevel;

    /**
     * 婴儿能不能吃
     */
    private String babyLevel;

    /**
     * 哺乳期能不能吃
     */
    private String lactationLevel;

    /**
     * 孕妇描述
     */
    private String gravidaDesc;

    /**
     * 产妇描述
     */
    private String puerperaDesc;

    /**
     * 婴儿描述
     */
    private String babyDesc;

    /**
     * 哺乳期描述
     */
    private String lactationDesc;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDicId() {
        return dicId;
    }

    public void setDicId(Integer dicId) {
        this.dicId = dicId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getGravidaLevel() {
        return gravidaLevel;
    }

    public void setGravidaLevel(String gravidaLevel) {
        this.gravidaLevel = gravidaLevel;
    }

    public String getPuerperaLevel() {
        return puerperaLevel;
    }

    public void setPuerperaLevel(String puerperaLevel) {
        this.puerperaLevel = puerperaLevel;
    }

    public String getBabyLevel() {
        return babyLevel;
    }

    public void setBabyLevel(String babyLevel) {
        this.babyLevel = babyLevel;
    }

    public String getLactationLevel() {
        return lactationLevel;
    }

    public void setLactationLevel(String lactationLevel) {
        this.lactationLevel = lactationLevel;
    }

    public String getGravidaDesc() {
        return gravidaDesc;
    }

    public void setGravidaDesc(String gravidaDesc) {
        this.gravidaDesc = gravidaDesc;
    }

    public String getPuerperaDesc() {
        return puerperaDesc;
    }

    public void setPuerperaDesc(String puerperaDesc) {
        this.puerperaDesc = puerperaDesc;
    }

    public String getBabyDesc() {
        return babyDesc;
    }

    public void setBabyDesc(String babyDesc) {
        this.babyDesc = babyDesc;
    }

    public String getLactationDesc() {
        return lactationDesc;
    }

    public void setLactationDesc(String lactationDesc) {
        this.lactationDesc = lactationDesc;
    }
}