package com.JDBL63.MiniProjectDigitalLibrary2.Service;

import com.JDBL63.MiniProjectDigitalLibrary2.Model.Author;
import com.JDBL63.MiniProjectDigitalLibrary2.UpdateDto.RangeDataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;


@Service
public class RedisService {
    @Autowired
    private RedisTemplate redisTemplate;
    private final String key="AUTHOR::";
    public void addNewAuthor(Author author) {
        redisTemplate.opsForValue().set(key+author.getAuthorId(),author);
    }

    public Author getData(Integer authorId) {
        return (Author) redisTemplate.opsForValue().get(key+authorId);
    }

    public void addNewAuthorList(Author author) {
        redisTemplate.opsForList().leftPush(key+"List",author);
    }


    public RangeDataDto getDataByRange(int start, int end) {
        List<Author> range= redisTemplate.opsForList().range(key+"List",start,end);
        return RangeDataDto.builder().dataSize(range.size()).data(range).build();
    }

    public void addNewAuthorToSet(Author author) {
        Random random=new Random();
        author.setAuthorId(random.nextInt(1000));
        redisTemplate.opsForSet().add(key+"set",author);
    }

    public Author getAndDeleteData(Integer authorId) {
        return (Author) redisTemplate.opsForValue().getAndDelete(key+authorId);
    }

    public List<Author> getRandomNumber(int count) {
        return redisTemplate.opsForSet().randomMembers(key+"set",count);
    }

    public void addNewDataForHash(Author author) {
        redisTemplate.opsForHash().put(key+"hash",author.getAuthorId(),author);
        Map<Integer,Author> entries=redisTemplate.opsForHash().entries(key+"hash");
        Set<Map.Entry<Integer,Author>> set=entries.entrySet();
        for(Map.Entry<Integer,Author> o:set)
        {
            System.out.println(o.getKey()+"\t"+o.getValue());
        }

    }
}
