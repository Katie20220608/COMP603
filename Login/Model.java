/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

import java.util.Observable;

/**
 *
 * @author yueli
 */
public class Model extends Observable{
    
    public LoginDatabase db;
    public Data data = new Data();
    public String userID;
    
    public Model(){
        this.db = new LoginDatabase();
        this.db.dbsetup();
        
    }

    public void loginAcc(String userID, String password) {
        this.userID = userID;
        this.data = this.db.loginAcc(userID, password);
        data.isAdmin = false;
        this.setChanged();
        this.notifyObservers(this.data);
    }
    
//    public void loginAsAdmin(String userID){
//        this.userID = userID;
//        this.data = this.db.loginAsAdmin(userID);
//        this.setChanged();
//        this.notifyObservers(this.data);
//    }
    
    public void createNewAcc(String userID, String userName, String password){
        this.userID = userID;
        this.db.createNewAccount(userID, password, userName);
        
        this.setChanged();
        this.notifyObservers(this.data);
    }
    
    public void resetPassword(String userID, String newPassword){
        this.userID = userID;
        this.db.resetPassword(userID, newPassword);
        this.setChanged();
        this.notifyObservers(this.data);  
    }
    
    public void deleteAcc(String userID){
        this.userID = userID;
        this.db.deleteAcc(userID);
        this.setChanged();
        this.notifyObservers(this.data);
    
    }
    
    public void quitSystem() {
        this.db.quitSystem();
        this.data.quitFlag = true;
        this.setChanged();
        this.notifyObservers(this.data);  
    }
      
}
