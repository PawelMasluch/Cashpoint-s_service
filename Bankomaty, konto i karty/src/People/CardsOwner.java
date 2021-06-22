package People;

import java.util.Scanner;

public class CardsOwner extends Person {

    public CardsOwner(String __name, String __surname){
        super(__name, __surname);
    }

    public CardsOwner(CardsOwner other){
        super( other.getName(), other.getSurname() );
    }

    public static CardsOwner createCardsOwner() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj dane właściciela karty.");

        System.out.println("Imie:");
        String __name = scanner.next();

        System.out.println("Nazwisko:");
        String __surname = scanner.next();

        return new CardsOwner(__name, __surname);
    }

    public void print(){
        System.out.println("Dane właściciela karty.");
        System.out.println( "Imie: " + this.getName() );
        System.out.println( "Nazwisko: " + this.getSurname() );
        System.out.println();
    }
}
