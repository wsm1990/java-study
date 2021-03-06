package com.tuacy.study.springboot.hook.importBeanDefinitionRegistrar.runstart;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @name: RunStartScannerRegister
 * @author: tuacy.
 * @date: 2019/8/16.
 * @version: 1.0
 * @Description:
 */
public class RunStartScannerRegister implements ImportBeanDefinitionRegistrar {

    private final static String PACKAGE_NAME_KEY = "basePackages";

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        AnnotationAttributes annoAttrs = AnnotationAttributes.fromMap(annotationMetadata.getAnnotationAttributes(RunStartScan.class.getName()));
        if (annoAttrs == null || annoAttrs.isEmpty()) {
            return;
        }

        String[] basePackages = (String[]) annoAttrs.get(PACKAGE_NAME_KEY);
        RunStartManager.INSTANCE.autoStartScan(basePackages);
    }
}
