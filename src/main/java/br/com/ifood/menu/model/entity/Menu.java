package br.com.ifood.menu.model.entity;

import br.com.ifood.menu.model.relationship.HaveItemGroup;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

/**
 * The Menu entity.
 * @author Fabio Covolo Mazzo
 */
@NodeEntity
public class Menu {

    @GraphId
    private Long id;

    @Index(unique = true)
    private String code;

    @Relationship(type = "BASED_ON_CHAIN_MENU")
    private ChainMenu chainMenu;

    @Relationship(type = "HAVE_ITEM_GROUP")
    private List<HaveItemGroup> haveItemGroupList;

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

    public ChainMenu getChainMenu() {
        return chainMenu;
    }

    public void setChainMenu(ChainMenu chainMenu) {
        this.chainMenu = chainMenu;
    }

    public List<HaveItemGroup> getHaveItemGroupList() {
        return haveItemGroupList;
    }

    public void setHaveItemGroupList(List<HaveItemGroup> haveItemGroupList) {
        this.haveItemGroupList = haveItemGroupList;
    }

    public void addHaveItemGroup(HaveItemGroup haveItemGroup) {
        if(haveItemGroupList == null) {
            haveItemGroupList = new ArrayList<>();
        }
        haveItemGroupList.add(haveItemGroup);
    }
}

