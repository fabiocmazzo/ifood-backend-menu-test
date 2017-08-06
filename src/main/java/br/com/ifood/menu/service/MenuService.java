package br.com.ifood.menu.service;

import br.com.ifood.menu.dto.MenuDto;
import br.com.ifood.menu.dto.adapter.MenuAdapter;
import br.com.ifood.menu.model.entity.Menu;
import br.com.ifood.menu.repository.MenuRepository;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class MenuService {


    @Autowired
    private MenuRepository menuRepository;


    @Autowired
    private RedissonClient redissonClient;

    @Value("${redis.seconds.ttl}")
    private Long redisSecondsTTL;


    private Menu getMenu(String code) {
        return menuRepository.findByCode(code);
    }


    public MenuDto getMenuDTO(String code) {
        // Verify if apapted object is persisted in REDIS
        RBucket<MenuDto> bucket = redissonClient.getBucket(code);
        MenuDto menuDto = bucket.get();
        if (menuDto != null) {
            return menuDto;
        }

        menuDto = MenuAdapter.adapt(getMenu(code));
        bucket.set(menuDto, redisSecondsTTL, TimeUnit.SECONDS);
        return menuDto;
    }
}
