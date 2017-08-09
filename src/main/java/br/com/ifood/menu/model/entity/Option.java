package br.com.ifood.menu.model.entity;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * Option Entity
 * @author Fabio Covolo Mazzo
 */
@NodeEntity
public class Option {

    @GraphId
    private Long id;

    @Index(unique=true)
    private String code;

    private String label;

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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
