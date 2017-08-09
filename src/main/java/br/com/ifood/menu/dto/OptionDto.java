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

    private String label;

    /**
     * Option Type can be SIZE, TOPING, etc
     */
    private String type;

    private Boolean canRepeat;

    private Integer order;

    private BigDecimal price;

    private Boolean available;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getAvailable() {
        return available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        OptionDto optionDto = (OptionDto) o;

        return new EqualsBuilder()
                .append(label, optionDto.label)
                .append(type, optionDto.type)
                .append(canRepeat, optionDto.canRepeat)
                .append(order, optionDto.order)
                .append(price, optionDto.price)
                .append(available, optionDto.available)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(label)
                .append(type)
                .append(canRepeat)
                .append(order)
                .append(price)
                .append(available)
                .toHashCode();
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
