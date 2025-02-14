import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.springframework.stereotype.Component;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // 루트 컨텍스트 설정
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
//        rootContext.register(RootConfig.class);
        servletContext.addListener(new ContextLoaderListener(rootContext));

        // 첫 번째 서블릿 전용 컨텍스트 설정
        AnnotationConfigWebApplicationContext firstServletContext = new AnnotationConfigWebApplicationContext();
//        firstServletContext.register(FirstServletConfig.class);
        ServletRegistration.Dynamic firstDispatcher = servletContext.addServlet("firstDispatcher", new DispatcherServlet(firstServletContext));
        firstDispatcher.setLoadOnStartup(1);
        firstDispatcher.addMapping("/first/*");

        // 두 번째 서블릿 전용 컨텍스트 설정
        AnnotationConfigWebApplicationContext secondServletContext = new AnnotationConfigWebApplicationContext();
//        secondServletContext.register(SecondServletConfig.class);
        ServletRegistration.Dynamic secondDispatcher = servletContext.addServlet("secondDispatcher", new DispatcherServlet(secondServletContext));
        secondDispatcher.setLoadOnStartup(2);
        secondDispatcher.addMapping("/second/*");
    }
}
