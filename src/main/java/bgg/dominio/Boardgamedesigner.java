package bgg.dominio;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@NodeEntity
@EqualsAndHashCode(of = "objectid")
@JacksonXmlRootElement(localName = "boardgamedesigner")
public class Boardgamedesigner {
	@Id
	Long objectid;
	@JacksonXmlText
	String name;
}