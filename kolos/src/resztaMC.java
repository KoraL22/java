import java.util.Random;
import java.util.Scanner;

public class resztaMC {
    static Scanner skan = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args) {

        int[] monety = {500, 200, 100, 50, 20, 10, 5, 2, 1};
        int limitMonet = 11;
        int losowania = 100;
        int minLimitWydanych = limitMonet;
        int i, r, moneta;
        int[] wydaneMonety = new int[limitMonet];
        int[] minWydaneMonety = new int[limitMonet];

        System.out.println("podaj zl: ");
        int zl = skan.nextInt();
        System.out.println("podaj gr: ");
        int gr = skan.nextInt();

        for (i = 0; i < losowania; i++) {
            r = zl * 100 + gr;
            int liczbaWydanych = 0;
            while (r > 0 && liczbaWydanych < limitMonet){
                moneta = monety[rand.nextInt(monety.length)];
                if (r >= moneta){
                    wydaneMonety[liczbaWydanych] = moneta;
                    r -= moneta;
                    liczbaWydanych++;
                }
            }

            if (liczbaWydanych < minLimitWydanych){
                minLimitWydanych = liczbaWydanych;
                for (int j = 0; j < liczbaWydanych; j++) {
                    minWydaneMonety[j] = wydaneMonety[j];
                }
            }
        }

        if (minLimitWydanych < limitMonet){
            System.out.println("reszta: ");
            for (int j = 0; j < minLimitWydanych; j++)
                System.out.print(minWydaneMonety[j]/100.0 + " ");
        }
        else System.out.println("nie da rady wydac reszty ");
    }
}