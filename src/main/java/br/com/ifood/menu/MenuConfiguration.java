package br.com.ifood.menu;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.FstCodec;
import org.redisson.config.Config;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Configuration
@ComponentScan
public class MenuConfiguration {

    @Value("${redis.uri}")
    private String redisURI;


    @Bean(destroyMethod = "shutdown")
    public RedissonClient redisson() {
        Config config = new Config();
        config.useSingleServer().setAddress(redisURI);
        // FSTCode é bem mais performatico que a JVM para
        // serializar/deserializar
        FstCodec fstCodec = new FstCodec();
        config.setCodec(fstCodec);
        return Redisson.create(config);
    }

}
