package br.com.ifood.menu.model.relationship;

import br.com.ifood.menu.model.entity.ItemGroup;
import br.com.ifood.menu.model.entity.Menu;
import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "HAVE_ITEM_GROUP")
public class HaveItemGroup {

    @GraphId
    private Long id;

    @StartNode
    private Menu menu;

    @EndNode
    private ItemGroup itemGroup;

    @Property
    private Boolean available;

    @Property
    private String restaurantCode;

    @Property
    private String chainCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public ItemGroup getItemGroup() {
        return itemGroup;
    }

    public void setItemGroup(ItemGroup itemGroup) {
        this.itemGroup = itemGroup;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getRestaurantCode() {
        return restaurantCode;
    }

    public void setRestaurantCode(String restaurantCode) {
        this.restaurantCode = restaurantCode;
    }

    public String getChainCode() {
        return chainCode;
    }

    public void setChainCode(String chainCode) {
        this.chainCode = chainCode;
    }
}
