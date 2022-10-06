package pt.isec.a2020134077.model.workers;

import pt.isec.a2020134077.model.day.Day;

public class Lumberjack extends Worker{

    private int workingDays;

    public Lumberjack(Day day) {
        super(day,20);
        workingDays = 0;
    }

    public int getWorkingDays() {
        return workingDays;
    }

    public boolean takeBreak(){
        if(workingDays == 5){
            workingDays = 0;
            return true;
        }
        return false;
    }
    @Override
    public Events nextDay(){
        if(takeBreak())
            return Events.LUMBERJACK_TAKE_A_BREAK;
        workingDays++;
        return Events.NONE;
    }

    @Override
    public WorkerType getWorkerType(){
        return WorkerType.LUMBERJACK;
    }

    @Override
    public String toString() {
        return "Lumberjack: " + super.toString() +
                " Working days: " + workingDays;
    }
}
