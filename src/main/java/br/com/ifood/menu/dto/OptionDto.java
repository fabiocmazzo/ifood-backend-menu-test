package br.com.ifood.menu.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Class optionDto to exposed Option to world.
 * @author Fabio Covolo Mazzo
 */
public class OptionDto implements Serializable {

    private String label;

    /**
     * Option Type can be SIZE, TOPING, etc
     */
    private String type;

    private Boolean canRepeat;

    private Integer order;

    private BigDecimal price;

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
}
