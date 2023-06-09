package com.resellerapp.models.entity;


import org.hibernate.annotations.GenericGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {
	
    @Id
    @GeneratedValue(generator = "UUIDGenerator")
    @GenericGenerator( name = "UUIDGenerator",strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    public BaseEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
