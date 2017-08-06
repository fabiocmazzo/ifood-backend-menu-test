package br.com.ifood.menu.dto;

import java.math.BigDecimal;
import java.util.List;

/**
 * ItemDto class.
 * @author Fabio Covolo Mazzo
 */
public class ItemDto {

    private String code;

    private String label;

    private BigDecimal price;

    private Integer order;

    private Integer qty;

    private List<OptionGroupDto> optionGroupDtoList;


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
}
