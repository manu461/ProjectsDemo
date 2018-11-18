package e.dekod.masteringblockchain.Beans;

import java.io.Serializable;

public class Questions implements Serializable {
    private int questionSerialID;
    private String questionStatement;
    private String optionOne;
    private String optionTwo;
    private String optionThree;
    private String optionFour;

    public Questions() {
    }

    public Questions(int questionSerialID, String questionStatement, String optionOne, String optionTwo, String optionThree, String optionFour) {
        this.questionSerialID = questionSerialID;
        this.questionStatement = questionStatement;
        this.optionOne = optionOne;
        this.optionTwo = optionTwo;
        this.optionThree = optionThree;
        this.optionFour = optionFour;
    }

    public int getQuestionSerialID() {
        return questionSerialID;
    }

    public void setQuestionSerialID(int questionSerialID) {
        this.questionSerialID = questionSerialID;
    }

    public String getQuestionStatement() {
        return questionStatement;
    }

    public void setQuestionStatement(String questionStatement) {
        this.questionStatement = questionStatement;
    }

    public String getOptionOne() {
        return optionOne;
    }

    public void setOptionOne(String optionOne) {
        this.optionOne = optionOne;
    }

    public String getOptionTwo() {
        return optionTwo;
    }

    public void setOptionTwo(String optionTwo) {
        this.optionTwo = optionTwo;
    }

    public String getOptionThree() {
        return optionThree;
    }

    public void setOptionThree(String optionThree) {
        this.optionThree = optionThree;
    }

    public String getOptionFour() {
        return optionFour;
    }

    public void setOptionFour(String optionFour) {
        this.optionFour = optionFour;
    }

    @Override
    public String toString() {
        return "Questions{" +
                "questionSerialID=" + questionSerialID +
                ", questionStatement='" + questionStatement + '\'' +
                ", optionOne='" + optionOne + '\'' +
                ", optionTwo='" + optionTwo + '\'' +
                ", optionThree='" + optionThree + '\'' +
                ", optionFour='" + optionFour + '\'' +
                '}';
    }
}
