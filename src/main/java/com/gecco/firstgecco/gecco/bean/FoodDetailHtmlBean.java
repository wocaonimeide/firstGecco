package com.gecco.firstgecco.gecco.bean;

import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Image;
import com.geccocrawler.gecco.spider.HtmlBean;

/**
 * 对应页面一个食物详情
 */
public class FoodDetailHtmlBean implements HtmlBean {

    @Image
    @HtmlField(cssPath = ".img-wrap > img")
    private String imageUrl;

    @Href(click = true, value = "href")
    @HtmlField(cssPath = "a:nth-child(2)")
    private String foodUrl;

    @HtmlField(cssPath = "a:nth-child(2)")
    private String foodName;

    public String getFoodUrl() {
        return foodUrl;
    }

    public void setFoodUrl(String foodUrl) {
        this.foodUrl = foodUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
