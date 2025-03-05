package io.springmvc;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // 루트 컨텍스트 설정
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        servletContext.addListener(new ContextLoaderListener(rootContext));

        // 서블릿 전용 컨텍스트 설정
        AnnotationConfigWebApplicationContext firstServletContext = new AnnotationConfigWebApplicationContext();
        firstServletContext.register(WebConfig.class);
        ServletRegistration.Dynamic firstDispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(firstServletContext));
        firstDispatcher.setLoadOnStartup(1);
        firstDispatcher.addMapping("/");

    }
}
