package com.edianyun.monitor.common.tools;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @author wudi
 * @version 1.0.0
 * @date 2021/4/26
 * @description 多环境配置
 */
@Slf4j
public class PropertyConfiguration extends PropertyPlaceholderConfigurer {

    private static final String ONLINE_KEY = "online";
    private static final String DEVELOP_KEY = "develop";

    private static final String EXTEND = ".properties";

    private static final String PROFILES_KEY = "spring.profiles.active";

    public PropertyConfiguration(){
        super();
        this.ignoreUnresolvablePlaceholders = true;
        String profile = System.getProperty(PROFILES_KEY);
        if(StringUtils.isEmpty(profile) || DEVELOP_KEY.equals(profile)){
            profile = "stage";
        }
        if(ONLINE_KEY.equals(profile)){
            profile = "prod";
        }
        String properties = "application-" + profile + EXTEND;
        log.info("properties name = [{}]",properties);

        this.setLocation(new ClassPathResource(properties));
    }
}
