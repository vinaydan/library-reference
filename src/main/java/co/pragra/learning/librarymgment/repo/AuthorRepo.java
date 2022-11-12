//package co.pragra.learning.librarymgment.repo;
//
//import co.pragra.learning.librarymgment.entity.Author;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.jdbc.core.namedparam.SqlParameterSource;
//import org.springframework.stereotype.Repository;
//
//import java.util.Collections;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//@Repository
//@Slf4j
//public class AuthorRepo implements Repo<Author> {
//// Transaction management
//    // Caching
//
//    protected NamedParameterJdbcTemplate template;
//    public AuthorRepo(NamedParameterJdbcTemplate template) {
//        this.template = template;
//    }
//    @Override
//    public Author create(Author author) {
//        String sql =  "INSERT INTO AUTHOR VALUES( :id,:name)";
//        author.setId(getNextId());
//        int update = template.update(sql, new BeanPropertySqlParameterSource(author));
//        if(update == 1) {
//            log.debug("Author - [{}] has been inserted successfully in database ", author);
//            return author;
//        } else {
//            log.error("Couldn't insert record for author");
//            return null;
//        }
//    }
//
//    @Override
//    public List<Author> getAll(Map<String, Object> params) {
//        String sql =  "SELECT * FROM AUTHOR";
//        return template.query(sql, new AuthorMapper());
//    }
//
//    @Override
//    public Optional<Author> getById(int id) {
//        String sql =  "SELECT * FROM AUTHOR WHERE ID = :id ";
//        try {
//            return Optional.of(getId(id, sql));
//        } catch (EmptyResultDataAccessException e) {
//            return null;
//        }
//    }
//
//
//
//    @Override
//    public Author update(Author author) {
//        String sql =  "UPDATE AUTHOR SET NAME = :name WHERE ID = :id";
//        int update = template.update(sql, new BeanPropertySqlParameterSource(author));
//        if(update == 1) {
//            log.debug("Author - [{}] has been updated successfully in database ", author);
//            return author;
//        } else {
//            log.error("Couldn't update record for author");
//            return null;
//        }
//    }
//
//    @Override
//    public Author deleteById(int id) {
//        String sql =  "SELECT * FROM AUTHOR WHERE ID = :id ";
//        Author author;
//        try {
//            author = getId(id, sql);
//            String sqld =  "DELETE FROM AUTHOR WHERE ID = :id ";
//            int update = template.update(sqld, Collections.singletonMap("id",id));
//            if (update == 1) {
//                log.debug("Author - [{}] has been deleted successfully from database", author);
//                return author;
//            } else {
//                log.error("Couldn't delete record for author");
//                return null;
//            }
//        } catch (EmptyResultDataAccessException e) {
//            return null;
//        }
//    }
//
//    public int getNextId() {
//        return template.queryForObject("select next value for AUTHORSEQ", Collections.emptyMap() ,Integer.class);
//    }
//
//    private Author getId(int id, String sql) {
//        return template.queryForObject(sql, Collections.singletonMap("id", id), new AuthorMapper());
//    }
//}
