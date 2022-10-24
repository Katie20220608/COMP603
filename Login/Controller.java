/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author yueli
 */
public class Controller implements ActionListener {
    public LoginView view;
    public Model model;
    
    public Controller(LoginView view, Model model){
        this.view = view;
        this.model = model;
        this.view.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch(command){
            case "Log in Now":
                this.view.loginAccount();
                break;
            
            case "Create New Account":
                this.view.createAnAccount();     
                break;
                
            case "Log in":
                String userID = this.view.uidInput.getText();
                String password = this.view.pwInput.getText();
                this.model.db.loginAcc(userID, password);
                System.out.println(this.model.data.isAdmin);
                this.model.loginAcc(userID, password);
                System.out.println(this.model.data.isAdmin);
                break;

            case "Quit":
                this.view.quitSystem();
                break;
                
            case "Register":
                String newUserID = this.view.newUserId.getText().trim();
                String newUserName = this.view.newUserName.getText().trim();
                String newUserPassword = this.view.newUserPassword.getText().trim();
                if(newUserID.isEmpty()||newUserName.isEmpty()||newUserPassword.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Invalid input!");
                }else if(newUserID.length()>30){
                    JOptionPane.showMessageDialog(null, "You input information exceeds maximum allowed characters (30)");
                }else if(newUserName.length()>30){
                    JOptionPane.showMessageDialog(null, "You input information exceeds maximum allowed characters (30)");
                }else if(newUserPassword.length()>30){
                    JOptionPane.showMessageDialog(null, "You input information exceeds maximum allowed characters (30)");
                }else{
                    this.model.createNewAcc(newUserID, newUserName, newUserPassword);
                }
                break;
                
            case "Reset Password":
                this.view.resetPassword();
                break;
                
            case "Submit":
                String inputID = this.view.inputUserID.getText().trim();
                String newPassword = this.view.newInputPassword.getText().trim();
                this.model.resetPassword(inputID,newPassword);
                break;
                
            case "Delete an account":
                this.view.deleteAcc();
                break;
                
            case "Delete":
                String deleteID = this.view.inputUserID.getText().trim();
                this.model.deleteAcc(deleteID);
                break;
                
            case "Back":
                this.view.goBackToQAMenu();
                break;
                
            default:
                break;
                
        }
    }  
}
