package com.gecco.firstgecco.gecco.pipeline;

import com.gecco.firstgecco.entities.FoodLevel;
import com.gecco.firstgecco.gecco.bean.FoodDetailPageBean;
import com.gecco.firstgecco.services.FoodLevelService;
import com.geccocrawler.gecco.pipeline.Pipeline;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("foodDetailPageBeanPipeline")
public class FoodDetailPageBeanPipeline implements Pipeline<FoodDetailPageBean> {

    @Autowired
    private FoodLevelService foodLevelService;

    @Override
    public void process(FoodDetailPageBean bean) {
        String titel=bean.getTitel();
        String foodName= StringUtils.substring(titel,0,StringUtils.indexOf(titel,"的功效"));
        FoodLevel temp=new FoodLevel();
        temp.setFoodName(foodName);
        FoodLevel foodLevel=foodLevelService.selectByFoodName(temp);
        if (foodLevel != null) {
            modifyLevel(bean);
            foodLevel.setBabyLevel(bean.getBabyLevel());
            foodLevel.setBabyDesc(bean.getBabyDesc());
            foodLevel.setGravidaLevel(bean.getYunFuLevel());
            foodLevel.setGravidaDesc(bean.getYunFuDesc());
            foodLevel.setPuerperaLevel(bean.getChanFuLevel());
            foodLevel.setPuerperaDesc(bean.getChanFuDesc());
            foodLevel.setLactationLevel(bean.getBuruqiLevel());
            foodLevel.setLactationDesc(bean.getBuruqiDesc());
            foodLevelService.updateByPrimaryKey(foodLevel);
        }

    }

    private void modifyLevel(FoodDetailPageBean bean){
        String level=null;
        String yunLevel=null;
        String chanLevel=null;
        String buLevel=null;
        for (String s : MotherWebCrawlerBeanPipeline.EAT_LEVEL.keySet()) {
            if (bean.getBabyLevel().equals(MotherWebCrawlerBeanPipeline.EAT_LEVEL.get(s))){
                level=s;
            }
            if (bean.getYunFuLevel().equals(MotherWebCrawlerBeanPipeline.EAT_LEVEL.get(s))){
                yunLevel=s;
            }
            if (bean.getChanFuLevel().equals(MotherWebCrawlerBeanPipeline.EAT_LEVEL.get(s))){
                chanLevel=s;
            }
            if (bean.getBabyLevel().equals(MotherWebCrawlerBeanPipeline.EAT_LEVEL.get(s))){
                buLevel=s;
            }
        }
        if (level == null) {
            throw new RuntimeException("level is null");
        }else {
            bean.setBabyLevel(level);
        }
        if (yunLevel == null) {
            throw new RuntimeException("level is null");
        }else {
            bean.setYunFuLevel(yunLevel);
        }
        if (chanLevel == null) {
            throw new RuntimeException("level is null");
        }else {
            bean.setChanFuLevel(chanLevel);
        }
        if (buLevel == null) {
            throw new RuntimeException("level is null");
        }else {
            bean.setBuruqiLevel(buLevel);
        }

    }

    public static void main(String[] args) {
        String titel="日本忙的功效和作用";
        String foodName= StringUtils.substring(titel,0,StringUtils.indexOf(titel,"的功效和作用"));
        System.out.println(foodName);
    }
}
