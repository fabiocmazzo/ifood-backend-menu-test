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

    private static final long serialVersionUID = 1705434706214723586L;

    private Long id;

    private String code;

    private String label;

    private BigDecimal startPrice;

    private Integer order;

    private Integer qty;

    private List<OptionGroupDto> optionGroupDtoList;

    private Boolean available;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public BigDecimal getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(BigDecimal startPrice) {
        this.startPrice = startPrice;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public List<OptionGroupDto> getOptionGroupDtoList() {
        return optionGroupDtoList;
    }

    public void setOptionGroupDtoList(List<OptionGroupDto> optionGroupDtoList) {
        this.optionGroupDtoList = optionGroupDtoList;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
