package br.com.ifood.menu.dto;

import br.com.ifood.menu.model.entity.Menu;
import br.com.ifood.menu.model.relationship.HaveItemGroup;

import java.util.List;

/**
 * Class MenuDto for Menu response.
 */
public class MenuDto {


  private String code;

  private List<ItemGroupDto> itemGroupDtoList;

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
}
