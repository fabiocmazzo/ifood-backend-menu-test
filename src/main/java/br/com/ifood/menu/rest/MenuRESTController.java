package br.com.ifood.menu.rest;

import br.com.ifood.menu.dto.MenuDto;
import br.com.ifood.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuRESTController {

    @Autowired
    private MenuService menuService;

    public MenuDto getMenu(@RequestParam(value="code") String code) {
        return menuService.getMenuDTO(code);
    }

}
