package bgg;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "boardgames")
public class Boardgames {

	@XmlElement(name = "boardgame", type = Boardgame.class)
	private List<Boardgame> games = new ArrayList<Boardgame>();

	public Boardgames() {
	}

	public Boardgames(List<Boardgame> books) {
		this.games = books;
	}

	public List<Boardgame> getGames() {
		return games;
	}

	public void setGames(List<Boardgame> games) {
		this.games = games;
	}
}
