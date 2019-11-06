/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginForm.model.exceptions;


public class IllegalUsernameException extends Exception {

    /**
     * Creates a new instance of <code>IllegalUsernameException</code> without
     * detail message.
     */
    public IllegalUsernameException() {
    }

    /**
     * Constructs an instance of <code>IllegalUsernameException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public IllegalUsernameException(String msg) {
        super(msg);
    }
}
