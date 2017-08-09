package br.com.ifood.menu.model.relationship;

import br.com.ifood.menu.model.entity.Item;
import br.com.ifood.menu.model.entity.ItemCombo;
import br.com.ifood.menu.model.entity.Option;
import br.com.ifood.menu.model.entity.OptionGroup;
import org.neo4j.ogm.annotation.*;

/**
 * HaveComboOptionGroup RelationShip. (ItemCombo -> OptionGroup).
 *
 * @author Fabio Covolo Mazzo
 */
@RelationshipEntity(type = "HAVE_COMBO_OPTION_GROUP")
public class HaveComboOptionGroup {

    @GraphId
    private Long id;

    @Property
    private Integer order;

    @Property
    private String chainCode;

    @Property
    private String restaurantCode;

    @Property
    private Boolean canRepeat;

    @Property
    private Integer minOptions;

    @Property
    private Integer maxOptions;

    @Property
    private Boolean available;

    @StartNode
    private ItemCombo itemCombo;

    @EndNode
    private OptionGroup optionGroup;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
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

    public Boolean getCanRepeat() {
        return canRepeat;
    }

    public void setCanRepeat(Boolean canRepeat) {
        this.canRepeat = canRepeat;
    }

    public Integer getMinOptions() {
        return minOptions;
    }

    public void setMinOptions(Integer minOptions) {
        this.minOptions = minOptions;
    }

    public Integer getMaxOptions() {
        return maxOptions;
    }

    public void setMaxOptions(Integer maxOptions) {
        this.maxOptions = maxOptions;
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

    public OptionGroup getOptionGroup() {
        return optionGroup;
    }

    public void setOptionGroup(OptionGroup optionGroup) {
        this.optionGroup = optionGroup;
    }
}
