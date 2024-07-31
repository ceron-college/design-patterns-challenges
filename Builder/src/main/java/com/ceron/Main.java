/*
 * Subject: Software Design Patterns
 * Creational Pattern -> Builder
 * Class Type: Main()
 */
package com.ceron;

import com.ceron.data.transfer.Student;

/**
 * Author: Fabrizio Bolaño
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Student student = new Student.StudentBuilder().setName("Gilberto Santarrosa").setGender("Male").setAge(49).setAddress("Santurce San Juan", "Puerto Rico", "Puerto Rico", "03400").addContacts("Fania All Star", "555777888", "123", "Work", "New York", "United States", "USA", "10023").addContacts("Ruben Blades", "202020", null, "Mobile").addPhones("88889999", null, "Mobile").addPhones("1010103030", null, "Work").setProgram("Computer Science", 8).build();
        System.out.println(student);
    }
}