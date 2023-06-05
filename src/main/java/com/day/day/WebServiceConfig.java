package com.day.day;

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

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<>(servlet, "/ws/*");
	}

	@Bean(name = "countries")
	public DefaultWsdl11Definition  defaultWsdl11Definition(XsdSchema diasSchema) {
		DefaultWsdl11Definition ddiaDefinition = new DefaultWsdl11Definition();
		ddiaDefinition.setPortTypeName("DiasPort");
		ddiaDefinition.setLocationUri("/ws");
		ddiaDefinition.setTargetNamespace("http://spring.io/guides/gs-producing-web-service");
		ddiaDefinition.setSchema(diasSchema);
		return ddiaDefinition;
	}

	@Bean
	public XsdSchema diasSchema() {
		return new SimpleXsdSchema(new ClassPathResource("dias.xsd"));
	}
}
