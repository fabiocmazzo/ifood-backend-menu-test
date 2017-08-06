package br.com.ifood.menu.model.relationship;

import br.com.ifood.menu.model.entity.ItemCombo;
import br.com.ifood.menu.model.entity.ItemGroup;
import org.neo4j.ogm.annotation.*;

import java.math.BigDecimal;

/**
 * HaveItemCombo RelationShip. ItemGroup -> ItemCombo
 * @author Fabio Covolo Mazzo
 */
@RelationshipEntity(type="HAVE_ITEM_COMBO")
public class HaveItemCombo {

    @GraphId
    private Long id;

    @Property
    private BigDecimal price;

    @Property
    private Integer order;

    @StartNode
    private ItemGroup itemGroup;

    @EndNode
    private ItemCombo itemCombo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public ItemGroup getItemGroup() {
        return itemGroup;
    }

    public void setItemGroup(ItemGroup itemGroup) {
        this.itemGroup = itemGroup;
    }

    public ItemCombo getItemCombo() {
        return itemCombo;
    }

    public void setItemCombo(ItemCombo itemCombo) {
        this.itemCombo = itemCombo;
    }
}
