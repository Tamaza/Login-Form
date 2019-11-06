
package LoginForm.model.oop;

import LoginForm.model.exceptions.IllegalEmailException;
import LoginForm.model.exceptions.IllegalNameException;
import LoginForm.model.exceptions.IllegalNumberException;
import LoginForm.model.exceptions.IllegalPasswordException;
import LoginForm.model.exceptions.IllegalSurnameException;
import LoginForm.model.exceptions.IllegalUsernameException;
import java.io.File;

/**
 * კლასში არის ინფორმაციის შემოწმების მეთოდები
 * 
 * @author ADMIN
 */
public abstract class Checker {
    
    public static void validName(String name) throws IllegalNameException{
        if (name.length() < 2){
            throw new IllegalNameException("Use minimum 2 symbols!");
        }
    }
    
    public static void validSurname(String surname) throws IllegalSurnameException{
        if (surname.length() < 2){
            throw new IllegalSurnameException("Use minimum 2 symbols!");
        }
    }

    public static void validEmail(String email) throws IllegalEmailException {
        String arr1[] = email.split("@");
        if (arr1.length != 2){
            throw new IllegalEmailException("Wrong e-mail!");
        }
        String s = arr1[1];
        String arr2[] = s.split("\\.");
        if (arr2.length < 2){
            throw new IllegalEmailException("Wrong e-mail!");
        }
        for (int i=0; i<arr2.length; i++){
            if (arr2[i].equals("")){
                throw new IllegalEmailException("Wrong e-mail!");
            }
        }
    }
    
    public static void validNumber(String number) throws IllegalNumberException{
        for (int i=0; i<number.length(); i++){
            if (number.charAt(i) < '0' || number.charAt(i) > '9'){
                throw new IllegalNumberException("Wrong number format!");
            }
        }
    }
    
    public static void validUsername(String username) throws IllegalUsernameException{
        if (username.length() < 4 || username.length() > 12){
            throw new IllegalUsernameException("Wrong name format!");
        }
        for (int i=0; i<username.length(); i++){
            if (username.charAt(i) == ' '){
                throw new IllegalUsernameException("Wrong name format");
            }
        }
    }
    
    public static void validPassword(String password) throws IllegalPasswordException{
        if (password.length() < 8 || password.length() > 15){
            throw new IllegalPasswordException("Weak password!");
        }
        int x = 0;
        for (int i=0; i<password.length(); i++){
            if (password.charAt(i) >= 'a' && password.charAt(i) <= 'z'){
                x++;
                break;
            }
        }
        for (int i=0; i<password.length(); i++){
            if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z'){
                x++;
                break;
            }
        }
        for (int i=0; i<password.length(); i++){
            if (password.charAt(i) >= '0' && password.charAt(i) <= '9'){
                x++;
                break;
            }
        }
        if (x!=3){
            throw new IllegalPasswordException("Wrong password");
        }
    }
    
    public static boolean isValid(String username) {
        String path = User.path + username + ".txt";
        
        File file = new File(path);
        if (file.exists()) {
            return false;
        } else {
            return true;
        }
    }
    
}
