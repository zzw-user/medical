package com.ylht;

import com.ylht.util.CrosFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan({"com.ylht.mapper","com.ylht.mapperzxz"})
@SpringBootApplication
public class MedicalApplication {
    public static void main(String[] args) {
        SpringApplication.run(MedicalApplication.class,args);
    }

    @Bean
    public FilterRegistrationBean registerFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.addUrlPatterns("/*");
        bean.setFilter(new CrosFilter());
        return bean;
    }
}