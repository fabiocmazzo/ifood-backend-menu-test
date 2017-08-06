package br.com.ifood.menu.repository;

import br.com.ifood.menu.model.entity.CommonItemPool;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonItemPoolRepository extends Neo4jRepository<CommonItemPool, Long>{
}
