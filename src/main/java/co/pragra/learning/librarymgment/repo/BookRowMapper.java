//package co.pragra.learning.librarymgment.repo;
//
//import co.pragra.learning.librarymgment.entity.Author;
//import co.pragra.learning.librarymgment.entity.Book;
//import org.springframework.jdbc.core.RowMapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class BookRowMapper implements RowMapper<Book> {
//
//    @Override
//    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//        // BeanPropertyRowMapper cannot properly map ID of book and author.
//        // Author author = (new BeanPropertyRowMapper<>(Author.class)).mapRow(rs, rowNum);
//        // Book book = (new BeanPropertyRowMapper<>(Book.class)).mapRow(rs, rowNum);
//
//        Author author = new Author();
//        Book book = new Book();
//        author.setId(rs.getInt("AUTHOR.ID"));
//        author.setPublishedName(rs.getString("AUTHOR.NAME"));
//        book.setId(rs.getInt("BOOK.ID"));
//        book.setTitle(rs.getString("BOOK.TITLE"));
//        book.setIsbn(rs.getString("BOOK.ISBN"));
//        book.setCategory(rs.getString("BOOK.CATEGORY"));
//        book.setCreateDate(rs.getDate("BOOK.CREATEDATE"));
//        book.setPublishDate(rs.getDate("BOOK.PUBLISHDATE"));
//        book.setAuthor(author);
//        return book;
//    }
//}
