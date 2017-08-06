package br.com.ifood.menu.dto;

import java.util.List;

public class ItemGroupDto {

    private String label;

    private List<ItemDto> itemDtoList;

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
}
