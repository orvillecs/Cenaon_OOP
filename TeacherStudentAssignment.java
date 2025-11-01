public class TeacherStudentAssigment {
    public static void main(String[] args) {

        Student s1 = new Student("Ana Santos", 19, "Female", "S1005");
        
        Student s2 = new Student("Justin Nabunturan", 19, "Male", "S1034");
        
        Course c1 = new Course("CS100", "Computer Programming");
        Course c2 = new Course("CS101", "Programming Fundamentals");
        Course c3 = new Course("CS102", "Data Structures");

        Course[] courses = { c1, c2, c3 };

        Teacher t1 = new Teacher("Mr. Dela Cruz", 45, "Male", "Computer Studies", courses);

        s1.displayStudent();
        s2.displayStudent();
        
        t1.displayTeacher();
    }
}

class Person {
    String name;
    int age;
    String gender;

    Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
    }
}

class Student extends Person {
    String studentId;

    Student(String name, int age, String gender, String studentId) {
        super(name, age, gender);
        this.studentId = studentId;
    }

    void displayStudent() {
      System.out.println("\n——— Student Information ———");
        displayInfo();
        System.out.println("Program: " + program);
        System.out.println("Student ID: " + studentId);
        System.out.println("———————————————————————————");
    }
}

class Teacher extends Person {
    String department;
    Course[] courses;

    Teacher(String name, int age, String gender, String department, Course[] courses) {
        super(name, age, gender);
        this.department = department;
        this.courses = courses;
    }

    void displayTeacher() {
      System.out.println("\n——— Teacher Information ———");
        displayInfo();
        System.out.println("Department: " + department);
        System.out.println("Courses Handled:");
        for (Course c : courses) {
            c.displayCourse();
        }
        System.out.println("———————————————————————————");


        System.out.println("\n——— Courses ———");

        for (Course c : courses) {
            c.displayCourse();
        }
        System.out.println("———————————————————————————");
    }
}

class Course {
    String courseCode;
    String courseName;

    Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    void displayCourse() {
        System.out.println("  " + courseCode + " - " + courseName);
    }
}
