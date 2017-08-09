package br.com.ifood.menu.model.entity;

import br.com.ifood.menu.model.relationship.*;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * ItemCombo Neo4J Entity.
 *
 * @author Fabio Covolo Mazzo
 */
@NodeEntity
public class ItemCombo {

    @GraphId
    private Long id;

    private String label;

    private String code;

    @Relationship
    private Set<HaveComboItem> haveComboItemSet;

    @Relationship
    private Set<HaveComboOptionGroup> haveComboOptionGroupSet;

    @Relationship
    private Set<HaveComboOption> haveComboOptionSet;

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

    public Set<HaveComboItem> getHaveComboItemSet() {
        return haveComboItemSet;
    }

    public void setHaveComboItemSet(Set<HaveComboItem> haveComboItemSet) {
        this.haveComboItemSet = haveComboItemSet;
    }

    public Set<HaveComboOptionGroup> getHaveComboOptionGroupSet() {
        return haveComboOptionGroupSet;
    }


    public void setHaveComboOptionGroupSet(Set<HaveComboOptionGroup> haveComboOptionGroupSet) {
        this.haveComboOptionGroupSet = haveComboOptionGroupSet;
    }

    public void addHaveComboOptionGroup(HaveComboOptionGroup haveComboOptionGroup) {
        if (this.haveComboOptionGroupSet == null) {
            this.haveComboOptionGroupSet = new HashSet<>();
        }
        haveComboOptionGroupSet.add(haveComboOptionGroup);
    }

    public Set<HaveComboOption> getHaveComboOptionSet() {
        return haveComboOptionSet;
    }

    public void setHaveComboOptionSet(Set<HaveComboOption> haveComboOptionSet) {
        this.haveComboOptionSet = haveComboOptionSet;
    }

    public void addHaveComboOption(HaveComboOption haveComboOption) {
        if (this.haveComboOptionSet == null) {
            this.haveComboOptionSet = new HashSet<>();
        }
        haveComboOptionSet.add(haveComboOption);
    }

    public void addHaveComboItem(HaveComboItem haveComboItem) {
        if (this.haveComboItemSet == null) {
            this.haveComboItemSet = new HashSet<>();
        }
        haveComboItemSet.add(haveComboItem);
    }


   public void createHaveComboItem(Item item, Boolean available, BigDecimal additionalPrice, String itemGroupCode, Integer order, Integer qty, String chainCode, String restaurantCode) {
        HaveComboItem haveComboItem = new HaveComboItem();
        haveComboItem.setItem(item);
        haveComboItem.setQty(qty);
        haveComboItem.setAdditionalPrice(additionalPrice);
        haveComboItem.setItemGroupCode(itemGroupCode);
        haveComboItem.setOrder(order);
        haveComboItem.setAvailable(available);
        haveComboItem.setChainCode(chainCode);
        haveComboItem.setRestaurantCode(restaurantCode);
        haveComboItem.setItemCombo(this);
        this.addHaveComboItem(haveComboItem);
    }

    public void createHaveComboOptionGroup(OptionGroup optionGroup, Boolean canRepeat, Integer minOptions, Integer maxOptions, Boolean available, Integer order, String chainCode, String restaurantCode) {
        HaveComboOptionGroup haveComboOptionGroup = new HaveComboOptionGroup();
        haveComboOptionGroup.setOptionGroup(optionGroup);
        haveComboOptionGroup.setAvailable(available);
        haveComboOptionGroup.setItemCombo(this);
        haveComboOptionGroup.setChainCode(chainCode);
        haveComboOptionGroup.setRestaurantCode(restaurantCode);
        haveComboOptionGroup.setCanRepeat(canRepeat);
        haveComboOptionGroup.setMinOptions(minOptions);
        haveComboOptionGroup.setMaxOptions(maxOptions);
        haveComboOptionGroup.setOrder(order);
        this.addHaveComboOptionGroup(haveComboOptionGroup);
    }

}
