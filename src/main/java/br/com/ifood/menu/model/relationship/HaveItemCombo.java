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
    private BigDecimal startPrice;

    @Property
    private Integer order;

    @StartNode
    private ItemGroup itemGroup;

    @EndNode
    private ItemCombo itemCombo;

    @Property
    private String chainCode;

    @Property
    private String restaurantCode;

    @Property
    private Boolean available;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(BigDecimal startPrice) {
        this.startPrice = startPrice;
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

    public String getChainCode() {
        return chainCode;
    }

    public void setChainCode(String chainCode) {
        this.chainCode = chainCode;
    }

    public String getRestaurantCode() {
        return restaurantCode;
    }

    public void setRestaurantCode(String restaurantCode) {
        this.restaurantCode = restaurantCode;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
