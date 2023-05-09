package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class TrelloMapperTests {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    public void mapToBoardsTest() {
        // Given
        List<TrelloListDto> trelloListDto = Arrays.asList(
                new TrelloListDto("1", "TrelloListDto 1", true)
        );
        List<TrelloBoardDto> trelloBoardDtoList = Arrays.asList(
                new TrelloBoardDto("1", "BoardDto 1", trelloListDto)
        );
        // When
        List<TrelloBoard> resultList = trelloMapper.mapToBoards(trelloBoardDtoList);
        // Then
        assertEquals("1", resultList.get(0).getId());
        assertEquals("BoardDto 1", resultList.get(0).getName());
        assertEquals(1, resultList.get(0).getLists().size());
        assertEquals("TrelloListDto 1", resultList.get(0).getLists().get(0).getName());
    }

    @Test
    public void mapToBoardsDtoTest() {
        // Given
        List<TrelloList> trelloLists = Arrays.asList(
                new TrelloList("1", "TrelloList 1", true)
        );
        List<TrelloBoard> trelloBoardsList = Arrays.asList(
                new TrelloBoard("1", "TrelloBoard 1", trelloLists)
        );
        // When
        List<TrelloBoardDto> resultList = trelloMapper.mapToBoardsDto(trelloBoardsList);
        // Then
        assertEquals("1", resultList.get(0).getId());
        assertEquals("TrelloBoard 1", resultList.get(0).getName());
        assertEquals(1, resultList.get(0).getLists().size());
        assertEquals("TrelloList 1", resultList.get(0).getLists().get(0).getName());

    }

    @Test
    public void mapToTrelloListTest() {
        // Given
        List<TrelloListDto> trelloListDto = Arrays.asList(
                new TrelloListDto("1", "TrelloListDto 1", true)
        );
        // When
        List<TrelloList> resultList = trelloMapper.mapToList(trelloListDto);
        // Then
        assertEquals("1", resultList.get(0).getId());
        assertEquals("TrelloListDto 1", resultList.get(0).getName());
        assertEquals(true, resultList.get(0).isClosed());
        assertEquals(1, resultList.size());
    }

    @Test
    public void mapToTrelloListDtoTest() {
        // Given
        List<TrelloList> trelloLists = Arrays.asList(
                new TrelloList("1", "TrelloList 1", true)
        );
        // When
        List<TrelloListDto> resultList = trelloMapper.mapToListDto(trelloLists);
        // Then
        assertEquals("1", resultList.get(0).getId());
        assertEquals("TrelloList 1", resultList.get(0).getName());
        assertEquals(true, resultList.get(0).isClosed());
        assertEquals(1, resultList.size());
    }

    @Test
    public void mapToCardDtoTest() {
        // Given
        TrelloCard trelloCard = new TrelloCard("TrelloCard", "Some card in trello", "Top", "1");
        // When
        TrelloCardDto resultCardDto = trelloMapper.mapToCardDto(trelloCard);
        // Then
        assertEquals("TrelloCard", resultCardDto.getName());
        assertEquals("Some card in trello", resultCardDto.getDescription());
        assertEquals("Top", resultCardDto.getPos());
        assertEquals("1", resultCardDto.getListId());
    }

    @Test
    public void mapToCardTest() {
        // Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("TrelloCard", "Some card in trello", "Top", "1");
        // When
        TrelloCard resultCard = trelloMapper.mapToCard(trelloCardDto);
        // Then
        assertEquals("TrelloCard", resultCard.getName());
        assertEquals("Some card in trello", resultCard.getDescription());
        assertEquals("Top", resultCard.getPos());
        assertEquals("1", resultCard.getListId());
    }
}
