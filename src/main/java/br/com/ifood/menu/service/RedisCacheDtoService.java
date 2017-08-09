package br.com.ifood.menu.service;

import br.com.ifood.menu.dto.MenuDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * Spring Data Redis, to cache MenuDto and minimize access to Neo$J.
 * @author Fabio Covolo Mazzo
 */
@Service
public class RedisCacheDtoService {

    /**
     * Key for differ entries in Redis Server.
     */
    private static final String KEY = "DTO_MENU_IFOOD";

    @Autowired
    private RedisTemplate<String, Object> templateRedis;

    @Value("${redis.seconds.ttl}")
    private Long redisTtl;

    private HashOperations hashOps;

    @PostConstruct
    private void init() {
        hashOps = templateRedis.opsForHash();
    }

    @Value("${redis.seconds.ttl}")
    private Long redisSecondsTTL;


    /**
     * Put MenuDTO in Redis.
     * @param menuDto MenuDto
     * @param restaurantCode Restaurant's code
     */
    public void put(String restaurantCode, MenuDto menuDto) {
        hashOps.put(KEY, restaurantCode, menuDto);
        templateRedis.expire( KEY, redisTtl, TimeUnit.SECONDS );
    }

    /**
     * Get MenuDto from Redis.
     * @param restaurantCode Restaurant's code
     * @return MenuDto Object
     */
    public MenuDto get(String restaurantCode) {
        return (MenuDto) hashOps.get(KEY, restaurantCode);
    }


}
