package br.com.ifood.menu.repository;

import br.com.ifood.menu.model.entity.Restaurant;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * Neo4J repository for Restaurant entity.
 * @author Fabio Covolo Mazzo
 */
@Repository
public interface RestaurantRepository extends Neo4jRepository<Restaurant, Long> {

    Restaurant findByCode(String code);

}