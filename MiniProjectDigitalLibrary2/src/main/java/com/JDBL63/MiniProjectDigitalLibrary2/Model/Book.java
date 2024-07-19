package com.JDBL63.MiniProjectDigitalLibrary2.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonGetter;
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

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;
    @Column(nullable = false)
    private String bookName;
    @Column(nullable = true)
    private String publicationYear;
    @Column(nullable = false)
    private String edition;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private String category;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "authorId")
    private Author author;
    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "issuedBook")
    @JsonBackReference
    private List<User> user=new ArrayList<>();
    @CurrentTimestamp
    private LocalDateTime insertion;
    @UpdateTimestamp
    private LocalDateTime updateTime;

}
