package Project2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Katie LI
 * @Student ID:18003055
 */
public class LoginView extends JFrame implements Observer {

    // initilizing the GUI instance of variables
    private JPanel userPanel1 = new JPanel();
    private JPanel userPanel2 = new JPanel();
    public JLabel queryMessage = new JLabel("Have you already got an account?", JLabel.CENTER);
    private JLabel yes = new JLabel("Yes, I want to log in with my account.");
    private JButton yesButton = new JButton("Log in Now");
    private JLabel no = new JLabel("No, I want to create a new account.");
    private JButton noButton = new JButton("Create New Account");

    private JPanel loginPanel1 = new JPanel();
    private JPanel loginPanel2 = new JPanel();
    private JLabel uID = new JLabel("User ID: ");
    private JLabel pWord = new JLabel("Password: ");
    public JTextField uidInput = new JTextField(10);
    public JTextField pwInput = new JTextField(10);
    private JButton loginButton = new JButton("Log in");

    private JPanel createAccPanel1 = new JPanel();
    private JPanel createAccPanel2 = new JPanel();
    private JLabel inputId = new JLabel("Please input a user ID: ");
    private JLabel inputName = new JLabel("Please input your name: ");
    private JLabel inputPassword = new JLabel("Please input your password: ");
    public JTextField newUserId = new JTextField(11);
    public JTextField newUserName = new JTextField(11);
    public JTextField newUserPassword = new JTextField(11);
    private JButton createNewAccButton = new JButton("Create New Account");
    private JButton registerButton = new JButton("Register");
    private JLabel remindMsgForNewAcc = new JLabel("As the user ID,user name and password are sensitive, please do not include special characters(for example: ',_.~!) when you create new account.");

    private JPanel resetPasswordPanel = new JPanel();
    private JPanel loginAsAdminPanel1 = new JPanel();
    private JLabel IDquery = new JLabel("Please input your user ID:");
    public JTextField inputUserID = new JTextField(10);
    private JLabel resetPassword = new JLabel("Please input your new password:");
    public JTextField newInputPassword = new JTextField(10);
    private JButton resetPasswordButton = new JButton("Reset Password");
    private JButton submitButton = new JButton("Submit");

    private JPanel quitPanel = new JPanel();
    private JButton quitButton = new JButton("Quit");
    private JLabel goodbye = new JLabel("Goodbye! See you next time!");

    private JButton backButton = new JButton("Back");

    protected Model m;

    //The constructor initializes the frame window as well as the login interface.
    public LoginView() {
        super("-----------------------------Welcome to ENSE600/COMP603 Q & A App-----------------------------");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 200);
        this.setResizable(false);

        this.add(this.queryMessage, BorderLayout.NORTH);
        this.queryMessage.setFont(new Font("Serif", Font.ITALIC, 18));

        this.userPanel1.add(yes);
        this.userPanel1.add(yesButton);
        this.userPanel2.add(no);
        this.userPanel2.add(noButton);
        this.userPanel2.add(quitButton);
        this.quitButton.setForeground(Color.red);

        this.add(userPanel1, BorderLayout.CENTER);
        this.add(userPanel2, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public void loginAccount() {
        loginPanel1.add(uID);
        loginPanel1.add(uidInput);
        loginPanel1.add(pWord);
        loginPanel1.add(pwInput);
        loginPanel2.add(loginButton);
        loginPanel2.add(backButton);
        loginPanel2.add(quitButton);
        this.quitButton.setForeground(Color.red);
        loginPanel2.add(resetPasswordButton);
        loginPanel2.add(createNewAccButton);

        this.getContentPane().removeAll();
        loginPanel1.setVisible(true);
        loginPanel2.setVisible(true);

        this.add(loginPanel1, BorderLayout.CENTER);
        this.add(loginPanel2, BorderLayout.SOUTH);
        this.revalidate();
        this.repaint();
    }

    public void createAnAccount() {
        createAccPanel1.add(inputId);
        createAccPanel1.add(newUserId);
        createAccPanel1.add(inputName);
        createAccPanel1.add(newUserName);
        createAccPanel1.add(inputPassword);
        createAccPanel1.add(newUserPassword);
        createAccPanel1.add(registerButton);
        createAccPanel1.add(backButton);
        createAccPanel1.add(quitButton);
        this.quitButton.setForeground(Color.red);
        createAccPanel2.add(remindMsgForNewAcc);
        this.remindMsgForNewAcc.setFont(new Font("Serif", Font.ITALIC, 18));
        this.remindMsgForNewAcc.setForeground(Color.BLUE);

        this.getContentPane().removeAll();
        createAccPanel1.setVisible(true);
        createAccPanel2.setVisible(true);
        this.add(createAccPanel1, BorderLayout.CENTER);
        this.add(createAccPanel2, BorderLayout.SOUTH);
        this.revalidate();
        this.repaint();
    }

    public void resetPassword() {
        resetPasswordPanel.add(IDquery);
        resetPasswordPanel.add(inputUserID);
        resetPasswordPanel.add(resetPassword);
        resetPasswordPanel.add(newInputPassword);
        resetPasswordPanel.add(submitButton);
        resetPasswordPanel.add(quitButton);
        resetPasswordPanel.add(backButton);
        resetPasswordPanel.add(quitButton);

        this.getContentPane().removeAll();
        resetPasswordPanel.setVisible(true);
        this.add(resetPasswordPanel);
        this.revalidate();
        this.repaint();
    }

    public void loginAsAdmin() {
        new QnaAdminMenuView(m);
        this.dispose();
    }

    public void printQuestionMenu() {
        new QnaMenuView(m);
        this.dispose();
    }

    public void addActionListener(ActionListener listener) {
        this.yesButton.addActionListener(listener);
        this.noButton.addActionListener(listener);
        this.loginButton.addActionListener(listener);
        this.quitButton.addActionListener(listener);
        this.backButton.addActionListener(listener);
        this.createNewAccButton.addActionListener(listener);
        this.registerButton.addActionListener(listener);
        this.resetPasswordButton.addActionListener(listener);
        this.submitButton.addActionListener(listener);
    }

    public void quitSystem() {
        quitPanel.add(goodbye);
        goodbye.setFont(new Font("Serif", Font.ITALIC, 16));
        quitPanel.add(goodbye, BorderLayout.AFTER_LAST_LINE);
        this.getContentPane().removeAll();

        this.add(quitPanel);
        this.revalidate();
        this.repaint();
    }

    public void goBacktoMenu() {
        this.dispose();
        new App();
    }

    //Define the event when model has been modified.
    @Override
    public void update(Observable o, Object arg) {
        LoginData data = (LoginData) arg;
        if (!data.hasAnAccount) {//if the user has an account, to the login window
            this.loginAccount();
            if (data.loginFlag == true) {//if the user ID and password matching the information in db then go to the QAMenu window
                if (data.isAdmin == false) {
                    this.printQuestionMenu();
                } else {//after login, if the user is recogized as Admin, go to the Admin Menu window
                    this.loginAsAdmin();
                }
            }else{//otherwise it will go back to the first page
                this.goBacktoMenu();
            }
        }
        else if (!data.quitFlag) {//if the user press the quit button, go to the quite window
            this.quitSystem();
        } else if (data.resetPasswordDone) {//go to the the reset window
            this.resetPassword();
            data.loginFlag = false;
        } else if (data.accountExist) {//go to the the createAnAccount window
            this.createAnAccount();
            data.hasAnAccount = true;
        } else if (!data.accountExist) {//go to the resetPassword window
            this.resetPassword();
        } 
    }
}
