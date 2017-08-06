package br.com.ifood.menu.model.entity;

import br.com.ifood.menu.model.relationship.HaveItemGroup;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

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

    private HaveItemGroup haveItemGroup;

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

    public HaveItemGroup getHaveItemGroup() {
        return haveItemGroup;
    }

    public void setHaveItemGroup(HaveItemGroup haveItemGroup) {
        this.haveItemGroup = haveItemGroup;
    }
}

