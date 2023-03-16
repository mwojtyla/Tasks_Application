package com.crud.tasks.config;

import com.crud.tasks.trello.client.TrelloClient;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class TrelloConfig {

    @Value("${trello.api.endpoint.prod}")
    private String trelloApiEndpoint;
    @Value("${trello.app.key}")
    private String trelloAppKey;
    @org.springframework.beans.factory.annotation.Value("${trello.app.token}")
    private String trelloToken;

    @org.springframework.beans.factory.annotation.Value("${trello.app.user}")
    private String trelloUser;


}
