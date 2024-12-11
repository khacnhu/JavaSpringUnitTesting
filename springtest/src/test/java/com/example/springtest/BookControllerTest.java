package com.example.springtest;

import com.example.springtest.Controller.BookController;
import com.example.springtest.Entity.Book;
import com.example.springtest.repository.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.when;

public class BookControllerTest {

    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();
    private ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookController bookController;

    private Book record1 = new Book(1L, "ana", "amb", 23);
    private Book record2 = new Book(2L, "nhu", "tran", 52);
    private Book record3 = new Book(3L, "phu", "nam", 11);

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Replace initMocks with openMocks
        this.mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    public void getAllBookRecord_success() throws Exception {
        // Prepare mock data
        List<Book> records = new ArrayList<>(List.of(record1, record2, record3));

        // Stub the repository call
        when(bookRepository.findAll()).thenReturn(records);

        // Perform the GET request and assert the response
        mockMvc.perform(MockMvcRequestBuilders.get("/books")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())  // Assert that the status is 200 OK
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)) // Assert that content is JSON
                .andExpect(jsonPath("$", org.hamcrest.Matchers.hasSize(3))); // Assert the size of the returned array

    }
}
