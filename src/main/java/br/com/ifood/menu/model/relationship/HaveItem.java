package br.com.ifood.menu.model.relationship;

import br.com.ifood.menu.model.entity.Item;
import br.com.ifood.menu.model.entity.ItemGroup;
import org.neo4j.ogm.annotation.*;

import java.math.BigDecimal;

/**
 * HaveItem RelationShip ItemGroup -> Item
 * @author Fabio Covolo Mazzo
 */
@RelationshipEntity(type = "HAVE_ITEM")
public class HaveItem {

    @GraphId
    private Long id;

    @Property
    private BigDecimal price;

    @Property
    private Integer order;

    @StartNode
    private ItemGroup itemGroup;

    @EndNode
    private Item item;

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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
