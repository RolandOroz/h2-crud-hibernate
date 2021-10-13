package com.roland.oroz.h2crud.model;

import lombok.*;

import javax.persistence.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "newstitle")
    private String newstitle;
    @Column(name = "fpost")
    private String fpost;
    @Column(name = "cdate")
    private LocalDate cdate;



    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", newstitle='" + newstitle + '\'' +
                ", fpost='" + fpost + '\'' +
                ", cdate=" + cdate +
                '}';
    }
}
