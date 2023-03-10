package com.crud.tasks.trello.client;

import com.crud.tasks.domain.TrelloBoardDto;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.*;

@Component
@RequiredArgsConstructor
public class TrelloClient {

    private final RestTemplate restTemplate;


    @org.springframework.beans.factory.annotation.Value("${trello.api.endpoint.prod}")
    private String trelloApiEndpoint;
    @org.springframework.beans.factory.annotation.Value("${trello.app.key}")
    private String trelloAppKey;
    @org.springframework.beans.factory.annotation.Value("${trello.app.token}")
    private String trelloToken;

    @org.springframework.beans.factory.annotation.Value("${trello.app.username}")
    private String username;

    private URI urlBuild(){
        URI url = UriComponentsBuilder.fromHttpUrl(trelloApiEndpoint + "/members/martynawojtyla/boards")
                .queryParam("key", trelloAppKey)
                .queryParam("token", trelloToken)
                .queryParam("username", username)
                .queryParam("fields", "name,id")
                .build().encode().toUri();

        return url;
    }
    public List<TrelloBoardDto> getTrelloBoards() {
        TrelloBoardDto[] boardsResponse = restTemplate.getForObject(urlBuild(), TrelloBoardDto[].class);


        return Optional.ofNullable(boardsResponse)
                .map(Arrays::asList)
                .orElse(Collections.emptyList());
    }

}
