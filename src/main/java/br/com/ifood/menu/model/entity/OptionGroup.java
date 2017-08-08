package br.com.ifood.menu.model.entity;

import br.com.ifood.menu.model.relationship.HaveOption;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

/**
 * OptionGroup Neo4J Entity.
 * @author Fabio Covolo Mazzo
 */
@NodeEntity
public class OptionGroup {

    @GraphId
    private Long id;

    private String label;

    @Relationship(type = "HAVE_OPTION")
    private List<HaveOption> haveOptionList;

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

    public List<HaveOption> getHaveOptionList() {
        return haveOptionList;
    }

    public void setHaveOptionList(List<HaveOption> haveOptionList) {
        this.haveOptionList = haveOptionList;
    }

    public void addHaveOption(HaveOption haveOption) {
        if(haveOptionList == null) {
            haveOptionList = new ArrayList<>();
        }
        haveOptionList.add(haveOption);
    }


}
