import AccountAndCard.Account;
import AccountAndCard.Card;

import java.util.Random;

public class Cashpoint { // has infinitely much money
    public static void payOutMoney(){
        Random random = new Random();
        Account account = Account.createAccount();

        Cashpoint[] netOfCashpoints = new Cashpoint[5];

        System.out.println("Wybierz bankomat:");
        int nr = random.nextInt(5);
        System.out.println("Pobieram pieniądze z bankomatu nr " + nr);

        System.out.println("Którą kartą chcesz wypłacić?");
        int cardsNumber = random.nextInt( account.getNumberOfCards() );
        System.out.println("Karta nr " + cardsNumber);

        System.out.println("Podaj kwotę do wypłacenia:");
        int amount = random.nextInt(1000);
        System.out.println("Kwota do wypłacenia: " + amount);

        account.payOutMoney(cardsNumber, amount);

        account.print();
    }

}
