package com.lino.dslearnbds.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_lesson")
@Inheritance(strategy = InheritanceType.JOINED)//Para quando usa herança, usando o Joined ele vai criar as tres tabelas
public class Lesson implements Serializable {//Estq relacionada as aulas, ele pode ser um conteudo ou uma tarefa

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer position;

    @ManyToOne//Uma lesson vai ter que ter uma seção
    @JoinColumn(name = "section_id")
    private Section section;//Vai ter uma seção obrigatoriamente

    @ManyToMany(fetch = FetchType.LAZY)//Uma lesson pode estar varios usuarios assim como varios usuarios em uma tarefa
    @JoinTable(name = "tb_lesson_done",
    joinColumns = @JoinColumn(name = "lesson_id"),
    inverseJoinColumns = {//Como esta usando chave composta o inverse joincolun ficou dessa maneira
            @JoinColumn(name = "user_id"),
            @JoinColumn(name = "offer_id")
    })
    private Set<Enrrollment> enrrollmentsDone = new HashSet<>();//Para verificar qual aluno ja finalizou a aula

    public Lesson() {
    }

    public Lesson(Long id, String title, Integer position, Section section) {
        this.id = id;
        this.title = title;
        this.position = position;
        this.section = section;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Set<Enrrollment> getEnrrollmentsDone() {
        return enrrollmentsDone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return Objects.equals(id, lesson.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
