package br.com.ifood.menu.dto.adapter;

import br.com.ifood.menu.dto.*;
import br.com.ifood.menu.model.entity.Menu;
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
     * Adapt HaveOption RelationShip to OptionDto.
     *
     * @param haveOption HaveOptionRelationShip.
     * @return OptionDto
     */
    private static OptionDto adapt(HaveOption haveOption) {
        OptionDto optionDto = new OptionDto();
        optionDto.setLabel(haveOption.getOption().getLabel());
        optionDto.setOrder(haveOption.getOrder());
        optionDto.setPrice(haveOption.getPrice());
        //optionDto.setType(haveOption.getOption().getType());
        return optionDto;
    }


    /**
     * Adapt HaveOptionGroup to OptionGroupDto.
     *
     * @param haveOptionGroup haveOptioNgroup Relationship with Option list.
     * @return OptionGroupDto
     */
    private static OptionGroupDto adapt(HaveOptionGroup haveOptionGroup) {
        OptionGroupDto optionGroupDto = new OptionGroupDto();
        optionGroupDto.setLabel(haveOptionGroup.getOptionGroup().getLabel());
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
        itemDto.setCode(haveComboItem.getItem().getCode());
        itemDto.setLabel(haveComboItem.getItem().getLabel());
        // É zero pois o preço já está no Combo
        itemDto.setPrice(BigDecimal.ZERO);
        itemDto.setOrder(haveComboItem.getOrder());
        itemDto.setQty(haveComboItem.getQty());
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
        itemComboDto.setCode(haveItemCombo.getItemCombo().getCode());
        itemComboDto.setLabel(haveItemCombo.getItemCombo().getLabel());
       // itemComboDto.setPrice(haveItemCombo.getStartPrice());
        if (haveItemCombo.getItemCombo().getHaveComboItemSet() != null) {
            List<ItemDto> itemDtoList = haveItemCombo.getItemCombo().getHaveComboItemSet().stream().map(haveComboItem -> adapt(haveComboItem)).collect(Collectors.toList());
            itemComboDto.setItemDtoList(itemDtoList);
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
        itemDto.setCode(haveItem.getItem().getCode());
        itemDto.setLabel(haveItem.getItem().getLabel());
        itemDto.setOrder(haveItem.getOrder());
        itemDto.setPrice(haveItem.getStartPrice());
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
        menuDto.setCode(menu.getCode());
        if (menu.getHaveItemGroupList() != null) {
            List<ItemGroupDto> itemGroupDtoList = menu.getHaveItemGroupList().stream().map(haveItemGroup -> adapt(haveItemGroup)).collect(Collectors.toList());
            menuDto.setItemGroupDtoList(itemGroupDtoList);
        }
        return menuDto;
    }
}
