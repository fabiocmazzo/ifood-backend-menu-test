package br.com.ifood.menu.model.entity;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

/**
 * CommonItemPool Neo4J Entity.
 * @author Fabio Covolo Mazzo
 */
public class CommonItemPool {

    @GraphId
    private Long id;

    @Index(unique = true)
    private String code;

    @Relationship(type = "HAVE_COMMON_ITEM")
    private List<CommonItem> commonItemList;

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

    public List<CommonItem> getCommonItemList() {
        return commonItemList;
    }

    public void setCommonItemList(List<CommonItem> commonItemList) {
        this.commonItemList = commonItemList;
    }

    public void addCommonItem(CommonItem commonItem) {
        if(this.commonItemList == null) {
            this.commonItemList = new ArrayList<>();
        }
        this.commonItemList.add(commonItem);
    }
}
