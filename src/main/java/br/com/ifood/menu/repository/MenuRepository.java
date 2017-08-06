package br.com.ifood.menu.repository;

import br.com.ifood.menu.model.entity.Menu;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * Neo4J repository for Menu repository.
 * @author Fabio Covolo Mazzo
 */
@Repository
interface MenuRepository extends Neo4jRepository<Menu, Long> {

    Menu findByCode(String code);

}
