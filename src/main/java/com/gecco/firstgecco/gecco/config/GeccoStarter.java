package com.gecco.firstgecco.gecco.config;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.request.HttpGetRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class GeccoStarter {

    @Autowired
    private SpringPipelineFactory pipelineFactory;

    @EventListener(classes = {ContextRefreshedEvent.class})
    private void listener(ContextRefreshedEvent event){
        HttpGetRequest request=new HttpGetRequest("http://www.mama.cn/z/t20021/");
        GeccoEngine.create()
                //工程的包路径
                .classpath("com.gecco.firstgecco.gecco")
                //开始抓取的页面地址
                .start(request)
                //开启几个爬虫线程
                .thread(4)
                //单个爬虫每次抓取完一个请求后的间隔时间
                .interval(2000)
                //循环抓取
                .loop(false)
                //使用pc端userAgent
                .mobile(false)
                //非阻塞方式运行
                .debug(false)
                .pipelineFactory(pipelineFactory)
                .start();
    }

}
