package com.treinamento.hibernate;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class InitData {

    private final CourseRepository r;

    public void start(){
        Course c1 = new Course();
        c1.setName("JPA course");
        r.save(c1);

        Course c2 = new Course();
        c2.setName("Hibernate course");
        r.save(c2);

        Course c3 = new Course();
        c3.setName("Spring data course");
        r.save(c3);
    }
}
