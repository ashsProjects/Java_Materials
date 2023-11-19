import java.io.*;
public class Deserialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user = null;
        FileInputStream fileIn = new FileInputStream("C:\\Users\\Ayush\\Documents\\Visual Studio Code\\Java\\Data_Structures\\UserInfo.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        user = (User) in.readObject();
        in.close();
        fileIn.close();

        System.out.println(user.name);
        System.out.println(user.password);
        user.sayHello();
    }
    
}