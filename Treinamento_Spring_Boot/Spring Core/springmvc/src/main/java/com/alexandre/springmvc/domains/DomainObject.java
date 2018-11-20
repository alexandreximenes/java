package com.alexandre.springmvc.domains;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public interface DomainObject {
    void setId(Integer id);
    Integer getId();
}
