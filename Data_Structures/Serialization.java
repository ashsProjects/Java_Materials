import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Serialization {
    public static void main(String[] args) throws Exception{
        User user = new User();
        user.name = "Ash.Adhikari";
        user.password = "Password12321";

        user.sayHello();

        FileOutputStream fileOut = new FileOutputStream("UserInfo.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(user);
        out.close();
        fileOut.close();

        System.out.println("Object Info Saved!");
    }
}
