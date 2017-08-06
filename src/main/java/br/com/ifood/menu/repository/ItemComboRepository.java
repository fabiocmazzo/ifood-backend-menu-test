package br.com.ifood.menu.repository;

import br.com.ifood.menu.model.entity.ItemCombo;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * Neo4J repository for ItemCombo Repository.
 * @author Fabio Covolo Mazzo
 */
@Repository
public interface ItemComboRepository extends Neo4jRepository<ItemCombo, Long> {

    ItemRepository findByCode(String code);

}
