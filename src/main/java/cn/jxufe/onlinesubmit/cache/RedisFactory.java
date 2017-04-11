/**
 * 
 */
package cn.jxufe.onlinesubmit.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Redis工厂，用于创建Jedis连接
 * @author Frank
 *
 */

@Configuration
@EnableRedisHttpSession
public class RedisFactory {
	
	@Autowired
	private RedisConfiguration redisConfig;
	
	@Bean
	public JedisConnectionFactory connectionFactory() {
		JedisConnectionFactory factory = new JedisConnectionFactory();
		
		factory.setHostName(redisConfig.getHost());
		factory.setTimeout((int) redisConfig.getTimeout());
		factory.setPort((int) redisConfig.getPort());
		
		return factory;
	}
	
}
