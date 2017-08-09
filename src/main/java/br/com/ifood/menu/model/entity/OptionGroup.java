package br.com.ifood.menu.model.entity;

import br.com.ifood.menu.model.relationship.HaveOption;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * OptionGroup Neo4J Entity.
 *
 * @author Fabio Covolo Mazzo
 */
@NodeEntity
public class OptionGroup {

    @GraphId
    private Long id;

    @Index(unique = true)
    private String code;

    private String label;

    private String type;

    @Relationship(type = "HAVE_OPTION")
    private List<HaveOption> haveOptionList;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<HaveOption> getHaveOptionList() {
        return haveOptionList;
    }

    public void setHaveOptionList(List<HaveOption> haveOptionList) {
        this.haveOptionList = haveOptionList;
    }

    public void addHaveOption(HaveOption haveOption) {
        if (haveOptionList == null) {
            haveOptionList = new ArrayList<>();
        }
        haveOptionList.add(haveOption);
    }

    public void createHaveOption(Option option, Integer order, Boolean canRepeat, BigDecimal price, Boolean available, String chainCode, String restaurantCode) {
        HaveOption haveOption = new HaveOption();
        haveOption.setOrder(1);
        haveOption.setPrice(price);
        haveOption.setOption(option);
        haveOption.setAvailable(available);
        haveOption.setOptionGroup(this);
        haveOption.setCanRepeat(canRepeat);
        haveOption.setChainCode(chainCode);
        haveOption.setChainCode(restaurantCode);
        this.addHaveOption(haveOption);
    }

}
