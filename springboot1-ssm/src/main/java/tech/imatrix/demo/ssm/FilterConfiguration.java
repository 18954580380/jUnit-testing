package tech.imatrix.demo.ssm;

import com.nerderg.ajaxanywhere.AAFilter;
import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {

    @Bean
    public FilterRegistrationBean registFilters() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new AAFilter());
//        springboot 自动配置的spring mvc dispatcherSevlet的名字
        registration.addServletNames("dispatcherServlet");
//        如果使用/*路径匹配会导致静态资源和jsp被拦截。jsp也是servlet，一个controller执行过程中，AAFilter会拦截两次
//        AAFilter会拦截两次:controller对应的dispatcherServlet一次，forward到jsp页面有拦截一次，会导致zones区域重复
//        registration.addUrlPatterns("/*");
//        registration.addInitParameter("paramName", "paramValue");
        registration.setName("AjaxAnywhere");
        registration.setOrder(1);
        return registration;
    }
}
