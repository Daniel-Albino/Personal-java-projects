import pt.isec.a2020134077.model.day.Day;
import pt.isec.a2020134077.model.workers.Lumberjack;
import pt.isec.a2020134077.model.workers.Miner;
import pt.isec.a2020134077.model.workers.Operator;
import pt.isec.a2020134077.model.workers.Worker;

public class Main {
    public static void main(String[] args) {
        Day day = new Day();
        System.out.println(day);
        day.newDay();
        System.out.println(day);
        Miner miner = new Miner(day);
        Operator operator = new Operator(day);
        day.newDay();
        Lumberjack lumberjack = new Lumberjack(day);
        lumberjack.nextDay();
        lumberjack.nextDay();
        lumberjack.nextDay();
        lumberjack.nextDay();
        System.out.println(miner + "\n" + operator + "\n" + lumberjack + "\n" + lumberjack.takeBreak());
        lumberjack.nextDay();
        System.out.println(miner + "\n" + operator + "\n" + lumberjack + "\n" + lumberjack.takeBreak());
    }
}