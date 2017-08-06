package br.com.ifood.menu.model.relationship;

import br.com.ifood.menu.model.entity.Item;
import br.com.ifood.menu.model.entity.OptionGroup;
import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "HAVE_OPTION_GROUP")
public class HaveOptionGroup {

    @GraphId
    private Long id;

    @StartNode
    private Item item;

    @EndNode
    private OptionGroup optionGroup;

    @Property
    private Integer order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public OptionGroup getOptionGroup() {
        return optionGroup;
    }

    public void setOptionGroup(OptionGroup optionGroup) {
        this.optionGroup = optionGroup;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
