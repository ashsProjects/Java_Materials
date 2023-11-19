import java.io.*;
import java.net.*;
import java.util.Random;

public class TCPClient {
    static DataInputStream din;
    static DataOutputStream dout;
    static Random rand;
    static Socket clientSocket;

    public static int receive(){
        try {
            int response = din.readInt();
            return response;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return -1;
    }

    public static void send(int numToSend){
        try {
            dout.writeInt(numToSend);
            dout.flush();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void cleanUp(){
        try {
            clientSocket.close();
            dout.close();
            din.close();

            System.exit(0);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        String serverHost = args[0];
        int port = Integer.parseInt(args[1]);

        long senderSum = 0;
        int numOfMessagesSent = 0;

        try {
            clientSocket = new Socket(serverHost, port);
            dout = new DataOutputStream(clientSocket.getOutputStream());
            din = new DataInputStream(clientSocket.getInputStream());

            int numMessages = receive();
            int seed = receive();
            rand = new Random(seed);

            System.out.println("Received config");
            System.out.println("number of messages = " + numMessages);
            System.out.println("seed = " + seed);
            
            System.out.println("Starting to send messages to server...");
            for (int i = 0; i < numMessages; i++) {
                int numToSend = rand.nextInt();
                send(numToSend);
                senderSum += numToSend;
                numOfMessagesSent++;
            }
            System.out.println("Finished sending messages to server.");
            System.out.println("Total messages sent: " + numOfMessagesSent);
            System.out.println("Sum of messages sent: " + senderSum);

            long receiverSum = 0;
            int numOfReceivedMessages = 0;
            
            System.out.println("Starting to listen for messages from server...");
            for (int i = 0; i < numMessages; i++) {
                int receivedNum = receive();
                receiverSum += receivedNum;
                numOfReceivedMessages++;
            }
            System.out.println("Finished listening for messages from server.");
            System.out.println("Total messages received: " + numOfReceivedMessages);
            System.out.println("Sum of messages received: " + receiverSum);

            cleanUp();

        }
        catch (IOException e) {
            System.err.print(e.getMessage());
        }

    }

}
