package br.com.ifood.menu.model.relationship;

import br.com.ifood.menu.model.entity.TemplateOption;
import br.com.ifood.menu.model.entity.TemplateOptionGroup;
import org.neo4j.ogm.annotation.*;

/**
 * HaveTemplateOption Relationship.
 * @author Fabio Covolo Mazzo
 */
@RelationshipEntity(type="HAVE_TEMPLATE_OPTION")
public class HaveTemplateOption {

    @GraphId
    private Long id;

    @Property
    private Boolean canRepeat;

    @StartNode
    private TemplateOptionGroup templateOptionGroup;

    @EndNode
    private TemplateOption templateOption;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getCanRepeat() {
        return canRepeat;
    }

    public void setCanRepeat(Boolean canRepeat) {
        this.canRepeat = canRepeat;
    }

    public TemplateOptionGroup getTemplateOptionGroup() {
        return templateOptionGroup;
    }

    public void setTemplateOptionGroup(TemplateOptionGroup templateOptionGroup) {
        this.templateOptionGroup = templateOptionGroup;
    }

    public TemplateOption getTemplateOption() {
        return templateOption;
    }

    public void setTemplateOption(TemplateOption templateOption) {
        this.templateOption = templateOption;
    }
}

