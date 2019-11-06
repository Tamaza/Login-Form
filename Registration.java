/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginForm.model.oop;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public abstract class Registration {
    
    public static boolean register(User user) {
        
        if (Checker.isValid(user.getUsername())) {
            String path = User.path + user.getUsername() + ".txt";
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
                out.writeObject(user);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            return true;
        } else {
            return false;
        }
        
    }
    
}
