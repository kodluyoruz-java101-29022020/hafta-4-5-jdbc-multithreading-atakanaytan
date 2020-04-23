package threadProblem;

import threadProblem.utils.ListUtil;
import threadProblem.thread.EvenOddNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Main {

    public static void main(String[] args) {

        int continuousNumbersStart = 1;
        int continuousNumbersEnd   = 10000;

        int threadSize = 4;
        int chunkSize;

        try {

            chunkSize = getChunkValue(continuousNumbersStart, continuousNumbersEnd, threadSize);
        }
        catch (Throwable e) {
            e.printStackTrace();

            return;
        }

        List<Integer> sequentialNumbersAsList = ListUtil.generateContinuousNumbers(continuousNumbersStart, continuousNumbersEnd);

        ExecutorService executor = Executors.newFixedThreadPool(threadSize);

        List<EvenOddNumbers> numbers = new ArrayList<EvenOddNumbers>();

        for (int i=0; i<threadSize; i++) {

            EvenOddNumbers evenOddNumbers = new EvenOddNumbers(ListUtil.groupedAsList(sequentialNumbersAsList,chunkSize, i));

            numbers.add(evenOddNumbers);
            executor.execute((evenOddNumbers));
        }

        try {
            if (!executor.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        List<Integer> oddNumbers = new ArrayList<Integer>();
        List<Integer> evenNumbers = new ArrayList<Integer>();

        for (int i=0; i<threadSize; i++) {
            oddNumbers.addAll(numbers.get(i).getOddNumbers());
            evenNumbers.addAll(numbers.get(i).getEvenNumbers());
        }

        System.out.println("Odd numbers:  "  + oddNumbers);
        System.out.println("Even numbers: "  + evenNumbers);
    }

    private static int getChunkValue(int continuousNumbersStart, int continuousNumbersEnd, int threadSize) throws Throwable{

        if (threadSize > continuousNumbersEnd - continuousNumbersStart) {

            throw new Exception("Please enter a valid range of numbers bigger than thread size");
        }

        int chunkValue = (continuousNumbersEnd - continuousNumbersStart ) / threadSize;

        return chunkValue % threadSize == 0 ? chunkValue : chunkValue + (threadSize - (chunkValue % threadSize));
    }
}
