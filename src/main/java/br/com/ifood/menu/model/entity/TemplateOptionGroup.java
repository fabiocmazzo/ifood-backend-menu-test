package br.com.ifood.menu.model.entity;

import br.com.ifood.menu.model.relationship.HaveTemplateOption;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

/**
 * TemplateOptionGroup Entity
 * @author Fabio Covolo Mazzo
 */
@NodeEntity
public class TemplateOptionGroup {

    @GraphId
    private Long id;

    @Index(unique = true)
    private String code;

    private String description;

    @Relationship
    private Set<HaveTemplateOption> haveTemplateOptionSet;

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

    public Set<HaveTemplateOption> getHaveTemplateOptionSet() {
        return haveTemplateOptionSet;
    }

    public void setHaveTemplateOptionSet(Set<HaveTemplateOption> haveTemplateOptionSet) {
        this.haveTemplateOptionSet = haveTemplateOptionSet;
    }
}
