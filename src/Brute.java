import java.util.Arrays;

public class Brute {

    public static void main(String[] args) {
        // rescale coordinates and turn on animation mode
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.show(0);
        StdDraw.setPenRadius(0.01);  // make the points a bit larger

        // read in the input
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Point[] pointsArr = new Point[N];
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            Point p = new Point(x, y);
            p.draw();
            pointsArr[i] = p;
        }

        Arrays.sort(pointsArr);

        StdDraw.setPenRadius(0.0);

        Point P, Q, R, S;
        for(int p = 0; p < N; p++) {
            P = pointsArr[p];
            for(int q = p+1; q < N; q++) {
                Q = pointsArr[q];
                for(int r = q+1; r < N; r++) {
                    R = pointsArr[r];
                    double slopePtoQ = P.slopeTo(Q);
                    double slopeQtoR = Q.slopeTo(R);
                    if(slopePtoQ == slopeQtoR) {
                        for(int s = r+1; s < N; s++) {
                            S = pointsArr[s];
                            double slopeRtoS = R.slopeTo(S);
                            if(slopeQtoR == slopeRtoS) {
                                StdOut.println(P.toString() + " -> " +
                                        Q.toString() + " -> " +
                                        R.toString() + " -> " +
                                        S.toString());
                                P.drawTo(Q);
                                Q.drawTo(R);
                                R.drawTo(S);
                            }
                        }
                    }
                }
            }
        }

        // display to screen all at once
        StdDraw.show(0);
    }
}
