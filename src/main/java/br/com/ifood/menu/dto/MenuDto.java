package br.com.ifood.menu.dto;

import java.util.List;

/**
 * Class MenuDto for Menu response.
 * @author Fabio Covolo Mazzo
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
