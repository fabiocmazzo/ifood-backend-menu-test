package br.com.ifood.menu.service;

import br.com.ifood.menu.model.entity.*;
import br.com.ifood.menu.model.relationship.HaveItem;
import br.com.ifood.menu.model.relationship.HaveItemGroup;
import br.com.ifood.menu.model.relationship.HaveOption;
import br.com.ifood.menu.model.relationship.HaveOptionGroup;
import br.com.ifood.menu.repository.ChainRepository;
import br.com.ifood.menu.repository.ItemRepository;
import br.com.ifood.menu.repository.MenuRepository;
import br.com.ifood.menu.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.math.BigDecimal;

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

        /**
         * Cria restaurante
         */
        Restaurant restaurant = new Restaurant();
        restaurant.setCode("RJOAO");
        restaurant.setName("Restaurante de João");

        /**
         * Cria Menu
         */
        Menu menu = new Menu();
        menu.setCode("RJOAO_MENU_V01");

        /**
         * Cria ItemGroup Porções
         */
        ItemGroup itemGroupPorcoes = new ItemGroup();
        itemGroupPorcoes.setLabel("Porçoes");


        /**
         * Cria relacionamento itemGroup com menu.
         */
        HaveItemGroup haveItemGroup = new HaveItemGroup();
        haveItemGroup.setActive(true);
        haveItemGroup.setItemGroup(itemGroupPorcoes);
        haveItemGroup.setMenu(menu);
        menu.setHaveItemGroup(haveItemGroup);

        /**
         * Cria item Batata frita.
         */
        Item itemBatataFrita = new Item();
        itemBatataFrita.setCode("BATATA_FRITA");
        itemBatataFrita.setLabel("Batata Frita");

        /**
         * Cria HaveItem
         */
        HaveItem haveItemBatataFrita = new HaveItem();
        haveItemBatataFrita.setItemGroup(itemGroupPorcoes);
        haveItemBatataFrita.setItem(itemBatataFrita);
        haveItemBatataFrita.setOrder(1);
        haveItemBatataFrita.setPrice(new BigDecimal("23.50"));

        itemGroupPorcoes.setHaveItem(haveItemBatataFrita);

        /**
         * O OptionGroup e os Options podem ser compartilhados.
         */
        OptionGroup optionGroupAdicionais = new OptionGroup();
        optionGroupAdicionais.setLabel("Adicionais");

        HaveOptionGroup haveOptionGroup = new HaveOptionGroup();
        haveOptionGroup.setItem(itemBatataFrita);
        haveOptionGroup.setOptionGroup(optionGroupAdicionais);
        haveOptionGroup.setOrder(1);


        Option bacon = new Option();
        bacon.setLabel("Bacon Picado");
        bacon.setType(OptionType.TOPIC);

        Option parmesao = new Option();
        parmesao.setLabel("Parmesão Ralado");
        parmesao.setType(OptionType.TOPIC);

        HaveOption haveBacon = new HaveOption();
        haveBacon.setCanRepeat(true);
        haveBacon.setOrder(1);
        haveBacon.setPrice(new BigDecimal("3"));
        haveBacon.setOption(bacon);
        haveBacon.setOptionGroup(optionGroupAdicionais);

        HaveOption haveParmesao = new HaveOption();
        haveParmesao.setCanRepeat(true);
        haveParmesao.setOrder(2);
        haveParmesao.setPrice(new BigDecimal("4"));
        haveParmesao.setOption(bacon);
        haveParmesao.setOptionGroup(optionGroupAdicionais);

        optionGroupAdicionais.addHaveOption(haveBacon);
        optionGroupAdicionais.addHaveOption(haveParmesao);




    }



    @PostConstruct
    public void init() {
        createTestData();
    }
}
