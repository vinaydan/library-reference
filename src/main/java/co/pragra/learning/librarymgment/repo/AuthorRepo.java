package co.pragra.learning.librarymgment.repo;

import co.pragra.learning.librarymgment.entity.Author;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@Slf4j
public class AuthorRepo implements Repo<Author> {

    private JdbcTemplate template;

    public AuthorRepo(JdbcTemplate template) {
        this.template = template;
    }
    @Override
    public Author create(Author author) {
        String sql =  "INSERT INTO AUTHOR VALUES( ?,?)";
        author.setId(getNextId());
        int update = template.update(sql,
                author.getId(),
                author.getName()
        );
        if(update == 1) {
            log.debug("Author - [{}] has been inserted successfully in database ", author);
            return author;
        } else {
            log.error("Couldn't insert record for author");
            return null;
        }
    }

    @Override
    public List<Author> getAll(Map<String, Object> params) {
        String sql =  "SELECT * FROM AUTHOR";
        return template.query(sql, new BeanPropertyRowMapper<>(Author.class));
    }

    @Override
    public Optional<Author> getById(int id) {
        String sql =  "SELECT * FROM AUTHOR WHERE ID = ? ";
        try {
            return Optional.of(template.queryForObject(sql, new BeanPropertyRowMapper<>(Author.class), id));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Author update(Author author) {
        String sql =  "UPDATE AUTHOR SET NAME = ? WHERE ID = ?";
        int update = template.update(sql,
                author.getName(),
                author.getId()
        );
        if(update == 1) {
            log.debug("Author - [{}] has been updated successfully in database ", author);
            return author;
        } else {
            log.error("Couldn't update record for author");
            return null;
        }
    }

    @Override
    public Author deleteById(int id) {
        String sql =  "SELECT * FROM AUTHOR WHERE ID = ? ";
        Author author;
        try {
            author = template.queryForObject(sql, new BeanPropertyRowMapper<>(Author.class), id);
            String sqld =  "DELETE FROM AUTHOR WHERE ID = ? ";
            int update = template.update(sqld, id);
            if (update == 1) {
                log.debug("Author - [{}] has been deleted successfully from database", author);
                return author;
            } else {
                log.error("Couldn't delete record for author");
                return null;
            }
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public int getNextId() {
        return template.queryForObject("select next value for AUTHORSEQ", Integer.class);
    }
}
