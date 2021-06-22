package People;

import java.util.Scanner;

public class Person {
    private String name;
    private String surname;

    public Person(String __name, String __surname){
        name = __name;
        surname = __surname;
    }

    public Person(Person other){
        name = other.name;
        surname = other.surname;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public void setName(String __name){
        name = __name;
    }

    public void setSurname(String __surname){
        surname = __surname;
    }

    /*
    public static Person createPerson() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Imie:");
        String __name = scanner.next();

        System.out.println("Nazwisko:");
        String __surname = scanner.next();

        return new Person(__name, __surname);
    }
     */

    /*
    public void print(){
        System.out.println("Imie: " + name);
        System.out.println("Nazwisko: " + surname);
    }
    */
}
