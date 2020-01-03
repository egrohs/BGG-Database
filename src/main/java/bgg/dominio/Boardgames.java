package bgg.dominio;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "boardgames")
public class Boardgames {
	@JacksonXmlElementWrapper(useWrapping = false)
	private Boardgame boardgame;
}