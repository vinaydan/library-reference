package co.pragra.learning.librarymgment.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(unique = true)
    private String isbn;
    @Column(nullable = false)
    private String title;
    @Column(name = "BOOK_CATEGORY")
    private String category;
    @OneToOne(cascade = CascadeType.ALL)
    private Author author;
    private Date publishDate;
    private Date createDate;

    @OneToMany
    private List<Review> reviews;
}

