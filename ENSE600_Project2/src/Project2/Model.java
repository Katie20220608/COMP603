package Project2;

import java.util.Observable;

/**
 *
 * @author Katie LI and Leo JIA
 * @Student ID:18003055 and 20115737
 */
public class Model extends Observable {

    public Database db;

    public QuestionData questionData;
    public LoginData loginData;

    public Model() {
        this.db = new Database();
        this.db.setup();

        this.loginData = new LoginData();
        this.questionData = new QuestionData();

        this.initialiseQuestionData();
    }

    public void initialiseQuestionData() {
        questionData = new QuestionData();
        db.initialiseQuestions(questionData);
        db.initialiseAnswers(questionData);
    }

    //Compare userID and password with that inside db.
    public void loginAcc(String userID, String password) {
        this.loginData = this.db.loginAcc(userID, password);
        loginData.userid = userID;
        loginData.password = password;
        this.setChanged();
        this.notifyObservers(this.loginData);
    }

    //generate a new account and write back to db
    public void createNewAcc(String userID, String userName, String password) {
        this.db.createNewAccount(userID, password, userName);
        loginData.userid = userID;
        loginData.password = password;
        this.setChanged();
        this.notifyObservers(this.loginData);
    }

    //add the new password back to db
    public void resetPassword(String userID, String newPassword) {
        this.db.resetPassword(userID, newPassword);
        loginData.password = newPassword;
        this.setChanged();
        this.notifyObservers(this.loginData);
    }

    //delete the information which matching with the userID in db
    public void deleteAcc(String userID) {
        this.db.deleteAcc(userID);
    }

    //insert new question in db, and reinitialise questionData
    public void newQuestion(String question, String topic) {
        question = question.replace("'", "''");
        Question newQuestion = new Question(question, this.loginData.username, topic);
        db.insertQuestion(newQuestion);
        initialiseQuestionData();
    }

    //insert new answer in db, and reinitialise questionData
    public void newAnswer(String questionid, String answer) {
        questionid = questionid.replace("'", "''");
        answer = answer.replace("'", "''");
        Answer newAnswer = new Answer(questionid, answer, this.loginData.username);
        db.insertAnswer(newAnswer);
        this.questionData.questions.get(newAnswer.getQuestionid()).answers.add(newAnswer);
    }

    //delete question in db, and reinitialise questionData
    public void deleteQuestion(Question q) {
        db.deleteQuestion(q.getqId().replace("'", "''"));
        initialiseQuestionData();
    }

    //delete answer in db, and reinitialise questionData
    public void deleteAnswer(Answer a) {
        db.deleteAnswer(a.getAnswerid().replace("'", "''"));
        this.questionData.questions.get(a.getQuestionid()).answers.remove(a);
    }
}
