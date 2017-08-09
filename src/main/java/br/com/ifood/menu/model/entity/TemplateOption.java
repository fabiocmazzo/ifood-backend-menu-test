package br.com.ifood.menu.model.entity;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * TemplateOption Entity
 * @author Fabio Covolo Mazzo
 */
@NodeEntity
public class TemplateOption {

    @GraphId
    private Long id;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
