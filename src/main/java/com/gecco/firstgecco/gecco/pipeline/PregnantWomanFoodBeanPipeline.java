package com.gecco.firstgecco.gecco.pipeline;

import com.gecco.firstgecco.entities.DictionaryEntity;
import com.gecco.firstgecco.entities.FoodLevel;
import com.gecco.firstgecco.gecco.bean.FoodDetailHtmlBean;
import com.gecco.firstgecco.gecco.bean.PregnantWomanFoodBean;
import com.gecco.firstgecco.services.DictionaryEntityService;
import com.gecco.firstgecco.services.FoodLevelService;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.scheduler.DeriveSchedulerContext;
import com.geccocrawler.gecco.spider.HrefBean;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("pregnantWomanFoodBeanPipeline")
public class PregnantWomanFoodBeanPipeline implements Pipeline<PregnantWomanFoodBean> {

    private static final String HAS_NEXT_FLAG = "››";


    @Autowired
    private DictionaryEntityService entityService;

    @Autowired
    private FoodLevelService foodLevelService;

    @Override
    public void process(PregnantWomanFoodBean bean) {
        List<FoodDetailHtmlBean> foodDetailHtmlBeans = bean.getFoodDetailHtmlBeans();
        List<String> foodNames = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(foodDetailHtmlBeans)) {
            for (FoodDetailHtmlBean foodDetailHtmlBean : foodDetailHtmlBeans) {
                String titel = foodDetailHtmlBean.getFoodName();
                foodNames.add(titel);
            }
        }
        String currUrl = bean.getRequest().getUrl();
        int foodindex = StringUtils.indexOf(currUrl, "/f");
        String foodCode = StringUtils.substring(currUrl, foodindex + 2, foodindex + 7);
        DictionaryEntity temp = new DictionaryEntity();
        temp.setDictionaryType(MotherWebCrawlerBeanPipeline.FOOT);
        temp.setDictionaryCode(foodCode);
        DictionaryEntity foodEntity = entityService.selectByTypeAndCode(temp);
        if (null == foodEntity || null == foodEntity.getId()) {
            throw new RuntimeException("food entity is null");
        }
        FoodLevel foodLevel = new FoodLevel();
        for (String foodName : foodNames) {
            foodLevel.setDicId(foodEntity.getId());
            foodLevel.setFoodName(foodName);
            if (foodLevelService.selectByFoodName(foodLevel) == null) {
                foodLevelService.insert(foodLevel);
            }
        }
        List<HrefBean> hrefBeans = bean.getFootPageHrefas();
        if (CollectionUtils.isNotEmpty(hrefBeans)) {
            boolean hasNext = false;
            for (HrefBean hrefBean : hrefBeans) {
                if (StringUtils.equals(hrefBean.getTitle(), HAS_NEXT_FLAG)) {
                    hasNext = true;
                    break;
                }
            }
            if (hasNext) {
                int index = currUrl.indexOf("_p");
                if (index > -1) {
                    String nextUrl = StringUtils.substring(currUrl, 0, index);
                    Integer currPage = Integer.valueOf(StringUtils.substring(currUrl, index + 2));
                    nextUrl = nextUrl + "_p" + (currPage + 1);
                    DeriveSchedulerContext.into(new HttpGetRequest(nextUrl));
                }
            }
        }
    }
}
