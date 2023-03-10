package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrelloDto {


    @JsonProperty("board")
    private int board;

    @JsonProperty("card")
    private int card;

}
