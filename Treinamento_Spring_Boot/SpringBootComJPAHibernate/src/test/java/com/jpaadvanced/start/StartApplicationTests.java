package com.jpaadvanced.start;

import com.jpaadvanced.start.entity.Course;
import com.jpaadvanced.start.repository.CourseRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StartApplicationTests {

    @Autowired
    CourseRepository repository;
    @Test
    @DirtiesContext
    public void contextLoads() {
        repository.remove(2L);
        repository.saveOrUpdate(new Course(5L, "Docker", LocalDateTime.now(), LocalDateTime.now(), null, null));
        assertEquals(repository.findAll().size(), repository.findAll().size());
    }

}

