package br.com.ifood.menu.service;

import br.com.ifood.menu.dto.MenuDto;
import br.com.ifood.menu.dto.adapter.MenuAdapter;
import br.com.ifood.menu.model.entity.Menu;
import br.com.ifood.menu.model.entity.Restaurant;
import br.com.ifood.menu.repository.RestaurantRepository;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * MenuService Bean, use to find Menu and transforms to
 * MenuDto using Redis Cache if avaliable.
 * @author Fabio Covolo Mazzo
 */
@Service
public class MenuService {


    @Autowired
    private RestaurantRepository restaurantRepository;


    @Autowired
    private RedissonClient redissonClient;

    @Value("${redis.seconds.ttl}")
    private Long redisSecondsTTL;


    /**
     * Get menu from Neo4j Repository by restaurant code.
     * @param restaurantCode restaurant code
     * @return Menu entity
     */
    private Menu getMenu(String restaurantCode) {
        Restaurant restaurant = restaurantRepository.findByCode(restaurantCode);
        // Return empty menu if not found
        Menu menu = new Menu();
        if(restaurant != null) {
            menu = restaurant.getMenu();
        }
        return menu;
    }


    /**
     * Return MenuDto in Redis cache or find in Neo4j Repository
     * and transforms in menuDto and cache it.
     * @param restaurantCode Restaurant code.
     * @return MenuDto
     */
    public MenuDto getMenuDTO(String restaurantCode) {
        // Verify if apapted object is persisted in REDIS
        RBucket<MenuDto> bucket = redissonClient.getBucket(restaurantCode);
        MenuDto menuDto = bucket.get();
        if (menuDto != null) {
            return menuDto;
        }
        menuDto = MenuAdapter.adapt(getMenu(restaurantCode));
        bucket.set(menuDto, redisSecondsTTL, TimeUnit.SECONDS);
        return menuDto;
    }
}
