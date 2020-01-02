package bgg;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "boardgamehonor")
public class Boardgamehonor {
	@XmlAttribute
	int objectid;
	@XmlValue
	String name;
}
