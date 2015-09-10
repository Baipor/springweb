package thjug.springboot;

import javax.servlet.Filter;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import thjug.springboot.filter.AnalyticFilter;
import thjug.springboot.filter.PermissionFilter;

@Configuration
public class ServletConfig {

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {

        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(final ConfigurableEmbeddedServletContainer container) {
                container.addErrorPages(
                        new ErrorPage(HttpStatus.UNAUTHORIZED, "/401.html"),
                        new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"),
                        new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html")
                );
            }
        };
    }

    @Bean
    public FilterRegistrationBean analyticFilterBean() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(analyticFilter());
        registration.addUrlPatterns("/*");
        registration.setName("analyticFilter");
        registration.setOrder(Integer.MAX_VALUE - 1);
        return registration;
    }

    @Bean
    public FilterRegistrationBean permissionFilterBean() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(permissionFilter());
        registration.addUrlPatterns("/auth/*");
        registration.setOrder(Integer.MAX_VALUE);
        return registration;
    }

    @Bean(name = "permissionFilter")
    public Filter permissionFilter() {
        return new PermissionFilter();
    }

    @Bean(name = "analyticFilter")
    public Filter analyticFilter() {
        return new AnalyticFilter();
    }

}
