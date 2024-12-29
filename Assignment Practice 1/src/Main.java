import models.Student;
import models.Teacher;
import models.School;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File studentFile = new File("/Users/alihan/Documents/Java 2nd trimester/Assignment Practice 1/src/students.txt");
        File teacherFile = new File("/Users/alihan/Documents/Java 2nd trimester/Assignment Practice 1/src/teachers.txt");

        School school = new School();

        Scanner scStudent = new Scanner(studentFile);
        while (scStudent.hasNextLine()) {
            String line = scStudent.nextLine();
            String[] parts = line.split(" ");

            String name = parts[0];
            String surname = parts[1];
            int age = Integer.parseInt(parts[2]);
            boolean gender = parts[3].equalsIgnoreCase("Male");

            Student student = new Student(name, surname, age, gender);
            for (int i = 4; i < parts.length; i++) {
                student.addGrade(Integer.parseInt(parts[i]));
            }
            student.calculateGPA();
            school.addMember(student);
        }
        scStudent.close();

        Scanner scTeacher = new Scanner(teacherFile);
        while (scTeacher.hasNextLine()) {
            String line = scTeacher.nextLine();
            String[] parts = line.split(" ");

            String name = parts[0];
            String surname = parts[1];
            int age = Integer.parseInt(parts[2]);
            boolean gender = parts[3].equalsIgnoreCase("Male");
            String subject = parts[4];
            int yearsOfExperience = Integer.parseInt(parts[5]);
            int salary = Integer.parseInt(parts[6]);

            Teacher teacher = new Teacher(name, surname, age, gender, subject, yearsOfExperience, salary);

            if (teacher.getYearsOfExperience() > 10) {
                teacher.giveRaise(5);
            }

            school.addMember(teacher);
        }
        scTeacher.close();
        school.sortMembersBySurname();

        System.out.println(school);

    }
}