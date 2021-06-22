package AccountAndCard;

import People.AccountsOwner;

import java.util.Scanner;

public class Account {
    private AccountsOwner accountsOwner;
    private int bankBalance; // >=0, <INF
    private String accountsPIN;
    private int numberOfAttemptsForCardsPIN;
    private int numberOfAttemptsForAccountsPIN;

    private int numberOfCards; // >= 0
    private Card[] arrayOfCards;

    public void print(){
        accountsOwner.print();
        System.out.println("Stan konta: " + bankBalance);
        System.out.println("Liczba kart: " + numberOfCards);
        for (int i=0; i<numberOfCards; ++i) {
            System.out.println( "Karta nr " + (i+1) );
            arrayOfCards[i].printOnlyCardsOwner();
        }
    }

    public Account(AccountsOwner __accountsOwner, int __bankBalance, String __accountsPIN, int __numberOfAttemptsForAccountsPIN, int __numberOfAttemptsForCardsPIN, int __numberOfCards){
        accountsOwner = __accountsOwner;
        bankBalance = __bankBalance;
        accountsPIN = __accountsPIN;
        numberOfAttemptsForAccountsPIN = __numberOfAttemptsForAccountsPIN;
        numberOfAttemptsForCardsPIN = __numberOfAttemptsForCardsPIN;

        numberOfCards = __numberOfCards;
        arrayOfCards = new Card[numberOfCards];
        for (int i = 0; i < numberOfCards; i++) {
            arrayOfCards[i] = Card.createCard( bankBalance, numberOfAttemptsForCardsPIN );
        }
    }

    public Account(Account other){
        accountsOwner = other.accountsOwner;
        bankBalance = other.bankBalance;
        accountsPIN = other.accountsPIN;
        numberOfAttemptsForAccountsPIN = other.numberOfAttemptsForAccountsPIN;
        numberOfAttemptsForCardsPIN = other.numberOfAttemptsForCardsPIN;


        numberOfCards = other.numberOfCards;
        arrayOfCards = new Card[numberOfCards];
        System.arraycopy(
                other.arrayOfCards,
                0,
                arrayOfCards,
                0,
                numberOfCards
                        );
    }

    public AccountsOwner getAccountsOwner(){
        return accountsOwner;
    }
    private void setAccountsOwner(AccountsOwner __accountsOwner) { accountsOwner = __accountsOwner; }

    public int getBankBalance() {
        return bankBalance;
    }
    private void setBankBalance(int __bankBalance) { bankBalance = __bankBalance; }

    private String getAccountsPIN() { return accountsPIN; }
    private void setAccountsPIN(String __accountsPIN) { accountsPIN = __accountsPIN; }

    public int getNumberOfAttemptsForAccountsPIN() { return numberOfAttemptsForAccountsPIN; }
    private void setNumberOfAttemptsForAccountsPIN(int __numberOfAttemptsForAccountsPIN) { numberOfAttemptsForAccountsPIN = __numberOfAttemptsForAccountsPIN; }

    public int getNumberOfAttemptsForCardsPIN() { return numberOfAttemptsForCardsPIN; }
    private void setNumberOfAttemptsForCardsPIN(int __numberOfAttemptsForCardsPIN) { numberOfAttemptsForCardsPIN = __numberOfAttemptsForCardsPIN; }

    public int getNumberOfCards() { return numberOfCards; }

    public Card getCard(int cardsNumber) { return arrayOfCards[cardsNumber]; }

    public Card[] getArrayOfCards() { return arrayOfCards; }

    public static Account createAccount() {
        AccountsOwner __accountsOwner = AccountsOwner.createAccountsOwner();
        int __bankBalance = Account.createBankBalance();
        String __accountsPIN = Account.createAccountsPIN();
        int __numberOfAttemptsForAccountsPIN = Account.createNumberOfAttemptsForAccountsPIN();
        int __numberOfAttemptsForCardsPIN = Card.createNumberOfAttemptsForCardsPIN();
        int __numberOfCards = Account.createNumberOfCards();

        return new Account(__accountsOwner, __bankBalance, __accountsPIN, __numberOfAttemptsForAccountsPIN, __numberOfAttemptsForCardsPIN, __numberOfCards);
    }

    private static int createNumberOfCards() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj liczbę kart:");
        int __numberOfCards = scanner.nextInt();

        return __numberOfCards;
    }

    private static int createNumberOfAttemptsForAccountsPIN() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj liczbę prób dla kodu PIN konta:");
        int __numberOfAttemptsForAccountsPIN = scanner.nextInt();

        return __numberOfAttemptsForAccountsPIN;
    }

    private static String createAccountsPIN() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj PIN do konta:");
        String __accountsPIN = scanner.next();

        return __accountsPIN;
    }

    private static int createBankBalance() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj stan konta:");
        int __bankBalance = scanner.nextInt();

        return __bankBalance;
    }

    public void PayInMoney(int amount){
        bankBalance += amount;

        for (Card card: arrayOfCards) {
            card.payInMoney(amount);
        }
    }

    public void payOutMoney(int amount){
        if(bankBalance >= amount){
            bankBalance -= amount;

            for (Card card: arrayOfCards) {
                card.payOutMoney(amount);
            }

            //System.out.println("Operation finished succesfully in your account.");
        }
        else{
            //System.out.println("To less money in your account.");
        }
    }

    public void payOutMoney(int cardsNumber, int amount){
        if(bankBalance >= amount){
            bankBalance -= amount;

            for (Card c: arrayOfCards) {
                c.payOutMoney(amount);
            }

            System.out.println("Operation finished succesfully in your card.");
        }
        else{
            System.out.println("To less money in your card.");
        }
    }
}
