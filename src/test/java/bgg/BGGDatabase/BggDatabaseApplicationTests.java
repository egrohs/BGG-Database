package bgg.BGGDatabase;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import bgg.Boardgame;
import bgg.repository.BoardgameRepository;

@SpringBootTest
class BggDatabaseApplicationTests {
	@Autowired
	private BoardgameRepository bgRepo;

	@Test
	void contextLoads() {
		Boardgame t = new Boardgame();
		t.setName("Puerto Rico");
//		t.setReleased(1989);
		bgRepo.save(t);
	}
}