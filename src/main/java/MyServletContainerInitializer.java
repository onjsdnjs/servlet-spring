import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HandlesTypes;

import java.util.Set;

@HandlesTypes(MyWebAppInitializer.class)  // 특정 타입을 다룰 수 있다.
public class MyServletContainerInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        for (Class<?> initClass : c) {
            try {
                MyWebAppInitializer initializer = (MyWebAppInitializer) initClass.getDeclaredConstructor().newInstance();

                initializer.onStartup(ctx);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}