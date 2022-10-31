package basic.ComEx2.attendance_calculation.entity;

public class WorkingTime {
    private int hour;
    private int minutes;
    private int restTime;

    public WorkingTime(int hour, int minutes, int restTime) {
        this.hour = hour;
        this.minutes = minutes;
        this.restTime = restTime;
    }

    public int getHour() {
        return this.hour;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public int getRestTime() { return this.restTime; }

    public int inMinutes() {
        return (hour * 60) + minutes;
    }
}