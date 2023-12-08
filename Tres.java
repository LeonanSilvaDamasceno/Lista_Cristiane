package Taurus;

public class Tres {
    public static void main(String[] args) {
        int index;

        int [] numbers  = new int [100];

        int [] cluster1 = new int [101];
        int [] cluster2 = new int [101];
        int [] cluster3 = new int [101];

        for (index = 0; index < 100; index++) {
            numbers[index] = (int) (Math.random()*100);
        }
    }
}
