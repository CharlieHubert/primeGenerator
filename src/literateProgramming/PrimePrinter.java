package literateProgramming;


public class PrimePrinter {
  public static void main(String[] args) {
    final int M = 1000;
    final int RR = 50;
    final int CC = 4;
    final int ORDMAX = 30;
    int P[] = new int[M+1];
    int PAGENUMBER;
    int pageOFFSET;
    int ROWOFFSET;
    int C;
    int J;
    int K;
    boolean JPRIME;
    int ORD;
    int SQUARE;
    int N=0;
    int MULT[] = new int[ORDMAX+1];

    J=1;
    K=1;
    P[1] = 2;
    ORD = 2;
    SQUARE = 9;

    while (K < M) {
      do {
        J += 2;
        if (J == SQUARE) {
          ORD++;
          SQUARE=P[ORD]*P[ORD];
          MULT[ORD-1]=J;
        }
        N=2;
        JPRIME=true;
        while (N < ORD && JPRIME) {
          while (MULT[N]<J)
            MULT[N] += P[N] + P[N];
          if (MULT[N] == J)
            JPRIME=false;
          N++;
        }
      } while (!JPRIME);
      K++;
      P[K]=J;
    }
    PAGENUMBER = 1;
    pageOFFSET = 1;
    while (pageOFFSET <= M) {
      System.out.print("The First ");
      System.out.print(Integer.toString(M));
      System.out.print(" Prime Numbers --- Page ");
      System.out.print(Integer.toString(PAGENUMBER));
      System.out.println("\n");
      for (ROWOFFSET=pageOFFSET; ROWOFFSET <= pageOFFSET+RR-1; ROWOFFSET++) {
        for (C=0; C <= CC-1; C++)
          if (ROWOFFSET+C*RR <= M)
            System.out.printf("%10d", P[ROWOFFSET+C*RR]);
        System.out.println();
      }
      System.out.println("\f");
      PAGENUMBER++;
      pageOFFSET += RR*CC;
    }
  }
}
