package bin;

import java.io.*;
import java.util.Hashtable;
import java.util.*;

public class BankingSystem {
    static Stack userData = new Stack();
    public static void main(String[] args) {
        register();
    }

    private static void register() {
        Hashtable newUser = new Hashtable();
        Scanner input = new Scanner(System.in);
        System.out.print("Input name: ");
        String user = input.nextLine();
        System.out.print("Input password: ");
        String password = input.nextLine();
        input.close();

        double amount = 100;
        newUser.put("Name", user);
        newUser.put("Password", password);
        newUser.put("Money", amount);
        userData.push(newUser);
        System.out.println("Your account: [ " + userData + " ]");
    }
}

// import java.io.*;
// import java.nio.file.Files;
// import java.nio.file.Paths;
// import java.util.Scanner;

// public class BankingSystem {
//     static File file = new File("base.txt");

//     public static void main(String[] args) throws IOException { // Main
//         startCommand();
//     }

//     private static void startCommand() throws IOException {
//         Scanner check = new Scanner(System.in);
//         System.out.print("What you need for: ");
//         System.out.println(
//                 "\n(\'register\' - to create an account, \n\'acc\' - to search for your account, \n\'send\' - to send money to another user)");
//         switch (check.next()) {
//         case "register":
//             register();
//             break;
//         case "acc":
//             signIn();
//             break;
//         case "send":
//             send();
//             break;
//         default:
//             System.out.println("No such services");
//             break;
//         }
//         check.close();
//     }

//     private static void register() {
//         Scanner input = new Scanner(System.in);

//         System.out.print("Input name: ");
//         String user = input.nextLine();
//         System.out.print("Input password: ");
//         String password = input.nextLine();
//         input.close();

//         double amount = 100;

//         try {
//             String userData = ("Name: \'" + user + "\'" + " Password: \'" + password + "\'" + " In your account: "
//                     + amount + " (uah)\n");
//             FileWriter writer = new FileWriter("base.txt", true);
//             writer.write(userData);
//             writer.flush();
//             writer.close();
//             System.out.println("Your account: [ " + userData + " ]");
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }

//     private static void signIn() throws IOException {
//         Scanner userCheck = new Scanner(System.in);
//         System.out.print("Your name: ");
//         String nameCheck = userCheck.nextLine();
//         System.out.print("Your password: ");
//         String passwordCheck = userCheck.nextLine();

//         Scanner scanner = new Scanner(file);
//         Boolean founder = false;
//         String userLine = new String();
//         try {
//             while (scanner.hasNextLine()) {
//                 String line = scanner.nextLine();
//                 if (line.contains("Name: \'" + nameCheck + "\'" + " Password: " + "\'" + passwordCheck + "\'")) {
//                     founder = true;
//                     userLine = line;
//                 }
//             }

//             if (founder == true)
//                 System.out.println("Account has been found, your account: \n" + userLine);
//             else
//                 System.out.println("Wrong name or password");
//         } finally {
//             scanner.close();
//         }
//         userCheck.close();
//     }

//     private static void send() throws IOException {
//         Scanner moneySendProcess = new Scanner(System.in);
//         System.out.print("Enter your name: ");
//         String senderName = moneySendProcess.nextLine();
//         System.out.print("Enter your password: ");
//         String senderPassword = moneySendProcess.nextLine();

//         Scanner userInBase = new Scanner(file);
//         String userData = new String();
//         Boolean hasUser = false;
//         try {
//             while (userInBase.hasNextLine()) {
//                 String line = userInBase.nextLine();
//                 if (line.contains("Name: \'" + senderName + "\'" + " Password: " + "\'" + senderPassword + "\'")) {
//                     hasUser = true;
//                     userData = line;
//                 }
//             }
//         } finally {
//             System.out.println(hasUser ? "User found" : "User not found");
//             userInBase.close();
//         }

//         Scanner recipientInBase = new Scanner(file);
//         System.out.print("To whom money to send: ");
//         String recipientName = moneySendProcess.nextLine();

//         Boolean hasRecipient = false;
//         String recipientData = new String();

//         try {
//             while (recipientInBase.hasNextLine()) {
//                 String line = recipientInBase.nextLine();
//                 if (line.contains("Name: \'" + recipientName + "\'")) {
//                     hasRecipient = true;
//                     recipientData = line;
//                 }
//             }
//         } finally {
//             System.out.println(hasRecipient ? "Recipient found" : "Recipient not found");
//             recipientInBase.close();
//         }

//         if (hasUser && hasRecipient) {
//             System.out.print("How much: ");
//             Double amount = moneySendProcess.nextDouble();
//             System.out.println(amount + " (uah) has been sent to " + recipientName);
//             moneySendProcess.close();

//             double userMoney = Double.parseDouble(
//                     userData.substring(userData.indexOf("In your account: ") + 17, userData.indexOf(" (uah)")));
//             double recipientMoney = Double.parseDouble(recipientData
//                     .substring(recipientData.indexOf("In your account: ") + 17, recipientData.indexOf(" (uah)")));
//             System.out.println("На вашем счету теперь: " + (userMoney - amount) + "\nНа счету получателя теперь: "
//                     + (recipientMoney + amount));

//             Scanner rewriting = new Scanner(file);
//             try {
//                 while (rewriting.hasNextLine()) {
//                     String line = rewriting.nextLine();
//                     if (line.contains("Name: \'" + senderName + "\'" + " Password: " + "\'" + senderPassword + "\'")) {
//                         line.replace(line, ("Name: \'" + senderName + "\'" + " Password: " + "\'" + senderPassword
//                                 + "\'" + " In your account: " + userMoney));
//                     }
//                 }
//             } finally {
//                 rewriting.close();
//             }
//         }
//     }
// }