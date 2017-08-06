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
    private Boolean active;

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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
