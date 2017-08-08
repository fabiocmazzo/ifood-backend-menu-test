package br.com.ifood.menu.service;

import br.com.ifood.menu.model.entity.*;
import br.com.ifood.menu.model.relationship.*;
import br.com.ifood.menu.repository.*;
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

    @Autowired
    private OptionRepository optionRepository;

    @Autowired
    private OptionGroupRepository optionGroupRepository;

    @Autowired
    private ItemComboRepository itemComboRepository;

    @Autowired
    private ItemGroupRepository itemGroupRepository;

    @Autowired
    private CommonItemPoolRepository commonItemPoolRepository;

    private void createChainAndRestaurant() {

        /**
         * Cria chain
         */
        Chain chain = new Chain();
        chain.setCode("REDEMCDONALDS");
        chain.setName("Rede McDonalds");

        /**
         * Cria restaurante
         */
        Restaurant restaurant = new Restaurant();
        restaurant.setCode("MCDONALDSCAMBUI");
        restaurant.setName("McDonalds Cambui");
        restaurant.setChain(chain);


        /**
         * Cria Menu
         */
        Menu menuChain = new Menu();
        menuChain.setCode("MCDONALDS_PADRAO_CHAIN");
        restaurant.setMenu(menuChain);
        chain.setMenu(menuChain);

        ItemGroup itemGroupRestaurant = new ItemGroup();
        itemGroupRestaurant.setCode("LANCHES-SELECIONADOS");
        itemGroupRestaurant.setLabel("Lanches Selecionados");

        ItemGroup itemGroupCombos = new ItemGroup();
        itemGroupCombos.setCode("COMBOS");
        itemGroupCombos.setLabel("Combos");

        /**
         * Cria ItemGroup Bebidas
         */
        ItemGroup itemGroupLanches = new ItemGroup();
        itemGroupLanches.setCode("LANCHES-MCDONALDS");
        itemGroupLanches.setLabel("Lanches");

        /**
         * Cria ItemGroup Bebidas
         */
        ItemGroup itemGroupBebidas = new ItemGroup();
        itemGroupBebidas.setCode("BEBIDAS-MCDONALDS");
        itemGroupBebidas.setLabel("Bebidas");


        /**
         * Cria relacionamento itemGroup com menu do restaurante.
         */
        HaveItemGroup haveItemGroupLanchesSelecionados = new HaveItemGroup();
        haveItemGroupLanchesSelecionados.setAvailable(true);
        haveItemGroupLanchesSelecionados.setItemGroup(itemGroupRestaurant);
        haveItemGroupLanchesSelecionados.setMenu(menuChain);
        haveItemGroupLanchesSelecionados.setChainCode(chain.getCode());
        menuChain.addHaveItemGroup(haveItemGroupLanchesSelecionados);


        /**
         * Cria relacionamento itemGroup Bebidas com menu.
         */
        HaveItemGroup haveItemGroupBebidas = new HaveItemGroup();
        haveItemGroupBebidas.setAvailable(true);
        haveItemGroupBebidas.setItemGroup(itemGroupBebidas);
        haveItemGroupBebidas.setMenu(menuChain);
        haveItemGroupLanchesSelecionados.setChainCode(chain.getCode());
        menuChain.addHaveItemGroup(haveItemGroupBebidas);


        /**
         * Cria relacionamento itemGroup Lanches com menu.
         */
        HaveItemGroup haveItemGroupLanches = new HaveItemGroup();
        haveItemGroupLanches.setAvailable(true);
        haveItemGroupLanches.setItemGroup(itemGroupLanches);
        haveItemGroupLanches.setMenu(menuChain);
        haveItemGroupLanchesSelecionados.setChainCode(chain.getCode());
        menuChain.addHaveItemGroup(haveItemGroupLanches);


        /**
         * Cria item Cheese-Burger
         */
        Item itemCheeseBurger = new Item();
        itemCheeseBurger.setCode("BIG-MAC");
        itemCheeseBurger.setLabel("BigMac");

        Item itemHamburguer = new Item();
        itemHamburguer.setCode("BIG-TASTY");
        itemHamburguer.setLabel("BigTasty");

        Item itemDoubleCheeseBacon = new Item();
        itemDoubleCheeseBacon.setCode("QUARTEIRAO");
        itemDoubleCheeseBacon.setLabel("Quarteirão");

        Item itemCheeseOrion = new Item();
        itemCheeseOrion.setCode("MCCHICKEN");
        itemCheeseOrion.setLabel("McChicken");


        HaveItem haveItemCheeseBurger = new HaveItem();
        haveItemCheeseBurger.setItemGroup(itemGroupLanches);
        haveItemCheeseBurger.setItem(itemCheeseBurger);
        haveItemCheeseBurger.setOrder(1);
        haveItemCheeseBurger.setAvailable(true);
        haveItemCheeseBurger.setChainCode(chain.getCode());
        haveItemCheeseBurger.setPrice(new BigDecimal("15.50"));

        itemGroupLanches.addHaveItem(haveItemCheeseBurger);

        HaveItem haveItemHamburguer = new HaveItem();
        haveItemHamburguer.setItemGroup(itemGroupLanches);
        haveItemHamburguer.setItem(itemHamburguer);
        haveItemHamburguer.setOrder(1);
        haveItemHamburguer.setAvailable(true);
        haveItemHamburguer.setRestaurantCode(restaurant.getCode());
        haveItemHamburguer.setPrice(new BigDecimal("18.50"));

        itemGroupLanches.addHaveItem(haveItemHamburguer);


        HaveItem haveItemDoubleCheeseBacon = new HaveItem();
        haveItemDoubleCheeseBacon.setItemGroup(itemGroupLanches);
        haveItemDoubleCheeseBacon.setItem(itemDoubleCheeseBacon);
        haveItemDoubleCheeseBacon.setOrder(1);
        haveItemDoubleCheeseBacon.setChainCode(chain.getCode());
        haveItemDoubleCheeseBacon.setPrice(new BigDecimal("23.50"));

        itemGroupLanches.addHaveItem(haveItemDoubleCheeseBacon);

        HaveItem haveItemCheeseOrion = new HaveItem();
        haveItemCheeseOrion.setItemGroup(itemGroupLanches);
        haveItemCheeseOrion.setItem(itemCheeseOrion);
        haveItemCheeseOrion.setOrder(1);
        haveItemCheeseOrion.setChainCode(chain.getCode());
        haveItemCheeseOrion.setPrice(new BigDecimal("33.50"));

        HaveItem haveItemCheeseOrionRestaurant = new HaveItem();
        haveItemCheeseOrionRestaurant.setItemGroup(itemGroupLanches);
        haveItemCheeseOrionRestaurant.setItem(itemCheeseOrion);
        haveItemCheeseOrionRestaurant.setOrder(1);
        haveItemCheeseOrionRestaurant.setRestaurantCode(restaurant.getCode());
        haveItemCheeseOrionRestaurant.setPrice(new BigDecimal("77.50"));


        itemGroupLanches.addHaveItem(haveItemCheeseOrion);
        itemGroupLanches.addHaveItem(haveItemCheeseOrionRestaurant);






        /**
         * O OptionGroup e os Options podem ser compartilhados.
         */
        OptionGroup optionGroupAdicionais = new OptionGroup();
        optionGroupAdicionais.setLabel("Adicionais");

        HaveOptionGroup haveOptionGroup = new HaveOptionGroup();
        haveOptionGroup.setItem(itemHamburguer);
        haveOptionGroup.setAvailable(true);
        haveOptionGroup.setChainCode(chain.getCode());
        haveOptionGroup.setOptionGroup(optionGroupAdicionais);
        haveOptionGroup.setOrder(1);


        Option bacon = new Option();
        bacon.setLabel("Bacon Picado");
        bacon.setType(OptionType.TOPIC);

        Option parmesao = new Option();
        parmesao.setLabel("Parmesão Ralado");
        parmesao.setType(OptionType.TOPIC);

        HaveOption haveBacon = new HaveOption();
        haveBacon.setOrder(1);
        haveBacon.setPrice(new BigDecimal("3"));
        haveBacon.setOption(bacon);
        haveBacon.setAvailable(true);
        haveBacon.setOptionGroup(optionGroupAdicionais);
        haveBacon.setChainCode(chain.getCode());

        // Desabilita apenas para o restaurant

        HaveOption dontHaveBacon = new HaveOption();
        dontHaveBacon.setOrder(1);
        dontHaveBacon.setPrice(new BigDecimal("3"));
        dontHaveBacon.setOption(bacon);
        dontHaveBacon.setAvailable(true);
        dontHaveBacon.setOptionGroup(optionGroupAdicionais);
        dontHaveBacon.setRestaurantCode(restaurant.getCode());


        HaveOption haveParmesao = new HaveOption();
        haveParmesao.setOrder(2);
        haveParmesao.setPrice(new BigDecimal("4"));
        haveParmesao.setOption(parmesao);
        haveParmesao.setOptionGroup(optionGroupAdicionais);
        haveParmesao.setRestaurantCode(restaurant.getCode());


        optionGroupAdicionais.addHaveOption(haveBacon);
        optionGroupAdicionais.addHaveOption(haveParmesao);
        optionGroupAdicionais.addHaveOption(dontHaveBacon);



        /**
         * Cria item Coca-Cola.
         */
        Item itemCocaCola = new Item();
        itemCocaCola.setCode("COCA_COLA");
        itemCocaCola.setLabel("Coca-Cola");


        /**
         * Cria HaveItem para a Fanta
         */
        HaveItem haveItemCocaCola = new HaveItem();
        haveItemCocaCola.setItemGroup(itemGroupBebidas);
        haveItemCocaCola.setItem(itemCocaCola);
        haveItemCocaCola.setOrder(1);
        haveItemCocaCola.setAvailable(true);
        haveItemCocaCola.setChainCode(chain.getCode());
        haveItemCocaCola.setPrice(new BigDecimal("9.50"));

        itemGroupBebidas.addHaveItem(haveItemCocaCola);


        /**
         * Cria item Fanta.
         */
        Item itemFanta = new Item();
        itemFanta.setCode("FANTA");
        itemFanta.setLabel("Fanta");


        /**
         * Cria HaveItem para a Fanta
         */
        HaveItem haveItemFanta = new HaveItem();
        haveItemFanta.setItemGroup(itemGroupBebidas);
        haveItemFanta.setItem(itemFanta);
        haveItemFanta.setOrder(1);
        haveItemFanta.setRestaurantCode(restaurant.getCode());
        haveItemFanta.setPrice(new BigDecimal("23.50"));

        itemGroupBebidas.addHaveItem(haveItemFanta);


        /**
         * Cria OptionGroup de Tamnanho de refrigerante (será compartilhado para todos os refrigerantes).
         */
        OptionGroup optionGroupSizeRefri = new OptionGroup();
        optionGroupSizeRefri.setLabel("Tamanho Refrigerante");

        Option option350ml = new Option();
        option350ml.setType(OptionType.SIZE);
        option350ml.setLabel("350 ml");
        HaveOption haveOption350ml = new HaveOption();
        haveOption350ml.setOrder(1);
        haveOption350ml.setPrice(new BigDecimal("4.50"));
        haveOption350ml.setOption(option350ml);
        haveOption350ml.setOptionGroup(optionGroupSizeRefri);
        optionGroupSizeRefri.addHaveOption(haveOption350ml);




        Option option600ml = new Option();
        option600ml.setType(OptionType.SIZE);
        option600ml.setLabel("600 ml");
        HaveOption haveOption600ml = new HaveOption();
        haveOption600ml.setOrder(2);
        haveOption600ml.setPrice(new BigDecimal("6.50"));
        haveOption600ml.setOption(option600ml);
        haveOption600ml.setOptionGroup(optionGroupSizeRefri);
        optionGroupSizeRefri.addHaveOption(haveOption600ml);


        Option option2L = new Option();
        option2L.setType(OptionType.SIZE);
        option2L.setLabel("2 L");
        HaveOption haveOption2L = new HaveOption();
        haveOption2L.setOrder(2);
        haveOption2L.setPrice(new BigDecimal("10.50"));
        haveOption2L.setOption(option2L);
        haveOption2L.setOptionGroup(optionGroupSizeRefri);
        optionGroupSizeRefri.addHaveOption(haveOption2L);


        HaveOptionGroup haveOptionGroupSizeCoca = new HaveOptionGroup();
        haveOptionGroupSizeCoca.setOptionGroup(optionGroupSizeRefri);
        haveOptionGroupSizeCoca.setItem(itemCocaCola);
        itemCocaCola.addHaveOptionGroup(haveOptionGroupSizeCoca);


        HaveOptionGroup haveOptionGroupSizeFanta = new HaveOptionGroup();
        haveOptionGroupSizeFanta.setOptionGroup(optionGroupSizeRefri);
        haveOptionGroupSizeFanta.setItem(itemFanta);
        itemFanta.addHaveOptionGroup(haveOptionGroupSizeFanta);




        /**
         * Tem fixo batata frita mais 2 coca-colas, caso
         * queira deixar a opção mais flexivel como batata frita mais
         * 2 refrigerantes é possivel cadastrar o sabor do refrigerante como um
         * Option, e esse option do sabor, não deixar associado ao combo
         * deixando a seleção para o usuário.
         */
        ItemCombo porcaoMais2Refrigerantes = new ItemCombo();
        porcaoMais2Refrigerantes.setLabel("Batata-Frita mais 2 Fantas");
        HaveComboItem porcaoMaisRefriHaveComboItemBatata = new HaveComboItem();
        porcaoMaisRefriHaveComboItemBatata.setItem(itemCheeseBurger);
        porcaoMaisRefriHaveComboItemBatata.setQty(1);
        porcaoMaisRefriHaveComboItemBatata.setRestaurantCode(restaurant.getCode());
        porcaoMaisRefriHaveComboItemBatata.setItemCombo(porcaoMais2Refrigerantes);

        porcaoMais2Refrigerantes.addHaveComboItem(porcaoMaisRefriHaveComboItemBatata);

        HaveComboItem porcaoMaisRefriHaveComboItemFanta = new HaveComboItem();
        porcaoMaisRefriHaveComboItemFanta.setItem(itemFanta);
        porcaoMaisRefriHaveComboItemFanta.setQty(2);
        porcaoMaisRefriHaveComboItemFanta.setRestaurantCode(restaurant.getCode());


        HaveComboItemOption comboItemOptionFanta = new HaveComboItemOption();
        comboItemOptionFanta.setItemCode(itemFanta.getCode());
        comboItemOptionFanta.setQty(2);
        comboItemOptionFanta.setItemCombo(porcaoMais2Refrigerantes);
        comboItemOptionFanta.setOption(option350ml);
        comboItemOptionFanta.setRestaurantCode(restaurant.getCode());


        HaveItemCombo haveItemComboPorcaoMais2Refrigerantes = new HaveItemCombo();
        haveItemComboPorcaoMais2Refrigerantes.setRestaurantCode(restaurant.getCode());
        haveItemComboPorcaoMais2Refrigerantes.setItemCombo(porcaoMais2Refrigerantes);
        haveItemComboPorcaoMais2Refrigerantes.setItemGroup(itemGroupCombos);
        haveItemComboPorcaoMais2Refrigerantes.setRestaurantCode(restaurant.getCode());
        itemGroupCombos.addHaveItemCombo(haveItemComboPorcaoMais2Refrigerantes);

        restaurantRepository.save(restaurant, -1);
        menuRepository.save(menuChain, -1);
        chainRepository.save(chain, -1);
        itemGroupRepository.save(itemGroupCombos);
        itemGroupRepository.save(itemGroupBebidas);
        itemGroupRepository.save(itemGroupLanches);
        optionGroupRepository.save(optionGroupAdicionais);
        optionRepository.save(bacon);
        optionRepository.save(parmesao);
        itemRepository.save(itemCocaCola);
        itemRepository.save(itemFanta);

        itemRepository.save(itemCheeseBurger);
        itemRepository.save(itemCheeseOrion);
        itemRepository.save(itemDoubleCheeseBacon);
        itemRepository.save(itemHamburguer);

        optionRepository.save(option350ml);
        optionRepository.save(option600ml);
        optionRepository.save(option2L);
        itemComboRepository.save(porcaoMais2Refrigerantes);

    }


    private void createSingleRestaurant() {

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
        restaurant.setMenu(menu);


        /**
         * Cria ItemGroup Porções
         */
        ItemGroup itemGroupPorcoes = new ItemGroup();
        itemGroupPorcoes.setCode("PORCOES");
        itemGroupPorcoes.setLabel("Porções");

        /**
         * Cria ItemGroup Bebidas
         */
        ItemGroup itemGroupLanches = new ItemGroup();
        itemGroupLanches.setCode("LANCHES");
        itemGroupLanches.setLabel("Lanches");

        /**
         * Cria ItemGroup Bebidas
         */
        ItemGroup itemGroupBebidas = new ItemGroup();
        itemGroupBebidas.setCode("BEBIDAS");
        itemGroupBebidas.setLabel("Bebidas");


        /**
         * Cria relacionamento itemGroup com menu.
         */
        HaveItemGroup haveItemGroupPorcoes = new HaveItemGroup();
        haveItemGroupPorcoes.setAvailable(true);
        haveItemGroupPorcoes.setItemGroup(itemGroupPorcoes);
        haveItemGroupPorcoes.setMenu(menu);
        menu.addHaveItemGroup(haveItemGroupPorcoes);


        /**
         * Cria relacionamento itemGroup Bebidas com menu.
         */
        HaveItemGroup haveItemGroupBebidas = new HaveItemGroup();
        haveItemGroupBebidas.setAvailable(true);
        haveItemGroupBebidas.setItemGroup(itemGroupBebidas);
        haveItemGroupBebidas.setMenu(menu);
        menu.addHaveItemGroup(haveItemGroupBebidas);


        /**
         * Cria relacionamento itemGroup Lanches com menu.
         */
        HaveItemGroup haveItemGroupLanches = new HaveItemGroup();
        haveItemGroupLanches.setAvailable(true);
        haveItemGroupLanches.setItemGroup(itemGroupLanches);
        haveItemGroupLanches.setMenu(menu);
        menu.addHaveItemGroup(haveItemGroupLanches);


        /**
         * Cria item Cheese-Burger
         */
        Item itemCheeseBurger = new Item();
        itemCheeseBurger.setCode("CHEESE-BURGER");
        itemCheeseBurger.setLabel("Cheese Burger");

        Item itemHamburguer = new Item();
        itemHamburguer.setCode("HAMBURGER");
        itemHamburguer.setLabel("Hamburger");

        Item itemDoubleCheeseBacon = new Item();
        itemDoubleCheeseBacon.setCode("DOUBLE-CHEESE-BACON");
        itemDoubleCheeseBacon.setLabel("Double Cheese Burger");

        Item itemCheeseOrion = new Item();
        itemCheeseOrion.setCode("CHEESE-ORION");
        itemCheeseOrion.setLabel("Cheese Orion");


        HaveItem haveItemCheeseBurger = new HaveItem();
        haveItemCheeseBurger.setItemGroup(itemGroupLanches);
        haveItemCheeseBurger.setItem(itemCheeseBurger);
        haveItemCheeseBurger.setOrder(1);
        haveItemCheeseBurger.setRestaurantCode(restaurant.getCode());
        haveItemCheeseBurger.setPrice(new BigDecimal("15.50"));

        itemGroupLanches.addHaveItem(haveItemCheeseBurger);

        HaveItem haveItemHamburguer = new HaveItem();
        haveItemHamburguer.setItemGroup(itemGroupLanches);
        haveItemHamburguer.setItem(itemCheeseBurger);
        haveItemHamburguer.setOrder(1);
        haveItemHamburguer.setRestaurantCode(restaurant.getCode());
        haveItemHamburguer.setPrice(new BigDecimal("18.50"));

        itemGroupLanches.addHaveItem(haveItemHamburguer);


        HaveItem haveItemDoubleCheeseBacon = new HaveItem();
        haveItemDoubleCheeseBacon.setItemGroup(itemGroupLanches);
        haveItemDoubleCheeseBacon.setItem(itemDoubleCheeseBacon);
        haveItemDoubleCheeseBacon.setOrder(1);
        haveItemDoubleCheeseBacon.setRestaurantCode(restaurant.getCode());
        haveItemDoubleCheeseBacon.setPrice(new BigDecimal("23.50"));

        itemGroupLanches.addHaveItem(haveItemDoubleCheeseBacon);



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
        haveItemBatataFrita.setRestaurantCode(restaurant.getCode());
        haveItemBatataFrita.setPrice(new BigDecimal("23.50"));

        itemGroupPorcoes.addHaveItem(haveItemBatataFrita);


        /**
         * Cria item Batata frita.
         */
        Item itemMandiocaFrita = new Item();
        itemMandiocaFrita.setCode("MANDIOCA_FRITA");
        itemMandiocaFrita.setLabel("Mandioca Frita");


        /**
         * Cria HaveItem
         */
        HaveItem haveItemMandiocaFrita = new HaveItem();
        haveItemMandiocaFrita.setItemGroup(itemGroupPorcoes);
        haveItemMandiocaFrita.setItem(itemMandiocaFrita);
        haveItemMandiocaFrita.setOrder(1);
        haveItemMandiocaFrita.setRestaurantCode(restaurant.getCode());
        haveItemMandiocaFrita.setPrice(new BigDecimal("28.50"));

        itemGroupPorcoes.addHaveItem(haveItemMandiocaFrita);


        /**
         * O OptionGroup e os Options podem ser compartilhados.
         */
        OptionGroup optionGroupAdicionais = new OptionGroup();
        optionGroupAdicionais.setLabel("Adicionais");

        HaveOptionGroup haveOptionGroup = new HaveOptionGroup();
        haveOptionGroup.setItem(itemBatataFrita);
        haveOptionGroup.setRestaurantCode(restaurant.getCode());
        haveOptionGroup.setOptionGroup(optionGroupAdicionais);
        haveOptionGroup.setOrder(1);


        Option bacon = new Option();
        bacon.setLabel("Bacon Picado");
        bacon.setType(OptionType.TOPIC);

        Option parmesao = new Option();
        parmesao.setLabel("Parmesão Ralado");
        parmesao.setType(OptionType.TOPIC);

        HaveOption haveBacon = new HaveOption();
        haveBacon.setOrder(1);
        haveBacon.setPrice(new BigDecimal("3"));
        haveBacon.setOption(bacon);
        haveBacon.setOptionGroup(optionGroupAdicionais);
        haveBacon.setRestaurantCode(restaurant.getCode());


        HaveOption haveParmesao = new HaveOption();
        haveParmesao.setOrder(2);
        haveParmesao.setPrice(new BigDecimal("4"));
        haveParmesao.setOption(parmesao);
        haveParmesao.setOptionGroup(optionGroupAdicionais);
        haveParmesao.setRestaurantCode(restaurant.getCode());


        optionGroupAdicionais.addHaveOption(haveBacon);
        optionGroupAdicionais.addHaveOption(haveParmesao);

        HaveOptionGroup haveOptionGroupBatata = new HaveOptionGroup();
        haveOptionGroupBatata.setOptionGroup(optionGroupAdicionais);
        haveOptionGroupBatata.setItem(itemBatataFrita);
        haveOptionGroupBatata.setRestaurantCode(restaurant.getCode());

        itemBatataFrita.addHaveOptionGroup(haveOptionGroupBatata);

        HaveOptionGroup haveOptionGroupMandioca = new HaveOptionGroup();
        haveOptionGroupMandioca.setOptionGroup(optionGroupAdicionais);
        haveOptionGroupMandioca.setItem(itemMandiocaFrita);
        haveOptionGroupMandioca.setRestaurantCode(restaurant.getCode());

        itemMandiocaFrita.addHaveOptionGroup(haveOptionGroupMandioca);


        /**
         * Cria item Coca-Cola.
         */
        Item itemCocaCola = new Item();
        itemCocaCola.setCode("COCA_COLA");
        itemCocaCola.setLabel("Coca-Cola");


        /**
         * Cria HaveItem para a Fanta
         */
        HaveItem haveItemCocaCola = new HaveItem();
        haveItemCocaCola.setItemGroup(itemGroupBebidas);
        haveItemCocaCola.setItem(itemCocaCola);
        haveItemCocaCola.setOrder(1);
        haveItemCocaCola.setAvailable(true);
        haveItemCocaCola.setRestaurantCode(restaurant.getCode());
        haveItemCocaCola.setPrice(new BigDecimal("9.50"));

        itemGroupBebidas.addHaveItem(haveItemCocaCola);


        /**
         * Cria item Fanta.
         */
        Item itemFanta = new Item();
        itemFanta.setCode("FANTA");
        itemFanta.setLabel("Fanta");


        /**
         * Cria HaveItem para a Fanta
         */
        HaveItem haveItemFanta = new HaveItem();
        haveItemFanta.setItemGroup(itemGroupBebidas);
        haveItemFanta.setItem(itemFanta);
        haveItemFanta.setOrder(1);
        haveItemFanta.setAvailable(true);
        haveItemFanta.setRestaurantCode(restaurant.getCode());
        haveItemFanta.setPrice(new BigDecimal("23.50"));
        itemGroupBebidas.addHaveItem(haveItemFanta);


        /**
         * Cria OptionGroup de Tamnanho de refrigerante (será compartilhado para todos os refrigerantes).
         */
        OptionGroup optionGroupSizeRefri = new OptionGroup();
        optionGroupSizeRefri.setLabel("Tamanho Refrigerante");

        Option option350ml = new Option();
        option350ml.setType(OptionType.SIZE);
        option350ml.setLabel("350 ml");
        HaveOption haveOption350ml = new HaveOption();
        haveOption350ml.setOrder(1);
        haveOption350ml.setPrice(new BigDecimal("4.50"));
        haveOption350ml.setOption(option350ml);
        haveOption350ml.setRestaurantCode(restaurant.getCode());
        haveOption350ml.setAvailable(true);
        haveOption350ml.setOptionGroup(optionGroupSizeRefri);
        optionGroupSizeRefri.addHaveOption(haveOption350ml);




        Option option600ml = new Option();
        option600ml.setType(OptionType.SIZE);
        option600ml.setLabel("600 ml");
        HaveOption haveOption600ml = new HaveOption();
        haveOption600ml.setOrder(2);
        haveOption600ml.setPrice(new BigDecimal("6.50"));
        haveOption600ml.setOption(option600ml);
        haveOption600ml.setOptionGroup(optionGroupSizeRefri);
        haveOption600ml.setAvailable(true);
        haveOption600ml.setRestaurantCode(restaurant.getCode());


        optionGroupSizeRefri.addHaveOption(haveOption600ml);


        Option option2L = new Option();
        option2L.setType(OptionType.SIZE);
        option2L.setLabel("2 L");
        HaveOption haveOption2L = new HaveOption();
        haveOption2L.setOrder(2);
        haveOption2L.setPrice(new BigDecimal("10.50"));
        haveOption2L.setOption(option2L);
        haveOption2L.setOptionGroup(optionGroupSizeRefri);
        haveOption2L.setAvailable(true);
        haveOption2L.setRestaurantCode(restaurant.getCode());
        optionGroupSizeRefri.addHaveOption(haveOption2L);


        HaveOptionGroup haveOptionGroupSizeCoca = new HaveOptionGroup();
        haveOptionGroupSizeCoca.setOptionGroup(optionGroupSizeRefri);
        haveOptionGroupSizeCoca.setItem(itemCocaCola);
        haveOptionGroupSizeCoca.setAvailable(true);
        haveOptionGroupSizeCoca.setRestaurantCode(restaurant.getCode());
        itemCocaCola.addHaveOptionGroup(haveOptionGroupSizeCoca);


        HaveOptionGroup haveOptionGroupSizeFanta = new HaveOptionGroup();
        haveOptionGroupSizeFanta.setOptionGroup(optionGroupSizeRefri);
        haveOptionGroupSizeFanta.setItem(itemFanta);
        haveOptionGroupSizeFanta.setAvailable(true);
        haveOptionGroupSizeFanta.setRestaurantCode(restaurant.getCode());
        itemFanta.addHaveOptionGroup(haveOptionGroupSizeFanta);


        /**
         * CommonItem pode ser utilizado para compartilhar itens entre restaurantes
         */
        CommonItemPool commonItemBebidas = new CommonItemPool();
        commonItemBebidas.setCode("REFRIGERANTES");
        CommonItem commonItemCocaCola = new CommonItem();
        CommonItem commonItemFanta = new CommonItem();
        commonItemCocaCola.addItem(itemCocaCola);
        commonItemFanta.addItem(itemFanta);



        /**
         * Tem fixo batata frita mais 2 coca-colas, caso
         * queira deixar a opção mais flexivel como batata frita mais
         * 2 refrigerantes é possivel cadastrar o sabor do refrigerante como um
         * Option, e esse option do sabor, não deixar associado ao combo
         * deixando a seleção para o usuário.
         */
        ItemCombo porcaoMais2Refrigerantes = new ItemCombo();
        porcaoMais2Refrigerantes.setLabel("Batata-Frita mais 2 Fantas");
        HaveComboItem porcaoMaisRefriHaveComboItemBatata = new HaveComboItem();
        porcaoMaisRefriHaveComboItemBatata.setItem(itemBatataFrita);
        porcaoMaisRefriHaveComboItemBatata.setQty(1);
        porcaoMaisRefriHaveComboItemBatata.setAvailable(true);
        porcaoMaisRefriHaveComboItemBatata.setRestaurantCode(restaurant.getCode());
        porcaoMaisRefriHaveComboItemBatata.setItemCombo(porcaoMais2Refrigerantes);

        porcaoMais2Refrigerantes.addHaveComboItem(porcaoMaisRefriHaveComboItemBatata);

        HaveComboItem porcaoMaisRefriHaveComboItemFanta = new HaveComboItem();
        porcaoMaisRefriHaveComboItemFanta.setItem(itemFanta);
        porcaoMaisRefriHaveComboItemFanta.setQty(2);
        porcaoMaisRefriHaveComboItemFanta.setRestaurantCode(restaurant.getCode());



        HaveComboItemOption comboItemOptionFanta = new HaveComboItemOption();
        comboItemOptionFanta.setItemCode(itemFanta.getCode());
        comboItemOptionFanta.setQty(2);
        comboItemOptionFanta.setItemCombo(porcaoMais2Refrigerantes);
        comboItemOptionFanta.setOption(option350ml);
        comboItemOptionFanta.setRestaurantCode(restaurant.getCode());
        comboItemOptionFanta.setAvailable(true);



        HaveItemCombo haveItemComboPorcaoMais2Refrigerantes = new HaveItemCombo();
        haveItemComboPorcaoMais2Refrigerantes.setRestaurantCode(restaurant.getCode());
        haveItemComboPorcaoMais2Refrigerantes.setItemCombo(porcaoMais2Refrigerantes);
        haveItemComboPorcaoMais2Refrigerantes.setItemGroup(itemGroupPorcoes);
        haveItemComboPorcaoMais2Refrigerantes.setRestaurantCode(restaurant.getCode());
        comboItemOptionFanta.setAvailable(true);
        itemGroupPorcoes.addHaveItemCombo(haveItemComboPorcaoMais2Refrigerantes);








        restaurantRepository.save(restaurant);
        menuRepository.save(menu, -1);
        itemGroupRepository.save(itemGroupPorcoes);
        itemGroupRepository.save(itemGroupBebidas);
        itemGroupRepository.save(itemGroupLanches);
        itemRepository.save(itemBatataFrita);
        itemGroupRepository.save(itemGroupPorcoes);
        itemRepository.save(itemMandiocaFrita);
        optionGroupRepository.save(optionGroupAdicionais);
        optionRepository.save(bacon);
        optionRepository.save(parmesao);
        itemRepository.save(itemBatataFrita);
        itemRepository.save(itemCocaCola);
        itemRepository.save(itemFanta);

        itemRepository.save(itemCheeseBurger);
        itemRepository.save(itemCheeseOrion);
        itemRepository.save(itemDoubleCheeseBacon);
        itemRepository.save(itemHamburguer);

        optionRepository.save(option350ml);
        optionRepository.save(option600ml);
        optionRepository.save(option2L);
        commonItemPoolRepository.save(commonItemBebidas);
        itemComboRepository.save(porcaoMais2Refrigerantes);

    }


    private void createTestData() {
        //createSingleRestaurant();
        //createChainAndRestaurant();
    }



    @PostConstruct
    public void init() {
        createTestData();
    }
}
