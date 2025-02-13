import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HandlesTypes;

import java.util.Set;

@HandlesTypes(MyWebAppInitializer.class)  // 특정 타입을 다룰 수 있다.
public class MyServletContainerInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        System.out.println("Custom ServletContainerInitializer 실행됨");
        // 여기서 ServletContext 리스너나 다른 초기화 로직 등록 가능
    }
}