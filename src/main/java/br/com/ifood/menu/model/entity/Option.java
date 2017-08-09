package br.com.ifood.menu.model.entity;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

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

    @Relationship(type="HAVE_OPTION_TYPE_ITEM")
    private Item item;

    /**
     * Properties used for OptionGroup, is here to avoid complexity
     * to create a unecessary relationship.
     */
    private Integer maxOptionsForOptionGroup;

    private Integer minOptionForOptionGroup;

    private Boolean canRepeatForOptionGroup;

    @Relationship(type="HAVE_OPTION_TYPE_OPTION_GROUP")
    private OptionGroup optionGroup;



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

    public Integer getMaxOptionsForOptionGroup() {
        return maxOptionsForOptionGroup;
    }

    public void setMaxOptionsForOptionGroup(Integer maxOptionsForOptionGroup) {
        this.maxOptionsForOptionGroup = maxOptionsForOptionGroup;
    }

    public Integer getMinOptionForOptionGroup() {
        return minOptionForOptionGroup;
    }

    public void setMinOptionForOptionGroup(Integer minOptionForOptionGroup) {
        this.minOptionForOptionGroup = minOptionForOptionGroup;
    }

    public Boolean getCanRepeatForOptionGroup() {
        return canRepeatForOptionGroup;
    }

    public void setCanRepeatForOptionGroup(Boolean canRepeatForOptionGroup) {
        this.canRepeatForOptionGroup = canRepeatForOptionGroup;
    }
}
