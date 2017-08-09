package br.com.ifood.menu.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Class ItemComboDto to expose ItemCombo to World.
 *
 * @author Fabio Covolo Mazzo
 */
public class ItemComboDto implements Serializable {

    private static final long serialVersionUID = -2273929810948551865L;

    private Long id;

    private String label;

    private String code;

    private List<ItemDto> itemDtoList;

    private List<OptionGroupDto> optionGroupDtoList;

    private BigDecimal startPrice;

    private Boolean available;

    private Integer order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<OptionGroupDto> getOptionGroupDtoList() {
        return optionGroupDtoList;
    }

    public void setOptionGroupDtoList(List<OptionGroupDto> optionGroupDtoList) {
        this.optionGroupDtoList = optionGroupDtoList;
    }

    public BigDecimal getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(BigDecimal startPrice) {
        this.startPrice = startPrice;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
