package com.JDBL63.MiniProjectDigitalLibrary2.UpdateDto;

import com.JDBL63.MiniProjectDigitalLibrary2.Model.Author;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder

public class RangeDataDto {
    public Integer dataSize;
    public List<Author> data;
}
