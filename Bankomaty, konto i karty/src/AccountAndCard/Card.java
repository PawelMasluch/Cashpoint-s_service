package AccountAndCard;

import People.CardsOwner;

import java.util.Scanner;

public class Card {
    private CardsOwner cardsOwner;
    private int bankBalance; //>=0, <INF
    private String cardsPIN;
    private int numberOfAttemptsForCardsPIN;

    public Card(CardsOwner __cardsOwner, int __bankBalance, String __cardsPIN, int __numberOfAttemptsForCardsPIN){
        cardsOwner = __cardsOwner;
        bankBalance = __bankBalance;
        cardsPIN = __cardsPIN;
        numberOfAttemptsForCardsPIN = __numberOfAttemptsForCardsPIN;
    }

    public Card(Card other){
        cardsOwner = other.cardsOwner;
        bankBalance = other.bankBalance;
        cardsPIN = other.cardsPIN;
        numberOfAttemptsForCardsPIN = other.numberOfAttemptsForCardsPIN;
    }

    public CardsOwner getCardsOwner() { return cardsOwner; }
    private void setCardsOwner(CardsOwner __cardsOwner) { cardsOwner = __cardsOwner; }

    public int getBankBalance() { return bankBalance; }
    private void setBankBalance(int __bankBalance) { bankBalance = __bankBalance; }

    private String getCardsPIN() { return cardsPIN; }
    private void setCardsPIN(String __cardsPIN) { cardsPIN = __cardsPIN; }

    public int getNumberOfAttemptsForCardsPIN() { return numberOfAttemptsForCardsPIN; }
    private void setNumberOfAttemptsForCardsPIN(int __numberOfAttemptsForCardsPIN) { numberOfAttemptsForCardsPIN = __numberOfAttemptsForCardsPIN; }

    static int createNumberOfAttemptsForCardsPIN() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj liczbę prób dla kodu PIN karty:");
        int __numberOfAttemptsForCardsPIN = scanner.nextInt();

        return __numberOfAttemptsForCardsPIN;
    }

    private static int createBankBalance() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj stan konta na karcie:");
        int __bankBalance = scanner.nextInt();

        return __bankBalance;
    }

    private static String createCardsPIN() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj PIN do karty:");
        String __cardsPIN = scanner.next();

        return __cardsPIN;
    }

    public static Card createCard() {
        CardsOwner __cardsOwner = CardsOwner.createCardsOwner();
        int __bankBalance = Card.createBankBalance();
        String __PIN = Card.createCardsPIN();
        int __numberOfAttemptsForCardsPIN = Card.createNumberOfAttemptsForCardsPIN();

        return new Card(__cardsOwner, __bankBalance, __PIN, __numberOfAttemptsForCardsPIN);
    }

    public static Card createCard(int __bankBalance) {
        CardsOwner __cardsOwner = CardsOwner.createCardsOwner();
        String __PIN = Card.createCardsPIN();
        int __numberOfAttemptsForCardsPIN = Card.createNumberOfAttemptsForCardsPIN();

        return new Card(__cardsOwner, __bankBalance, __PIN, __numberOfAttemptsForCardsPIN);
    }

    public static Card createCard(int __bankBalance, int __numberOfAttemptsForCardsPIN) {
        CardsOwner __cardsOwner = CardsOwner.createCardsOwner();
        String __PIN = Card.createCardsPIN();

        return new Card(__cardsOwner, __bankBalance, __PIN, __numberOfAttemptsForCardsPIN);
    }

    public void payOutMoney(int amount){
        if(bankBalance >= amount){
            bankBalance -= amount;
            //System.out.println("Operation finished succesfully in your card.");
        }
        else{
            //System.out.println("To less money in your card.");
        }
    }

    public void payInMoney(int amount) {
        bankBalance += amount;
    }

    public void print(){
        System.out.println("Wypisuję informacje o karcie.");

        cardsOwner.print();
        System.out.println("Stan konta: " + bankBalance);
    }

    void printOnlyCardsOwner(){
        System.out.println("Wypisuję informacje o karcie.");

        cardsOwner.print();
    }
}
