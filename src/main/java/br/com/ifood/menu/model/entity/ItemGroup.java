package br.com.ifood.menu.model.entity;

import br.com.ifood.menu.model.relationship.HaveItem;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class ItemGroup {

    @GraphId
    private Long id;

    private String label;

    private HaveItem haveItem;

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

    public HaveItem getHaveItem() {
        return haveItem;
    }

    public void setHaveItem(HaveItem haveItem) {
        this.haveItem = haveItem;
    }
}
