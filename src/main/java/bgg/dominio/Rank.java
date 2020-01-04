package bgg.dominio;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@NodeEntity
@EqualsAndHashCode(of = { "objectid", "id" })
@ToString(of = { "objectid", "id", "name" })
@JacksonXmlRootElement(localName = "rank")
//@CompositeIndex()
//@CompositeIndexes()
public class Rank {
	@Id
	@GeneratedValue
	Long objectid;
	@Id
	Long id;
	String type;
	String name;
	String friendlyname;
	int value;
	double bayesaverage;
}