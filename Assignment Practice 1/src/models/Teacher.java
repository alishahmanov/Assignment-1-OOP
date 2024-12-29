package models;

public class Teacher extends Person {
    private String subject;
    private int yearsOfExperience;
    private int salary;

    public Teacher(String name, String surname, int age, boolean gender, String subject, int yearsOfExperience, int salary) {
        super(name, surname, age, gender);
        this.subject = subject;
        this.yearsOfExperience = yearsOfExperience;
        this.salary = salary;
    }

    public void giveRaise(int percent) {
        this.salary = (int)(this.salary * (1 + percent / 100.0));
    }

    public int getSalary() {
        return salary;
    }

    public String getSubject() {
        return subject;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    @Override
    public String toString() {
        return super.toString() + " I teach " + subject + ", have " + yearsOfExperience + " years of experience, and earn " + salary + " per year.";
    }
}
