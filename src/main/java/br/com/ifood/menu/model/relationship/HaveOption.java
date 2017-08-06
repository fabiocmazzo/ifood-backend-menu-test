package br.com.ifood.menu.model.relationship;

import br.com.ifood.menu.model.entity.Option;
import br.com.ifood.menu.model.entity.OptionGroup;
import org.neo4j.ogm.annotation.*;

import java.math.BigDecimal;

/**
 * HaveOption Relationship. OptionGroup -> Option.
 * @author Fabio Covolo Mazzo
 */
@RelationshipEntity(type="HAVE_OPTION")
public class HaveOption {

    @GraphId
    private Long id;

    @Property
    private Boolean canRepeat;

    @Property
    private Integer order;

    @Property
    private BigDecimal price;

    @StartNode
    private OptionGroup optionGroup;

    @EndNode
    private Option option;

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

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public OptionGroup getOptionGroup() {
        return optionGroup;
    }

    public void setOptionGroup(OptionGroup optionGroup) {
        this.optionGroup = optionGroup;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }
}
