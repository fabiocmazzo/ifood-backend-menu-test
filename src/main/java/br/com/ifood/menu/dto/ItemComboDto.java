package br.com.ifood.menu.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Class ItemComboDto to expose ItemCombo to World.
 * @author Fabio Covolo Mazzo
 */
public class ItemComboDto {

    private String label;

    private String code;

    private List<ItemDto> itemDtoList;

    private Map<ItemDto, OptionDto> itemDtoOptionDtoMap;

    private BigDecimal price;

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
}
