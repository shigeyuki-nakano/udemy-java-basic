package ComEx2.attendance_calculation.service;

import ComEx2.attendance_calculation.entity.WorkingTime;

import java.math.BigDecimal;
import java.sql.Time;

public class CalcWorkingTimeService {
    private static final int ONE_HOUR_BY_MILLI_SEC = 1000 * 60 * 60;
    private static final int ONE_MIN_BY_MILLI_SEC = 1000 * 60;
    private static final int ONE_HOUR_BY_MIN = 60;

    final static int REST_TIME_IN_SHORT = 0;
    final static int REST_TIME_IN_NORMAL = 45;
    final static int REST_TIME_IN_LONG = 60;


    public WorkingTime getWorkingTime(Time startTime, Time endTime) {
        final int dailyWorkingTime = getDailyWorkingTime(startTime, endTime);
        final int restTime = getRestTime(dailyWorkingTime);

        final int workingTimeInHour = (dailyWorkingTime - restTime) / ONE_HOUR_BY_MIN;
        final int workingTimeInOverMinutes = (dailyWorkingTime - restTime) % ONE_HOUR_BY_MIN;

        return new WorkingTime(workingTimeInHour, workingTimeInOverMinutes, restTime);
    }

    private int getDailyWorkingTime(Time startTime, Time endTime) {
        long result = endTime.getTime() - startTime.getTime();

        return BigDecimal.valueOf(result)
                .divide(BigDecimal.valueOf(ONE_MIN_BY_MILLI_SEC))
                .intValue();
    }

    private int getRestTime(int dailyWorkingTime) {
        if(isNormalWorkingTime(dailyWorkingTime)) {
            return REST_TIME_IN_NORMAL;
        } else if(isLongWorkingTime(dailyWorkingTime)) {
            return REST_TIME_IN_LONG;
        }

        return REST_TIME_IN_SHORT;
    }

    private boolean isNormalWorkingTime(int dailyWorkingTime) {
        final int lowerThresholdInMinutes = (ONE_HOUR_BY_MIN * 6) + REST_TIME_IN_NORMAL;
        final int thresholdInMinutes = (ONE_HOUR_BY_MIN * 8) + REST_TIME_IN_NORMAL;

        return dailyWorkingTime > lowerThresholdInMinutes && dailyWorkingTime <= thresholdInMinutes;
    }

    private boolean isLongWorkingTime(int dailyWorkingTime) {
        final int thresholdInMinutes = (ONE_HOUR_BY_MIN * 8) + REST_TIME_IN_NORMAL;

        return dailyWorkingTime > thresholdInMinutes;
    }
}
