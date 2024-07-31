/*
 * Subject: Software Design Patterns
 * Creational Pattern -> Builder
 * Class: Student - Java.
 */
package com.ceron.data.transfer;

import java.util.ArrayList;
import java.util.List;
import com.ceron.builderpattern.InterfaceBuilder;

/**
 * Author: Fabrizio Bolaño
 */
public class Student {
    private String name;
    private int age;
    private String gender;
    private Address address;
    private List<Phones> phones;
    private List<Contacts> contacts;
    private Program program;

    private Student(String name, int age, String gender, Address address,
                    List<Phones> phones, List<Contacts> contacts, Program program) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phones = phones;
        this.contacts = contacts;
        this.program = program;
    }

    private Student(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Phones> getPhones() {
        return phones;
    }

    public void setPhones(List<Phones> phones) {
        this.phones = phones;
    }

    public List<Contacts> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contacts> contacts) {
        this.contacts = contacts;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    @Override
    public String toString() {
        return "Student{" + "Name=" + name + ", Age=" + age + ", Gender="
                + gender + ", \nAddress=" + address + ", \nPhone=" + phones
                + ", \nContacts=" + contacts + ", \nProgram=" + program + '}';
    }

    public static class StudentBuilder implements InterfaceBuilder<Student> {
        private String name;
        private int age;
        private String gender;
        private Address address;
        private final List<Phones> phones = new ArrayList<>();
        private final List<Contacts> contacts = new ArrayList<>();
        private Program program;

        public StudentBuilder() {
        }

        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public StudentBuilder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public StudentBuilder setAddress(String address, String city, String country, String locality) {
            this.address = new Address(address, city, country, locality);
            return this;
        }

        public StudentBuilder addPhones(String phoneNumber, String extension,
                                        String type) {
            phones.add(new Phones(phoneNumber, extension, type));
            return this;
        }

        public StudentBuilder addContacts(String names, String phoneNumber,
                                          String extension, String type, String address, String city,
                                          String country, String locality) {
            contacts.add(new Contacts(names, new Phones(phoneNumber, extension, type)
                    , new Address(address, city, country, locality)));
            return this;
        }

        public StudentBuilder addContacts(String names, String phoneNumber,
                                          String extension, String type) {
            contacts.add(new Contacts(names, new Phones(phoneNumber, extension, type)));
            return this;
        }

        public StudentBuilder setProgram(String programName, int numberOfSemesters) {
            this.program = new Program(programName, numberOfSemesters);
            return this;
        }

        @Override
        public Student build() {
            return new Student(name, age, gender, address, phones, contacts, program);
        }
    }
}
