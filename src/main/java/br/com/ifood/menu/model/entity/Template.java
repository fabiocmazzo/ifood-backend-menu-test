package br.com.ifood.menu.model.entity;

import br.com.ifood.menu.model.relationship.HaveTemplateOptionGroup;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

/**
 * Template Entity
 * @author Fabio Covolo Mazzo
 */
@NodeEntity
public class Template {

    @GraphId
    private Long id;

    @Index(unique = true)
    private String code;

    private String description;

    @Relationship
    private Set<HaveTemplateOptionGroup> haveTemplateOptionGroupSet;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<HaveTemplateOptionGroup> getHaveTemplateOptionGroupSet() {
        return haveTemplateOptionGroupSet;
    }

    public void setHaveTemplateOptionGroupSet(Set<HaveTemplateOptionGroup> haveTemplateOptionGroupSet) {
        this.haveTemplateOptionGroupSet = haveTemplateOptionGroupSet;
    }
}
