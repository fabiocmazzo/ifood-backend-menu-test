package br.com.ifood.menu.model.entity;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * Chain entity.
 * @author Fabio Covolo Mazzo
 */
@NodeEntity
public class Chain {

    @GraphId
    private Long id;

    @Index(unique = true)
    private String code;

    private String name;

    @Relationship(type = "HAVE_MENU")
    private Menu menu;


    /**
     * Get entity id.
     * @return entity id
     */
    public Long getId() {
        return id;
    }

    /**
     * Set entity id.
     * @param id Entity id
     */
    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
