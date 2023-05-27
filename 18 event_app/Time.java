public class Time {
    private int hour;
    private int minute;

    public Time(int hour, int minute) {
        if(!isValidTime(hour, minute)) throw new IllegalArgumentException();
        this.hour = hour;
        this.minute = minute;
    }


    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }
    private boolean isValidTime(int hour, int minute){
        return (minute >= 0 && minute <= 59) && (hour >= 0 && hour < 24);
    }
}
