/**
 * 
 */
package cn.jxufe.onlinesubmit.server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Tomcat的配置类
 * @author Frank
 *
 */
@Component
public class ServerContainerConfiguration {

	@Value("${spring.container.tomcat.404}")
	private String notfoundPage;
	
	@Value("${spring.container.tomcat.500}")
	private String errorPage;
	
	@Value("${spring.container.tomcat.port}")
	private int port;

	/**
	 * @return the notfoundPage
	 */
	public String getNotfoundPage() {
		return notfoundPage;
	}

	/**
	 * @param notfoundPage the notfoundPage to set
	 */
	public void setNotfoundPage(String notfoundPage) {
		this.notfoundPage = notfoundPage;
	}

	/**
	 * @return the errorPage
	 */
	public String getErrorPage() {
		return errorPage;
	}

	/**
	 * @param errorPage the errorPage to set
	 */
	public void setErrorPage(String errorPage) {
		this.errorPage = errorPage;
	}

	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	}
	
}
