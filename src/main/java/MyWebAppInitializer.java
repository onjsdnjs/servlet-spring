import jakarta.servlet.ServletContext;

public interface MyWebAppInitializer {
    // 실제 초기화에 필요한 메서드 정의
    void onStartup(ServletContext servletContext);
}
