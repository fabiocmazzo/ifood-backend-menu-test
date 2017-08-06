package br.com.ifood.menu.model.entity;

import br.com.ifood.menu.model.relationship.HaveOption;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class OptionGroup {

    @GraphId
    private Long id;

    private String label;

    private HaveOption haveOption;

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

    public HaveOption getHaveOption() {
        return haveOption;
    }

    public void setHaveOption(HaveOption haveOption) {
        this.haveOption = haveOption;
    }
}
