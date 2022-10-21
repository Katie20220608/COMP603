/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

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
 * @author yueli
 */
public class LoginView extends JFrame implements Observer  {
    
    private JPanel userPanel1 = new JPanel();
    private JPanel userPanel2 = new JPanel();
    
    private JPanel loginPanel = new JPanel();
    private JPanel createAccPanel = new JPanel();
    
    private JPanel QAMenu = new JPanel();
    
    
    public JLabel queryMessage = new JLabel("Have you already got an account?",JLabel.CENTER);
    private JLabel yes = new JLabel("Yes, I want to log in with my account.");
    private JButton yesButton = new JButton("Log in Now");
    private JLabel no = new JLabel("No, I want to create a new account.");
    private JButton noButton = new JButton("Create New Account");
    private JButton quitButton = new JButton("Quit");
    private JButton registerButton = new JButton("Register");
    private JButton backButton = new JButton("Back");
    
    private JLabel uID = new JLabel("User ID: ");
    private JLabel pWord = new JLabel("Password: ");
    public JTextField uidInput = new JTextField(10);
    public JTextField pwInput = new JTextField(10);
    private JLabel wrongName = new JLabel();
    private JButton loginButton = new JButton("Log in");
    
    private JLabel inputId = new JLabel("Please input a user ID: ");
    private JLabel inputName = new JLabel("Please input your name: ");
    private JLabel inputPassword = new JLabel("Please input your password: ");
    public JTextField newUserId = new JTextField(40);
    public JTextField newUserName = new JTextField(40);
    public JTextField newUserPassword = new JTextField(40);
    private JButton createNewAccButton = new JButton("Create New Account");
    
    private JLabel welcomMessage = new JLabel("Kia ora,you have logged in successfully!");
    private JLabel questionMenu = new JLabel("Would you like to: ");
    private JButton askQuestion = new JButton("Ask a new question");
    private JButton browseQuestions = new JButton("Browse all questions");
    private JButton browseQuesByTopic = new JButton("Browse questions by topic");
    private JButton answerQuestions = new JButton("Answer unanswered questions");
    
   
    public LoginView(){
        super("-------------Welcome to ENSE600/COMP603 Q & A App-------------");
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,200);
        
        this.add(this.queryMessage,BorderLayout.NORTH);
        this.queryMessage.setFont(new Font("Serif",Font.ITALIC,18));
        
        this.userPanel1.add(yes);
        this.userPanel1.add(yesButton);
        this.userPanel2.add(no);
        this.userPanel2.add(noButton);
        this.userPanel2.add(quitButton);
        this.quitButton.setForeground(Color.red);
        
        this.add(userPanel1,BorderLayout.CENTER);
        this.add(userPanel2,BorderLayout.SOUTH);
        this.setVisible(true);
    
    }
    
    public void loginAccount(){
        loginPanel.add(uID);
        loginPanel.add(uidInput);
        loginPanel.add(pWord);
        loginPanel.add(pwInput);
        loginPanel.add(loginButton);
        loginPanel.add(quitButton);
        this.quitButton.setForeground(Color.red);
        loginPanel.add(createNewAccButton);
        
        this.getContentPane().removeAll();
        loginPanel.setVisible(true);
        
        this.add(loginPanel);
        this.revalidate();
        this.repaint();
        
    }
    public void createAnAccount() {
        createAccPanel.add(inputId);
        createAccPanel.add(newUserId);
        createAccPanel.add(inputName);
        createAccPanel.add(newUserName);
        createAccPanel.add(inputPassword);
        createAccPanel.add(newUserPassword);
        createAccPanel.add(quitButton);
        this.quitButton.setForeground(Color.red);
        createAccPanel.add(registerButton);
        
        this.getContentPane().removeAll();
        createAccPanel.setVisible(true);
        this.add(createAccPanel);
        this.revalidate();
        this.repaint();
        
    }
    
    public void printQuestionMenu(){
        QAMenu.add(welcomMessage,BorderLayout.NORTH);
        QAMenu.add(questionMenu,BorderLayout.CENTER);
        QAMenu.add(askQuestion);
        QAMenu.add(browseQuestions);
        QAMenu.add(browseQuesByTopic);
        QAMenu.add(answerQuestions);
        QAMenu.add(quitButton);
        this.quitButton.setForeground(Color.red);
        
        this.getContentPane().removeAll();
        QAMenu.setVisible(true);
        this.add(QAMenu);
        this.revalidate();
        this.repaint(); 
        
    }
    
    public void addActionListener(ActionListener listener) {
        this.yesButton.addActionListener(listener);
        this.noButton.addActionListener(listener);
        this.loginButton.addActionListener(listener);
        this.quitButton.addActionListener(listener);
        this.backButton.addActionListener(listener);
        this.createNewAccButton.addActionListener(listener);
        this.registerButton.addActionListener(listener);
    }
    
    public void quitSystem(){
        JPanel quitPanel = new JPanel();
        JLabel goodbye = new JLabel("Goodbye! See you next time!");
        goodbye.setFont(new Font("Serif",Font.ITALIC,16));
        quitPanel.add(goodbye,BorderLayout.AFTER_LAST_LINE);
        this.getContentPane().removeAll();
        
        this.add(quitPanel);
        this.revalidate();
        this.repaint(); 
    }
    
    public void goBackToQAMenu() {
        this.printQuestionMenu();
   
    }
    
    @Override
    public void update(Observable o, Object arg) {
        Data data = (Data) arg;
        if(!data.hasAnAccount){
            this.loginAccount();
            if(data.loginFlag== true){
            this.printQuestionMenu();
            }else{
                this.loginAccount();
            }
        }else if(data.hasAnAccount){
            this.createAnAccount();
            data.loginFlag = false;  
        }else if(data.loginFlag){
            this.loginAccount();
        }else if(!data.quitFlag){
            this.quitSystem();
        }
    }      
}