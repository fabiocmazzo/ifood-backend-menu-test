package br.com.ifood.menu.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.List;

/**
 * Class MenuDto for Menu response.
 * @author Fabio Covolo Mazzo
 */
public class MenuDto implements Serializable {

  private String code;

  private List<ItemGroupDto> itemGroupDtoList;

    private Boolean available;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<ItemGroupDto> getItemGroupDtoList() {
        return itemGroupDtoList;
    }

    public void setItemGroupDtoList(List<ItemGroupDto> itemGroupDtoList) {
        this.itemGroupDtoList = itemGroupDtoList;
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

        MenuDto menuDto = (MenuDto) o;

        return new EqualsBuilder()
                .append(code, menuDto.code)
                .append(itemGroupDtoList, menuDto.itemGroupDtoList)
                .append(available, menuDto.available)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(code)
                .append(itemGroupDtoList)
                .append(available)
                .toHashCode();
    }
}
