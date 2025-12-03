import java.util.Scanner;
class Student2 {
    int rollNumber;
    String studentName;
    int[] marks = new int[3];

    void validateMarks() throws InvalidMarksException {
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] < 0 || marks[i] > 100) {
                throw new InvalidMarksException();
            }
        }
    }

    double calculateAverage() {
        int sum = 0;
        for (int i = 0; i < marks.length; i++) {
            sum+=marks[i];
        }
        return sum / marks.length;
    }

    void displayResult() {
        System.out.println("Name: " + studentName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: ");
        for(int m : marks){
            System.out.println(m);
        }
        double avg = calculateAverage();
        System.out.println("Average: " + avg);
        if(avg>=33){
            System.out.println("Result Status: Pass");
        }
        else{
            System.out.println("Reslut Status: Fail");
        }
    }
}

class InvalidMarksException extends Exception {
    InvalidMarksException() {
        System.out.println("Marks cannot be negative");
    }
}

class ResultManager {
    int[] marks = new int[3];
    int count = 0;
    Scanner sc = new Scanner(System.in);
    Student2[] students = new Student2[100]; 
    void addStudent(){
        try{
            System.out.println("Enter Student Name: ");
            String name = sc.nextLine();
            sc.nextLine();
            System.out.println("Enter roll number: ");
            int roll = sc.nextInt();
            System.out.println("Enter marks: ");
            for(int i =0;i<marks.length;i++){
                marks[i] = sc.nextInt();
            }
            Student2 obj = new Student2(); // important
            obj.rollNumber = roll;
            obj.studentName = name;
            obj.marks = marks;
            obj.validateMarks();
            students[count++] = obj;
            System.out.println("Student added successfully!");
        }
        catch (InvalidMarksException e) {
            System.out.println("Error: Invalid marks entered!");
        }
        catch (NullPointerException e){
            System.out.println("Error: Marks cannot be empty");
        }
    }

    void showStudentDetails(){
        System.out.print("Enter Roll Number to search: ");
        int roll = sc.nextInt();
        boolean found = false;
        for(int i=0;i<count;i++){
            if(students[i].rollNumber == roll){
                students[i].displayResult();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
    }

    void mainMenu(){
        while(true){
            System.out.println("===== Student Result Management System ===== ");
            System.out.println("1. Add Student ");
            System.out.println("2. Show Student Details");
            System.out.println("3. Exit ");
            System.out.println("Enter your choice: ");
            int n = sc.nextInt();
            if(n==1){
                addStudent();
            }
            if(n==2){
                showStudentDetails();
            }
            if(n==3){
                System.out.println("Exiting program. Thank you! ");
                break;
            }
        }
    }

}

class Assign3 {
    public static void main(String[] args) {
        ResultManager obj1 = new ResultManager();
        obj1.mainMenu();
    }
}
