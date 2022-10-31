package ComEx2.attendance_calculation;

import ComEx2.attendance_calculation.service.CalcSalaryService;
import ComEx2.attendance_calculation.service.CalcWorkingTimeService;
import ComEx2.attendance_calculation.utility.ReadFileUtil;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Time;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try {
            String[] readCsvTestArgs = {"/Users/nakanojino/Sources/java-test/cb-study/java-basic/src/ComEx2/attendance_calculation/Attendances.csv"};

            argValidation(readCsvTestArgs);
            execution(readCsvTestArgs);
        } catch(IllegalArgumentException e) {
            System.out.println("引数が適切ではありません");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void argValidation(String[] args) {
        if(args.length != 1 && args.length != 2) {
            throw new IllegalArgumentException("第一引数に勤務時間csvのファイルパスを指定するか、第一引数に業務開始時間、第二引数に業務終了時間を指定してください。");
        }
    }

    private static void execution(String[] args) throws IOException {
        CalcWorkingTimeService calcWorkingTimeService = new CalcWorkingTimeService();
        CalcSalaryService calcSalaryService = new CalcSalaryService(calcWorkingTimeService);

        if(args.length == 1) {
            Path filePath = Paths.get(args[0]);
            var fileContent = ReadFileUtil.csv(filePath);
            var workingTimeData = fileContent.stream()
                    .map(c -> {
                        Time[] times = {Time.valueOf(c[0]), Time.valueOf(c[1])};
                        return times;
                    })
                    .collect(Collectors.toList());

            var result = calcSalaryService.getWages(workingTimeData);
            System.out.println("あなたの今日の給与は、" + result + "円です");
        }

        if(args.length == 2) {
            Time startTime = Time.valueOf(args[0]);
            Time endTime = Time.valueOf(args[1]);

            var result = calcSalaryService.getDailyWages(startTime, endTime);
            System.out.println("あなたの今日の給与は、" + result + "円です");
        }
    }
}
