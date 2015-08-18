public class Brute {

    public static void main(String[] args) {
        // read in the input
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Point[] pointsArr = new Point[N];
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            pointsArr[i] = new Point(x, y);
        }


    }
}
