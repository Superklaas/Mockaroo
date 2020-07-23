package be.vdab.Mockaroo;

public class TestMockaroo {
    public static void main(String[] args) throws PersonException {

        PersonDAO personDAO = new PersonDAO(ConnectionUsersDB.address, ConnectionUsersDB.user, ConnectionUsersDB.password);

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

    }
}
