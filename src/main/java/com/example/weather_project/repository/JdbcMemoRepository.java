package com.example.weather_project.repository;

import com.example.weather_project.domain.Memo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcMemoRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcMemoRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Memo save(Memo memo) {
        String sql = " insert into memo values(?, ?) ";
        jdbcTemplate.update(sql, memo.getId(), memo.getText());
        return memo;
    }

    public List<Memo> findAll(){
        String sql = " select * from memo ";

        //jdbcTemplate이 mysql에 가서 위의 sql쿼리를 던지고, 반환된 결과를 resultset 형태로 가지고 있는다.
        //resultset형태의 데이터를 미리 명시한 memoRowMapper 함수를 이용해서 Memo객체로 가져왔다고 생각하면됨.
        return jdbcTemplate.query(sql, memoRowMapper());
    }

    public Optional<Memo> findById(Long id) {
        String sql = " select * from memo where id = ? ";
        return jdbcTemplate.query(sql, memoRowMapper(), id).stream().findFirst();
    }

    private RowMapper<Memo> memoRowMapper(){
        //ResultSet
        //{id = 1, text = 'this is memo'}
        return (rs, rowNum) -> new Memo(
                rs.getInt("id"),
                rs.getString("text")
        );
    }
}

