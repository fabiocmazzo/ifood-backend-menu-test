package br.com.ifood.menu.model.relationship;

import br.com.ifood.menu.model.entity.Template;
import br.com.ifood.menu.model.entity.TemplateOptionGroup;
import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "HAVE_TEMPLATE_OPTION_GROUP")
public class HaveTemplateOptionGroup {

    @GraphId
    private Long id;

    @StartNode
    private Template template;

    @EndNode
    private TemplateOptionGroup templateOptionGroup;

    @Property
    private Boolean canRepeat;

    @Property
    private Integer minOptions;

    @Property
    private Integer maxOptions;

    @Property
    private Boolean available;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getCanRepeat() {
        return canRepeat;
    }

    public void setCanRepeat(Boolean canRepeat) {
        this.canRepeat = canRepeat;
    }

    public Integer getMinOptions() {
        return minOptions;
    }

    public void setMinOptions(Integer minOptions) {
        this.minOptions = minOptions;
    }

    public Integer getMaxOptions() {
        return maxOptions;
    }

    public void setMaxOptions(Integer maxOptions) {
        this.maxOptions = maxOptions;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
