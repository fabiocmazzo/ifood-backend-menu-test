package br.com.ifood.menu.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.List;

/**
 * ItemGroupDto Class.
 * @author Fabio Covolo Mazzo
 */
public class ItemGroupDto implements Serializable {

    private static final long serialVersionUID = -8859697065090235679L;

    private String label;

    private List<ItemDto> itemDtoList;

    private List<ItemComboDto> itemComboDtoList;

    private Boolean available;

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

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

}
