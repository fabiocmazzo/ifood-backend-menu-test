package br.com.ifood.menu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * MenuConfiguration Class.
 *
 * @author Fabio Covolo Mazzo
 */
@Configuration
@ComponentScan
public class MenuConfiguration {

    @Value("${redis.uri}")
    private String redisURI;

   @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConFactory = new JedisConnectionFactory();
        jedisConFactory.setHostName(redisURI);
        jedisConFactory.setPort(6379);
        return jedisConFactory;
    }

}
