package br.com.ifood.menu.model.entity;

import br.com.ifood.menu.model.relationship.HaveOptionGroup;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

/**
 * ItemCombo Entity
 * @author Fabio Covolo Mazzo
 */
@NodeEntity
public class Item {

    @GraphId
    private Long id;

    /**
     * Não pode ser único pois será utilzado para sobrescrever itens
     * do ChainMenu pelo Menu.
     */
    private String code;

    private String label;

    @Relationship(type = "HAVE_OPTION_GROUP")
    private Set<HaveOptionGroup> haveOptionGroupSet;

    @Relationship(type = "IMPLEMENTS_TEMPLATE")
    private Template template;



    public void overwriteChainRelationships() {

    }



    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Set<HaveOptionGroup> getHaveOptionGroupSet() {
        return haveOptionGroupSet;
    }

    public void setHaveOptionGroupSet(Set<HaveOptionGroup> haveOptionGroupSet) {
        this.haveOptionGroupSet = haveOptionGroupSet;
    }

    public void addHaveOptionGroup(HaveOptionGroup haveOptionGroup) {
        if(this.haveOptionGroupSet == null) {
            this.haveOptionGroupSet = new HashSet<>();
        }
        this.haveOptionGroupSet.add(haveOptionGroup);
    }

    public void createHaveOptionGroup(OptionGroup optionGroup, Boolean available, Integer order, Boolean canRepeat, Integer minOptions, Integer maxOptions, String chainCode, String restaurantCode) {
        HaveOptionGroup haveOptionGroup = new HaveOptionGroup();
        haveOptionGroup.setItem(this);
        haveOptionGroup.setAvailable(available);
        haveOptionGroup.setChainCode(chainCode);
        haveOptionGroup.setCanRepeat(canRepeat);
        haveOptionGroup.setMinOptions(minOptions);
        haveOptionGroup.setMaxOptions(maxOptions);
        haveOptionGroup.setRestaurantCode(restaurantCode);
        haveOptionGroup.setOptionGroup(optionGroup);
        haveOptionGroup.setOrder(order);
        this.addHaveOptionGroup(haveOptionGroup);
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }
}
