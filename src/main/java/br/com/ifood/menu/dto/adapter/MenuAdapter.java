package br.com.ifood.menu.dto.adapter;

import br.com.ifood.menu.dto.*;
import br.com.ifood.menu.model.entity.Item;
import br.com.ifood.menu.model.entity.Menu;
import br.com.ifood.menu.model.entity.OptionGroup;
import br.com.ifood.menu.model.relationship.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * MenuAdapter class.
 *
 * @author Fabio Covolo Mazzo
 */
public class MenuAdapter {


    /**
     * Adapt item to ItemDto, used only in item from Option.
     *
     * @param item Item
     * @return ItemDto
     */
    private static ItemDto adapt(Item item, Boolean available) {
        ItemDto itemDto = new ItemDto();
        itemDto.setId(item.getId());
        itemDto.setCode(item.getCode());
        itemDto.setAvailable(available);
        // When is a Option item there is no price, because price is defined in Option RelationShip with father
        itemDto.setStartPrice(BigDecimal.ZERO);
        itemDto.setQty(1);
        if (item.getHaveOptionGroupSet() != null) {
            List<OptionGroupDto> optionDtoList = item.getHaveOptionGroupSet().stream().map(haveOptionGroup -> adapt(haveOptionGroup)).collect(Collectors.toList());
            itemDto.setOptionGroupDtoList(optionDtoList);
        }
        return itemDto;
    }

    /**
     * Adapt OptionGroup to OptionGroupDto
     *
     * @param optionGroup OptionGroup
     * @return OptionGroupDto
     */
    private static OptionGroupDto adapt(OptionGroup optionGroup, Boolean available, Integer minOptions, Integer maxOptions, Boolean canRepeat) {
        OptionGroupDto optionGroupDto = new OptionGroupDto();
        optionGroupDto.setLabel(optionGroup.getLabel());
        optionGroupDto.setId(optionGroup.getId());
        optionGroupDto.setAvailable(available);
        // is 1, beacause relation with option is 1:1
        optionGroupDto.setOrder(1);
        // This is defined by
        optionGroupDto.setMinOptions(minOptions);
        optionGroupDto.setMaxOptions(maxOptions);
        optionGroupDto.setCanRepeat(canRepeat);
        optionGroupDto.setLabel(optionGroup.getLabel());
        if (optionGroup.getHaveOptionList() != null) {
            List<OptionDto> optionDtoList = optionGroup.getHaveOptionList().stream().map(haveOption -> adapt(haveOption)).collect(Collectors.toList());
            optionGroupDto.setOptionDtoList(optionDtoList);
        }
        return optionGroupDto;
    }


    /**
     * Adapt HaveOption RelationShip to OptionDto.
     *
     * @param haveOption HaveOptionRelationShip.
     * @return OptionDto
     */
    private static OptionDto adapt(HaveOption haveOption) {
        OptionDto optionDto = new OptionDto();
        optionDto.setId(haveOption.getId());
        optionDto.setLabel(haveOption.getOption().getLabel());
        optionDto.setOrder(haveOption.getOrder());
        optionDto.setAdditionalPrice(haveOption.getPrice());
        Item item = haveOption.getOption().getItem();
        if (item != null) {
            optionDto.setItemDto(adapt(item, optionDto.getAvailable()));
        }
        OptionGroup optionGroup = haveOption.getOption().getOptionGroup();
        if (optionGroup != null) {
            optionDto.setOptionGroupDto(adapt(optionGroup,haveOption.getAvailable(), haveOption.getOption().getMinOptionForOptionGroup(),haveOption.getOption().getMaxOptionsForOptionGroup(), haveOption.getOption().getCanRepeatForOptionGroup() ));
        }
        optionDto.setAvailable(haveOption.getAvailable());
        return optionDto;
    }


    /**
     * Adapt HaveComboOptionGroup to OptionGroupDto.
     *
     * @param haveComboOptionGroup haveComboOptionGroup Relationship with Option list.
     * @return OptionGroupDto
     */
    private static OptionGroupDto adapt(HaveComboOptionGroup haveComboOptionGroup) {
        OptionGroupDto optionGroupDto = new OptionGroupDto();
        optionGroupDto.setId(haveComboOptionGroup.getOptionGroup().getId());
        optionGroupDto.setAvailable(haveComboOptionGroup.getAvailable());
        optionGroupDto.setOrder(haveComboOptionGroup.getOrder());
        optionGroupDto.setMinOptions(haveComboOptionGroup.getMinOptions());
        optionGroupDto.setMaxOptions(haveComboOptionGroup.getMaxOptions());
        optionGroupDto.setCanRepeat(haveComboOptionGroup.getCanRepeat());
        optionGroupDto.setLabel(haveComboOptionGroup.getOptionGroup().getLabel());
        optionGroupDto.setType(haveComboOptionGroup.getOptionGroup().getType());
        if (haveComboOptionGroup.getOptionGroup().getHaveOptionList() != null) {
            List<OptionDto> optionDtoList = haveComboOptionGroup.getOptionGroup().getHaveOptionList().stream().map(haveOption -> adapt(haveOption)).collect(Collectors.toList());
            optionGroupDto.setOptionDtoList(optionDtoList);
        }
        return optionGroupDto;
    }



    /**
     * Adapt HaveOptionGroup to OptionGroupDto.
     *
     * @param haveOptionGroup haveOptioNgroup Relationship with Option list.
     * @return OptionGroupDto
     */
    private static OptionGroupDto adapt(HaveOptionGroup haveOptionGroup) {
        OptionGroupDto optionGroupDto = new OptionGroupDto();
        optionGroupDto.setId(haveOptionGroup.getOptionGroup().getId());
        optionGroupDto.setAvailable(haveOptionGroup.getAvailable());
        optionGroupDto.setOrder(haveOptionGroup.getOrder());
        optionGroupDto.setMinOptions(haveOptionGroup.getMinOptions());
        optionGroupDto.setMaxOptions(haveOptionGroup.getMaxOptions());
        optionGroupDto.setCanRepeat(haveOptionGroup.getCanRepeat());
        optionGroupDto.setLabel(haveOptionGroup.getOptionGroup().getLabel());
        optionGroupDto.setType(haveOptionGroup.getOptionGroup().getType());

        if (haveOptionGroup.getOptionGroup().getHaveOptionList() != null) {
            List<OptionDto> optionDtoList = haveOptionGroup.getOptionGroup().getHaveOptionList().stream().map(haveOption -> adapt(haveOption)).collect(Collectors.toList());
            optionGroupDto.setOptionDtoList(optionDtoList);
        }
        return optionGroupDto;
    }

    /**
     * Adapt HaveComboItem of ItemDto.
     *
     * @param haveComboItem HaveComboItemRelationShip
     * @return ItemDto
     */
    private static ItemDto adapt(HaveComboItem haveComboItem) {
        ItemDto itemDto = new ItemDto();
        itemDto.setId(haveComboItem.getItem().getId());
        itemDto.setCode(haveComboItem.getItem().getCode());
        itemDto.setLabel(haveComboItem.getItem().getLabel());
        // É zero pois o preço já está no Combo
        itemDto.setStartPrice(BigDecimal.ZERO);
        itemDto.setOrder(haveComboItem.getOrder());
        itemDto.setQty(haveComboItem.getQty());
        itemDto.setAvailable(haveComboItem.getAvailable());
        if (haveComboItem.getItem().getHaveOptionGroupSet() != null) {
            List<OptionGroupDto> optionDtoList = haveComboItem.getItem().getHaveOptionGroupSet().stream().map(haveOptionGroup -> adapt(haveOptionGroup)).collect(Collectors.toList());
            itemDto.setOptionGroupDtoList(optionDtoList);
        }
        return itemDto;
    }

    /**
     * Adapt HaveItemCombo to ItemComboDto.
     *
     * @param haveItemCombo HaveItemCombo
     * @return ItemComboDto
     */
    private static ItemComboDto adapt(HaveItemCombo haveItemCombo) {
        ItemComboDto itemComboDto = new ItemComboDto();
        itemComboDto.setId(haveItemCombo.getItemCombo().getId());
        itemComboDto.setCode(haveItemCombo.getItemCombo().getCode());
        itemComboDto.setLabel(haveItemCombo.getItemCombo().getLabel());
        itemComboDto.setStartPrice(haveItemCombo.getStartPrice());
        itemComboDto.setAvailable(haveItemCombo.getAvailable());
        if (haveItemCombo.getItemCombo().getHaveComboItemSet() != null) {
            List<ItemDto> itemDtoList = haveItemCombo.getItemCombo().getHaveComboItemSet().stream().map(haveComboItem -> adapt(haveComboItem)).collect(Collectors.toList());
            itemComboDto.setItemDtoList(itemDtoList);
        }

        if (haveItemCombo.getItemCombo().getHaveComboOptionGroupSet() != null) {
            List<OptionGroupDto> optionGroupDtoList = haveItemCombo.getItemCombo().getHaveComboOptionGroupSet().stream().map(haveComboOptionGroup -> adapt(haveComboOptionGroup)).collect(Collectors.toList());
            itemComboDto.setOptionGroupDtoList(optionGroupDtoList);
        }
        return itemComboDto;
    }

    /**
     * Adapt HaveItem to ItemDto.
     *
     * @param haveItem HaveItem RelationShip.
     * @return ItemDto
     */
    private static ItemDto adapt(HaveItem haveItem) {
        ItemDto itemDto = new ItemDto();
        itemDto.setId(haveItem.getItem().getId());
        itemDto.setCode(haveItem.getItem().getCode());
        itemDto.setLabel(haveItem.getItem().getLabel());
        itemDto.setOrder(haveItem.getOrder());
        itemDto.setStartPrice(haveItem.getStartPrice());
        itemDto.setAvailable(haveItem.getAvailable());
        itemDto.setQty(1);
        if (haveItem.getItem().getHaveOptionGroupSet() != null) {
            List<OptionGroupDto> optionDtoList = haveItem.getItem().getHaveOptionGroupSet().stream().map(haveOptionGroup -> adapt(haveOptionGroup)).collect(Collectors.toList());
            itemDto.setOptionGroupDtoList(optionDtoList);
        }
        return itemDto;
    }


    /**
     * Adapt HaveItemGroup to ItemGroupDto.
     *
     * @param haveItemGroup HaveItemGroup.
     * @return ItemGroupDto
     */
    private static ItemGroupDto adapt(HaveItemGroup haveItemGroup) {
        ItemGroupDto itemGroupDto = new ItemGroupDto();
        itemGroupDto.setLabel(haveItemGroup.getItemGroup().getLabel());
        if (haveItemGroup.getItemGroup().getHaveItemList() != null) {
            List<ItemDto> itemDtoList = haveItemGroup.getItemGroup().getHaveItemList().stream().map(haveItem -> adapt(haveItem)).collect(Collectors.toList());
            itemGroupDto.setItemDtoList(itemDtoList);
        }

        if (haveItemGroup.getItemGroup().getHaveItemComboSet() != null) {
            List<ItemComboDto> itemComboDtoList = haveItemGroup.getItemGroup().getHaveItemComboSet().stream().map(haveComboItem -> adapt(haveComboItem)).collect(Collectors.toList());
            itemGroupDto.setItemComboDtoList(itemComboDtoList);
        }

        return itemGroupDto;
    }


    /**
     * Convert Menu entity to MenuDto.
     *
     * @param menu Menu entity.
     * @return menuDto
     */
    public static MenuDto adapt(Menu menu) {
        MenuDto menuDto = new MenuDto();
        menuDto.setId(menu.getId());
        menuDto.setCode(menu.getCode());
        if (menu.getHaveItemGroupList() != null) {
            List<ItemGroupDto> itemGroupDtoList = menu.getHaveItemGroupList().stream().map(haveItemGroup -> adapt(haveItemGroup)).collect(Collectors.toList());
            menuDto.setItemGroupDtoList(itemGroupDtoList);
        }
        return menuDto;
    }
}
