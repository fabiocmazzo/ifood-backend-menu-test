package br.com.ifood.menu.service;

import br.com.ifood.menu.repository.ChainRepository;
import br.com.ifood.menu.repository.ItemRepository;
import br.com.ifood.menu.repository.MenuRepository;
import br.com.ifood.menu.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

/**
 * Service to create test data.
 * @author Fabio Covolo Mazzo
 */
@Service
public class StartupService {

    @Autowired
    private ChainRepository chainRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private ItemRepository itemRepository;




    private void createTestData() {



    }



    @PostConstruct
    public void init() {
        createTestData();
    }
}
