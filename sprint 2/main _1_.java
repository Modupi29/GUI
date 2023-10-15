//Name          : Modupi Hope
//Surname       : Dlamini
//Student number: 4154846
//Project Name  : Hostel Management System



import java.util.Scanner;
public class Main
{
    public static void main(String[] args) {
        System.out.println("The purpose of the Hostel Management System project is to create a user-friendly oftware that efficiently manages all aspects of hostel operations, from room reservations to billing.");
        System.out.println("\nWelcome to the User Registration System.\n");
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter your Name : ");
        String Name = scan.nextLine();
        System.out.println("Enter your Surname : ");
        String Surname = scan.nextLine();
        System.out.println("Enter your Student number : ");
        int Student_number = scan.nextInt();
        System.out.println("Enter your Contacts : 0");
        int Contacts = scan.nextInt();
        
        System.out.println("\nThanks for registering ");
        System.out.println("Name : " + Name);
        System.out.println("Surname : "+ Surname);
        System.out.println("Student number : "+ Student_number);
        System.out.println("Contacts : "+ Contacts);
    }
}
