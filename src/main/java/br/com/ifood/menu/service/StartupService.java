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
 *
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

    private void createFictionalRestaurantMenu() {

        /**
         * Chain
         */
        Chain chain = new Chain();
        chain.setCode("TEST_IFOOD_CHAIN");
        chain.setName("Ifood Chain");
        /**
         * Restaurant
         */
        Restaurant restaurant = new Restaurant();
        restaurant.setCode("Hitchhiker_Restaurant");
        restaurant.setName("The Restaurant at the End of the Universe");
        restaurant.setChain(chain);


        /**
         *  Menu
         */
        Menu menuChain = new Menu();
        menuChain.setCode("EndOfTheUniverseMenu");
        restaurant.setMenu(menuChain);
        chain.setMenu(menuChain);


        /**
         *  ItemGroups
         */
        ItemGroup burgersGroup = new ItemGroup();
        burgersGroup.setCode("BURGERS");
        burgersGroup.setLabel("Burgers");
        menuChain.createHaveItemGroup(true, burgersGroup, chain.getCode(), null);

        /**
         *  ItemGroups
         */
        ItemGroup comboItemGroup = new ItemGroup();
        comboItemGroup.setCode("COMBOS");
        comboItemGroup.setLabel("Combos");
        menuChain.createHaveItemGroup(true, comboItemGroup, chain.getCode(), null);




        ItemGroup snacksGroup = new ItemGroup();
        snacksGroup.setCode("SNACKS_AND_SIDES");
        snacksGroup.setLabel("Snacks & Sides");
        menuChain.createHaveItemGroup(true, snacksGroup, chain.getCode(), null);

        ItemGroup drinksGroup = new ItemGroup();
        drinksGroup.setCode("DRINKS");
        drinksGroup.setLabel("Drinks");
        menuChain.createHaveItemGroup(true, drinksGroup, chain.getCode(), null);

        /**
         * Item Chips
         */
        Item itemChips = new Item();
        itemChips.setCode("CHIPS");
        itemChips.setLabel("Chips");
        snacksGroup.createHaveItem(itemChips, 1, true, new BigDecimal("4"), chain.getCode(), null);


        /**
         * Double Cheese Burger
         */
        Item itemDoubleCheeseBurger = new Item();
        itemDoubleCheeseBurger.setCode("DOUBLE_CHEESE_BURGER");
        itemDoubleCheeseBurger.setLabel("Double Cheese Burger");
        burgersGroup.createHaveItem(itemDoubleCheeseBurger, 1, true, new BigDecimal("12"), chain.getCode(), null);

        /**
         * Cola
         */
        Item itemCola = new Item();
        itemCola.setCode("COLA");
        itemCola.setLabel("Cola");
        drinksGroup.createHaveItem(itemCola, 1, true, new BigDecimal("3"), chain.getCode(), null);


        /**
         * Chips Topics OptionGroup
         */
        OptionGroup optionGroupChipsTopics = new OptionGroup();
        optionGroupChipsTopics.setCode("CHIPS_TOPICS");
        optionGroupChipsTopics.setLabel("Chips Topics");
        optionGroupChipsTopics.setType(OptionGroupType.TOPIC);
        itemChips.createHaveOptionGroup(optionGroupChipsTopics, true, 1, false, 0, 1, chain.getCode(), null);


        /**
         * Bacon Option
         */
        Option bacon = new Option();
        bacon.setLabel("Bacon");
        bacon.setCode("BACON");
        optionGroupChipsTopics.createHaveOption(bacon, 1, true, BigDecimal.ONE, true, chain.getCode(), null);


        /**
         * Burger Extras OptionGroup
         */
        OptionGroup optionGroupBurgerExtras = new OptionGroup();
        optionGroupBurgerExtras.setCode("BURGER_EXTRAS");
        optionGroupBurgerExtras.setLabel("Burger Extras");
        optionGroupBurgerExtras.setType(OptionGroupType.EXTRA);

        itemDoubleCheeseBurger.createHaveOptionGroup(optionGroupBurgerExtras, true, 1, true, 0, null, chain.getCode(), null);

        Option salad = new Option();
        salad.setLabel("Salad");
        salad.setCode("SALAD");
        optionGroupBurgerExtras.createHaveOption(salad, 1, false, BigDecimal.ZERO, true, chain.getCode(), null);

        Option extraBurger = new Option();
        extraBurger.setLabel("Extra Burger");
        extraBurger.setCode("EXTRA_BURGER");
        optionGroupBurgerExtras.createHaveOption(extraBurger, 1, true, new BigDecimal("3"), true, chain.getCode(), null);
        optionGroupBurgerExtras.createHaveOption(bacon, 1, true, new BigDecimal("2"), true, chain.getCode(), null);

        /**
         * Create Onions option, but set avaiable = false, because it is only avaiable in combo.
         */
        Option onionsOption = new Option();
        onionsOption.setLabel("Onion");
        onionsOption.setCode("ONION");
        optionGroupBurgerExtras.createHaveOption(onionsOption, 1, false, BigDecimal.ZERO, true, chain.getCode(), null);


        /**
         * Create Combo N. 5
         */
        ItemCombo comboN5 = new ItemCombo();
        comboN5.setLabel("Combo nº5");
        comboN5.setCode("COMBON5");
        comboN5.createHaveComboItem(itemDoubleCheeseBurger, true, BigDecimal.ZERO, null, 1, 1, chain.getCode(), null);
        comboItemGroup.createHaveItemCombo(comboN5, 1, true, new BigDecimal("17"), chain.getCode(), null);

        OptionGroup sideDishOptionGroup = new OptionGroup();
        sideDishOptionGroup.setCode("OG_SIDE_DISH");
        sideDishOptionGroup.setLabel("Side Dish");
        sideDishOptionGroup.setType(OptionGroupType.ITEM);

        Item itemOnionRings = new Item();
        itemOnionRings.setLabel("Onion Rings");
        itemOnionRings.setCode("OPTION_ONION_RINGS_ITEM");

        Option optionOnionRings = new Option();
        optionOnionRings.setLabel("Onion Rings");
        optionOnionRings.setCode("OPTION_ONION_RINGS");
        optionOnionRings.setItem(itemOnionRings);
        sideDishOptionGroup.createHaveOption(optionOnionRings, 1, true, BigDecimal.ONE, true, chain.getCode(), null);


        Option optionChips = new Option();
        optionChips.setLabel("Onion Rings");
        optionChips.setCode("OPTION_ONION_RINGS");
        optionChips.setItem(itemChips);
        sideDishOptionGroup.createHaveOption(optionChips, 1, true, BigDecimal.ZERO, true, chain.getCode(), null);
        comboN5.createHaveComboOptionGroup(sideDishOptionGroup, false, 1, 1, true, 2, chain.getCode(), null);


        OptionGroup beverageOptionGroup = new OptionGroup();
        beverageOptionGroup.setLabel("Beverage");
        beverageOptionGroup.setCode("BEVERAGE");
        beverageOptionGroup.setType(OptionGroupType.OPTION_GROUP);


        /**
         * Option Soda
         */
        Option optionSoda = new Option();
        optionSoda.setLabel("Soda");
        optionSoda.setCode("OPTION_SODA");
        beverageOptionGroup.createHaveOption(optionSoda, 1, true, BigDecimal.ZERO, true, chain.getCode(), null);


        OptionGroup optionGroupSoda = new OptionGroup();
        optionGroupSoda.setType(OptionGroupType.ITEM);
        optionGroupSoda.setCode("OPTION_GROUP_SODA");
        optionGroupSoda.setLabel("Soda");
        optionSoda.setOptionGroup(optionGroupSoda);

        Option optionItemCola = new Option();
        optionItemCola.setCode("OPTION_ITEM_COLA");
        optionItemCola.setItem(itemCola);
        optionItemCola.setLabel("Cola");
        optionGroupSoda.createHaveOption(optionItemCola, 1, false, BigDecimal.ZERO, true, chain.getCode(), null);

        Item itemDrPepper = new Item();
        itemDrPepper.setCode("ITEM_DR_PEPPER");
        itemDrPepper.setLabel("Dr Pepper");

        Option optionItemDrPepper = new Option();
        optionItemDrPepper.setCode("OPTION_ITEM_DR_PEPPER");
        optionItemDrPepper.setLabel("Dr Pepper");
        optionItemDrPepper.setItem(itemDrPepper);
        optionGroupSoda.createHaveOption(optionItemDrPepper, 1, false, BigDecimal.ZERO, true, chain.getCode(), null);


        /**
         * Option Juice
         */
        Option optionJuice = new Option();
        optionJuice.setLabel("Soda");
        optionJuice.setCode("OPTION_SODA");
        beverageOptionGroup.createHaveOption(optionJuice, 2, true, BigDecimal.ONE, true, chain.getCode(), null);


        OptionGroup optionGroupJuice = new OptionGroup();
        optionGroupJuice.setType(OptionGroupType.ITEM);
        optionGroupJuice.setCode("OPTION_GROUP_SODA");
        optionGroupJuice.setLabel("Soda");
        optionJuice.setOptionGroup(optionGroupJuice);

        Item itemOrangeJuice = new Item();
        itemOrangeJuice.setCode("ITEM_ORANGE_JUICE");
        itemOrangeJuice.setLabel("Orange");

        Option optionOrangeJuice = new Option();
        optionOrangeJuice.setCode("OPTION_ORANGE");
        optionOrangeJuice.setItem(itemOrangeJuice);
        optionOrangeJuice.setLabel("Orange");
        optionGroupJuice.createHaveOption(optionOrangeJuice, 1, false, BigDecimal.ZERO, true, chain.getCode(), null);


        Item itemLemonJuice = new Item();
        itemLemonJuice.setCode("ITEM_LEMON_JUICE");
        itemLemonJuice.setLabel("Lemon");

        Option optionItemLemon = new Option();
        optionItemLemon.setCode("OPTION_ITEM_DR_PEPPER");
        optionItemLemon.setLabel("Dr Pepper");
        optionItemLemon.setItem(itemLemonJuice);
        optionGroupJuice.createHaveOption(optionItemLemon, 1, false, BigDecimal.ZERO, true, chain.getCode(), null);

        comboN5.createHaveComboOptionGroup(beverageOptionGroup, false, 1, 1,true, 1,chain.getCode(), null);


        menuRepository.save(menuChain, -1);
        itemComboRepository.save(comboN5, -1);

        optionGroupRepository.save(sideDishOptionGroup);
        optionGroupRepository.save(optionGroupChipsTopics);
        optionGroupRepository.save(optionGroupBurgerExtras);


        optionGroupRepository.save(beverageOptionGroup);
        optionGroupRepository.save(optionGroupSoda);
        optionGroupRepository.save(optionGroupJuice);

        optionRepository.save(optionOrangeJuice);
        optionRepository.save(optionItemLemon);
        optionRepository.save(onionsOption);
        optionRepository.save(optionChips);

        itemRepository.save(itemDrPepper);
        itemRepository.save(itemCola);
        itemRepository.save(itemLemonJuice);
        itemRepository.save(itemOrangeJuice);

        itemComboRepository.save(comboN5);
        optionRepository.save(onionsOption);
        optionGroupRepository.save(optionGroupBurgerExtras);
        optionRepository.save(extraBurger);
        optionRepository.save(salad);
        optionGroupRepository.save(optionGroupBurgerExtras);
        optionRepository.save(bacon);
        optionGroupRepository.save(optionGroupChipsTopics);
        itemRepository.save(itemCola);
        itemRepository.save(itemDoubleCheeseBurger);
        itemRepository.save(itemChips);
        itemGroupRepository.save(drinksGroup);
        itemGroupRepository.save(snacksGroup);
        itemGroupRepository.save(burgersGroup);
        itemGroupRepository.save(comboItemGroup);
        menuRepository.save(menuChain);
        restaurantRepository.save(restaurant);
        chainRepository.save(chain);
    }

   private void createTestData() {
        createFictionalRestaurantMenu();
    }

    @PostConstruct
    public void init() {
        createTestData();
    }
}
