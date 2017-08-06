package br.com.ifood.menu;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.FstCodec;
import org.redisson.config.Config;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Configuration
@ComponentScan
public class MenuConfiguration {

    @Bean(destroyMethod = "shutdown")
    public RedissonClient redisson() {
        Config config = new Config();
        config.useSingleServer().setAddress("http://localhost:6379");
        // FSTCode é bem mais performatico que a JVM para
        // serializar/deserializar
        FstCodec fstCodec = new FstCodec();
        config.setCodec(fstCodec);
        return Redisson.create(config);
    }

    @Bean
    public Logger getLogger(InjectionPoint p) {
        return Logger.getLogger(p.getClass().getCanonicalName());
    }


}
