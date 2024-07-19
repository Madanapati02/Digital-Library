package com.JDBL63.MiniProjectDigitalLibrary2.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class Author implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorId;
    @Column(nullable = false,unique = true)
    @NotBlank(message = "name cannot be empty")
    private String authorName;
    @Column(nullable = false)
    private String authorAddress;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonBackReference
    List<Book> bookList=new ArrayList<>();

}
