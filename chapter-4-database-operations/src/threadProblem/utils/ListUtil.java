package threadProblem.utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListUtil {

    public static List<Integer> generateContinuousNumbers(int start, int end){

        List<Integer> list = IntStream.rangeClosed(start, end)
                .boxed().collect(Collectors.toList());

        return list;
    }


    public static List<Integer> groupedAsList(List<Integer> list, int chunkSize, int listIndex) {

        int startIndex = listIndex * chunkSize;

        return list.subList(startIndex, Math.min(startIndex+ chunkSize, list.size()));

    }
}
