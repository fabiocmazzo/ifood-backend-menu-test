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
        chainRepository.save(chain);
        /**
         * Restaurant
         */
        Restaurant restaurant = new Restaurant();
        restaurant.setCode("Hitchhiker_Restaurant");
        restaurant.setName("The Restaurant at the End of the Universe");
        restaurant.setChain(chain);
        restaurantRepository.save(restaurant);


        /**
         *  Menu
         */
        Menu menuChain = new Menu();
        menuChain.setCode("EndOfTheUniverseMenu");
        restaurant.setMenu(menuChain);
        chain.setMenu(menuChain);
        menuRepository.save(menuChain);


        /**
         *  ItemGroups
         */
        ItemGroup burgersGroup = new ItemGroup();
        burgersGroup.setCode("BURGERS");
        burgersGroup.setLabel("Burgers");
        menuChain.createHaveItemGroup(true, burgersGroup, chain.getCode(), null);
        itemGroupRepository.save(burgersGroup);


        ItemGroup snacksGroup = new ItemGroup();
        snacksGroup.setCode("SNACKS_AND_SIDES");
        snacksGroup.setLabel("Snacks & Sides");
        menuChain.createHaveItemGroup(true, snacksGroup, chain.getCode(), null);
        itemGroupRepository.save(snacksGroup);


        ItemGroup drinksGroup = new ItemGroup();
        drinksGroup.setCode("DRINKS");
        drinksGroup.setLabel("Drinks");
        menuChain.createHaveItemGroup(true, drinksGroup, chain.getCode(), null);
        itemGroupRepository.save(drinksGroup);


        /**
         * Item Chips
         */
        Item itemChips = new Item();
        itemChips.setCode("CHIPS");
        itemChips.setLabel("Chips");
        snacksGroup.createHaveItem(itemChips, 1, true, new BigDecimal("4"), chain.getCode(), null);
        itemRepository.save(itemChips);

        /**
         * Double Cheese Burger
         */
        Item itemDoubleCheeseBurger = new Item();
        itemDoubleCheeseBurger.setCode("DOUBLE_CHEESE_BURGER");
        itemDoubleCheeseBurger.setLabel("Double Cheese Burger");
        burgersGroup.createHaveItem(itemDoubleCheeseBurger, 1, true, new BigDecimal("12"), chain.getCode(), null);
        itemRepository.save(itemDoubleCheeseBurger);


        /**
         * Cola
         */
        Item itemCola = new Item();
        itemCola.setCode("COLA");
        itemCola.setLabel("Cola");
        drinksGroup.createHaveItem(itemCola, 1, true, new BigDecimal("3"), chain.getCode(), null);
        itemRepository.save(itemCola);


        /**
         * Chips Topics OptionGroup
         */
        OptionGroup optionGroupChipsTopics = new OptionGroup();
        optionGroupChipsTopics.setCode("CHIPS_TOPICS");
        optionGroupChipsTopics.setLabel("Chips Topics");
        optionGroupChipsTopics.setType(OptionGroupType.TOPIC);
        itemChips.createHaveOptionGroup(optionGroupChipsTopics, true, 1, false, 0, 1, chain.getCode(), null);
        optionGroupRepository.save(optionGroupChipsTopics);


        /**
         * Bacon Option
         */
        Option bacon = new Option();
        bacon.setLabel("Bacon");
        bacon.setCode("BACON");
        optionGroupChipsTopics.createHaveOption(bacon, 1, true, BigDecimal.ONE, true, chain.getCode(), null);
        optionRepository.save(bacon);


        /**
         * Burger Extras OptionGroup
         */
        OptionGroup optionGroupBurgerExtras = new OptionGroup();
        optionGroupBurgerExtras.setCode("BURGER_EXTRAS");
        optionGroupBurgerExtras.setLabel("Burger Extras");
        optionGroupBurgerExtras.setType(OptionGroupType.EXTRA);
        optionGroupRepository.save(optionGroupBurgerExtras);

        itemDoubleCheeseBurger.createHaveOptionGroup(optionGroupBurgerExtras, true, 1, true, 0, null, chain.getCode(), null);

        Option salad = new Option();
        salad.setLabel("Salad");
        salad.setCode("SALAD");
        optionGroupBurgerExtras.createHaveOption(salad, 1, false, BigDecimal.ZERO, true, chain.getCode(), null);
        optionRepository.save(salad);

        Option extraBurger = new Option();
        extraBurger.setLabel("Extra Burger");
        extraBurger.setCode("EXTRA_BURGER");
        optionGroupBurgerExtras.createHaveOption(extraBurger, 1, true, new BigDecimal("3"), true, chain.getCode(), null);
        optionRepository.save(extraBurger);

        optionGroupBurgerExtras.createHaveOption(bacon, 1, true, new BigDecimal("2"), true, chain.getCode(), null);
        optionGroupRepository.save(optionGroupBurgerExtras);

        /**
         * Create Onions option, but set avaiable = false, because it is only avaiable in combo.
         */
        Option onionsOption = new Option();
        onionsOption.setLabel("Onion");
        onionsOption.setCode("ONION");
        optionGroupBurgerExtras.createHaveOption(onionsOption, 1, false, BigDecimal.ZERO, true, chain.getCode(), null);
        optionRepository.save(onionsOption);

        /**
         * Create Combo N. 5
         */
        ItemCombo comboN5 = new ItemCombo();
        comboN5.setLabel("Combo nº5");
        comboN5.setCode("COMBON5");
        comboN5.createHaveComboItem(itemDoubleCheeseBurger, true, BigDecimal.ZERO, null, 1, 1, chain.getCode(), null);
        comboN5.createHaveComboOptionGroup(optionGroupBurgerExtras, true, 2, null, itemDoubleCheeseBurger.getCode(), true, 1, chain.getCode(), restaurant.getCode());
        itemComboRepository.save(comboN5);

        ItemGroup sideDishItemGroup = new ItemGroup();
        sideDishItemGroup.setLabel("Side dish");
        sideDishItemGroup.setCode("SIDE_DISH");
        comboN5.createHaveComboItemGroup(sideDishItemGroup, true, 1, 1, true, 1, chain.getCode(), null);
        itemGroupRepository.save(sideDishItemGroup);

        Item onionRings = new Item();
        onionRings.setCode("ONION_RINGS");
        onionRings.setLabel("Onion Rings");
        sideDishItemGroup.createHaveItem(onionRings, 1, true, null, chain.getCode(), null);
        sideDishItemGroup.createHaveItem(itemChips, 2, true, null, chain.getCode(), null);
        comboN5.createHaveComboItem(onionRings, true, BigDecimal.ONE, sideDishItemGroup.getCode(), 1, 1, chain.getCode(), null);
        itemRepository.save(onionRings);

        ItemGroup beverage = new ItemGroup();
        beverage.setLabel("Beverage");
        sideDishItemGroup.setCode("BEVERAGE");
        comboN5.createHaveComboItemGroup(beverage, true, 1, 1, true, 1, chain.getCode(), null);
        itemGroupRepository.save(beverage);


        Item itemSoda = new Item();
        itemSoda.setCode("SODA");
        itemSoda.setLabel("Soda");
        comboN5.createHaveComboItem(itemSoda, true, BigDecimal.ZERO, beverage.getCode(), 1, 1, chain.getCode(), null);
        itemRepository.save(itemSoda);

        Item itemJuice = new Item();
        itemJuice.setCode("JUICE");
        itemJuice.setLabel("Juice");
        comboN5.createHaveComboItem(itemJuice, true, BigDecimal.ONE, beverage.getCode(), 1, 1, chain.getCode(), null);
        itemRepository.save(itemJuice);

        OptionGroup sodaFlavorOptionGroup = new OptionGroup();
        sodaFlavorOptionGroup.setLabel("Soda Flavor");
        sodaFlavorOptionGroup.setCode("SODA_FLAVOR");
        itemSoda.createHaveOptionGroup(sodaFlavorOptionGroup, true, 1, false, 1, 1, chain.getCode(), null);
        optionGroupRepository.save(sodaFlavorOptionGroup);

        Option colaOption = new Option();
        colaOption.setLabel("Cola");
        colaOption.setCode("COLA_OPTION");
        sodaFlavorOptionGroup.createHaveOption(colaOption, 1, false, BigDecimal.ZERO, true, chain.getCode(), null);
        optionRepository.save(colaOption);


        Option drPepperOption = new Option();
        drPepperOption.setLabel("Dr Pepper");
        drPepperOption.setCode("DR_PEPPER_OPTION");
        sodaFlavorOptionGroup.createHaveOption(drPepperOption, 2, false, BigDecimal.ZERO, true, chain.getCode(), null);
        optionRepository.save(drPepperOption);

        OptionGroup juiceFlavorOptionGroup = new OptionGroup();
        juiceFlavorOptionGroup.setCode("JUICE_FLAVOR");
        juiceFlavorOptionGroup.setLabel("Juice Flavor");
        itemJuice.createHaveOptionGroup(sodaFlavorOptionGroup, true, 1, false, 1, 1, chain.getCode(), null);
        optionGroupRepository.save(juiceFlavorOptionGroup);

        Option orangeOption = new Option();
        orangeOption.setLabel("Orange");
        orangeOption.setCode("ORANGE_OPTION");
        juiceFlavorOptionGroup.createHaveOption(orangeOption, 1, false, BigDecimal.ZERO, true, chain.getCode(), null);
        optionRepository.save(orangeOption);

        Option lemonOption = new Option();
        lemonOption.setLabel("Lemon");
        lemonOption.setCode("LEMON_OPTION");
        sodaFlavorOptionGroup.createHaveOption(lemonOption, 2, false, BigDecimal.ZERO, true, chain.getCode(), null);
        optionRepository.save(lemonOption);

        menuRepository.save(menuChain, -1);
        itemComboRepository.save(comboN5, -1);
    }

   private void createTestData() {
        createFictionalRestaurantMenu();
    }

    @PostConstruct
    public void init() {
        createTestData();
    }
}
