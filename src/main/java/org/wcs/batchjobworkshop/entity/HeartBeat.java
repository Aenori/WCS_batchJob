package org.wcs.batchjobworkshop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class HeartBeat {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private LocalDate createdAt;
    private String source;

    public HeartBeat(){}
    public HeartBeat(LocalDate createdAt, String source) {
        this.createdAt = createdAt;
        this.source = source;
    }
    public HeartBeat(Integer id, LocalDate createdAt, String source) {
        this.id = id;
        this.createdAt = createdAt;
        this.source = source;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
