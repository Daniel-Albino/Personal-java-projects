package pt.isec.a2020134077.model.workers;

import pt.isec.a2020134077.model.day.Day;

public class Operator extends Worker{

    private int probTiredOrLeaving;
    private int workingDays;

    public Operator(Day day) {
        super(day,15);
        probTiredOrLeaving = 5;
        workingDays = 0;
    }

    public int getProbTiredOrLeaving() {
        return probTiredOrLeaving;
    }

    public int getWorkingDays() {
        return workingDays;
    }
    @Override
    public Events nextDay(){
        int leave = (int) (Math.random() * 100);
        if(leave < probTiredOrLeaving)
            return Events.OPERATOR_LEAVE;
        workingDays++;
        return Events.NONE;
    }
    @Override
    public WorkerType getWorkerType(){
        return WorkerType.OPERATOR;
    }

    @Override
    public String toString() {
        return "Operator: " + super.toString() + " Probability to get tired or leaving: " +
                probTiredOrLeaving + "%" + " Working days: " + workingDays;
    }
}
