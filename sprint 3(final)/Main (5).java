import java.util.Scanner;

public class Main{
  
  private String name;
  private String surname;
  private double studentNumber;
  private String email;
  private String contacts;
  private String room;

  public Main (String name, String surname, double studentNumber, String email, String contacts, String room){
    this.name = name;
    this.surname = surname;
    this.studentNumber = studentNumber;
    this.email = email;
    this.contacts = contacts;
    this.room = room;
  }
  public void setName(String name){
    this.name = name;
  }  
  public void setSurname(String surname){
    this.surname = surname;
  }
  public void setStudentNumber(double studentNumber){
    this.studentNumber = studentNumber;
  }
  public void setEmial(String email){
    this.email = email;
  }
  public void setContacts(String contacts){
    this.contacts = contacts;
  }
  public void setRoom(String room){
    this.room = room;
  }


  public String getName(){
    return name;
  }
  public String getSurname(){
    return surname;
  }
  public double getStudentNumber(){
    return studentNumber;
  }
  public String getEmail(){
    return email;
  }
  public String getContacts(){
    return contacts;
  }
  public String getRoom(){
    return room;
  }

  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Surname: ");
        String surname = scanner.nextLine();

        System.out.print("Enter Student Number: ");
        double studentNumber = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Contacts: ");
        String contacts = scanner.nextLine();

        System.out.println("Select Room Type(choose 1,2,3):");
        System.out.println("1. Single");
        System.out.println("2. Double");
        System.out.println("3. Triple");

        int roomChoice = scanner.nextInt();
        String room;

        if (roomChoice == 1) {
            room = "Single";
        } else if (roomChoice == 2) {
            room = "Double";
        } else if (roomChoice == 3) {
            room = "Triple";
        } else {
            System.out.println("Invalid room choice, setting to Single by default.");
            room = "Single";
        }

        Main student = new Main(name, surname, studentNumber, email, contacts, room);

        System.out.println("Student Information:");
        System.out.println("Name: " + student.getName());
        System.out.println("Surname: " + student.getSurname());
        System.out.println("Student Number: " + student.getStudentNumber());
        System.out.println("Email: " + student.getEmail());
        System.out.println("Contacts: " + student.getContacts());
        System.out.println("Room: " + student.getRoom());
    }
}
