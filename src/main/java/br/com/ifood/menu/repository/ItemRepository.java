package br.com.ifood.menu.repository;

import br.com.ifood.menu.model.entity.Item;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * Neo4J repository for Item repository.
 * @author Fabio Covolo Mazzo
 */
@Repository
public interface ItemRepository extends Neo4jRepository<Item, Long> {

    Item findByCode(String code);

}
