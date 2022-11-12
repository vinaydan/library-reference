//package co.pragra.learning.librarymgment.repo;
//
//import co.pragra.learning.librarymgment.entity.Author;
//import org.springframework.jdbc.core.RowMapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class AuthorMapper implements RowMapper<Author> {
//    @Override
//    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
//        return  Author.builder().id(rs.getInt("id")).publishedName(rs.getString("name")).build();
//    }
//}
