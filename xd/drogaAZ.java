public class drogaAZ {
    static String[] city = {"Warszawa", "Katowice", "Zakopane", "Lwów" ,"Wiedeń" ,"Budapeszt" ,"Bukareszt" ,"Zagrzeb", "Sofia"};
    public static int[][] road = {
            //0    1   2   3    4   5   6   7   8
            {0  ,300,402,356,  0,  0,  0,  0,  0},
            {300,  0,  0,  0,440,474,  0,  0,  0},
            {402,  0,  0,  0,  0,330,  0,  0,  0},
            {356,  0,  0,  0,  0,  0,823,  0,  0},
            {  0,440,  0,  0,  0,  0,  0,430,  0},
            {  0,474,330,  0,  0,  0,813,365,774},
            {  0,  0,  0,823,  0,813,  0,  0,403},
            {  0,  0,  0,  0,430,365,  0,  0,768},
            {  0,  0,  0,  0,  0,774,403,768,  0}
    };

    public static void main(String[] args) {

        boolean achieved=false;
        int totalTime=0;

        int y=3; //TU MIASTO POCZATKOWE
        int x=-1;

        while(!achieved) {
            int minTime = Integer.MAX_VALUE;
            for (int i = 0; i < road.length; i++) {
                if (road[y][i] < minTime && road[y][i] != 0) {
                    minTime = road[y][i];
                    x = i;
                }
            }
            System.out.println(city[y] + "->" + city[x]+"\t\t"+road[y][x]);
            totalTime+=road[y][x];

            road[y][x]=0; road[x][y]=0;
            y = x;

            if (y == 0) achieved = true; //TUTAJ MIASTO KONCOWE
        }
        System.out.println(totalTime);
    }
}