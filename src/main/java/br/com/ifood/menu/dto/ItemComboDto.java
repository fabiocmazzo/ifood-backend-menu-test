package br.com.ifood.menu.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Class ItemComboDto to expose ItemCombo to World.
 * @author Fabio Covolo Mazzo
 */
public class ItemComboDto implements Serializable {

    private String label;

    private String code;

    private List<ItemDto> itemDtoList;

    private Map<ItemDto, OptionDto> itemDtoOptionDtoMap;

    private BigDecimal price;

    private Boolean available;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<ItemDto> getItemDtoList() {
        return itemDtoList;
    }

    public void setItemDtoList(List<ItemDto> itemDtoList) {
        this.itemDtoList = itemDtoList;
    }

     public Map<ItemDto, OptionDto> getItemDtoOptionDtoMap() {
        return itemDtoOptionDtoMap;
    }

    public void setItemDtoOptionDtoMap(Map<ItemDto, OptionDto> itemDtoOptionDtoMap) {
        this.itemDtoOptionDtoMap = itemDtoOptionDtoMap;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

        ItemComboDto that = (ItemComboDto) o;

        return new EqualsBuilder()
                .append(label, that.label)
                .append(code, that.code)
                .append(itemDtoList, that.itemDtoList)
           //     .append(itemDtoOptionDtoMap, that.itemDtoOptionDtoMap)
                .append(price, that.price)
                .append(available, that.available)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(label)
                .append(code)
                .append(itemDtoList)
           //     .append(itemDtoOptionDtoMap)
                .append(price)
                .append(available)
                .toHashCode();
    }
}
