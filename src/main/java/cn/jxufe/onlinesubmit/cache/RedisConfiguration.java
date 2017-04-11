/**
 * 
 */
package cn.jxufe.onlinesubmit.cache;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Redis配置文件映射
 * @author Frank
 *
 */
@Component
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConfiguration {

	private String host;
	
	private long port;
	
	private long timeout;

	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * @return the port
	 */
	public long getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(long port) {
		this.port = port;
	}

	/**
	 * @return the timeout
	 */
	public long getTimeout() {
		return timeout;
	}

	/**
	 * @param timeout the timeout to set
	 */
	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RedisConfiguration [host=" + host + ", port=" + port + ", timeout=" + timeout + "]";
	}
	
}
