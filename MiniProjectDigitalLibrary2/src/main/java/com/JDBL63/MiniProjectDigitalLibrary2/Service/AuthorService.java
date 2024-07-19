package com.JDBL63.MiniProjectDigitalLibrary2.Service;

import com.JDBL63.MiniProjectDigitalLibrary2.Exception.BadRequestExceptuion;
import com.JDBL63.MiniProjectDigitalLibrary2.Model.Author;
import com.JDBL63.MiniProjectDigitalLibrary2.Repository.AuthorRepository;
import com.JDBL63.MiniProjectDigitalLibrary2.UpdateDto.UpdateDto;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j

public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public Author addNewAuthor(Author author) throws Exception {
        return authorRepository.save(author);
    }

    public Author updateAuthorAddress(UpdateDto authorDTO) {
        try {
            Author author = authorRepository.findById(authorDTO.getAuthorId()).get();
            author.setAuthorAddress(authorDTO.getAuthorAddress());
            return authorRepository.save(author);
        }
        catch(Exception e){
            log.error("error occurred at exception time:",e.getMessage());
            throw new BadRequestExceptuion("error occurred"+e.getMessage());

        }

    }

    public List<Author> fetchAllData() {
        return authorRepository.findAll();
    }

    public Author fetchById(String authorName) {
        return authorRepository.findByAuthorName(authorName);
    }

    public void uploadingAuthorDetails(String fileContent) {
        List<String> authorsData=List.of(fileContent.split("\n"));
        List<Author> authors=new ArrayList<>();
        for(int i=1;i<authorsData.size();i++)
        {
            String[] row=authorsData.get(i).split(",");
            authors.add(Author.builder()
                    .authorId(Integer.valueOf(row[0]))
                    .authorAddress(row[1])
                    .authorName(row[2])
                    .build());
        }
        authorRepository.saveAll(authors);
    }
}
