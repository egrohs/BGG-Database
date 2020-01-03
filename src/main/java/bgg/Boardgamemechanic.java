package bgg;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "objectid")
@NodeEntity
@XmlRootElement(name = "boardgamecategory")
public class Boardgamemechanic {
	@Id
	@GeneratedValue
	@XmlAttribute
	Long objectid;
	@XmlValue
	String name;

	@Relationship(type = "POSSUI")
	private List<Boardgame> bg;
}