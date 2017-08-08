package br.com.ifood.menu.dto;

import java.io.Serializable;
import java.util.List;

/**
 * OptionGroup Dto
 * @author Fabio Covolo Mazzo
 */
public class OptionGroupDto implements Serializable {

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
}
