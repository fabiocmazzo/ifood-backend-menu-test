package br.com.ifood.menu.repository;

import br.com.ifood.menu.model.entity.CommonItem;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * CommonItem Neo4J Repository.
 * @author Fabio Covolo Mazzo
 */
@Repository
public interface CommonItemRepository extends Neo4jRepository<CommonItem, Long>{
}
