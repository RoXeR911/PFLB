package Task1;

public class Task1 {

    public static void main(String[] args) {
        if (args.length < 2) {
        } else {
            int n = Integer.parseInt(args[0]);
            int m = Integer.parseInt(args[1]);
            int[] array = new int[n];

            for(int a = 0; a < n; a++) {
                array[a] = a + 1;
            }
            StringBuilder b = new StringBuilder();
            int c = 0;
            do {
                b.append(array[c]);
                c = (c + m - 1) % n;
            } while(c != 0);
            System.out.println(b);
        }
    }
}