package edu.baykov.spring.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * 9.3.6 Рандомизация контейнером. Необходимо проверить конфигурацию контейнера в процессе его инициализации.
 * В случае если в списке бинов отсутствует бин с именем random, необходимо
 * добавить такой бин, при этом при каждом запросе из контейнера этого бина должно
 * возвращаться новое случайное число, лежащее в диапазоне от 0 до 100.
 */

@Component
public class CheckRandomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        if (beanFactory.containsBeanDefinition("random2")) return;

        BeanDefinitionRegistry registry = (BeanDefinitionRegistry) beanFactory;
        BeanDefinition bdf = new GenericBeanDefinition();
        bdf.setBeanClassName("edu.baykov.spring.RandomIntGenerator");
        bdf.setScope("prototype");
        bdf.setFactoryMethodName("get");
        registry.registerBeanDefinition("random2", bdf);
    }
}
