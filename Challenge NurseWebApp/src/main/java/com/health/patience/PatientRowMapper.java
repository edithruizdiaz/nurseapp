package com.health.patience;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientRowMapper implements RowMapper<Patient> {

    @Override
    public Patient mapRow(ResultSet rs, int rowNum) throws SQLException {

        Patient patient=new Patient();
        patient.setId(rs.getInt("id"));
        patient.setFirstName(rs.getString("first_name"));
        patient.setLastName(rs.getString("last_name"));
        patient.setAge(rs.getInt("age"));
        patient.setGender(rs.getString("gender"));
        patient.setBpMax(rs.getString("bp_max"));
        patient.setBpMin(rs.getString("bp_min"));
        patient.setHrMax(rs.getString("hr_max"));
        patient.setHrMin(rs.getString("hr_min"));

        return patient;

    }
}
