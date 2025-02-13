import jakarta.servlet.ServletContext;

public class MyWebAppInitializerImpl implements MyWebAppInitializer {
    @Override
    public void onStartup(ServletContext servletContext) {
        System.out.println("onStartup");
        // 여기서 ServletContext 관련 로직 수행
        // 예: DispatcherServlet 등록, 필터 등록 등
    }
}
