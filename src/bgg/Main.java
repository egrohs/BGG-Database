package bgg;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Main {
	static Boardgames games;

	public static void main(String[] args) {
		try {
			File file = new File("bgg.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Boardgames.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			games = (Boardgames) jaxbUnmarshaller.unmarshal(file);
			System.out.println(games.getGames().size());
			//mechanics();
			//designers();

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	private static void designers() {
		Map<String, Integer> des = new HashMap<String, Integer>();
		for (Boardgame game : games.getGames()) {
			for (Boardgamedesigner m : game.desigs) {
				if (des.containsKey(m.name)) {
					des.put(m.name, des.get(m.name) + 1);
				} else {
					des.put(m.name, 1);
				}
			}
		}
		List<String> keys = Main.sortByValue(des);
		for (String k : keys) {
			System.out.println(k + ";" + des.get(k));
		}
	}

	private static void mechanics() {
		Map<String, Integer> mechs = new HashMap<String, Integer>();
		for (Boardgame game : games.getGames()) {
			for (Boardgamemechanic m : game.mechs) {
				if (mechs.containsKey(m.name)) {
					mechs.put(m.name, mechs.get(m.name) + 1);
				} else {
					mechs.put(m.name, 1);
				}
			}
		}
		List<String> keys = Main.sortByValue(mechs);
		for (String k : keys) {
			System.out.println(k + ";" + mechs.get(k));
		}
	}

	public static List<String> sortByValue(final Map<String, Integer> m) {
		List<String> keys = new ArrayList<String>();
		keys.addAll(m.keySet());
		Collections.sort(keys, new Comparator() {
			public int compare(Object o1, Object o2) {
				Object v1 = m.get(o1);
				Object v2 = m.get(o2);
				if (v1 == null) {
					return (v2 == null) ? 0 : 1;
				} else if (v1 instanceof Comparable) {
					return ((Comparable) v1).compareTo(v2);
				} else {
					return 0;
				}
			}
		});
		return keys;
	}
}
