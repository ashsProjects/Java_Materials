import java.io.Serializable;

public class User implements Serializable{
    //serialVersionUID needs to match between the two classes
    private static final long serialVersionUID = 1;
    String name;
    //transient variables are not serialized
    transient String password;

    public void sayHello() {
        System.out.println("Hello " + name);
    }

}
