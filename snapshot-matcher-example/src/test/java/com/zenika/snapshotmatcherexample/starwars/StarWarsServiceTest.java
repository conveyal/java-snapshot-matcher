package com.zenika.snapshotmatcherexample.starwars;

import static com.zenika.snapshotmatcher.SnapshotMatcher.matchesSnapshot;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static utils.TestUtils.fromJson;

import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.zenika.snapshotmatcherexample.starwars.dtos.FilmDTO;
import com.zenika.snapshotmatcherexample.starwars.dtos.PeopleDTO;
import com.zenika.snapshotmatcherexample.starwars.dtos.PlanetDTO;
import com.zenika.snapshotmatcherexample.starwars.entities.Planet;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StarWarsServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @Autowired
    @InjectMocks
    private StarWarsService service;

    private PeopleDTO lukeSkywalker = fromJson("luke-skywalker", PeopleDTO.class);
    private FilmDTO attackOfTheClones = fromJson("attack-of-the-clones", FilmDTO.class);
    private Planet tatooine = fromJson("tatooine", Planet.class);

    @Before
    public void setUp() {
        when(restTemplate.getForObject("https://swapi.co/api/people/1/", PeopleDTO.class))
                .thenReturn(lukeSkywalker);
        when(restTemplate.getForObject("https://swapi.co/api/films/5/", FilmDTO.class))
                .thenReturn(attackOfTheClones);
        when(restTemplate.getForObject("https://swapi.co/api/planets/1", Planet.class))
                .thenReturn(tatooine);
    }

    @Test
    public void getPlanetTest() {
        PlanetDTO planet = service.getPlanet(1L);

        assertThat(planet, matchesSnapshot());
    }
}