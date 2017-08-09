package br.com.ifood.menu.model.relationship;

import br.com.ifood.menu.model.entity.ItemCombo;
import br.com.ifood.menu.model.entity.Option;
import org.neo4j.ogm.annotation.*;

/**
 * HaveComboOption RelationShip. (ItemCombo -> Option).
 *
 * @author Fabio Covolo Mazzo
 */
@RelationshipEntity(type = "HAVE_COMBO_ITEM_OPTION")
public class HaveComboOption {

    @GraphId
    private Long id;

    @Property
    private Boolean canRepeat;

    @Property
    private String chainCode;

    @Property
    private String restaurantCode;

    @Property
    private String optionGroupCode;

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

    public Boolean getCanRepeat() {
        return canRepeat;
    }

    public void setCanRepeat(Boolean canRepeat) {
        this.canRepeat = canRepeat;
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

    public String getOptionGroupCode() {
        return optionGroupCode;
    }

    public void setOptionGroupCode(String optionGroupCode) {
        this.optionGroupCode = optionGroupCode;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
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
}
