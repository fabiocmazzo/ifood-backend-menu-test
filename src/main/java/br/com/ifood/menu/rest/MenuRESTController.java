package br.com.ifood.menu.rest;

import br.com.ifood.menu.dto.MenuDto;
import br.com.ifood.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Menu REST Controller to expose menu to world.
 * @author Fabio Covolo Mazzo
 */
@RestController
public class MenuRESTController {

    @Autowired
    private MenuService menuService;

    /**
     * Get menuDto by restaurantCode
     * @param restaurantCode The Restaurant Code;
     * @return menuDTO
     */
    @RequestMapping("/rest/menu")
    public MenuDto getMenu(@RequestParam(value="code") String restaurantCode) {
        return menuService.getMenuDTO(restaurantCode);
    }


}
