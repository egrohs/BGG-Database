package bgg.dominio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement(name = "boardgamesubdomain")
@XmlAccessorType(XmlAccessType.FIELD)
public class Boardgamesubdomain {
	@XmlAttribute
	int objectid;
	@XmlAttribute
	String name;
}