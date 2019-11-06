/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginForm.model.exceptions;


public class IllegalNumberException extends Exception {

    /**
     * Creates a new instance of <code>IllegalNumberException</code> without
     * detail message.
     */
    public IllegalNumberException() {
    }

    /**
     * Constructs an instance of <code>IllegalNumberException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public IllegalNumberException(String msg) {
        super(msg);
    }
}
