package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskMapperTests {

    @Autowired
    private TaskMapper taskMapper;

    @Test
    public void mapToTaskTest() {
        // Given
        TaskDto taskDto = new TaskDto(1L, "Test", "Testing the task");
        // When
        Task resultTask = taskMapper.mapToTask(taskDto);
        // Then
        assertEquals(1L, resultTask.getId());
        assertEquals("Test", resultTask.getTitle());
        assertEquals("Testing the task", resultTask.getContent());
    }

    @Test
    public void mapToTaskDtoTest() {
        // Given
        Task task = new Task(1L, "Test", "Testing the task");
        // When
        TaskDto resultTaskDto = taskMapper.mapToTaskDto(task);
        // Then
        assertEquals(1L, resultTaskDto.getId());
        assertEquals("Test", resultTaskDto.getTitle());
        assertEquals("Testing the task", resultTaskDto.getContent());
    }

    @Test
    public void mapToTaskDtoListTest() {
        // Given
        List<Task> taskList = Arrays.asList(
                new Task(1L, "Test", "Testing the task")
        );
        // When
        List<TaskDto> resultList = taskMapper.mapToTaskDtoList(taskList);
        // Then
        assertEquals(1L, resultList.get(0).getId());
        assertEquals("Test", resultList.get(0).getTitle());
        assertEquals("Testing the task", resultList.get(0).getContent());
    }
}
