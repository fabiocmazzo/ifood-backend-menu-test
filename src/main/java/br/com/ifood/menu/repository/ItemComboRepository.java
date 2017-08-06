package br.com.ifood.menu.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * Neo4J repository for Item repository.
 * @author Fabio Covolo Mazzo
 */
@Repository
public interface ItemComboRepository extends Neo4jRepository<ItemRepository, Long> {

    ItemRepository findByCode(String code);

}
