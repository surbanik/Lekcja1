import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Zadanie1 {

    /*
    Wymagania:
    1. Program losuje liczbę z zakresu 0-99.
    2. Program wyświetla komunikat z prośbą o rozpoczęcie zgadywania liczby całkowitej z zakresu 0-99
    3. Program wczytuje liczbę wpisaną przez użytkownika.
    4. Użytkownik powinien mieć maksymalnie 5 prób zgadywania.
    5. Zachowanie programu podczas podania niepoprawnej liczby:
    - w przypadku podania zbyt dużej liczby wypisać do konsoli: "Your number is GREATER than the one you are trying to guess"
    - w przypadku podania zbyt małej liczby wypisać do konsoli: "Your number is LOWER than the one you are trying to guess"
    - podać ile prób zostało mu do końca.
    - jeżeli nie była to jego ostatnia próba to wypisać tekst: "Please try again"
    6. Jeżeli użytkownik zgadł liczbę, program powinien wydrukować tekst "You guessed it!"
    7. Jeżeli w ciągu 5 prób nie udało się odgadnąć liczby użytkownik, program ma wydrukować wiadomość:
    "Sorry you didn't guess the number, the answer was: "
    oraz dopisać do niej jaka była wartość liczby której nie udało się odgadnąć
    Podpowiedź:
    Aby zakończyć wykonywanie pętli wcześniej niż wskazuje na to jej warunek można się posłużyć poleceniem 'break;'
     */



    //checking is given number is lower, greater or equal to wanted number
    public static boolean checker(int numberToGuess, int userNumber){
        if (numberToGuess == userNumber){
            System.out.println("You guessed it!");
            return true;
        }else if (numberToGuess > userNumber){
            System.out.println("Your number is LOWER than the one you are trying to guess");
            return false;
        }else if (numberToGuess < userNumber) {
            System.out.println("Your number is GREATER than the one you are trying to guess");
            return false;
        }
        return false;
    }
    //extra method, checking is given number is in the range
    public static boolean rangeChecker(int userNumber){
        if (userNumber >= 0 && userNumber < 100)
            return false;
        else {
            System.out.println("Your number is out of range. GAME OVER");
            return true;
        }
    }
    //checking number of chances left
    public static boolean isLastChance(int presentTry, int numberToGuess, int numberOfChances){
        if (presentTry==numberOfChances) {
            System.out.println("Sorry you didn't guess the number, the answer was: " + numberToGuess);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberToGuess = new Random().nextInt(100);
        //if we would like to change number of chances for player, we can change it here
        int numberOfChances = 5;
        int presentTry;

        System.out.println("Podaj liczbę z zakresu 0 - 99");
        //extra, in case user will give another value than intiger
        try {
            int userNumber = scanner.nextInt();
            for (presentTry=1; presentTry<=numberOfChances; presentTry++ ){
                if (rangeChecker(userNumber)){
                    break;
                }
                if (checker(numberToGuess, userNumber)){
                    break;
                }else{
                    if (isLastChance(presentTry, numberToGuess, numberOfChances))
                        break;
                }
                int numberOfChancesLeft = numberOfChances-presentTry;
                System.out.println("Number of chances left: " + numberOfChancesLeft);
                System.out.println("Please try again ");
                userNumber = scanner.nextInt();
            }
        }catch(InputMismatchException e){
            System.out.println("Nie podano liczby całkowitej. GAME OVER");
        }

    }
}
