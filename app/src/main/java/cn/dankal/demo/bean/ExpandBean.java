package cn.dankal.demo.bean;

import java.util.List;

public class ExpandBean {
    private String title="问题分类";
    private List<ProblemBean.QuestionsBeanX> questions;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ProblemBean.QuestionsBeanX> getQuestions() {
        return questions;
    }

    public void setQuestions(List<ProblemBean.QuestionsBeanX> questions) {
        this.questions = questions;
    }
}
