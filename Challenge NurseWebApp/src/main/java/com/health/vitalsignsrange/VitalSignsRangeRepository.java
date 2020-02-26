package com.health.vitalsignsrange;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

@Repository
public class VitalSignsRangeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<VitalSignsRange> findByFilters(int age, String gender) {

        String sql = "SELECT * FROM vitalsigns_range WHERE min_age >= ? and max_age <= ? and gender = ? ";
        Object[] params = new Object[]{age, age, gender};

        return jdbcTemplate.query(sql, params, new VitalSignsRangeRowMapper());

    }

}
