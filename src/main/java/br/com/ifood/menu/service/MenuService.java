package br.com.ifood.menu.service;

import br.com.ifood.menu.dto.MenuDto;
import br.com.ifood.menu.dto.adapter.MenuAdapter;
import br.com.ifood.menu.model.entity.Menu;
import br.com.ifood.menu.model.entity.Restaurant;
import br.com.ifood.menu.repository.MenuRepository;
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
    private MenuRepository menuRepository;


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
        if(restaurant != null && restaurant.getMenu() != null) {
            menu = menuRepository.findOne(restaurant.getMenu().getId(), -1);
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
       // RBucket<MenuDto> bucket = redissonClient.getBucket(restaurantCode);
        //MenuDto menuDto = bucket.get();
        //Comentado para testar a lógica sem o REDIS
        //TODO:retornar o Redis e rodar testes de carga e performance após finalizar a lógica
        MenuDto menuDto = null;
        if (menuDto != null) {
            return menuDto;
        }
        menuDto = MenuAdapter.adapt(getMenu(restaurantCode));
        //bucket.set(menuDto, redisSecondsTTL, TimeUnit.SECONDS);
        return menuDto;
    }
}
