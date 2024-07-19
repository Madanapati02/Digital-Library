package com.JDBL63.MiniProjectDigitalLibrary2;

import com.JDBL63.MiniProjectDigitalLibrary2.Model.Author;
import com.JDBL63.MiniProjectDigitalLibrary2.Repository.AuthorRepository;
import com.JDBL63.MiniProjectDigitalLibrary2.Service.AuthorService;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class AuthorServiceTest {
    @InjectMocks
    private AuthorService authorService;
    @Mock
    private AuthorRepository authorRepository;
    @Before("")
    public void setUp()
    {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testAddNewAuthor() throws Exception {
        Author author = Author.builder().authorId(1111).authorName("pranav").authorAddress("nashik").build();
        when(authorRepository.save(any())).thenReturn(author);
        Author a = authorService.addNewAuthor(author);
        Assertions.assertThat(a).isEqualTo(author);
    }
    @Test
    public void testUploadAuthorsDataToDatabase() {
        String fileContent = "authorId, authorName, authorAddress\n" +
                "11, ABC, Kolkata\n" +
                "12, PQR, Jaipur\n" +
                "13, Rahul, Raipur\n" +
                "14, Divya, Nagpur";
        authorService.uploadingAuthorDetails(fileContent);
        verify(authorRepository, times(1)).saveAll(any());
    }

}
