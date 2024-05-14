package org.example;

import org.example.entity.Answer;
import org.example.entity.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Question question = new Question();
        question.setId(1);
        question.setQuestion("Which are your favourite places?");

        Answer answer = new Answer();
        answer.setAnswer("Australia");
        answer.setId(1);
        answer.setQuestion(question);

        Answer answer1 = new Answer();
        answer1.setAnswer("Sydney");
        answer1.setId(2);
        answer1.setQuestion(question);

        Answer answer2 = new Answer();
        answer2.setAnswer("Brisbane");
        answer2.setId(3);
        answer2.setQuestion(question);

        List<Answer> ansList = new ArrayList<>();
        ansList.add(answer);
        ansList.add(answer1);
        ansList.add(answer2);

        question.setAnswer(ansList);

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(question);
        tx.commit();

        Question s1 = (Question) session.get(Question.class, 7);
        System.out.println(s1.toString());
        session.close();

    }
}