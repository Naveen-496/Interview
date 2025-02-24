package dev.reddy.boot_master.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class BeanInterceptorExample implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof UserService) {
            System.out.println("UserService bean about to be initialized: " + beanName);
            // We can modify the bean here or even replace it entirely
        }
        return bean; // Return the bean instance to use
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof UserService) {
            System.out.println("UserService bean has been initialized: " + beanName);
            // We could implement AOP-like functionality by wrapping the bean in a proxy
        }
        return bean;
    }
}