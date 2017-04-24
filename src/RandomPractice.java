import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

/**
 * Created by danawacomputer on 2017-04-21.
 */
public class RandomPractice {

    public static void main(String[] args) {

        Stream.of(1,2,3,4,5,6,7,8)
                .forEach(System.out::println);

        long sum = LongStream.range(1, 10000000)
                .sum();
        System.out.println(sum);

        IntStream.generate(() -> 1)
                .limit(1)
                .forEach(System.out::println);

        Random r = new Random();

        r.ints().limit(5).forEach(System.out::println);

//        int[] iArr = {0,0,0,0,0,0};
//        r.ints(1,7)
//                .limit(10000000)
//                .collect(groupingBy(x-> {
//
//                }));

        int inputNumber;

        System.out.print("주사위를 몇번 던지시겠습니까? ");
        Scanner input = new Scanner(System.in);

        inputNumber = Integer.parseInt(input.nextLine());

        Map<Integer, Long> listMap =
                r.ints(1,7)
                        .limit(inputNumber)
                        .boxed()
                        .peek(System.out::println)
                        .collect(Collectors.groupingBy(
                                Function.identity(), Collectors.counting()));

        System.out.println("각 숫자는 몇번씩 나왔을까요? : " + listMap);




    }
}
