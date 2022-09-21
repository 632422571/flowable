package com.example.flowable.demo;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 6、因为我们在节点里面存的Class类，
 * 所以我们得通过实现ApplicationContextAware类来获取Spring容器中的bean实例
 */
@Component
public class BeanService implements ApplicationContextAware {

    /**
     * spring bean 上下文
     */
    protected static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BeanService.applicationContext = applicationContext;
    }

    public static Object getBeanByName(String name) throws BeansException {
        return applicationContext.getBean(name);
    }

    /**
     * 根据class类型获取bean
     * @throws BeansException 当有继承或者接口时（多个实现类）getBean(clazz)会报错
     *                         所以通过class name比较获取唯一的那个bean
     */
    public static <T> T getSingleBeanByType(Class<T> clazz) throws Exception {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            Object beanByName = getBeanByName(beanName);
            if (null != beanByName) {
                // 防止被代理拿不到bean
                Object target = AopTargetUtil.getTarget(beanByName);
                if (clazz.getName().equals(target.getClass().getName())) {
                    return (T) beanByName;
                }
            }
        }
        throw new RuntimeException();
    }

    public static <T> T getBean(String beanName) {
        if (applicationContext.containsBean(beanName)) {
            return (T) applicationContext.getBean(beanName);
        } else {
            return null;
        }
    }
}
