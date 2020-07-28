package be.vdab.Mockaroo;

import java.util.ArrayList;

public class TestMockaroo {
    public static void main(String[] args) throws PersonException {

        PersonDAO personDAO = new PersonDAO(ConnectionUsersDB.address, ConnectionUsersDB.user, ConnectionUsersDB.password);
        BitcoinDAO bitcoinDAO = new BitcoinDAO(ConnectionUsersDB.address, ConnectionUsersDB.user, ConnectionUsersDB.password);

        // test getPersonById
        System.out.println("\nTest getPersonById");
        Person person1 = personDAO.getPersonById(2);
        System.out.println(person1.toString());

        /* test createPerson
        System.out.println("\nTest createPerson");
        Person person2 = new Person(11,"Barack","Obama","barrie@hotmail.com","Male","137.148.99.5",11);
        personDAO.createPerson(person2);
        Person person3 = personDAO.getPersonByLastName("Obama");
        System.out.println(person3.toString());*/

        // test updatePerson
        System.out.println("\nTest updatePerson");
        Person person4 = personDAO.getPersonById(8);
        person4.setLastName("Obama");
        personDAO.updatePerson(person4);
        System.out.println(person4.toString());

        // test deletePerson
        System.out.println("\nTest deletePerson");
        personDAO.deletePerson("Bush");
        if (personDAO.getPersonByLastName("Bush") == null) {
            System.out.println("deletePerson method works fine");
        }

        // test getBalance
        System.out.println("\nTest getBalance");
        double balance = bitcoinDAO.getBalance("1D3HfEk6rd33RJ2wgoeEsyBgQvYf2dhneF");
        System.out.println("balance: " + balance);

    }
}
