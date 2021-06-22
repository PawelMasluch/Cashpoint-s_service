package People;

import java.util.Scanner;

public class AccountsOwner extends Person {

    public AccountsOwner(String __name, String __surname){
        super(__name, __surname);
    }

    public AccountsOwner(AccountsOwner other){
        super( other.getName(), other.getSurname() );
    }

    public static AccountsOwner createAccountsOwner() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj dane właściciela konta.");

        System.out.println("Imie:");
        String __name = scanner.next();

        System.out.println("Nazwisko:");
        String __surname = scanner.next();

        return new AccountsOwner(__name, __surname);
    }

    public void print(){
        System.out.println("Dane właściciela konta.");
        System.out.println( "Imie: " + this.getName() );
        System.out.println( "Nazwisko: " + this.getSurname() );
        System.out.println();
    }
}