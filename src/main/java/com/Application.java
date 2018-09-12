package com;







import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.support.SpringBootServletInitializer;







@SpringBootApplication

@EnableAutoConfiguration
//@SuppressWarnings("unchecked")
public class Application extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer{

	private static String port ="2019";//分实例
	//private static String port ="2077";//总实例
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

		return application.sources(Application.class);
	}

	public static void main(String[] args) throws Exception {
		if(args.length>0) {
			port = args[0];
	
		}
		SpringApplication.run(Application.class, args);
	}
	@Override
	public void customize(ConfigurableEmbeddedServletContainer arg0) {
		arg0.setPort(Integer.parseInt(port)); 

	}

}
