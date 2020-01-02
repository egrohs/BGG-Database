package bgg;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement(name = "boardgame")
public class Boardgame {
	@XmlAttribute
	int objectid;
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
	@XmlElement(name = "boardgamemechanic", type = Boardgamemechanic.class)
	List<Boardgamemechanic> mechs = new ArrayList<Boardgamemechanic>();

	// boardgamemechanic objectid=
	// boardgamecategory objectid=

}