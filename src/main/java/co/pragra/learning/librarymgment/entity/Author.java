package co.pragra.learning.librarymgment.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Author {
    private int id;
    private String name;
}

