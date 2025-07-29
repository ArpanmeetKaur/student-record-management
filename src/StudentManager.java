package src;
import java.io.*;
import java.util.*;

public class StudentManager{

    //defines a constant that holds the name of the file we’ll store students in(final= makes the variable constant)
    public static final String FILE_NAME = "students.txt";

    //ADD Student
    public static boolean addStudent(Student s) throws IOException{
        FileWriter writer = new FileWriter(FILE_NAME, true);  //Creates a FileWriter in append mode (doesn’t overwrite existing data) 
        writer.write(s.toFileString()); //converts the student object to String and writes to file
        writer.close(); //closes to save memory and avoid issues
        return true;
    }

    //GET All Student
    public static List<Student> getAllStudents() throws IOException{
        List<Student> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));  //Opens students.txt so we can read it line by line.

        String line;
        while ((line = reader.readLine()) != null) {
        list.add(Student.fromString(line));   //Converts each line into a Student object using the fromString() method and adds it to the list
        }
        reader.close();
        return list;
    }

    //DELETE Student by id
    public static boolean deleteStudent(String id) throws IOException{
        List<Student> list = getAllStudents();
        boolean deleted = false;
        FileWriter writer= new FileWriter(FILE_NAME); //Opens the file again but not in append mode(will overwrite this)
        for(Student s : list){ 
            if (!s.getId().equals(id)) {
            writer.write(s.toFileString());             //the student with the matching ID will be skipped (deleted)
            }
        }
        writer.close();
        return deleted;
    }
}