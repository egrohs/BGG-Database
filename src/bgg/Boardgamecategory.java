package bgg;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "boardgamecategory")
public class Boardgamecategory {
	@XmlAttribute
	int objectid;
	@XmlValue
	String name;
}
