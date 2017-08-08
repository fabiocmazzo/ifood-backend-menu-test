package br.com.ifood.menu.dto;

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
}
