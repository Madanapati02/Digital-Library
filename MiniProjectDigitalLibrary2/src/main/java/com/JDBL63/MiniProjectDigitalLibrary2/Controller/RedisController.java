package com.JDBL63.MiniProjectDigitalLibrary2.Controller;

import com.JDBL63.MiniProjectDigitalLibrary2.Model.Author;
import com.JDBL63.MiniProjectDigitalLibrary2.Service.RedisService;
import com.JDBL63.MiniProjectDigitalLibrary2.UpdateDto.RangeDataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "V1/redis",produces = MediaType.APPLICATION_JSON_VALUE)

public class RedisController {
    @Autowired
    private RedisService redisService;
    @PostMapping
    public void addNewAuthor(@RequestBody Author author)
    {
        redisService.addNewAuthor(author);
    }
    @GetMapping("/{authorId}")
    public Author getData(@PathVariable("authorId") Integer authorId)
    {
        return redisService.getData(authorId);
    }

    @GetMapping("/delete/{authorId}")
    public Author getAndDeleteData(@PathVariable("authorId") Integer authorId)
    {
        return redisService.getAndDeleteData(authorId);
    }
    //List
    @PostMapping("/L")
    public void addNewAuthorList(@RequestBody Author author)
    {
        redisService.addNewAuthorList(author);
    }
    @GetMapping("/list/{start}/{end}")
    public RangeDataDto getDataByRange(@PathVariable("start") int start, @PathVariable("end") int end)
    {
        return redisService.getDataByRange(start,end);
    }
    @PostMapping("/set")
    public void addNewAuthorToSet(@RequestBody Author author)
    {
        redisService.addNewAuthorToSet(author);
    }

    @GetMapping("/set/{count}")
    public List<Author> getRandomNumbers(@PathVariable("count") int count)
    {
        return redisService.getRandomNumber(count);
    }
    @PostMapping("/hash")
    public void addNewDataForHash(@RequestBody Author author)
    {
        redisService.addNewDataForHash(author);
    }

}
