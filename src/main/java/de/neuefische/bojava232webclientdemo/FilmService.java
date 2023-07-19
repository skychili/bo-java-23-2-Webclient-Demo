package de.neuefische.bojava232webclientdemo;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Objects;

@Service
public class FilmService {
private final WebClient webClient = WebClient.create("https://akabab.github.io/starwars-api/api");

    public FilmCharacter getFilmCharacter(){
    ResponseEntity<FilmCharacter> responseEntity = webClient

                .get()
                .uri("/id/3.json")
                .retrieve()
                .toEntity(FilmCharacter.class)
                .block()
                ;

        return Objects.requireNonNull(responseEntity).getBody();
    }
}
