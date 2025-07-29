package src;
public class Student{
    private String id;
    private String name;
    private String email;
    private String course;
    private String age;

    public Student(String id, String name,String email, String course,String age){
        this.id = id;
        this.name = name;
        this.email = email;
        this.course = course;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCourse() {
        return course;
    }

    public String getAge() {
        return age;
    }

    //Convert Student object into comma-separated line for dtoring in text file
    public String toFileString(){
        return id + "," + name + "," + email + "," + course + "," + age + "\n";
    }

    //Splits the line into parts and passes them to the constructor
    public static Student fromString(String line){
        String[] parts = line.split(",");
        return new Student(parts[0], parts[1], parts[2], parts[3], parts[4]);
    }

    //to access the private id field from outside
    public String getId(){
        return id;
    }

    //overriding the default toString() behavior.(instead of printing plain text to tabular form)
    @Override
    public String toString(){
        return "<tr>" +
                "<td>" + id + "</td>" +
                "<td>" + name + "</td>" +
                "<td>" + email + "</td>" +
                "<td>" + course + "</td>" +
                "<td>" + age + "</td>" +
                "<td><form action='students' method='post'>" +
                "<input type='hidden' name='action' value='delete'>" +
                "<input type='hidden' name='id' value='" + id + "'>" +
                "<button type='submit'>Delete</button></form></td>" +
                "</tr>";
    }
}