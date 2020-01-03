package bgg.dominio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement(name = "boardgamedesigner")
@XmlAccessorType(XmlAccessType.FIELD)
public class Boardgamedesigner {
	@XmlAttribute
	int objectid;
	@XmlAttribute
	String name;
}