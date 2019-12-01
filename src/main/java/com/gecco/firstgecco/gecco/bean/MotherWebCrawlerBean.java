package com.gecco.firstgecco.gecco.bean;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

/**
 * 妈妈网爬虫 bean
 */
@Gecco(matchUrl="http://www.mama.cn/z/t20021/",pipelines = {"motherWebCrawlerBeanPipeline"})
public class MotherWebCrawlerBean implements HtmlBean {

    private static final long serialVersionUID = -7127412585200687225L;

    @Request
    private HttpRequest request;

    /**
     * 食物分类li
     */
    @HtmlField(cssPath = "#J_filterForm > dl:nth-child(1) > dd > ul > li")
    private List<LiHtmlBean> foodTypes;

    @HtmlField(cssPath = "#J_filterForm > dl:nth-child(2) > dd > ul > li")
    private List<LiHtmlBean> humnTypes;

    @HtmlField(cssPath = "#J_filterForm > dl:nth-child(3) > dd > ul > li")
    private List<LiHtmlBean> eatLevel;

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

    public List<LiHtmlBean> getFoodTypes() {
        return foodTypes;
    }

    public void setFoodTypes(List<LiHtmlBean> foodTypes) {
        this.foodTypes = foodTypes;
    }

    public List<LiHtmlBean> getHumnTypes() {
        return humnTypes;
    }

    public void setHumnTypes(List<LiHtmlBean> humnTypes) {
        this.humnTypes = humnTypes;
    }

    public List<LiHtmlBean> getEatLevel() {
        return eatLevel;
    }

    public void setEatLevel(List<LiHtmlBean> eatLevel) {
        this.eatLevel = eatLevel;
    }
}
