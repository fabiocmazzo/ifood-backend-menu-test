package br.com.ifood.menu.model.entity;

import br.com.ifood.menu.model.relationship.HaveItem;
import br.com.ifood.menu.model.relationship.HaveOptionGroup;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

/**
 * ItemCombo Entity
 * @author Fabio Covolo Mazzo
 */
@NodeEntity
public class Item {

    @GraphId
    private Long id;

    /**
     * Não pode ser único pois será utilzado para sobrescrever itens
     * do ChainMenu pelo Menu.
     */
    private String code;

    private String label;

    @Relationship(type = "HAVE_OPTION_GROUP")
    private Set<HaveOptionGroup> haveOptionGroupSet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Set<HaveOptionGroup> getHaveOptionGroupSet() {
        return haveOptionGroupSet;
    }

    public void setHaveOptionGroupSet(Set<HaveOptionGroup> haveOptionGroupSet) {
        this.haveOptionGroupSet = haveOptionGroupSet;
    }

    public void addHaveOptionGroup(HaveOptionGroup haveOptionGroup) {
        if(this.haveOptionGroupSet == null) {
            this.haveOptionGroupSet = new HashSet<>();
        }
        this.haveOptionGroupSet.add(haveOptionGroup);
    }
}
