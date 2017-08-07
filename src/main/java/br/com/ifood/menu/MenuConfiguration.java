package br.com.ifood.menu;

import com.fasterxml.jackson.core.type.TypeReference;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.JsonJacksonMapCodec;
import org.redisson.codec.FstCodec;
import org.redisson.codec.IonJacksonCodec;
import org.redisson.codec.KryoCodec;
import org.redisson.codec.SerializationCodec;
import org.redisson.config.Config;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.logging.Logger;

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


    /**
     * A factory for RedissonClient.
     *
     * @return redissonClient instance
     */
    @Bean(destroyMethod = "shutdown")
    public RedissonClient redisson() {
        Config config = new Config();
        config.useSingleServer().setAddress(redisURI);
        FstCodec fstCodec = new FstCodec();
        config.setCodec(fstCodec);
        return Redisson.create(config);
    }

}
