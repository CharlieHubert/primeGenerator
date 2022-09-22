package literateProgramming;

public class PrimePrinter {
    public static void main(String[] args) {
        final int numPrimes = 1000;
        PrimeGenerator primeGenerator = new PrimeGenerator(numPrimes);
        NumberPrinter numberPrinter = new NumberPrinter(50, 4);
        numberPrinter.print(numPrimes, primeGenerator.generate());
    }

}