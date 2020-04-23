package threadProblem.thread;

import java.util.ArrayList;
import java.util.List;

public class EvenOddNumbers implements Runnable {

    private List<Integer> lists;

    public EvenOddNumbers(List<Integer> lists) {
        this.lists = lists;
    }

    private List<Integer> oddNumbers = new ArrayList<Integer>();
    private List<Integer> evenNumbers = new ArrayList<Integer>();

    public List<Integer> getOddNumbers() {
        return oddNumbers;
    }

    public List<Integer> getEvenNumbers() {
        return evenNumbers;
    }


    @Override
    public void run() {

        // If you want to see which thread reaching to the indexes
        //String threadName = Thread.currentThread().getName();

            for (int i=0; i<lists.size(); i++) {

                if (lists.get(i) %2 == 0) {
                    getEvenNumbers().add(lists.get(i));
                    //System.out.println("Thread Name: " + threadName + " Even Number: "+lists.get(i));
                }
                else{
                    getOddNumbers().add(lists.get(i));
                    //System.out.println("Thread Name: " + threadName + " Odd Number: "+lists.get(i));
                }

                //sleep(100);
            }
        }

    public static void sleep(long milliseconds) {

        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EvenOddNumbers{");
        sb.append("oddNumbers=").append(oddNumbers);
        sb.append(", evenNumbers=").append(evenNumbers);
        sb.append('}');
        return sb.toString();
    }


}
