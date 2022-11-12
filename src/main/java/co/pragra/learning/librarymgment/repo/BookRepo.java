//package co.pragra.learning.librarymgment.repo;
//
//import co.pragra.learning.librarymgment.entity.Book;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//@Repository
//@Slf4j
//public class BookRepo implements Repo<Book> {
//
//    private JdbcTemplate template;
//    private final String sqlBookJoinAuthor = "SELECT BOOK.ID, BOOK.TITLE, BOOK.ISBN, \n" +
//            "BOOK.CATEGORY, BOOK.CREATEDATE, BOOK.PUBLISHDATE, \n" +
//            "AUTHOR.ID, AUTHOR.NAME \n" +
//            "FROM BOOK \n" +
//            "JOIN AUTHOR ON BOOK.AUTHORID = AUTHOR.ID \n";
//
//    public BookRepo(JdbcTemplate template) {
//        this.template = template;
//    }
//
//    public void createSchema(){
//        try {
//            template.execute("DROP TABLE IF EXISTS BOOK;");
//            template.execute("DROP TABLE IF EXISTS AUTHOR;");
//            template.execute("DROP SEQUENCE IF EXISTS BOOKSEQ;");
//            template.execute("DROP SEQUENCE IF EXISTS AUTHORSEQ;");
//            template.execute("CREATE TABLE AUTHOR (ID INTEGER NOT NULL, NAME VARCHAR(100), CONSTRAINT AUTHOR_PK PRIMARY KEY (ID));");
//            template.execute("CREATE TABLE BOOK (ID INTEGER NOT NULL, ISBN VARCHAR(30) UNIQUE, TITLE VARCHAR(100), CATEGORY VARCHAR(30), PUBLISHDATE DATE, CREATEDATE DATE, AUTHORID INTEGER, CONSTRAINT BOOK_PK PRIMARY KEY (ID), CONSTRAINT BOOK_FK FOREIGN KEY (AUTHORID) REFERENCES AUTHOR(ID));");
//            template.execute("CREATE SEQUENCE BOOKSEQ;");
//            template.execute("CREATE SEQUENCE AUTHORSEQ;");
//        } catch (Exception ex) {
//            log.error(ex.getMessage());
//        }
//    }
//
//    @Override
//    public Book create(Book book) {
//        String sql =  "INSERT INTO BOOK VALUES( ?, ?, ?, ?,?,?,?)";
//        book.setId(getNextId());
//        int update = template.update(sql,
//                book.getId(),
//                book.getIsbn(),
//                book.getTitle(),
//                book.getCategory(),
//                book.getAuthor().getId(),
//                book.getPublishDate(),
//                book.getCreateDate()
//        );
//        if(update == 1) {
//            log.debug("Book - [{}] has been inserted successfully in database ", book);
//        }else {
//            log.error("Couldn't insert record for book");
//        }
//        // Query from database and return it.
//        return book;
//    }
//
//    @Override
//    public List<Book> getAll(Map<String, Object> params) {
//        String sql = sqlBookJoinAuthor;
//        return template.query(sql, new BookRowMapper());
//    }
//
//    @Override
//    public Optional<Book> getById(int id) {
//        String sql = sqlBookJoinAuthor + "WHERE BOOK.ID = ? ";
//        try {
//            return Optional.of(template.queryForObject(sql, new BookRowMapper(), id));
//        } catch (EmptyResultDataAccessException e) {
//            return null;
//        }
//    }
//
//    @Override
//    public Book update(Book book) {
//        String sql = "UPDATE BOOK SET TITLE=?, CATEGORY=? WHERE ID=?";
//        int update = template.update(sql
//                , new Object[] {book.getTitle(), book.getCategory(),book.getId()});
//        System.out.println("update:"+ update);
//        if (update==1){
//            log.debug("Book - [{}] has been updated successfully", book);
//            return book;
//        }else {
//            log.error("Book could not be updated");
//            return null;
//        }
//    }
//
//    @Override
//    public Book deleteById(int id) {
//        String sql = sqlBookJoinAuthor + "WHERE BOOK.ID = ? ";
//        Book book;
//        try {
//            book = template.queryForObject(sql, new BookRowMapper(), id);
//            String sqld =  "DELETE FROM BOOK WHERE ID = ? ";
//            int update = template.update(sqld, id);
//            if (update == 1) {
//                log.debug("Book - [{}] has been deleted successfully from database", book);
//                return book;
//            } else {
//                log.error("Couldn't delete record for book");
//                return null;
//            }
//        } catch (EmptyResultDataAccessException e) {
//            return null;
//        }
//    }
//
//    public Optional<Book> getByIsbn(String isbn) {
//        String sql = sqlBookJoinAuthor + "WHERE BOOK.ISBN = ?";
//        try {
//            return Optional.of(template.queryForObject(sql, new BookRowMapper(), isbn));
//        } catch (EmptyResultDataAccessException e) {
//            return null;
//        }
//    }
//
//    public int getNextId() {
//       return template.queryForObject("select next value for BOOKSEQ", Integer.class);
//    }
//}
//
//// /api/book