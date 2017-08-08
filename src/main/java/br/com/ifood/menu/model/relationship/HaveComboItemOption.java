package br.com.ifood.menu.model.relationship;

import br.com.ifood.menu.model.entity.Item;
import br.com.ifood.menu.model.entity.ItemCombo;
import br.com.ifood.menu.model.entity.Option;
import org.neo4j.ogm.annotation.*;

/**
 * HaveComboItemOption RelationShip. (ItemCombo -> Option).
 *
 * @author Fabio Covolo Mazzo
 */
@RelationshipEntity(type = "HAVE_COMBO_ITEM_OPTION")
public class HaveComboItemOption {

    @GraphId
    private Long id;

    @Property
    private Integer qty;

    @Property
    private Integer order;

    @Property
    private String itemCode;

    @Property
    private String chainCode;

    @Property
    private String restaurantCode;

    @Property
    private Boolean available;

    @StartNode
    private ItemCombo itemCombo;

    @EndNode
    private Option option;

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

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
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

    public ItemCombo getItemCombo() {
        return itemCombo;
    }

    public void setItemCombo(ItemCombo itemCombo) {
        this.itemCombo = itemCombo;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
