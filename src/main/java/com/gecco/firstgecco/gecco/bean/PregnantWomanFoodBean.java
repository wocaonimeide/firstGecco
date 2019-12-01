package com.gecco.firstgecco.gecco.bean;

import com.gecco.firstgecco.gecco.pipeline.MotherWebCrawlerBeanPipeline;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.annotation.RequestParameter;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HrefBean;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

/**
 * 孕妇食谱 分类页面
 */
@Gecco(matchUrl = MotherWebCrawlerBeanPipeline.DETAIL_URL,pipelines = "pregnantWomanFoodBeanPipeline")
public class PregnantWomanFoodBean implements HtmlBean {

    @Request
    private HttpRequest request;

    @RequestParameter("FOODTYPE")
    private String foodType;

    @RequestParameter("HUMN")
    private String humn;

    @RequestParameter("EAT")
    private String eatLevel;

    @RequestParameter("PAGE")
    private int page;

    @HtmlField(cssPath = "body > div.g-main > div.g-container.g-area > div.g-left > div > div > div.mod-ctn > ul > li")
    private List<FoodDetailHtmlBean> foodDetailHtmlBeans;

    @HtmlField(cssPath = "body > div.g-main > div.g-container.g-area > div.g-left > div > div > div.mod-ctn > div > div")
    private List<HrefBean> footPageHrefas;

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getHumn() {
        return humn;
    }

    public void setHumn(String humn) {
        this.humn = humn;
    }

    public String getEatLevel() {
        return eatLevel;
    }

    public void setEatLevel(String eatLevel) {
        this.eatLevel = eatLevel;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<FoodDetailHtmlBean> getFoodDetailHtmlBeans() {
        return foodDetailHtmlBeans;
    }

    public void setFoodDetailHtmlBeans(List<FoodDetailHtmlBean> foodDetailHtmlBeans) {
        this.foodDetailHtmlBeans = foodDetailHtmlBeans;
    }

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

    public List<HrefBean> getFootPageHrefas() {
        return footPageHrefas;
    }

    public void setFootPageHrefas(List<HrefBean> footPageHrefas) {
        this.footPageHrefas = footPageHrefas;
    }
}
