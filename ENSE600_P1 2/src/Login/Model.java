/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

import java.util.Observable;

/**
 *
 *@author Katie LI
 *@Student ID:18003055
 */
public class Model extends Observable{
    
    public LoginDatabase db;
    public Data data = new Data();
    public String userID;
    
    //Initialize the instance of Database in the constructor,
    // and build the connection between the program and the database.
    public Model(){
        this.db = new LoginDatabase();
        this.db.dbsetup();
    }

    //Compare userID and password with that inside db.
    public void loginAcc(String userID, String password) {
        this.userID = userID;
        this.data = this.db.loginAcc(userID, password);
        this.setChanged();
        this.notifyObservers(this.data);
    }

    //generate a new account and write back to db
    public void createNewAcc(String userID, String userName, String password){
        this.userID = userID;
        this.db.createNewAccount(userID, password, userName);
        
        this.setChanged();
        this.notifyObservers(this.data);
    }
    
    //add the new password back to db
    public void resetPassword(String userID, String newPassword){
        this.userID = userID;
        this.db.resetPassword(userID, newPassword);
        this.setChanged();
        this.notifyObservers(this.data);  
    }
    
    //delete the information which matching with the userID in db
    public void deleteAcc(String userID){
        this.userID = userID;
        this.db.deleteAcc(userID);
        this.setChanged();
        this.notifyObservers(this.data);
    
    }
    //update data in db
    public void quitSystem() {
        this.db.quitSystem();
        this.data.quitFlag = true;
        this.setChanged();
        this.notifyObservers(this.data);  
    }
      
}
