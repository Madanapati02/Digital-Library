package com.JDBL63.MiniProjectDigitalLibrary2.UpdateDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class UpdateForUser {
    private Integer userId;
    private String userName;
    private String userMobileNum;
}
