package com.github.gossie.battleship;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BattleshipApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
		ResponseEntity<TestGameDTO> createGameResponse = restTemplate.postForEntity("/api/games", "Player 1", TestGameDTO.class);
		assertThat(createGameResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);

		String selfHref = createGameResponse.getBody().links().stream()
				.filter(link -> link.hasRel("self"))
				.map(Link::getHref)
				.findFirst()
				.orElseThrow();

		ResponseEntity<TestGameDTO> getGameResponse = restTemplate.getForEntity(selfHref, TestGameDTO.class);
		assertThat(getGameResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(getGameResponse.getBody()).isEqualTo(createGameResponse.getBody());
	}

}
