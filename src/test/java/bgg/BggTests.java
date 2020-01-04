package bgg;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import bgg.dominio.Boardgame;
import bgg.dominio.Boardgameartist;
import bgg.dominio.Boardgamecategory;
import bgg.dominio.Boardgamemechanic;
import bgg.dominio.Boardgames;
import bgg.dominio.Rank;
import bgg.repository.BoardgameRepository;

@SpringBootTest
class BggTests {
	@Autowired
	private BoardgameRepository bgRepo;

	@Test
	void contextLoads() {
		//System.out.println(bgRepo.findById(10L));
		List<Boardgame> bgs = load();
		for (Boardgame bg : bgs) {
			bgRepo.save(bg);
		}
	}

	private List<Boardgame> load() {
		XmlMapper mapper = new XmlMapper();
		List<Boardgame> lbgs = new ArrayList<>();
		Boardgames bgs = null;
		Boardgame bg = null;
		try {
			mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

			//int i = 10;
			for (int i = 0; i < 100; i++)
			{
				File f = new File("databases/" + i + ".xml");
				if (f.exists())
				{
					Path path = Paths.get(f.getPath());
					String xml = Files.readString(path).replaceAll("</?statistics( page=\"\\d+\")?>", "")
							.replaceAll("</?ratings\\s?>", "").replaceAll("</?ranks>", "");
					//System.out.println(xml);
					bgs = mapper.readValue(xml, Boardgames.class);
					bg = bgs.getBoardgame();
					if (bg.getObjectid() != null) {
						lbgs.add(bg);
						System.out.println(bg);
						System.out.println(bg.getUsersrated());
						// System.exit(0);
//						for (Boardgamemechanic m : bg.getBoardgamemechanic()) {
//							System.out.println(m);
//						}
//						for (Boardgamecategory c : bg.getBoardgamecategory()) {
//							System.out.println(c);
//						}
//						for (Boardgameartist c : bg.getBoardgameartist()) {
//							System.out.println(c);
//						}
						for (Rank c : bg.getRank()) {
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
		return lbgs;
	}
}