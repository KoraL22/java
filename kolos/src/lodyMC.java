import java.util.Arrays;
import java.util.Random;

public class lodyMC {
    public static void main(String[] args) {
        int[][] czas = new int[][]{
                {0,7,20,21,12,23},
                {27,0,13,16,46,5},
                {53,15,0,25,27,6},
                {16,2,35,0,47,10},
                {31,29,5,18,0,4},
                {28,24,1,17,5,0}};

        int i=0, j;
        int n=100;
        int smaki=6;
        int besttime=Integer.MAX_VALUE;
        int[] bestwyn = new int[smaki+1];
        int[] tempwyn = new int[smaki+1];
        while(i<n) {

            int temptime=0;
            boolean[] tempres=new boolean[smaki+1];
            Random rng = new Random();
            int y=rng.nextInt(smaki);
            tempres[y]=true;
            tempwyn[0]=y;
            j=1;
            while(j<smaki) {

                int x= rng.nextInt(smaki);
                if(!tempres[x]&&czas[tempwyn[j-1]][x]!=0) {

                    tempres[x]=true;
                    temptime+=czas[tempwyn[j-1]][x];
                    tempwyn[j]=x;
                    j++;
                }

                tempres[smaki]=tempres[0];
            }
            tempwyn[smaki] = tempwyn[0];
            temptime+=czas[tempwyn[smaki-1]][tempwyn[smaki]];
            if(besttime>temptime) {

                besttime=temptime;
                bestwyn = Arrays.copyOf(tempwyn,tempwyn.length);
            }
            Arrays.fill(tempres,false);
            Arrays.fill(tempwyn,0);

            i++;
        }
        System.out.println(Arrays.toString(bestwyn));
        System.out.println(besttime);
    }
}
