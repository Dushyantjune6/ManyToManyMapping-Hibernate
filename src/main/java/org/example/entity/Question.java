package org.example.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Question {
    public Question(int id, String question, List<Answer> answer) {
        this.id = id;
        Question = question;
        this.answer = answer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public void setAnswer(List<Answer> answer) {
        this.answer = answer;
    }

    public Question() {
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return Question;
    }

    public List<Answer> getAnswer() {
        return answer;
    }

    @Id
    @Column(name = "question_id")
    private int id;
    private String Question;

    @OneToMany(mappedBy = "question")
    private List<Answer> answer;
}
