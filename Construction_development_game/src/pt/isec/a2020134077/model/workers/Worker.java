package pt.isec.a2020134077.model.workers;

import pt.isec.a2020134077.model.day.Day;

public class Worker {
    private static int nWorkers = 0;
    private final String id;

    private int cost;

    public Worker(Day day, int cost) {
        nWorkers++;
        id = createID(day);
        this.cost = cost;
    }

    private String createID(Day day) {
        String aux =  String.valueOf(nWorkers);
        aux += ".";
        aux += String.valueOf(day.getDay());
        return aux;
    }

    public int getCost() {
        return cost;
    }

    public String getId() {
        return id;
    }

    public WorkerType getWorkerType(){
        return getWorkerType();
    }

    public Events nextDay(){
        return nextDay();
    }

    @Override
    public String toString() {
        return "Id: " + id + " Cost: " + cost + "€";
    }
}
