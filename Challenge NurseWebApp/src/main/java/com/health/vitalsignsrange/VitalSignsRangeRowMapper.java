package com.health.vitalsignsrange;


import com.health.vitalsigns.VitalSignsHistory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VitalSignsRangeRowMapper implements RowMapper<VitalSignsRange> {

    @Override
    public VitalSignsRange mapRow(ResultSet rs, int rowNum) throws SQLException {

        VitalSignsRange vitalSignsRange= new VitalSignsRange();
        vitalSignsRange.setId(rs.getInt("id"));
        vitalSignsRange.setPatientID(rs.getInt("id_patient"));
        vitalSignsRange.setBpMax(rs.getString("bp_max"));
        vitalSignsRange.setBpMin(rs.getString("bp_min"));
        vitalSignsRange.setHrMax(rs.getString("hr_max"));
        vitalSignsRange.setHrMin(rs.getString("hr_min"));
        vitalSignsRange.setMinAge(rs.getInt("min_age"));
        vitalSignsRange.setMaxAge(rs.getInt("max_age"));
        vitalSignsRange.setGender(rs.getString("gender"));

        return vitalSignsRange;
    }
}
