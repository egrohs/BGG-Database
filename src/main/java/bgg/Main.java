package bgg;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import bgg.dominio.Boardgame;
import bgg.dominio.Boardgamecategory;
import bgg.dominio.Boardgamedesigner;
import bgg.dominio.Boardgamemechanic;
import bgg.dominio.Boardgames;

public class Main {
	static Boardgames games;

	public static void main(String[] args) {
		XmlMapper mapper = new XmlMapper();
		Boardgames bgs;
		try {
			mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

			for (int i = 0; i < 100; i++) {
				File f = new File("databases/" + i + ".xml");
				if (f.exists()) {
					bgs = mapper.readValue(f, Boardgames.class);
					Boardgame bg = bgs.getBoardgame();
					if (bg.getObjectid() != null) {
						System.out.println(bg);
						for (Boardgamemechanic m : bg.getBoardgamemechanic()) {
							System.out.println(m);
						}
						for (Boardgamecategory c : bg.getBoardgamecategory()) {
							System.out.println(c);
						}
					}
				}
			}
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void designers() {
		Map<String, Integer> des = new HashMap<String, Integer>();
		for (Boardgame game : games.getGames()) {
			for (Boardgamedesigner m : game.getDesigs()) {
				if (des.containsKey(m.getName())) {
					des.put(m.getName(), des.get(m.getName()) + 1);
				} else {
					des.put(m.getName(), 1);
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
			for (Boardgamemechanic m : game.getMechs()) {
				if (mechs.containsKey(m.getName())) {
					mechs.put(m.getName(), mechs.get(m.getName()) + 1);
				} else {
					mechs.put(m.getName(), 1);
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
