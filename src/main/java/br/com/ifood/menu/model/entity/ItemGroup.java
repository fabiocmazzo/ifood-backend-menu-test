package br.com.ifood.menu.model.entity;

import br.com.ifood.menu.model.relationship.HaveComboItem;
import br.com.ifood.menu.model.relationship.HaveItem;
import br.com.ifood.menu.model.relationship.HaveItemCombo;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class ItemGroup {

    @GraphId
    private Long id;

    private String label;

    private Set<HaveItem> haveItemList;


    private Set<HaveItemCombo> haveItemComboList;

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

    public Set<HaveItem> getHaveItemList() {
        return haveItemList;
    }

    public void setHaveItemList(Set<HaveItem> haveItemList) {
        this.haveItemList = haveItemList;
    }

    public void addHaveItem(HaveItem haveItem) {
        if(this.haveItemList == null) {
            this.haveItemList = new HashSet<>();
        }
        this.haveItemList.add(haveItem);
    }

    public Set<HaveItemCombo> getHaveItemComboList() {
        return haveItemComboList;
    }

    public void setHaveItemComboList(Set<HaveItemCombo> haveItemComboList) {
        this.haveItemComboList = haveItemComboList;
    }

    public void addHaveItemCombo(HaveItemCombo haveItemCombo) {
        if(this.haveItemComboList == null) {
            this.haveItemComboList = new HashSet<>();
        }
        this.haveItemComboList.add(haveItemCombo);
    }
}
