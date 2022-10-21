/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author yueli
 */
public class LoginDatabase {
    Connection conn = null;
    String url = "jdbc:derby:UserDB;create=true";
    
    String dbusername = "pdc";
    String dbpassword = "pdc";
    
    public void dbsetup(){
        try{
            conn = DriverManager.getConnection(url,dbusername,dbpassword);
            Statement statement = conn.createStatement();
            String tableName = "UserInfo";
            
            if(!checkTableExisting(tableName)){
                statement.executeLargeUpdate("CREATE TABLE "+ tableName +" (userid VARCHAR(30), username VARCHAR(30), password VARCHAR(12), isAdmin BOOLEAN)");
            }
            statement.close();  
        }catch(Throwable e){
            System.out.println("Error");
        }
    }

    private boolean checkTableExisting(String newTableName) {
        boolean flag = false;
        try{
            System.out.println("Checking existing tables...");
            String[] types ={"TABLE"};
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rsDBMeta = dbmd.getTables(null, null, null, null);//types);
            //Statement dropStatement=null;
            while (rsDBMeta.next()) {
                String tableName = rsDBMeta.getString("TABLE_NAME");
                if (tableName.compareToIgnoreCase(newTableName) == 0) {
                    System.out.println(tableName + "  is there");
                    flag = true;
                }
            }
            if (rsDBMeta != null) {
                rsDBMeta.close();
            } 
        }catch(SQLException ex){
        }
        return flag; 
    }

    public Data checkName(String userID, String password) {
        Data data = new Data();
      try{
          Statement statement = conn.createStatement();
          String sql ="SELECT userid, username, password FROM UserInfo WHERE userid = '"+userID+"'and password= '"+password+"'"; 
          ResultSet rs = statement.executeQuery(sql);
          int count = 0;
          while(rs.next()){
              count+=1;
              data.username = rs.getString(2);
          }
          if(count==1){
              JOptionPane.showMessageDialog(null,"User Found, Login Successfully!");
              
              data.loginFlag = true; 
          }else if(count>1){
              JOptionPane.showMessageDialog(null, "Duplicate User, Login Denied!"); 
              data.loginFlag = false; 
          }else{
              JOptionPane.showMessageDialog(null, "Login unsuccessfully! Invalid ID or password. Try Again or choose another option.");
              data.loginFlag = false; 
          }
            
      }catch (SQLException ex) {
            Logger.getLogger(LoginDatabase.class.getName()).log(Level.SEVERE, null, ex);
    }
      return data;
    }  
    public Data checkAccountExist(String userID){
        Data data = new Data();
        
        try {
            Statement statement = conn.createStatement();
            String checkIfAccExist ="SELECT userID from UserInfo WHERE userID ='"+userID+"'";
            ResultSet rs = statement.executeQuery(checkIfAccExist);
            
            if(rs.next()){
                    data.accountExist = true;   
            }else{
                
                data.accountExist = false;
            }
            } catch (SQLException ex) {
            Logger.getLogger(LoginDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    public Data createNewAccount(String userID, String password, String userName){
        Data data = new Data();
        
        try {
            
            data = checkAccountExist(userID);
            if (data.accountExist) {
                JOptionPane.showMessageDialog(null,"User ID alrady exist! Please try another one.");
            }else{
                Statement statement = conn.createStatement();
                String sql = "INSERT INTO UserInfo (userID, userName, password) VALUES('"+ userID + "','" + userName + "','" + password + "')";
                statement.execute(sql);
                data.createNewAccDone = true;
                JOptionPane.showMessageDialog(null, "You new Account has been created!");  

            }
              
        } catch (SQLException ex) {
            Logger.getLogger(LoginDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data;
    }
    
    public Data resetPassword(String userID, String newPassword) {
        Data data = new Data();
        try{
            
            data = checkAccountExist(userID);
            
            if (data.accountExist) {
                 Statement statement = conn.createStatement();

                String sql = "UPDATE USERINFO SET PASSWORD = '"+newPassword+"'WHERE USERID= '"+userID+"'";
                System.out.println(statement.execute(sql));
                data.resetPasswordDone = true;
                JOptionPane.showMessageDialog(null, "You new password has reseted!");   
            } else {
            
                JOptionPane.showMessageDialog(null,"User ID does not exist! Please try again!");
            
            }

        }catch(SQLException ex) {
            Logger.getLogger(LoginDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       return data; 
    }

    public void quitSystem(){
        Statement statement;
        try{
            statement = conn.createStatement();
            statement.close();
            
        }catch (SQLException ex) {
           System.out.println("See you next time!");
        }
    }

    
}
