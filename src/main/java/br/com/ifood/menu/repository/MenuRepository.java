package br.com.ifood.menu.repository;

import br.com.ifood.menu.model.entity.Menu;
import br.com.ifood.menu.model.entity.Restaurant;
import org.springframework.data.neo4j.annotation.Depth;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * Neo4J repository for Menu repository.
 * @author Fabio Covolo Mazzo
 */
@Repository
public interface MenuRepository extends Neo4jRepository<Menu, Long> {

   Menu findByCode(String code);

    @Query("MATCH (n:Restaurant) WHERE n.code = {0}  WITH n MATCH p=(n)-[rel*0..]-(m) where all(x in rel where x.restaurantCode = n.code or not exists(x.restaurantCode)) RETURN p " +
           "UNION " +
           "MATCH (n:Restaurant)-->(c:Chain) WHERE n.code = {0}  WITH n MATCH p=(n)-[rel*0..]-(m) where all(x in rel where x.restaurantCode = n.code or x.chainCode is not null or  (not exists(x.restaurantCode) and not exists(x.chainCode))  ) RETURN p")
    Menu findRelated(String code);

}
