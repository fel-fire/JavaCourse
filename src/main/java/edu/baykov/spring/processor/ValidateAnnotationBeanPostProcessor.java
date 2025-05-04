package edu.baykov.spring.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 * 9.3.4 Валидация контейнером. Создайте постобработчик на основе метода validate из задачи 8.3.5
 * Общие требования сохраняются, однако необходимо внести изменения в аннотацию: в качестве свойства
 * теперь необходимо указывать не класс, а имя правила, требующего проверки.
 */

@Component
public class ValidateAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Autowired
    private ApplicationContext context;
    private Map<String, Object> map = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(Validate.class)) {
            map.put(beanName, bean);
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (map.containsKey(beanName) && !isValid(map.get(beanName)))
            throw new ValidateError("Validation error for bean " + beanName);
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    private boolean isValid(Object bean) {
        String predicateName = bean.getClass().getAnnotation(Validate.class).predicate();
        Object p = context.getBean(predicateName);
        if (!(p instanceof Predicate))
            throw new RuntimeException(predicateName +
                " is no Predicate.class. You must enter Predicate.class name");
        return ((Predicate) p).test(bean);
    }
}
