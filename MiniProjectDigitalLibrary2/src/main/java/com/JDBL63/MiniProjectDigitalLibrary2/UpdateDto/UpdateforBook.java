package com.JDBL63.MiniProjectDigitalLibrary2.UpdateDto;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class UpdateforBook {
    private Integer bookId;
    private String bookName;
}
