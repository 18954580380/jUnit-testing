package tech.imatrix.demo.ssm;

import org.springframework.context.annotation.Configuration;

/** 通用mapper的配置单独移出来，这样就不会影响controller层的单元测试。WebMvcTest默认不会加载额外的configuration。
 * 如果把MapperScan注解放到SpringBootApplication类上，
 * controller单元测试的时候也会去扫描mapper就会出现找不到bean的问题。
 * 但是Service层的测试，SpringBootTest会加载这个configuration。
 **/
@Configuration
@tk.mybatis.spring.annotation.MapperScan(basePackages = "tech.imatrix.demo.ssm.dao")
public class GeneralMapperConfiguration {
}
