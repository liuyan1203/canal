package com.haiziwang.commodity.datasources;

import com.haiziwang.commodity.annotation.DataSourceTypeAnnotation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect    // for aop
@Component // for auto scan
@Order(0)  // execute before @Transactional
public class MultipleDataSourceAop {
    private final Logger logger = LoggerFactory.getLogger(MultipleDataSourceAop.class);

    @Before("execution(* com.haiziwang.commodity.mapper.*Mapper.*(..))")
    public void changeDataSource(JoinPoint joinPoint) {
        try {
            // 拦截实体类，就是当前正在执行的service
            Class<?> clazz = joinPoint.getTarget().getClass();
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod();
            // 提取目标对象方法注解和类型注解中的数据源标识(这里)
            DataSourceTypeAnnotation classAnnotation = clazz.getDeclaredAnnotation(DataSourceTypeAnnotation.class);
            if (classAnnotation != null) {
                MultipleDataSource.setDataSource(classAnnotation.value());
                logger.debug("Service Method 数据源切换至--->" + classAnnotation.value());
            } else {
                //获取接口上的注解
                for (Class<?> cls : clazz.getInterfaces()) {
                    classAnnotation = cls.getAnnotation(DataSourceTypeAnnotation.class);
                    if (classAnnotation != null) {
                        MultipleDataSource.setDataSource(classAnnotation.value());
                        logger.debug("Service Method 数据源切换至--->" + classAnnotation.value());
                        break;
                    }
                }

            }

//            if (clazz.isAnnotationPresent(DataSourceTypeAnnotation.class)) {
//                DataSourceTypeAnnotation source = clazz.getAnnotation(DataSourceTypeAnnotation.class);
//                MultipleDataSource.setDataSource(source.value());
//                logger.info("Service Class 数据源切换至--->" + source.value());
//            }

            Method realMethod = clazz.getDeclaredMethod(signature.getName(), method.getParameterTypes());
            if (realMethod != null) {
                DataSourceTypeAnnotation source = method.getAnnotation(DataSourceTypeAnnotation.class);
                if (source != null) {
                    MultipleDataSource.setDataSource(source.value());
                    logger.debug("Service Method 数据源切换至--->" + source.value());
                }

            }

//            Method m = clazz.getDeclaredMethod(method.getName(), types);
//            DataSourceTypeAnnotation source1 = m.getAnnotation(DataSourceTypeAnnotation.class);
//            if (m != null && m.isAnnotationPresent(DataSourceTypeAnnotation.class)) {
//                DataSourceTypeAnnotation source = m.getAnnotation(DataSourceTypeAnnotation.class);
//                MultipleDataSource.setDataSource(source.value());
//                logger.info("Service Method 数据源切换至--->" + source.value());
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 方法结束后
     */
    @After("execution(* com.haiziwang.commodity.mapper.*Mapper.*(..))")
    public void afterReturning() {
        try {
            MultipleDataSource.clearDataSource();
            logger.debug("数据源已移除！");
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("数据源移除报错！");
        }

    }


}