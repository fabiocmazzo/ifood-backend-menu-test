package br.com.ifood.menu.repository;

import br.com.ifood.menu.model.entity.Chain;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * Neo4J repository for Chain repository.
 * @author Fabio Covolo Mazzo
 */
@Repository
public interface ChainRepository extends Neo4jRepository<Chain, Long> {

    Chain findByCode(String code);

}
