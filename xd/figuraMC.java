import java.util.Random;

public class figuraMC {
    public static void main(String[] args) {
        System.out.println("POLE = " + pole(1000));
    }

    public static double pole(int llos) {
        Random los = new Random();
        int licz = 0;
        for (int i = 0; i < llos; i++) {
            double x = (los.nextInt(201) - 100) /100.0; //(los.nextInt(101) -50 )/ 1.0;
            double y = (los.nextInt(201) -100) /100.0; //(los.nextInt(101) -50 )/ 1.0;
            System.out.println("x= "+x+"\ty= "+y);
            if( y <= Math.sin(2*x + Math.PI/2) && y >= Math.sin(2*x - Math.PI/2) ){
                licz++;
                System.out.println("gra " + x + " " + y);
            }
        }
        return ( licz / 1000.0 * 4);
    }
}
