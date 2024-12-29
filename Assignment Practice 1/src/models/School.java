package models;

import java.util.ArrayList;

public class School {
    private ArrayList<Person> members = new ArrayList<>();

    public void addMember(Person person) {
        members.add(person);
    }

    public void sortMembersBySurname() {
        members.sort((a, b) -> a.getSurname().compareToIgnoreCase(b.getSurname()));
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("members:\n");
        for (Person member : members) {
            result.append(member).append("\n");
        }
        return result.toString();
    }

}
