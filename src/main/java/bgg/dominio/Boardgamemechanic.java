package bgg.dominio;

import java.util.List;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "objectid")
@NodeEntity
@JacksonXmlRootElement(localName = "boardgamemechanic")
public class Boardgamemechanic {
	@Id
//	@GeneratedValue
	Long objectid;

	@JacksonXmlText
	String boardgamemechanic;

	@Relationship(type = "POSSUI")
	private List<Boardgame> bg;
}