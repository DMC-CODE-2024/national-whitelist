package com.gl.ceir.repository.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GenericRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GenericRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String getCdrProcessingTimestamp() {
        String sql = "select max(modified_on) from cdr_file_processed_detail";
        return jdbcTemplate.queryForObject(sql, String.class);
    }
}

