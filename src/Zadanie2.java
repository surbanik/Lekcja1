import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Zadanie2 {

    //counting avg valueof array
    static double avgCounter(int numbers[]){
        //sum must be double, otherway avg value will be presented as int
        double sum = 0;
        double avg = 0;
        for (int number:numbers){
            sum += number;
        }
        return avg = sum/numbers.length;
    }
    //give max value from array
    static double maxCounter(int numbers[]){
        int max = 0;
        for (int number:numbers){
            if (max<=number) {
                max = number;
            }
        }
        return max;
    }
    //fills the elements of an array with the given values
    static void arraysFillingUp(int numbers[]){
        for (int i = 0; i< numbers.length;i++){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Podaj wartosc dla "+(i+1)+" elementu tablicy");
            numbers[i] = scanner.nextInt();
        }
    }
    //initializes arrays with the given number of elements
    static int[] arraysInitialization(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj wielkosc tablicy");
        int size = scanner.nextInt();
        int[] numbers = new int[size];
        return numbers;

    }

    public static void main(String[] args) {

        /*
        1. Program powinien poprosić użytkownika o podanie liczby całkowitej.
        2. Następnie program powinien stworzyć tablicę po podanym przez użytkownika rozmiarze.
        3. Następnie poprosić użytkownika o podanie liczb aby zapełnić nimi tablicę (jeżeli użytkownik w pkt 1 podał liczbę 5 jako rozmiar, to w pkt 3 oczekujemy że poda 5 liczb i każda z nich zapiszemy w tablicy)
        4. Po zakończeniu wpisywania liczb przez użytkownika, program powinien wypisać jaka była średnia liczb wprowadzonych przez użytkownika oraz wartość maksymalna
         */

        int[] numbers = arraysInitialization();
        arraysFillingUp(numbers);
        double avg= avgCounter(numbers);
        double max= maxCounter(numbers);
        
        System.out.println("Average value of elements is: "+avg);
        System.out.println("Maximum value for elements is: "+max);
    }
}
