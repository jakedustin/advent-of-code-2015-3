package Delivery.src;

public class App {
    public static void main(String[] args) {
        String fileName = "input.txt";
        Solver solver = new Solver();
        System.out.println(solver.solve(fileName));
    }
}
