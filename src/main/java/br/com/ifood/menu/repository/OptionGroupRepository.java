package br.com.ifood.menu.repository;

import br.com.ifood.menu.model.entity.OptionGroup;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * Neo4J repository for OptionGroup repository.
 * @author Fabio Covolo Mazzo
 */
@Repository
public interface OptionGroupRepository extends Neo4jRepository<OptionGroup, Long> {

}
