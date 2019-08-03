package com.treinamento.hibernate;

import org.springframework.stereotype.Service;

@Service
public class InitData {

    Student s = new Student();
    Passport p = new Passport();
    Course c1 = new Course();
    Review rv = new Review();

    public InitData() {
    }

    public void startStudent(StudentRepository sr) {
        s = new Student();
        s.setName("Alexandre");
        sr.save(s);

        s = new Student();
        s.setName("Tiago");
        sr.save(s);

        s = new Student();
        s.setName("Dayane");
        sr.save(s);
    }

    public void startStudentOneToOnePassport(StudentRepository sr, PassportRepository pr) {

        p = new Passport();
        p.setNumber("X1");
        pr.save(p);

        s = new Student();
        s.setName("Ximenes");
        s.setPassport(p);
        sr.save(s);



    }

    public void startPassport(PassportRepository pr) {
        p = new Passport();
        p.setNumber("A1");
        pr.save(p);

        p = new Passport();
        p.setNumber("T1");
        pr.save(p);

        p = new Passport();
        p.setNumber("D1");
        pr.save(p);
    }

    public void startCourse(CourseRepository r) {
        c1.setName("JPA course");
        r.save(c1);

        c1 = new Course();
        c1.setName("Hibernate course");
        r.save(c1);

        c1 = new Course();
        c1.setName("Spring data course");
        r.save(c1);
    }

    public void startReview(ReviewRepository rr) {
        rv = new Review();
        rv.setDescription("Review 1");
        rv.setRating("1");
        rr.save(rv);

        rv = new Review();
        rv.setDescription("Review 2");
        rv.setRating("2");
        rr.save(rv);

        rv = new Review();
        rv.setDescription("Review 3");
        rv.setRating("3");
        rr.save(rv);

    }
}
