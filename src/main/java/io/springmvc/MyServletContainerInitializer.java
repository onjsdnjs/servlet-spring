package io.springmvc;

import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HandlesTypes;
import org.springframework.util.ReflectionUtils;

import java.util.Set;

@HandlesTypes(MyWebAppInitializer.class)  // 특정 타입을 다룰 수 있다.
public class MyServletContainerInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        for (Class<?> initClass : c) {
            try {
                MyWebAppInitializer initializer = (MyWebAppInitializer) ReflectionUtils.accessibleConstructor(initClass).newInstance();

//                initializer.onStartup(ctx);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}