package com.test.myapp2.jdbc.employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.test.myapp2.jdbc.model.Employee;
@Repository
public class EmployeeJDBCRepository {
    //DAO(Data Access Object) -> CRUD
    //@Repository
    @Autowired
    JdbcTemplate jdbcTemplate;
    class EmployeeRowMapper implements RowMapper<Employee> {

        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setId(rs.getLong("id"));
            employee.setFirstName(rs.getString("first_name"));
            employee.setLastName(rs.getString("last_name"));
            employee.setEmailId(rs.getString("email_address"));
            return employee;
        }
    }
    public List<Employee> findAll() {
         return jdbcTemplate.query("select * from employees", new EmployeeRowMapper());

    }

}
