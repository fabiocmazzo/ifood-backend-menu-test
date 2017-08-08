package br.com.ifood.menu.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * ItemDto class.
 * @author Fabio Covolo Mazzo
 */
public class ItemDto implements Serializable {

    private String code;

    private String label;

    private BigDecimal price;

    private Integer order;

    private Integer qty;

    private List<OptionGroupDto> optionGroupDtoList;

    private Boolean available;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public List<OptionGroupDto> getOptionGroupDtoList() {
        return optionGroupDtoList;
    }

    public void setOptionGroupDtoList(List<OptionGroupDto> optionGroupDtoList) {
        this.optionGroupDtoList = optionGroupDtoList;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
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

        ItemDto itemDto = (ItemDto) o;

        return new EqualsBuilder()
                .append(code, itemDto.code)
                .append(label, itemDto.label)
                .append(price, itemDto.price)
                .append(order, itemDto.order)
                .append(qty, itemDto.qty)
                .append(optionGroupDtoList, itemDto.optionGroupDtoList)
                .append(available, itemDto.available)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(code)
                .append(label)
                .append(price)
                .append(order)
                .append(qty)
                .append(optionGroupDtoList)
                .append(available)
                .toHashCode();
    }
}