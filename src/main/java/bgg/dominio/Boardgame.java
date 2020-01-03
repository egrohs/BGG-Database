package bgg.dominio;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@NodeEntity
@EqualsAndHashCode(of = "objectid")
@ToString(of = { "objectid", "name" })
//@JacksonXmlRootElement(localName = "boardgame")
//@JsonDeserialize(as = Boardgame.class)
public class Boardgame {
	@Id
//	@GeneratedValue
	Long objectid;
	// @XmlAttribute
	String name;
	// @XmlAttribute
	int yearpublished;
	// @XmlAttribute
	int minplayers;
	// @XmlAttribute
	int maxplayers;
	// @XmlAttribute
	int playingtime;
	// @XmlAttribute
	int age;
//	// @XmlAttribute
//	String description;
//	@XmlAttribute(name = "boardgamehonor")//, type = Boardgamehonor.class)
//	List<Boardgameartist> honors = new ArrayList<Boardgameartist>();
//	@XmlAttribute(name = "boardgameartist")//, type = Boardgameartist.class)
//	List<Boardgameartist> artists = new ArrayList<Boardgameartist>();
	@JacksonXmlElementWrapper(useWrapping = false)
	// @JacksonXmlProperty(localName = "boardgamecategory")
	List<Boardgamecategory> boardgamecategory;// = new ArrayList<>();
	
	public void setBoardgamecategory(List<Boardgamecategory> value) {
		if (boardgamecategory == null) {
			boardgamecategory = new ArrayList<Boardgamecategory>(value.size());
		}
		boardgamecategory.addAll(value);
	}
	
//	@XmlAttribute(name = "boardgamedesigner")//, type = Boardgamedesigner.class)
//	List<Boardgamedesigner> desigs = new ArrayList<Boardgamedesigner>();

	//@Relationship(type = "POSSUI", direction = Relationship.INCOMING)
	@JacksonXmlElementWrapper(useWrapping = false)
	// @JacksonXmlProperty(localName = "boardgamemechanic")
	List<Boardgamemechanic> boardgamemechanic;// = new ArrayList<>();

	public void setBoardgamemechanic(List<Boardgamemechanic> value) {
		if (boardgamemechanic == null) {
			boardgamemechanic = new ArrayList<Boardgamemechanic>(value.size());
		}
		boardgamemechanic.addAll(value);
	}
}