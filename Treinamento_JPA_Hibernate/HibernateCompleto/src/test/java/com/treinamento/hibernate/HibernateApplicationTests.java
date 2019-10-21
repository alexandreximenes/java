package com.treinamento.hibernate;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.LazyInitializationException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HibernateApplication.class)
public class HibernateApplicationTests {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    PassportRepository passportRepository;
    @Autowired
    ReviewRepository reviewRepository;

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


    @Test
    @Transactional
    public void findByNameLikeNameTest() {
        List<Course> list = courseRepository.findByName();
        log.info("[findByNameLikeNameTest {}]", list);
        Assert.assertEquals(3, list.size());
    }


    @Test
    @Transactional
    public void findByNameNativeQueryTest() {
        List<Course> list = courseRepository.findByAllNativeQuery();
        log.info("[findByNameNativeQueryTest {}]", list);
        Assert.assertEquals(3, list.size());
    }

    @Test
    @Transactional
    public void findByNameNativeQueryPositionTest() {
        Course oneCourse = courseRepository.findByNameNativeQueryPosition();
        log.info("[findByNameNativeQueryPositionTest {}]", oneCourse);
        Assert.assertEquals("Hibernate course", oneCourse.getName());
    }

    @Test
    @Transactional
    public void findByNameParametter() {
        Course oneCourse = courseRepository.findByNameParametter();
        log.info("[findByNameParametter {}]", oneCourse);
        Assert.assertEquals("Hibernate course", oneCourse.getName());
    }

    @Test
    @Transactional
    public void updateNameCourse() {
        courseRepository.updateNameCourse("Hibernate2 course", 2L);
        Course course = courseRepository.findById(2L);
        log.info("[updateNameCourse {}]", course);
        Assert.assertEquals("Hibernate course", course.getName());
    }


    @Test
    @Transactional
    public void saveStudentWithPassport() {
        Passport p = new Passport();
        p.setNumber("X1");

        Student s = new Student();
        s.setName("Ximenes");
        s.setPassport(p);

        Student student = studentRepository.saveWithPassport(s);

        log.info("[saveStudentWithPassport {}]", student);
        Assert.assertEquals(s.getPassport().getId(), p.getId());
    }

    @Test(expected = LazyInitializationException.class)
    public void findStudentLazyInitialization() {
        Student student = studentRepository.findById(1L);
        Assert.assertNull(student.getPassport());
    }

    @Test
    @Transactional
    public void findStudenWithTransactionAndtLazyInitialization() {
        Student student = studentRepository.findById(1L);
        Assert.assertNotNull(student.getPassport());
    }

    @Test
    @Transactional
    public void findStudenWithPassport() {
        Student student = studentRepository.findById(1L);
        Assert.assertNotNull(student.getPassport());
    }

    @Test
    @Transactional
    public void findPassportWithStudent() {
        Passport passport = passportRepository.findById(1L);
        Assert.assertNotNull(passport.getStudent());
    }

    @Test
    @Transactional
    public void saveCourseAndReviewManyToMany() {

        List<Review> reviews = new ArrayList();
        Review review4 = new Review("4", "Review 4");
        reviews.add(review4);
        Review review5 = new Review("5", "Review 5");
        reviews.add(review5);


        List<Course> courses = new ArrayList();
        Course flutter_mobile = new Course("Flutter mobile");
        courses.add(flutter_mobile);
        Course flutter_web = new Course("Flutter web");
        courses.add(flutter_web);

        review4.addCourse(courses);
        flutter_mobile.addReview(reviews);

//        log.info("[saveStudentWithPassport {}]", student);
//        Assert.assertEquals(s.getPassport().getId(), p.getId());
    }

}
