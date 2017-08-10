package br.com.ifood.menu.model.entity;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * TemplateOption Entity
 * @author Fabio Covolo Mazzo
 */
@NodeEntity
public class TemplateOption {

    @GraphId
    private Long id;

    private String description;

    @Relationship(type="HAVE_TEMPLATE_OPTION_TYPE_ITEM")
    private Template template;

    @Relationship(type="HAVE_TEMPLATE_OPTION_TYPE_GROUP")
    private TemplateOptionGroup templateOptionGroup;

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

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    public TemplateOptionGroup getTemplateOptionGroup() {
        return templateOptionGroup;
    }

    public void setTemplateOptionGroup(TemplateOptionGroup templateOptionGroup) {
        this.templateOptionGroup = templateOptionGroup;
    }
}
