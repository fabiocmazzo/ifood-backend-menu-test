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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ItemGroupDto that = (ItemGroupDto) o;

        return new EqualsBuilder()
                .append(label, that.label)
                .append(itemDtoList, that.itemDtoList)
                .append(itemComboDtoList, that.itemComboDtoList)
                .append(available, that.available)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(label)
                .append(itemDtoList)
                .append(itemComboDtoList)
                .append(available)
                .toHashCode();
    }
}
