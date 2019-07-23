package com.treinamento.hibernate;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HibernateApplication.class)
public class HibernateApplicationTests {

    @Autowired
    CourseRepository courseRepository;

    @Test
    @Transactional
    public void getCourseTest() {
        Course course = courseRepository.findById(1L);
        log.info("[getCourseTest {} - {}]", "JPA course", course.getName());
        Assert.assertEquals("JPA course", course.getName());
    }

    @Test
    @Transactional
    public void saveCourseTest() {
        Course course = new Course();
        course.setName("Spring data");
        Course course1 = courseRepository.save(course);
        log.info("[saveCourseTest {} - {}]", course1.getName(), course.getName());
        Assert.assertEquals(course1.getName(), course.getName());
    }

    @Test
    @Transactional
    public void updateCourseTest() {
        Course course = courseRepository.findById(3L);
        course.setName("Spring data course 2");
        courseRepository.save(course);
        log.info("[updateCourseTest {} - {}", "Spring data course 2]", course.getName());
        Assert.assertEquals("Spring data course 2", course.getName());
    }

    @Test
    @Transactional
    public void deleteByIdCourseTest() {
        courseRepository.deleteById(1L);
        Course course = courseRepository.findById(1L);
        log.info("[deleteByIdCourseTest {} - {}]", course, null);
        Assert.assertNull(course);
    }

}
