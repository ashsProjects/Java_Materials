import java.io.*;
import java.net.*;
import java.util.Random;

public class TCPServer {
    static DataInputStream din1;
    static DataOutputStream dout1;
    static DataInputStream din2;
    static DataOutputStream dout2;
    static Socket clientSocket1;
    static Socket clientSocket2;
    static ServerSocket serverSocket;
    static Random rand;

    public static int receive(DataInputStream di) {
        try {
            int response = di.readInt();
            return response;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return -1;
    }

    public static void send(int numToSend, DataOutputStream dou) {
        try {
            dou.writeInt(numToSend);
            dou.flush();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public static void cleanUp() {
        try {
            serverSocket.close();
            clientSocket1.close();
            clientSocket2.close();
            dout1.close();
            din1.close();
            dout2.close();
            din2.close();

            System.exit(0);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);
        int seed = Integer.parseInt(args[1]);
        int numMessages = Integer.parseInt(args[2]);
        rand = new Random(seed);

        //Task 1
        try {
            System.out.println("IP Address: " + InetAddress.getLocalHost() + "\nPort Number " + port);
            if (port < 1024 && port > 65535) {
                System.out.println("Port not valid (Bind Failed)");
                System.exit(0);
            }
            
            serverSocket = new ServerSocket(port);

            System.out.println("waiting for client...");
            clientSocket1 = serverSocket.accept();
            clientSocket2 = serverSocket.accept();
            System.out.println("Clients Connected!");

            dout1 = new DataOutputStream(clientSocket1.getOutputStream());
            din1 = new DataInputStream(clientSocket1.getInputStream());
            dout2 = new DataOutputStream(clientSocket2.getOutputStream());
            din2 = new DataInputStream(clientSocket2.getInputStream());

            System.out.println("Sending config to clients...");
                
            int randNum = rand.nextInt();
            send(numMessages, dout1);
            send(randNum, dout1);
            System.out.printf("%s %d\n", clientSocket1.getInetAddress().getHostName(), randNum);

            randNum = rand.nextInt();
            send(numMessages, dout2);
            send(randNum, dout2);
            System.out.printf("%s %d\n", clientSocket2.getInetAddress().getHostName(), randNum);

            System.out.println("Finished sending config to clients.");
            System.out.println("Starting to listen for client messages.");

            int client1messages = 0;
            long client1sum = 0;
            int client2messages = 0;
            long client2sum = 0;
            
            for (int i = 0; i < numMessages; i++) {
                int client1 = receive(din1);
                int client2 = receive(din2);
                
                if (client1 != -1) {
                    client1messages++;
                    client1sum += client1;
                    send(client1, dout2);
                }
                if (client2 != -1) {
                    client2messages++;
                    client2sum += client2;
                    send(client2, dout1);
                }
            }

            System.out.println("Finished listening for client messages.");
            System.out.println(clientSocket1.getInetAddress().getHostName() 
                                + "\n\tMessages received: " + client1messages 
                                + "\n\tSum received: " + client1sum);
            System.out.println(clientSocket2.getInetAddress().getHostName()
                                + "\n\tMessages received: " + client2messages 
                                + "\n\tSum received: " + client2sum);
            
            cleanUp();
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

}
