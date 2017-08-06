package br.com.ifood.menu.repository;

import br.com.ifood.menu.model.entity.Option;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * Neo4J repository for Option repository.
 * @author Fabio Covolo Mazzo
 */
@Repository
public interface OptionRepository extends Neo4jRepository<Option, Long> {

}
