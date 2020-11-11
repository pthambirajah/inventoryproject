package fi.haagahelia.inventoryproject.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//In this repository you can see all the SQL queries that are sent to the DB
@Repository
public class UserRepoImpl implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User findByUsername(String username) {
        String sql = "select id, username, password, role from users where username = ? LIMIT 1";
        Object[] parameters = new Object[] { username };
        RowMapper<User> mapper = new UserRowMapper();

        User user = jdbcTemplate.queryForObject(sql, parameters, mapper);
        return user;
    }

    //Add a product to the db
    public void save(User user) {
        String sql = "insert into users(username, password, role) values(?,?,?)";
        Object[] parameters = new Object[]{user.getUsername(), user.getPasswordHash(),
                user.getRole()};
        jdbcTemplate.update(sql, parameters);

    }

}
