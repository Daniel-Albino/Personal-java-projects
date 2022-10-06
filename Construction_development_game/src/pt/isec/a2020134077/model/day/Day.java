package pt.isec.a2020134077.model.day;

public class Day {
    private static int day;

    public Day() {
        day = 0;
    }

    public void newDay(){
        day++;
    }

    public static int getDay() {
        return day;
    }

    @Override
    public String toString() {
        return "Day: " + day;
    }
}
