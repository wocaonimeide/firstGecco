package com.gecco.firstgecco.gecco.config;

import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.pipeline.PipelineFactory;
import com.geccocrawler.gecco.spider.SpiderBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringPipelineFactory implements ApplicationContextAware, PipelineFactory {

    private ApplicationContext applicationContext;
    @Override
    public Pipeline<? extends SpiderBean> getPipeline(String name) {
        try {
            Object bean = applicationContext.getBean(name);
            if(bean instanceof Pipeline) {
                return (Pipeline<? extends SpiderBean>)bean;
            }
        } catch(NoSuchBeanDefinitionException ex) {
            System.out.println("no such pipeline : " + name);
        }
        return null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }


}
