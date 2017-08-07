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
        restaurant.setMenu(menu);

        /**
         * O padrão é Depth -1 salva além da entidade atual as entidades
         * alteradas do que está carregado no objeto.
         */




        /**
         * Cria ItemGroup Porções
         */
        ItemGroup itemGroupPorcoes = new ItemGroup();
        itemGroupPorcoes.setLabel("Porçoes");


        /**
         * Cria ItemGroup Bebidas
         */
        ItemGroup itemGroupBebidas = new ItemGroup();
        itemGroupBebidas.setLabel("Bebidas");




        /**
         * Cria relacionamento itemGroup com menu.
         */
        HaveItemGroup haveItemGroupPorcoes = new HaveItemGroup();
        haveItemGroupPorcoes.setActive(true);
        haveItemGroupPorcoes.setItemGroup(itemGroupPorcoes);
        haveItemGroupPorcoes.setMenu(menu);
        menu.addHaveItemGroup(haveItemGroupPorcoes);

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
        haveItemMandiocaFrita.setPrice(new BigDecimal("28.50"));

        itemGroupPorcoes.addHaveItem(haveItemMandiocaFrita);


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
        haveParmesao.setOption(parmesao);
        haveParmesao.setOptionGroup(optionGroupAdicionais);

        optionGroupAdicionais.addHaveOption(haveBacon);
        optionGroupAdicionais.addHaveOption(haveParmesao);

        HaveOptionGroup haveOptionGroupBatata = new HaveOptionGroup();
        haveOptionGroupBatata.setOptionGroup(optionGroupAdicionais);
        haveOptionGroupBatata.setItem(itemBatataFrita);
        itemBatataFrita.addHaveOptionGroup(haveOptionGroupBatata);

        HaveOptionGroup haveOptionGroupMandioca = new HaveOptionGroup();
        haveOptionGroupMandioca.setOptionGroup(optionGroupAdicionais);
        haveOptionGroupMandioca.setItem(itemMandiocaFrita);
        itemMandiocaFrita.addHaveOptionGroup(haveOptionGroupMandioca);

        /**
         * Cria relacionamento itemGroup Bebidas com menu.
         */
        HaveItemGroup haveItemGroupBebidas = new HaveItemGroup();
        haveItemGroupBebidas.setActive(true);
        haveItemGroupBebidas.setItemGroup(itemGroupBebidas);
        haveItemGroupBebidas.setMenu(menu);
        menu.addHaveItemGroup(haveItemGroupBebidas);




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
        haveOption350ml.setCanRepeat(false);
        haveOption350ml.setPrice(new BigDecimal("4.50"));
        haveOption350ml.setOption(option350ml);
        haveOption350ml.setOptionGroup(optionGroupSizeRefri);
        optionGroupSizeRefri.addHaveOption(haveOption350ml);




        Option option600ml = new Option();
        option600ml.setType(OptionType.SIZE);
        option600ml.setLabel("600 ml");
        HaveOption haveOption600ml = new HaveOption();
        haveOption600ml.setOrder(2);
        haveOption600ml.setCanRepeat(false);
        haveOption600ml.setPrice(new BigDecimal("6.50"));
        haveOption600ml.setOption(option600ml);
        haveOption600ml.setOptionGroup(optionGroupSizeRefri);
        optionGroupSizeRefri.addHaveOption(haveOption600ml);


        Option option2L = new Option();
        option2L.setType(OptionType.SIZE);
        option2L.setLabel("2 L");
        HaveOption haveOption2L = new HaveOption();
        haveOption2L.setOrder(2);
        haveOption2L.setCanRepeat(false);
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
         * CommonItem pode ser utilizado para compartilhar itens entre restaurantes
         */
        CommonItemPool commonItemBebidas = new CommonItemPool();
        commonItemBebidas.setCode("REFRIGERANTES");
        commonItemBebidas.addItem(itemCocaCola);
        commonItemBebidas.addItem(itemFanta);



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
        porcaoMaisRefriHaveComboItemBatata.setItemCombo(porcaoMais2Refrigerantes);

        porcaoMais2Refrigerantes.addHaveComboItem(porcaoMaisRefriHaveComboItemBatata);

        HaveComboItem porcaoMaisRefriHaveComboItemFanta = new HaveComboItem();
        porcaoMaisRefriHaveComboItemFanta.setItem(itemFanta);
        porcaoMaisRefriHaveComboItemFanta.setQty(2);

        HaveComboItemOption comboItemOptionFanta = new HaveComboItemOption();
        comboItemOptionFanta.setItem(itemFanta);
        comboItemOptionFanta.setQty(2);
        comboItemOptionFanta.setItemCombo(porcaoMais2Refrigerantes);
        comboItemOptionFanta.setOption(option350ml);

        HaveItemCombo haveItemComboPorcaoMais2Refrigerantes = new HaveItemCombo();
        haveItemComboPorcaoMais2Refrigerantes.setItemCombo(porcaoMais2Refrigerantes);
        haveItemComboPorcaoMais2Refrigerantes.setItemGroup(itemGroupPorcoes);
        itemGroupPorcoes.addHaveItemCombo(haveItemComboPorcaoMais2Refrigerantes);

        restaurantRepository.save(restaurant);
        menuRepository.save(menu, -1);
        itemGroupRepository.save(itemGroupPorcoes);
        itemGroupRepository.save(itemGroupBebidas);
        itemRepository.save(itemBatataFrita);
        itemGroupRepository.save(itemGroupPorcoes);
        itemRepository.save(itemMandiocaFrita);
        optionGroupRepository.save(optionGroupAdicionais);
        optionRepository.save(bacon);
        optionRepository.save(parmesao);
        itemRepository.save(itemBatataFrita);
        itemRepository.save(itemCocaCola);
        itemRepository.save(itemFanta);
        optionRepository.save(option350ml);
        optionRepository.save(option600ml);
        optionRepository.save(option2L);
        commonItemPoolRepository.save(commonItemBebidas);
        itemComboRepository.save(porcaoMais2Refrigerantes);
    }



    @PostConstruct
    public void init() {
        //createTestData();
    }
}
