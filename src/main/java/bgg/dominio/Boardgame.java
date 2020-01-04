package bgg.dominio;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@NodeEntity
@EqualsAndHashCode(of = "objectid")
@ToString(of = { "objectid", "name" })
@JacksonXmlRootElement(localName = "boardgame")
public class Boardgame {
	@Id
//	@GeneratedValue
	Long objectid;
	// TODO busca o name <name primary="true"
	String name;
	int yearpublished;
	int minplayers;
	int maxplayers;
	int playingtime;
	int age;
	String description;

	//@JacksonXmlElementWrapper(localName="statistics.ratings")
	// private List<String> phone;
	//@JacksonXmlElementWrapper(useWrapping = false)
	//Statistics statistics;
	//Ratings ratings;
	int usersrated;
	double average;
	double bayesaverage;
	double stddev;
	int median;
	int owned;
	int trading;
	int wanting;
	int wishing;
	int numcomments;
	int numweights;
	double averageweight;

	@JacksonXmlElementWrapper(useWrapping = false)
	List<Boardgamehonor> boardgamehonor;

	public void setBoardgamehonor(List<Boardgamehonor> value) {
		if (boardgamehonor == null) {
			boardgamehonor = new ArrayList<Boardgamehonor>(value.size());
		}
		boardgamehonor.addAll(value);
	}

	@JacksonXmlElementWrapper(useWrapping = false)
	List<Boardgamedesigner> boardgamedesigner;

	public void setBoardgamedesigner(List<Boardgamedesigner> value) {
		if (boardgamedesigner == null) {
			boardgamedesigner = new ArrayList<Boardgamedesigner>(value.size());
		}
		boardgamedesigner.addAll(value);
	}

	@JacksonXmlElementWrapper(useWrapping = false)
	List<Boardgameartist> boardgameartist;

	public void setBboardgameartist(List<Boardgameartist> value) {
		if (boardgameartist == null) {
			boardgameartist = new ArrayList<Boardgameartist>(value.size());
		}
		boardgameartist.addAll(value);
	}

	@JacksonXmlElementWrapper(useWrapping = false)
	List<Boardgamecategory> boardgamecategory;

	// sets necessarios pra corrigir um bug? do jackson ao importar listas
	// parcialmente (apenas os ultimos elementos).
	public void setBoardgamecategory(List<Boardgamecategory> value) {
		if (boardgamecategory == null) {
			boardgamecategory = new ArrayList<Boardgamecategory>(value.size());
		}
		boardgamecategory.addAll(value);
	}

	@JacksonXmlElementWrapper(useWrapping = false)
	List<Boardgamemechanic> boardgamemechanic;

	public void setBoardgamemechanic(List<Boardgamemechanic> value) {
		if (boardgamemechanic == null) {
			boardgamemechanic = new ArrayList<Boardgamemechanic>(value.size());
		}
		boardgamemechanic.addAll(value);
	}
}