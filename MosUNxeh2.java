package loje;
import java.util.*;
//do krijojme lojen qe te zgjidhem te luajme me 2 ose 3 ose 4 lojtare

class Lojtar{
    String emri;
    int pozicioni;

    Lojtar(String emri){
        this.emri = emri;
        this.pozicioni = 0;
    }
}

public class MosUNxeh2 {
    static final int BOARD_SIZE=63;
    static final Set<Integer> kutiteSpeciale = Set.of(6,13,27,45,58);   //grup kutishe speciale ku lojtaret penalizohen

    public static void main(String[] args){
        Scanner merrUserInput = new Scanner(System.in);
        Random numriRandom = new Random();

        List<Lojtari> lojtaret = new ArrayList<>();

        System.out.println("Sa lojtarë do të luajnë? (2-4)");
        int nrLojtareve = merrUserInput.nextInt();
        merrUserInput.nextLine();

        for (int i = 1; i <= nrLojtareve; i++) {
            System.out.println("Emri i lojtarit " + i + ": ");
            lojtaret.add(new Lojtari(merrUserInput.nextLine()));
        }

        System.out.println("Zgjidh menyren e lojes: ");
        System.out.println("1 - Kush kalon 63 pike fiton");
        System.out.println("2 - Kush shkon fiks 63 fiton");
        int menyra = merrUserInput.nextInt();
        merrUserInput.nextLine();

        int currentIndex = 0;

        while (true) {
            Lojtari current = lojtaret.get(currentIndex);
            System.out.println("Rradha e " + current.emri);
            System.out.println("Pozicioni aktual: " + current.pozicioni);
            System.out.println("Shtype ENTER per te hedhur zar...");
            merrUserInput.nextLine();

            int zari = numriRandom.nextInt(6) + 1;
            System.out.println("Zari: " + zari);

            current.pozicioni += zari;

            if (kutiteSpeciale.contains(current.pozicioni)) {
                System.out.println("Kutia Speciale! Kthehu mbrapa 3 hapa");
                current.pozicioni -= 3;
            }

            if (menyra == 1) {
                if (current.pozicioni >= BOARD_SIZE) {
                    System.out.println("Fitoi: " + current.emri);
                    break;
                }
            } else {
                if (current.pozicioni == BOARD_SIZE) {
                    System.out.println("Fitoi: " + current.emri);
                    break;
                } else if (current.pozicioni > BOARD_SIZE) {
                    int overflow = current.pozicioni - BOARD_SIZE;
                    current.pozicioni = BOARD_SIZE - overflow;
                    System.out.println("Kalove 63 pike, do te kthehesh pas ne: " + current.pozicioni);
                }
            }

            currentIndex = (currentIndex + 1) % lojtaret.size();
        }

    }
}
