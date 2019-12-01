package com.gecco.firstgecco.gecco.bean;

import com.geccocrawler.gecco.annotation.Attr;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.spider.HtmlBean;

/**
 * html li 标签对应的bean
 */
public class LiHtmlBean implements HtmlBean {

    @Attr("data-value")
    @HtmlField(cssPath = "li")
    private String dataValue;

    @HtmlField(cssPath = "li")
    private String innnerHtml;

    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
    }

    public String getInnnerHtml() {
        return innnerHtml;
    }

    public void setInnnerHtml(String innnerHtml) {
        this.innnerHtml = innnerHtml;
    }
}
