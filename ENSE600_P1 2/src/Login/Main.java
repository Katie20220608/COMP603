/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

/**
 *
 * @author Katie LI
 *@Student ID:18003055
 */
public class Main {
    public static void main(String[] args){
        LoginView view = new LoginView();
        Model model = new Model();
        Controller controller = new Controller(view, model);
        model.addObserver(view);// Build connection between the view and the model.
    } 
}
