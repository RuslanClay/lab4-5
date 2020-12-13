package com.company;

import java.util.Vector;

public class Main {
    public static void main(String[] args) {
	    PersonsVector personsVector = new PersonsVector();
	    Vector<Person> persons = personsVector.getPersonsVector();
        for (int i=0; i<persons.size(); i++) {
            System.out.println("----------");
            System.out.println(persons.get(i).getId());
            System.out.println(persons.get(i).getName());
            System.out.println(persons.get(i).getSurname());
            System.out.println(persons.get(i).getHeight());
            System.out.println(persons.get(i).getWeight());
            System.out.println("----------");
        }
    }
}
