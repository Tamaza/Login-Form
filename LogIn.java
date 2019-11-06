
package LoginForm.model.oop;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class LogIn {
    
    public static boolean logIn(String username, String password) {
        File file = new File(User.path);
        for (File f : file.listFiles()) {
            try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))) {
                User user = (User)in.readObject();
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    return true;
                }
            } catch(IOException ex) {
                System.out.println(ex.getMessage());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
}
