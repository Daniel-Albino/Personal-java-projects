package pt.isec.a2020134077.model.workers;

import pt.isec.a2020134077.model.day.Day;

public class Miner extends Worker{
    private int workingDays;
    private int probTiredOrLeaving;

    public Miner(Day day) {
        super(day, 10);
        workingDays = 0;
        probTiredOrLeaving = 10;
    }

    public int getWorkingDays() {
        return workingDays;
    }

    public int getProbTiredOrLeaving() {
        return probTiredOrLeaving;
    }

    @Override
    public Events nextDay() {
        int leave = (int) (Math.random() * 100);
        if(leave < probTiredOrLeaving){
            return Events.MINER_LEAVE;
        }
        workingDays++;
        return Events.NONE;
    }

    @Override
    public WorkerType getWorkerType() {
        return WorkerType.MINER;
    }

    @Override
    public String toString() {
        return "Miner: " + super.toString() + " Probability to get tired or leaving: " +
                probTiredOrLeaving + "%" + " Working days: " + workingDays;
    }
}
