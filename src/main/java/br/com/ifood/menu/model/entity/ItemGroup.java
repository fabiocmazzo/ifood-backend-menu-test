package br.com.ifood.menu.model.entity;

import br.com.ifood.menu.model.relationship.HaveItem;
import br.com.ifood.menu.model.relationship.HaveItemCombo;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * ItemGroup Entity.
 * @author Fabio Covolo Mazzo
 */
@NodeEntity
public class ItemGroup {

    @GraphId
    private Long id;

    private String code;

    private String label;

    @Relationship(type="HAVE_ITEM")
    private Set<HaveItem> haveItemList;

    @Relationship(type="HAVE_ITEM_COMBO")
    private Set<HaveItemCombo> haveItemComboSet;

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

    public Set<HaveItem> getHaveItemList() {
        return haveItemList;
    }

    public void setHaveItemList(Set<HaveItem> haveItemList) {
        this.haveItemList = haveItemList;
    }

    public void addHaveItem(HaveItem haveItem) {
        if(this.haveItemList == null) {
            this.haveItemList = new HashSet<>();
        }
        this.haveItemList.add(haveItem);
    }

    public void createHaveItem(Item item, Integer order, Boolean available, BigDecimal startPrice, String chainCode, String restaurantCode) {
        HaveItem haveItem = new HaveItem();
        haveItem.setItemGroup(this);
        haveItem.setItem(item);
        haveItem.setOrder(order);
        haveItem.setAvailable(available);
        haveItem.setChainCode(chainCode);
        haveItem.setRestaurantCode(restaurantCode);
        haveItem.setStartPrice(startPrice);
        this.addHaveItem(haveItem);
    }



    public Set<HaveItemCombo> getHaveItemComboSet() {
        return haveItemComboSet;
    }

    public void setHaveItemComboSet(Set<HaveItemCombo> haveItemComboSet) {
        this.haveItemComboSet = haveItemComboSet;
    }

    public void addHaveItemCombo(HaveItemCombo haveItemCombo) {
        if(this.haveItemComboSet == null) {
            this.haveItemComboSet = new HashSet<>();
        }
        this.haveItemComboSet.add(haveItemCombo);
    }
}
