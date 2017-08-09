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

    private Long id;

    private String label;

    private Integer order;

    /**
     * OptiongGroup Type can be SIZE, TOPING, ITEM, OPTION_GROUP etc
     */
    private String type;

    private List<OptionDto> optionDtoList;

    private Boolean available;

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

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
