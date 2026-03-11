package loje;   //Tregon se ky kod është pjesë e një pakete të quajtur loje. Paketat përdoren për të organizuar kodin.

//si fillim importojme paketen

import java.util.*;     //importon te gjitha klasat nga paketa java.util (Scanner,Random,Set)

//krijojme nje klase qe do te ruaje emrin e lojtarit, pozicionin, konstruktorin

class Lojtari { //Krijon nje tip te ri objekti qe perfaqeson lojtarin
    String emri;    //variabel qe ruan emrin e lojtarit
    int pozicioni;  //variabel qe ruan pozicionin aktual ne tabele (fillon nga 0)

    Lojtari(String emri){       //Perdoret kur krijojme lojtarin . konstruktori qe perdoret per te caktuar emrin dhe pozicionin fillestar 0 , kur krijon lojtarin
        this.emri = emri;
        this.pozicioni = 0;
    }
}

//klasa kryesore ku ekzekutohet programi
public class LojaMosUNxeh {
    static final int BOARD_SIZE = 63;   //deklarojme me final (constante) e pandryshueshme madhesine e tabeles, e deklarojme me keywordin static sepse nuk do na duhet te krijojme objekt per te
    static final Set<Integer> kutiteSpeciale = Set.of(6,13,27,45,58);   //grup kutishe speciale ku lojtaret penalizohen

public static void main(String[] args){ //metoda main - pika e nisjes se programit
    Scanner merrUserInput = new Scanner(System.in);     //krijojme objekt per klasen Scanner per te marr input nga user
    Random numriRandom = new Random();  //Krijojme nje objekt per numrin random


    //Merr emrat e lojtareve nga user input
    System.out.println("Emri i lojtarit 1: ");
    Lojtari lojtari1 = new Lojtari(merrUserInput.nextLine());   //krijojme nje objekt per lojtarin e pare dhe marrim user input String

    System.out.println("Emri i lojtarit 2: ");
    Lojtari lojtari2 = new Lojtari(merrUserInput.nextLine());   //krijojme nje objekt per lojtarin e dyte dhe marrim emrin nga user input si String

    //Llojet e lojes
    System.out.println("Zgjidh menyren e lojes: ");
    System.out.println("1 - Kush kalon 63 pike fiton");
    System.out.println("2 - Kush shkon fiks 60 fiton");
    int menyra = merrUserInput.nextInt();   //deklarojme variablen menyra (per llojin e lojes) dhe marrim user input Int per te zgjedhur mes dy opsioneve

    Lojtari current = lojtari1;     //current tregon lojtarin qe ka rradhen per te hedhur zarin. Fillimisht eshte lojtari 1. Me vone,pas cdo raundi , current nderrohet mes lojtarit 1 dhe lojtarit 2.

    while (true){       //loja vazhdon pafund derisa dikush fiton
        System.out.println("Rradha e " + current.emri); //Shfaq emrin e lojtarit aktual
        System.out.println("Pozicioni aktual: " + current.pozicioni );  //shfaq pozicionin aktual te lojtarit
        System.out.println("Shtype butonin ENTER per te hedhur zar...");
        merrUserInput.nextLine();       //per enter

        int zari = numriRandom.nextInt(6) + 1; //ofron numra random nga 1-6
        System.out.println("Zari: " + zari);

        current.pozicioni += zari;      //shton rezultatin e zarit ne pozicionin e lojtarit


        //kontrollo kutite speciale
        if (kutiteSpeciale.contains(current.pozicioni)){
            System.out.println("Kutia Speciale! Kthehu mbrapa 3 hapa");
            current.pozicioni -= 3;     //nese lojtari bie ne nje kuti speciale , kthehet mbrapa 3 hapa
        }

        //kontrollo fituesin sipas llojit te lojes
        if (menyra ==1){
            if(current.pozicioni >= BOARD_SIZE){
                System.out.println("Fitoi: " + current.emri);
                break;
            }
        } else {
            if (current.pozicioni == BOARD_SIZE){
                System.out.println("Fitoi: " + current.emri);
                break;
            } else if (current.pozicioni > BOARD_SIZE){
                int overflow = current.pozicioni - BOARD_SIZE;
                current.pozicioni = BOARD_SIZE - overflow;
                System.out.println("Kalove 63 pike, do te kthehesh pas ne: " + current.pozicioni);
            }
        }


        //Nderrimi i lojtarit
        current = (current == lojtari1) ? lojtari2 : lojtari1;      //nderrimi lojtarit, nese ishte rradha e lojtari1, tani behet lojtari2 dhe anasjelltas
    }

}
}
