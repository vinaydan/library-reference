package co.pragra.learning.librarymgment.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private int id;
    private String isbn;
    private String title;
    private String category;
    private Author author;
    private Date publishDate;
    private Date createDate;
}
