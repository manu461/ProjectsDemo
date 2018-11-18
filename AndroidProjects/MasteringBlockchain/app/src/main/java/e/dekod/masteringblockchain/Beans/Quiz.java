package e.dekod.masteringblockchain.Beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Quiz implements Serializable {
    private String quizName;
    private String quizDescription;
    private String quizScore;
    private String quizImage;
    private List<Questions> questionsOfQuiz;

    public Quiz() {
    }

    public Quiz(String quizName, String quizDescription, String quizScore, String quizImage, List<Questions> questionsOfQuiz) {
        this.quizName = quizName;
        this.quizDescription = quizDescription;
        this.quizScore = quizScore;
        this.quizImage = quizImage;
        this.questionsOfQuiz = questionsOfQuiz;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public String getQuizDescription() {
        return quizDescription;
    }

    public void setQuizDescription(String quizDescription) {
        this.quizDescription = quizDescription;
    }

    public String getQuizScore() {
        return quizScore;
    }

    public void setQuizScore(String quizScore) {
        this.quizScore = quizScore;
    }

    public String getQuizImage() {
        return quizImage;
    }

    public void setQuizImage(String quizImage) {
        this.quizImage = quizImage;
    }

    public List<Questions> getQuestionsOfQuiz() {
        return questionsOfQuiz;
    }

    public void setQuestionsOfQuiz(List<Questions> questionsOfQuiz) {
        this.questionsOfQuiz = questionsOfQuiz;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "quizName='" + quizName + '\'' +
                ", quizDescription='" + quizDescription + '\'' +
                ", quizScore='" + quizScore + '\'' +
                ", quizImage='" + quizImage + '\'' +
                ", questionsOfQuiz=" + questionsOfQuiz +
                '}';
    }
}
