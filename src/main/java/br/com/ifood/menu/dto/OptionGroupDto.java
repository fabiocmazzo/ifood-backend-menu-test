package br.com.ifood.menu.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.List;

/**
 * OptionGroup Dto
 * @author Fabio Covolo Mazzo
 */
public class OptionGroupDto implements Serializable {

    private static final long serialVersionUID = -9133657394643773512L;
    
    private String label;

    private Integer order;

    private List<OptionDto> optionDtoList;

    private Boolean available;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public List<OptionDto> getOptionDtoList() {
        return optionDtoList;
    }

    public void setOptionDtoList(List<OptionDto> optionDtoList) {
        this.optionDtoList = optionDtoList;
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

        OptionGroupDto that = (OptionGroupDto) o;

        return new EqualsBuilder()
                .append(label, that.label)
                .append(order, that.order)
                .append(optionDtoList, that.optionDtoList)
                .append(available, that.available)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(label)
                .append(order)
                .append(optionDtoList)
                .append(available)
                .toHashCode();
    }
}
