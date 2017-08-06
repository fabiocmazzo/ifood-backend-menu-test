package br.com.ifood.menu.model.entity;

import br.com.ifood.menu.model.relationship.HaveComboItem;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class ItemCombo {

    @GraphId
    private Long id;

    private String label;

    private HaveComboItem haveComboItem;

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

    public HaveComboItem getHaveComboItem() {
        return haveComboItem;
    }

    public void setHaveComboItem(HaveComboItem haveComboItem) {
        this.haveComboItem = haveComboItem;
    }
}
