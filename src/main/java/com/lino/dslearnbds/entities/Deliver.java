package com.lino.dslearnbds.entities;

import com.lino.dslearnbds.entities.enums.DeliverStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_deliver")
public class Deliver implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uri;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant moment;
    private DeliverStatus status;
    private String feedback;
    private Integer correctCount;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "offer_id"),
            @JoinColumn(name = "user_id")
    })
    private Enrrollment enrrollment;
    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    public Deliver() {
    }

    public Deliver(Long id, String uri, Instant moment, DeliverStatus status, Integer correctCount, String feedback, Enrrollment enrrollment, Lesson lesson) {
        this.id = id;
        this.uri = uri;
        this.moment = moment;
        this.status = status;
        this.correctCount = correctCount;
        this.feedback = feedback;
        this.enrrollment = enrrollment;
        this.lesson = lesson;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public DeliverStatus getStatus() {
        return status;
    }

    public void setStatus(DeliverStatus status) {
        this.status = status;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Integer getCorrectCount() {
        return correctCount;
    }

    public void setCorrectCount(Integer correctCount) {
        this.correctCount = correctCount;
    }

    public Enrrollment getEnrrollment() {
        return enrrollment;
    }

    public void setEnrrollment(Enrrollment enrrollment) {
        this.enrrollment = enrrollment;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deliver deliver = (Deliver) o;
        return Objects.equals(id, deliver.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
