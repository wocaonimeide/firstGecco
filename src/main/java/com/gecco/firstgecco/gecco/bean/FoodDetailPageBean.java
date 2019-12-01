package com.gecco.firstgecco.gecco.bean;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.RequestParameter;
import com.geccocrawler.gecco.spider.HtmlBean;

@Gecco(matchUrl = "http://www.mama.cn/z/{itmeId}/",pipelines = "foodDetailPageBeanPipeline")
public class FoodDetailPageBean implements HtmlBean {

    @RequestParameter
    private String itemId;

    /**
     * 孕妇能不能吃
     */
    @HtmlField(cssPath = "body > div.g-main > div.g-container.g-area > div.g-left > section > div > div.topicCon > div:nth-child(3) > h2 > span.label")
    private String yunFuLevel;

    /**
     *
     */
    @HtmlField(cssPath = "body > div.g-main > div.g-container.g-area > div.g-left > section > div > div.topicCon > div:nth-child(3) > p")
    private String yunFuDesc;

    /**
     * 产妇能不能吃
     */
    @HtmlField(cssPath = "body > div.g-main > div.g-container.g-area > div.g-left > section > div > div.topicCon > div:nth-child(5) > h2 > span.label")
    private String chanFuLevel;

    @HtmlField(cssPath = "body > div.g-main > div.g-container.g-area > div.g-left > section > div > div.topicCon > div:nth-child(5) > p")
    private String chanFuDesc;

    /**
     * 哺乳期能不能吃
     */
    @HtmlField(cssPath = "body > div.g-main > div.g-container.g-area > div.g-left > section > div > div.topicCon > div:nth-child(7) > h2 > span.label")
    private String buruqiLevel;

    @HtmlField(cssPath = "body > div.g-main > div.g-container.g-area > div.g-left > section > div > div.topicCon > div:nth-child(7) > p")
    private String buruqiDesc;

    /**
     * 婴儿能不能吃
     */
    @HtmlField(cssPath = "body > div.g-main > div.g-container.g-area > div.g-left > section > div > div.topicCon > div:nth-child(9) > h2 > span.label")
    private String babyLevel;

    @HtmlField(cssPath = "body > div.g-main > div.g-container.g-area > div.g-left > section > div > div.topicCon > div:nth-child(9) > p")
    private String babyDesc;

    @HtmlField(cssPath = "body > div.g-main > div.g-container.g-area > div.g-left > section > div > div.topicCon > div.cata > div.summary > h3")
    private String titel;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getYunFuLevel() {
        return yunFuLevel;
    }

    public void setYunFuLevel(String yunFuLevel) {
        this.yunFuLevel = yunFuLevel;
    }

    public String getYunFuDesc() {
        return yunFuDesc;
    }

    public void setYunFuDesc(String yunFuDesc) {
        this.yunFuDesc = yunFuDesc;
    }

    public String getChanFuLevel() {
        return chanFuLevel;
    }

    public void setChanFuLevel(String chanFuLevel) {
        this.chanFuLevel = chanFuLevel;
    }

    public String getChanFuDesc() {
        return chanFuDesc;
    }

    public void setChanFuDesc(String chanFuDesc) {
        this.chanFuDesc = chanFuDesc;
    }

    public String getBuruqiLevel() {
        return buruqiLevel;
    }

    public void setBuruqiLevel(String buruqiLevel) {
        this.buruqiLevel = buruqiLevel;
    }

    public String getBuruqiDesc() {
        return buruqiDesc;
    }

    public void setBuruqiDesc(String buruqiDesc) {
        this.buruqiDesc = buruqiDesc;
    }

    public String getBabyLevel() {
        return babyLevel;
    }

    public void setBabyLevel(String babyLevel) {
        this.babyLevel = babyLevel;
    }

    public String getBabyDesc() {
        return babyDesc;
    }

    public void setBabyDesc(String babyDesc) {
        this.babyDesc = babyDesc;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }
}
