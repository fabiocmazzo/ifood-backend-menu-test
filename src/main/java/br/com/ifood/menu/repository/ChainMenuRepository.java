package br.com.ifood.menu.repository;

import br.com.ifood.menu.model.entity.Chain;
import br.com.ifood.menu.model.entity.ChainMenu;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * Neo4J repository for ChainMenu entity.
 * @author Fabio Covolo Mazzo
 */
@Repository
interface ChainMenuRepository extends Neo4jRepository<ChainMenu, Long> {

    Chain findByCode(String code);

}