package br.com.ifood.menu.dto;

import java.util.List;

/**
 * ItemGroupDto Class.
 * @author Fabio Covolo Mazzo
 */
public class ItemGroupDto {

    private String label;

    private List<ItemDto> itemDtoList;

    private List<ItemComboDto> itemComboDtoList;


    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<ItemDto> getItemDtoList() {
        return itemDtoList;
    }

    public void setItemDtoList(List<ItemDto> itemDtoList) {
        this.itemDtoList = itemDtoList;
    }

    public List<ItemComboDto> getItemComboDtoList() {
        return itemComboDtoList;
    }

    public void setItemComboDtoList(List<ItemComboDto> itemComboDtoList) {
        this.itemComboDtoList = itemComboDtoList;
    }
}
