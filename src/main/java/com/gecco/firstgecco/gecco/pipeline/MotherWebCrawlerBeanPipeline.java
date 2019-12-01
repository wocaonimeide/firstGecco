package com.gecco.firstgecco.gecco.pipeline;

import com.gecco.firstgecco.entities.DictionaryEntity;
import com.gecco.firstgecco.gecco.bean.LiHtmlBean;
import com.gecco.firstgecco.gecco.bean.MotherWebCrawlerBean;
import com.gecco.firstgecco.services.DictionaryEntityService;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.scheduler.DeriveSchedulerContext;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 处理 MotherWebCrawlerBean
 */
@Component("motherWebCrawlerBeanPipeline")
public class MotherWebCrawlerBeanPipeline implements Pipeline<MotherWebCrawlerBean> {

    private static final Logger logger= LoggerFactory.getLogger(MotherWebCrawlerBeanPipeline.class);

    /**
     * 食物种类
     */
    public static final Map<String,String> FOOD_TYPE=new ConcurrentHashMap<>();

    /**
     * 适用人群
     */
    public static final Map<String,String> HUMN_TYPE=new ConcurrentHashMap<>();

    /**
     * 能不能吃级别
     */
    public static final Map<String,String> EAT_LEVEL=new ConcurrentHashMap<>();

    public static final String DETAIL_URL="http://www.mama.cn/z/t20021/f{FOODTYPE}_s{HUMN}_e{EAT}_p{PAGE}";

    public static final String FOOT="FOOT";

    public static final String HUMN="HUMN";

    public static final String EAT="EAT";

    @Autowired
    private DictionaryEntityService entityService;

    private int page=1;

    @Override
    public void process(MotherWebCrawlerBean bean) {
        List<LiHtmlBean> foods=bean.getFoodTypes();
        for (LiHtmlBean food : foods) {
            if (StringUtils.isNotBlank(food.getDataValue()) && !StringUtils.equals("0",food.getDataValue())){
                DictionaryEntity entity=new DictionaryEntity();
                entity.setDictionaryCode(food.getDataValue());
                entity.setDictionaryName(food.getInnnerHtml());
                entity.setDictionaryType(FOOT);
                if (entityService.selectByTypeAndCode(entity) == null) {
                    entityService.insert(entity);
                }
                FOOD_TYPE.put(food.getDataValue(),food.getInnnerHtml());
            }
        }
        List<LiHtmlBean> eatLevel=bean.getEatLevel();
        for (LiHtmlBean liHtmlBean : eatLevel) {
            if (StringUtils.isNotBlank(liHtmlBean.getDataValue()) && !StringUtils.equals("0",liHtmlBean.getDataValue())){
                DictionaryEntity entity=new DictionaryEntity();
                entity.setDictionaryType(EAT);
                entity.setDictionaryCode(liHtmlBean.getDataValue());
                entity.setDictionaryName(liHtmlBean.getInnnerHtml());
                if (entityService.selectByTypeAndCode(entity) == null) {
                    entityService.insert(entity);
                }
                EAT_LEVEL.put(liHtmlBean.getDataValue(),liHtmlBean.getInnnerHtml());
            }
        }
        List<LiHtmlBean> humnTypes=bean.getHumnTypes();
        for (LiHtmlBean liHtmlBean : humnTypes) {
            if (StringUtils.isNotBlank(liHtmlBean.getDataValue()) && !StringUtils.equals("0",liHtmlBean.getDataValue())){
                DictionaryEntity entity=new DictionaryEntity();
                entity.setDictionaryType(HUMN);
                entity.setDictionaryCode(liHtmlBean.getDataValue());
                entity.setDictionaryName(liHtmlBean.getInnnerHtml());
                if (entityService.selectByTypeAndCode(entity) == null) {
                    entityService.insert(entity);
                }
                HUMN_TYPE.put(liHtmlBean.getDataValue(),liHtmlBean.getInnnerHtml());
            }
        }
        for (String s : FOOD_TYPE.keySet()) {
            for (String s1 : EAT_LEVEL.keySet()) {
                for (String s2 : HUMN_TYPE.keySet()) {
                    String resultUrl=DETAIL_URL.replace("{FOODTYPE}",s).replace("{HUMN}",s2)
                            .replace("{EAT}",s1).replace("{PAGE}",String.valueOf(page));
                    DeriveSchedulerContext.into(new HttpGetRequest(resultUrl));
                }
            }
        }
    }
}
