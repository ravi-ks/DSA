package harish;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int noOfStudents = in.nextInt();
        List<Student> studentList = new ArrayList<>();
        for(int i = 0; i < noOfStudents; i++){
            int id = in.nextInt();
            String name = in.next();
            int marks = in.nextInt();
            int age = in.nextInt();

            Student student = new Student(id, name, marks, age);
            studentList.add(student);
        }
        String studentNameToSearch = in.next();

        //call methods
        Student studentFound = findStudentWithMaximumMarks(studentList);
        if(studentFound != null)
            System.out.println(studentFound);
        else
            System.out.println("No Student found with mentioned attribute");

        Student studentWithGivenName = searchStudentByName(studentList, studentNameToSearch);
        if(studentWithGivenName != null)
            System.out.println(studentWithGivenName);
        else
            System.out.println("No Student found with mentioned attribute");
    }

    public static Student findStudentWithMaximumMarks(List<Student> studentList){
        Student studentToReturn = null;
        studentToReturn = studentList.stream().max(Comparator.comparingInt(Student::getMarks)).get();
        return studentToReturn;
    }

    public static Student searchStudentByName(List<Student> studentList, String studentName){
        Student studentToReturn = null;
        for(Student student: studentList){
            if(student.getName().equalsIgnoreCase(studentName)) {
                studentToReturn = student;
                break;
            }
        }
        return studentToReturn;
    }
}
