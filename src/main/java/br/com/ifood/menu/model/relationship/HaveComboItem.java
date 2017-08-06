package br.com.ifood.menu.model.relationship;

import br.com.ifood.menu.model.entity.Item;
import br.com.ifood.menu.model.entity.ItemCombo;
import org.neo4j.ogm.annotation.*;

/**
 * HaveComboItem (ItemCombo -> Item) Relationship.
 * @author Fabio Covolo Mazzo
 */
@RelationshipEntity(type="HAVE_COMBO_ITEM")
public class HaveComboItem {

    @GraphId
    private Long id;

    @Property
    private Integer qty;

    @Property
    private Integer order;

    @StartNode
    private ItemCombo itemCombo;

    @EndNode
    private Item item;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public ItemCombo getItemCombo() {
        return itemCombo;
    }

    public void setItemCombo(ItemCombo itemCombo) {
        this.itemCombo = itemCombo;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
