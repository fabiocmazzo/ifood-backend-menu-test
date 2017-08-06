package br.com.ifood.menu.model.entity;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

public class CommonItemPool {

    @GraphId
    private Long id;

    @Index(unique = true)
    private String code;

    @Relationship(type = "HAVE_COMMON_ITEM")
    private List<Item> itemList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public void addItem(Item item) {
        if(this.itemList == null) {
            this.itemList = new ArrayList<>();
        }
        this.itemList.add(item);
    }
}
