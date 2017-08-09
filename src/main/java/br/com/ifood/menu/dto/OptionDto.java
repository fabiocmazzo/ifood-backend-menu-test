package br.com.ifood.menu.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Class optionDto to exposed Option to world.
 * @author Fabio Covolo Mazzo
 */
public class OptionDto implements Serializable {

    private static final long serialVersionUID = 5320775881531236500L;

    private Long id;

    private String label;

    private Boolean canRepeat;

    private Integer order;

    private BigDecimal additionalPrice;

    private Boolean available;

    private ItemDto itemDto;

    private OptionGroupDto optionGroupDto;

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

    public Boolean getCanRepeat() {
        return canRepeat;
    }

    public void setCanRepeat(Boolean canRepeat) {
        this.canRepeat = canRepeat;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public BigDecimal getAdditionalPrice() {
        return additionalPrice;
    }

    public void setAdditionalPrice(BigDecimal additionalPrice) {
        this.additionalPrice = additionalPrice;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public ItemDto getItemDto() {
        return itemDto;
    }

    public void setItemDto(ItemDto itemDto) {
        this.itemDto = itemDto;
    }

    public OptionGroupDto getOptionGroupDto() {
        return optionGroupDto;
    }

    public void setOptionGroupDto(OptionGroupDto optionGroupDto) {
        this.optionGroupDto = optionGroupDto;
    }
}
