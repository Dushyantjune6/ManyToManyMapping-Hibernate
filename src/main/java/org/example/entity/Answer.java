package org.example.entity;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
public class Answer {

    public Answer() {
    }

    public Answer(int id, String answer, Question question) {
        this.id = id;
        this.answer = answer;
        this.question = question;
    }

    @Id
    @Column(name = "answer_id")
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public int getId() {
        return id;
    }

    public Question getQuestion() {
        return question;
    }

    private String answer;

    @ManyToOne
    private Question question;

}
