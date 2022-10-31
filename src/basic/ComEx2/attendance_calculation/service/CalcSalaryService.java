package basic.ComEx2.attendance_calculation.service;

import basic.ComEx2.attendance_calculation.entity.WorkingTime;

import java.sql.Time;
import java.util.List;

public class CalcSalaryService {
    private static final int HOURLY_WAGES = 900;
    private static final double OVERTIME_HOURLY_WAGES_RATE = 1.25;
    private static final double OVERTIME_HOURLY_WAGES = (HOURLY_WAGES * OVERTIME_HOURLY_WAGES_RATE);
    private static final int PRESCRIBED_WORKING_HOURS = 8;

    private final CalcWorkingTimeService calcWorkingTimeService;

    public CalcSalaryService(CalcWorkingTimeService calcWorkingTimeService) {
        this.calcWorkingTimeService = calcWorkingTimeService;
    }

    public int getDailyWages(Time startTime, Time endTime) {
        final var workingTime = calcWorkingTimeService.getWorkingTime(startTime, endTime);

        return calcWages(workingTime);
    }

    public int getWages(List<Time[]> times) {
        return times.stream()
                .map((t) -> getDailyWages(t[0], t[1]))
                .mapToInt(i -> i)
                .sum();
    }

    private int calcOvertimeWages(WorkingTime workingTime) {
        final int overtimeWorkingTimes = workingTime.inMinutes() - (PRESCRIBED_WORKING_HOURS * 60);

        if(overtimeWorkingTimes <= 0){
            return 0;
        }

        return (int) (overtimeWorkingTimes * (OVERTIME_HOURLY_WAGES / 60));
    }

    private int calcWages(WorkingTime workingTime) {
        if(workingTime.getHour() >= PRESCRIBED_WORKING_HOURS) {
            return (PRESCRIBED_WORKING_HOURS * HOURLY_WAGES) + calcOvertimeWages(workingTime);
        }

        return workingTime.inMinutes() * (HOURLY_WAGES / 60);
    }
}
