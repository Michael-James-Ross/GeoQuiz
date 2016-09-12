package model;

public class Question {
    private int questionTextResId;
    private boolean answer;

    public Question() {
    }

    public Question(int questionTextResId, boolean answer) {
        this.questionTextResId = questionTextResId;
        this.answer = answer;
    }

    public int getQuestionTextResId() {
        return questionTextResId;
    }

    public void setQuestionTextResId(int questionTextResId) {
        this.questionTextResId = questionTextResId;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
