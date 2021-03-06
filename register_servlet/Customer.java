package register_servlet;
import java.io.Serializable;

/**
 * JavaBean class used in jsp action tags.
 * @author Shubham Kumar
 */
public class Customer implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private String name;
    
    private String email;
    private String confirmEmail;
    private String password;
    private String confirmPassword;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getConfirmEmail() {
        return confirmEmail;
    }
    public void setConfirmEmail(String confirmEmail) {
        this.confirmEmail = confirmEmail;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
   
}
