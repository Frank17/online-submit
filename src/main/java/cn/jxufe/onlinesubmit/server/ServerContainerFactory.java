/**
 * 
 */
package cn.jxufe.onlinesubmit.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 服务器容器工厂类，负责产生自定义容器类型
 * @author Frank
 *
 */
@Configuration
public class ServerContainerFactory {

	@Autowired
	private ServerContainerConfiguration conf;
	
	@Bean
	public EmbeddedServletContainerFactory produceTomcatAsConfiguration() {
		TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
	
		factory.setPort(conf.getPort());
		
		
		return factory;
	
	}
	
}
