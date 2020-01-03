package bgg;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@XmlRootElement(name = "boardgame")
@NodeEntity
@EqualsAndHashCode(of = "objectid")
@ToString(of = { "objectid", "name" })
public class Boardgame {
	@Id
	@GeneratedValue
	@XmlAttribute
	Long objectid;
	@XmlElement
	String name;
	@XmlElement
	int yearpublished;
	@XmlElement
	int minplayers;
	@XmlElement
	int maxplayers;
	@XmlElement
	int playingtime;
	@XmlElement
	int age;
	@XmlElement
	String description;
	@XmlElement(name = "boardgamehonor", type = Boardgamehonor.class)
	List<Boardgameartist> honors = new ArrayList<Boardgameartist>();
	@XmlElement(name = "boardgameartist", type = Boardgameartist.class)
	List<Boardgameartist> artists = new ArrayList<Boardgameartist>();
	@XmlElement(name = "boardgamecategory", type = Boardgamecategory.class)
	List<Boardgamecategory> cats = new ArrayList<Boardgamecategory>();
	@XmlElement(name = "boardgamedesigner", type = Boardgamedesigner.class)
	List<Boardgamedesigner> desigs = new ArrayList<Boardgamedesigner>();
	
	@Relationship(type = "POSSUI", direction = Relationship.INCOMING)
	@XmlElement(name = "boardgamemechanic", type = Boardgamemechanic.class)
	List<Boardgamemechanic> mechs = new ArrayList<Boardgamemechanic>();

	// boardgamemechanic objectid=
	// boardgamecategory objectid=

}