package bgg.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import bgg.dominio.Boardgame;

@Repository
public interface BoardgameRepository extends Neo4jRepository<Boardgame, Long> {
	Boardgame findByName(@Param("name") String name);

//	@Query("MATCH (m:Movie) WHERE m.title =~ ('(?i).*'+{title}+'.*') RETURN m")
//	Collection<Boardgame> findByTitleContaining(@Param("title") String title);
//
//	@Query("MATCH (m:Movie)<-[:ACTED_IN]-(a:Person) RETURN m.title as movie, collect(a.name) as cast LIMIT {limit}")
//	List<Map<String, Object>> graph(@Param("limit") int limit);
}