package ComEx2.attendance_calculation;

import ComEx2.attendance_calculation.service.CalcSalaryService;
import ComEx2.attendance_calculation.service.CalcWorkingTimeService;

import java.sql.Time;

public class Main {
    public static void main(String[] args) {

        try {
            CalcWorkingTimeService calcWorkingTimeService = new CalcWorkingTimeService();
            CalcSalaryService calcSalaryService = new CalcSalaryService(calcWorkingTimeService);

            argValidation(args);
            argValidation(args);

            Time startTime = Time.valueOf(args[0]);
            Time endTime = Time.valueOf(args[1]);

            var result = calcSalaryService.getDailyWages(startTime, endTime);
            System.out.println("あなたの今日の給与は、" + result + "円です");
        } catch(IllegalArgumentException e) {
            System.out.println("引数が適切ではありません");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void argValidation(String[] args) {
        if(args.length != 2) {
            throw new IllegalArgumentException("第一引数に業務開始時間、第二引数に業務終了時間を指定してください。");
        }
    }
}
