package com.yinrj.soupstudy.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

/**
 * @author Yin
 * @date 2021/1/23
 */
@EnableWs
@Configuration
public class WebserviceConfig extends WsConfigurerAdapter {
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        // 得到wsdl文件的路径
        return new ServletRegistrationBean(servlet, "/ws/*");
    }

    @Bean(name = "employee")
    public DefaultWsdl11Definition employeeWsdl11Definition(XsdSchema pda2wmsSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("EmployeePort");
        wsdl11Definition.setLocationUri("/ws/employee-detail");
        wsdl11Definition.setTargetNamespace("http://yinrj.com/soupstudy/type");
        wsdl11Definition.setSchema(pda2wmsSchema);
        return wsdl11Definition;
    }
    @Bean
    public XsdSchema employeeSchema() {
        return new SimpleXsdSchema(new ClassPathResource("/xsd/employee.xsd"));
    }

}
