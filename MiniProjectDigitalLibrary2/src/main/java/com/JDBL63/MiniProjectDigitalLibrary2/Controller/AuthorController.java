package com.JDBL63.MiniProjectDigitalLibrary2.Controller;

import com.JDBL63.MiniProjectDigitalLibrary2.Exception.BadRequestExceptuion;
import com.JDBL63.MiniProjectDigitalLibrary2.Model.Author;
import com.JDBL63.MiniProjectDigitalLibrary2.Service.AuthorService;
import com.JDBL63.MiniProjectDigitalLibrary2.UpdateDto.UpdateDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "V1/authors",produces = MediaType.APPLICATION_JSON_VALUE)
@Validated

public class AuthorController {
    @Autowired
    private AuthorService authorService;
    @PostMapping()
    public ResponseEntity<Author> addNewAuthor(@RequestBody @Valid Author author)
    {
        try{
        if(author!=null)
        {
            Author author1=authorService.addNewAuthor(author);
            if(author1!=null)
            {
                return new ResponseEntity<>(author1, HttpStatus.CREATED);
            }
        }
        }catch (Exception e)
        {
            throw new BadRequestExceptuion(e.getMessage());
        }
        return null;
    }
    @PutMapping()
    @CachePut(value="authors",key="#authorsAddress")
    public Author updateAuthorAddress(@RequestBody @Valid UpdateDto authorDTO)
    {
        return authorService.updateAuthorAddress(authorDTO);
    }
    @GetMapping("/j")
    @Cacheable(value="authors",key="#authors")
    public List<Author> fetchAllData()
    {
        return authorService.fetchAllData();
    }
    @GetMapping("/iii")
    public Author fetchById(@RequestParam("authorName") String authorName)
    {
        if(!isBlank(authorName))
         return authorService.fetchById(authorName);
        throw new BadRequestExceptuion("please enter author name");
    }
    boolean isBlank(String string)
    {
        return string== null || string.isBlank();
    }
    @PostMapping("/update-csv")
    public void uploadingAuthorDetails(@RequestPart("file") MultipartFile multipartFile) throws IOException {
        String fileContent=new String(multipartFile.getBytes());
        authorService.uploadingAuthorDetails(fileContent);
    }
}
