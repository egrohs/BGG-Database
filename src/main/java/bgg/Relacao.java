package bgg;

import java.util.Collection;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
//@JsonIdentityInfo(generator=JSOGGenerator.class)
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
@RelationshipEntity(type = "POSSUI")
public class Relacao {
	@Id
	@GeneratedValue
	Long id;

	private Collection<String> roles;

	@StartNode
	private Boardgame bg;

	@EndNode
	private Boardgamemechanic mechanic;
}