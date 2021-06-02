package com.edianyun.monitor.biz.support.processor;

import com.edianyun.monitor.bean.MonitorConstants;
import com.edianyun.monitor.biz.dubboService.RegistryContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * Created by zxg on 15/11/3.
 * 14:04
 */
public class RegistryContainerProcessor implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private RegistryContainer registryContainer;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
        ApplicationContext applicationContext = event.getApplicationContext().getParent();
        //root application context 没有parent，他就是老大.
        if(applicationContext == null){
            //需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
            System.out.println("1=====start]");
            registryContainer.start();
            // ip地址的初始化
            MonitorConstants.initEcsMap();
        }else{
            // dubbo的数据初始化后的操作
            System.out.println("2=====start]");
            registryContainer.initRedisChangeAppCaChe();
        }
    }

}
