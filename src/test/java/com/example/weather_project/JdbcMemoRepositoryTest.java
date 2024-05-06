package com.example.weather_project;

import com.example.weather_project.domain.Memo;
import com.example.weather_project.repository.JdbcMemoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
public class JdbcMemoRepositoryTest {

    @Autowired
    JdbcMemoRepository jdbcMemoRepository;

    @Test
    void insertMemoTest() {

        //given
        Memo newMemo = new Memo(1, "THIS IS NEW MEMO~!");
        //when
        jdbcMemoRepository.save(newMemo);
        //then
        Optional<Memo> result = jdbcMemoRepository.findById(1L);
        assertEquals(result.get().getText(), "THIS IS NEW MEMO~!");
    }

    @Test
    void findAllMemosTest() {
        //given
        List<Memo> memoList = jdbcMemoRepository.findAll();
        //when
        System.out.println(memoList);
        //then
        assertNotNull(memoList);
    }
}
