package br.com.ifood.menu.model.entity;

import br.com.ifood.menu.model.relationship.HaveComboItem;
import br.com.ifood.menu.model.relationship.HaveComboItemOption;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class ItemCombo {

    @GraphId
    private Long id;

    private String label;

    private String code;

    private Set<HaveComboItem> haveComboItemSet;

    private Set<HaveComboItemOption> haveComboItemOptionSet;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Set<HaveComboItem> getHaveComboItemSet() {
        return haveComboItemSet;
    }

    public void setHaveComboItemSet(Set<HaveComboItem> haveComboItemSet) {
        this.haveComboItemSet = haveComboItemSet;
    }

    public void addHaveComboItem(HaveComboItem haveComboItem) {
        if(haveComboItemSet == null) {
            this.haveComboItemSet = new HashSet<>();
        }
        haveComboItemSet.add(haveComboItem);
    }

    public Set<HaveComboItemOption> getHaveComboItemOptionSet() {
        return haveComboItemOptionSet;
    }

    public void setHaveComboItemOptionSet(Set<HaveComboItemOption> haveComboItemOptionSet) {
        this.haveComboItemOptionSet = haveComboItemOptionSet;
    }

    public void addHaveComboItemOption(HaveComboItemOption haveComboItemOption) {
        if(haveComboItemOptionSet == null) {
            this.haveComboItemOptionSet = new HashSet<>();
        }
        haveComboItemOptionSet.add(haveComboItemOption);
    }
}
