package com.alexandre.springmvc.domains;

import javax.persistence.*;
@MappedSuperclass
public class AbstractEntity{

    {
        updateDate();
    }

    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date created_at;
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date updated_at;

    @PreUpdate
    @PrePersist
    private void updateDate(){
        if(this.created_at != null){
            this.created_at = new java.util.Date();
        }else{
            this.updated_at = new java.util.Date();
        }
    }

    public java.util.Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(java.util.Date created_at) {
        this.created_at = created_at;
    }

    public java.util.Date getUpdated_at() {
        return updated_at;
    }
}
