package br.com.ifood.menu.service;

import br.com.ifood.menu.dto.MenuDto;
import br.com.ifood.menu.dto.adapter.MenuAdapter;
import br.com.ifood.menu.model.entity.Menu;
import br.com.ifood.menu.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * MenuService Bean, use to find Menu and transforms to
 * MenuDto using Redis Cache if avaliable.
 * @author Fabio Covolo Mazzo
 */
@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private RedisCacheDtoService redisCacheDtoService;


    /**
     * Get menu from Neo4j Repository by restaurant code.
     * @param restaurantCode restaurant code
     * @return Menu entity
     */
    private Menu getMenu(String restaurantCode) {
          return menuRepository.findRelated(restaurantCode);
    }


    /**
     * Return MenuDto in Redis cache or find in Neo4j Repository
     * and transforms in menuDto and cache it.
     * @param restaurantCode Restaurant code.
     * @return MenuDto MenuDto Object.
     */
    public MenuDto getMenuDTO(String restaurantCode) {
        // Verify if apapted object is persisted in REDIS
        MenuDto menuDto = redisCacheDtoService.get(restaurantCode);
        if (menuDto != null) {
            return menuDto;
        }
        menuDto = MenuAdapter.adapt(getMenu(restaurantCode));
        redisCacheDtoService.put(restaurantCode, menuDto);
        return menuDto;
    }
}
