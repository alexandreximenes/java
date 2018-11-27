package com.alexandre.springmvc.domains;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@MappedSuperclass
public class AbstractEntity implements DomainObject {

    {
        updateDate();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;

    @Override
    public void setId(Integer id) {

    }

    @PreUpdate
    @PrePersist
    private void updateDate(){
        if(this.created_at != null){
            this.created_at = new Date();
        }else{
            this.updated_at = new Date();
        }
    }

    @Override
    public Integer getId() {
        return null;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractEntity)) return false;
        AbstractEntity that = (AbstractEntity) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
