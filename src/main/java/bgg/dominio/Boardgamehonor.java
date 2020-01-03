package bgg.dominio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement(name = "boardgamehonor")
@XmlAccessorType(XmlAccessType.FIELD)
public class Boardgamehonor {
	@XmlAttribute
	int objectid;
	@XmlAttribute
	String name;
}