import model.Salary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by danawacomputer on 2017-04-21.
 */
public class StreamDemo {

    public static void main(String[] args) {

        try {

            /*
             * 파일을 stream 형식으로
             */
            List<Salary> list =
                    Files.lines(Paths.get("src\\Salaries.csv"))
                    .skip(1)
                    .map(x -> {
                        String[] spl = x.split(",");
                        return new Salary(LocalDate.of(Integer.parseInt(spl[0]), 1, 1),
                                spl[1], spl[2], spl[3], Integer.parseInt(spl[4]));
                    })
                    .collect(Collectors.toList());

            /*
             * 파일을 mapping
             */
            Map<String, Salary> map =
                    Files.lines(Paths.get("src\\Salaries.csv"))
                        .skip(1)
                        .map(x -> {
                            String[] spl = x.split(",");
                            return new Salary(LocalDate.of(Integer.parseInt(spl[0]), 1, 1),
                                    spl[1], spl[2], spl[3], Integer.parseInt(spl[4]));
                        })
                    .collect(Collectors.toMap(x -> String.valueOf(new Random().nextInt()) + ". " + x.getPlayerID(), x -> x));

            map.forEach((k, v) -> System.out.println(k + " : " + v));


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
