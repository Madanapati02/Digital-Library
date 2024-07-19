package com.JDBL63.MiniProjectDigitalLibrary2.Model;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String userName;
    private String userMobileNum;
    private String userEmail;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="BOOK_ISSUED",
            joinColumns = @JoinColumn(name="bookId"),
            inverseJoinColumns = @JoinColumn(name="userId")
    )
    List<Book> issuedBook=new ArrayList<>();
}
