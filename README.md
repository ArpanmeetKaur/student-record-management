# STUDENT RECORD MANAGEMENT SYSTEM (SRMS)
This is web-based Student Record Management System built using HTML, CSS (frontend) and Java with Servlets and file handling (backend). It allows you to add, view, and delete student records.

## FEATURES
- Add new student records
- View all students
- Delete a student by ID
- Data stored using plain file handling
- Simple UI with form inputs

## PROJECT STRUCTURE
student-record-management/
├── index.html
├── style.css
├── src/
│ ├── Student.java
│ ├── StudentManager.java
│ └── StudentServlet.java
├── WEB-INF/
│ ├── web.xml
│ └── classes/ ← compiled .class files go here

## HOW TO RUN
1. Clone this repo or download the ZIP.
2. Place the project in `webapps` folder of Apache Tomcat.
3. Compile Java files using:
    javac -cp "C:\apache-tomcat-9.0.107\lib\servlet-api.jar" -d WEB-INF\classes src\*.java
4. Start Tomcat via startup.bat inside the bin folder.
5. Open in browser:
    http://localhost:8080/student-record-management/index.html

## PROJECT PREVIEW
<img width="1366" height="678" alt="SRMS(Preview)" src="https://github.com/user-attachments/assets/8904d6d5-9acf-4f95-b5a3-dd607543415f" />


