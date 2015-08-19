import java.util.Arrays;

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

        Arrays.sort(pointsArr);

        Stopwatch sw = new Stopwatch();
        for(int p = 0; p < N; p++) {
            for(int q = p+1; q < N; q++) {
                for(int r = q+1; r < N; r++) {
                    double slopePtoQ = pointsArr[p].slopeTo(pointsArr[q]);
                    double slopeQtoR = pointsArr[q].slopeTo(pointsArr[r]);
                    if(slopePtoQ == slopeQtoR) {
                        for(int s = r+1; s < N; s++) {
                            double slopeRtoS = pointsArr[r].slopeTo(pointsArr[s]);
                            if(slopePtoQ == slopeQtoR && slopeQtoR == slopeRtoS)
                                StdOut.println(pointsArr[p].toString() + " -> " +
                                        pointsArr[q].toString() + " -> " +
                                        pointsArr[r].toString() + " -> " +
                                        pointsArr[s].toString());
                        }
                    }
                }
            }
        }
        StdOut.println(sw.elapsedTime());
    }
}
