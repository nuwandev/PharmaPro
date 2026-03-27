package com.nuwandev.pharmapro.repository;

import com.nuwandev.pharmapro.enums.UserRole;
import com.nuwandev.pharmapro.enums.UserStatus;
import com.nuwandev.pharmapro.model.User;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Optional<User> findByUsername(String username) {
        List<User> users = jdbcTemplate.query(
                """
                        SELECT id, username, full_name, email, password_hash, role, status, created_at, updated_at
                        FROM users
                        WHERE username = ?
                        LIMIT 1
                        """,
                (rs, rowNum) -> new User(
                        rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("full_name"),
                        rs.getString("email"),
                        rs.getString("password_hash"),
                        UserRole.valueOf(rs.getString("role").trim().toUpperCase(Locale.ROOT)),
                        UserStatus.valueOf(rs.getString("status").trim().toUpperCase(Locale.ROOT)),
                        rs.getObject("created_at", OffsetDateTime.class),
                        rs.getObject("updated_at", OffsetDateTime.class)),
                username
        );

        return users.stream().findFirst();
    }
}
