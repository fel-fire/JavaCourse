package edu.baykov.spring.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 9.3.5 Кэширование контейнером. Создайте постобработчик на основе метода cache из задачи 8.3.6.
 * Требования к задаче сохраняются, однако теперь они должны применяться к каждому бину находящемуся в контейнере.
 */

@Component
public class CacheBeanPostProcessor implements BeanPostProcessor {
    private Map<String, Object> map = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(Cache.class)) {
            map.put(beanName,bean);
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (map.containsKey(beanName)) {
           return CacheAnnotationProcessor.cache(map.get(beanName));
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
