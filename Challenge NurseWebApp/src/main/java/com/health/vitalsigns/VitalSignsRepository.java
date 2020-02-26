package com.health.vitalsigns;


import com.health.patience.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

@Repository
public class VitalSignsRepository {
    //    id serial NOT NULL,
//    id_patient int4 NULL,
//    registered_date varchar NULL,
//    bp_min varchar NULL,
//    bp_max varchar NULL,
//    hr_min varchar NULL,
//    hr_max varchar NULL,
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save(VitalSignsHistory vsh) {
        return jdbcTemplate.update(
                "insert into vitalsigns_history (id_patient,registered_date,bp_min,bp_max,hr_min,hr_max) values(?,?,?,?,?,?)",
                vsh.getPatientID(),vsh.getRegisteredDate(),vsh.getBpMin(), vsh.getBpMax(), vsh.getHrMin(), vsh.getHrMax());
    }

    public int update(VitalSignsHistory vsh) {
        return jdbcTemplate.update(
                "update from vitalsigns_history set registered_date = ?, bp_min = ?, bp_max = ?, hr_min = ?, hr_max = ? where id_patient = ? ",
                vsh.getRegisteredDate(),vsh.getBpMin(), vsh.getBpMax(), vsh.getHrMin(), vsh.getHrMax(), vsh.getPatientID());

    }

    public VitalSignsHistory findById(Long id) {

        String sql = "SELECT * FROM vitalsigns_history WHERE ID = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new VitalSignsHistoryRowMapper());

    }

    public List<VitalSignsHistory> findByPatientId(Long id) {

        String sql = "SELECT * FROM vitalsigns_history WHERE id_patient = ?";

        return jdbcTemplate.query(sql, new Object[]{id}, new VitalSignsHistoryRowMapper());

    }

    public List<VitalSignsHistory> findByFilters(Long idPatient, Date dateFrom, Date dateTo) {

        String sql = "SELECT * FROM vitalsigns_history WHERE id_patient = ? ";
        Object[] params = new Object[]{idPatient};
        int N = params.length;
        if(dateFrom != null && dateTo != null ){
            sql += " and  registered_date between ? and ? ";
            params = Arrays.copyOf(params, N + 1);
            params[N] = dateFrom;

            N = params.length;
            params = Arrays.copyOf(params, N + 1);
            params[N] = dateTo;

        }else if(dateFrom != null){
            sql += " and  registered_date >= ? ";

            params = Arrays.copyOf(params, N + 1);
            params[N] = dateFrom;
        }else if(dateTo != null){
            sql += " and  registered_date <= ? ";
            params = Arrays.copyOf(params, N + 1);
            params[N] = dateTo;
        }

        return jdbcTemplate.query(sql, params, new VitalSignsHistoryRowMapper());

    }

    public List<VitalSignsHistory> findAll() {

        String sql = "SELECT * FROM vitalsigns_history";

        List<VitalSignsHistory> vitalsigns = jdbcTemplate.query(
                sql,
                new VitalSignsHistoryRowMapper());

        return vitalsigns;
    }

    public int deleteById(Long id) {
        return jdbcTemplate.update(
                "delete vitalsigns_history where id = ?",
                id);
    }


}
