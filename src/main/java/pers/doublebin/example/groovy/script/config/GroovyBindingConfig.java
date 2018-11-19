package pers.doublebin.example.groovy.script.config;

import groovy.lang.Binding;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class GroovyBindingConfig implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Bean("groovyBinding")
    public Binding groovyBinding() {
        Binding groovyBinding = new Binding();

        Map<String, Object> beanMap = applicationContext.getBeansOfType(Object.class);
        for (String beanName : beanMap.keySet()) {
            groovyBinding.setVariable(beanName, beanMap.get(beanName));
        }
        return groovyBinding;
    }

    /*@Bean("groovyBinding1")
    public Binding groovyBinding1() {
        Map<String, Object> beanMap = applicationContext.getBeansOfType(Object.class);
        return new Binding(beanMap);
    }*/

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;

    }
}
