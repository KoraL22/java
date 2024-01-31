import java.util.Scanner;

public class ResztaAZ {
    static Scanner skan = new Scanner(System.in);
    public static void main(String[] args) {

        int[] monety = {500, 200, 100, 50, 20, 10, 5, 2, 1};
        int[] dostepne = {1, 2, 0 , 1, 2, 3,5, 1, 0}; //10 47
        int[] LICZ = new int[monety.length];
        int r;
        int i = 0;

        System.out.println("podaj zl: ");
        int zl = Integer.parseInt(skan.next());
        System.out.println("podaj gr: ");
        int gr = Integer.parseInt(skan.next());
        r = zl * 100 + gr;

        while (r > 0 && i < monety.length){
            if (r >= monety[i] && dostepne[i] > 0){
                System.out.print(monety[i]/100.0 + " ");
                LICZ[i]++;
                r -= monety[i];
                dostepne[i]--;
            }
            else i++;
        }

        System.out.println();
        for (int j = 0; j<monety.length; j++){
            System.out.println(monety[j]/100.0 + " - " + LICZ[j]);
        }
        if (r > 0){
            System.out.println("nie mozna wydac calej reszty: " + r/100.0);
        }
    }
}