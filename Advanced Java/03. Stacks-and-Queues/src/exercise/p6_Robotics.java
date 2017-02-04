package exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p6_Robotics {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);
        String[] robotsInput = console.nextLine().split(";");

        ArrayDeque<Robot> robots = new ArrayDeque<>();
        for (int i = 0; i < robotsInput.length; i++) {
            String [] split = robotsInput[i].split("-");
            String robotName = split[0];
            Integer processTime = Integer.parseInt(split[1]);

            Robot robot = new Robot(robotName, processTime);

            robots.offer(robot);
        }

        String[] startingTime = console.nextLine().split(":");
        int timeInSeconds = (Integer.parseInt(startingTime[0]) * 3600) +
                (Integer.parseInt(startingTime[1]) * 60) +
                Integer.parseInt(startingTime[2]);

        ArrayDeque<String> products = new ArrayDeque<>();
        while (true) {
            String product = console.nextLine();
            if (product.equals("End")) {
                break;
            }

            products.offer(product);
        }

        int secondsPast = 0;
        for (Robot robot : robots) {
            secondsPast++;
            String robotName = robot.getRobotName();
            int procTime = robot.getInitialProcessTime();
            String product = products.poll();
            System.out.printf("%s - %s [%s]%n", robotName, product, timeInHMS(++timeInSeconds));
            robot.setProcessTime(robot.getInitialProcessTime() + secondsPast);
        }

        while (products.size() > 0){
            secondsPast++;
            timeInSeconds++;
            String product = products.poll();
            boolean productProcessed = false;
            for (Robot robot : robots) {
                if (robot.getProcessTime() <= secondsPast){
                    String robotName = robot.getRobotName();
                    System.out.printf("%s - %s [%s]%n", robotName, product, timeInHMS(timeInSeconds));
                    robot.setProcessTime(robot.getProcessTime() + robot.getInitialProcessTime());
                    productProcessed = true;
                    break;
                }
            }

            if (!productProcessed){
                products.offer(product);
            }
        }
    }

    private static String timeInHMS(int timeInSeconds) {
        String hours = "0" + String.valueOf((timeInSeconds / 3600) % 24);
        timeInSeconds = timeInSeconds % 3600;
        String minutes = "0" + String.valueOf(timeInSeconds / 60);
        timeInSeconds = timeInSeconds % 60;
        String seconds = "0" + String.valueOf(timeInSeconds);

        hours = hours.length() > 2 ? hours.substring(hours.length() - 2) : hours;
        minutes = minutes.length() > 2 ? minutes.substring(minutes.length() - 2) : minutes;
        seconds = seconds.length() > 2 ? seconds.substring(seconds.length() - 2) : seconds;

        return String.format("%s:%s:%s", hours, minutes, seconds);
    }

    private static class Robot implements Comparable<Robot>{
        private String robotName;
        private int initialProcessTime;
        private int processTime;

        Robot(String robotName, int initialProcessTime) {
            this.robotName = robotName;
            this.initialProcessTime = initialProcessTime;
            this.processTime = 0;
        }

        private String getRobotName() {
            return robotName;
        }

        private void setRobotName(String robotName) {
            this.robotName = robotName;
        }

        private int getInitialProcessTime() {
            return initialProcessTime;
        }

        private void setInitialProcessTime(int initialProcessTime) {
            this.initialProcessTime = initialProcessTime;
        }

        private int getProcessTime() {
            return processTime;
        }

        private void setProcessTime(int processTime) {
            this.processTime = processTime;
        }

        @Override
        public int compareTo(Robot robot) {
            if (this.getProcessTime() > robot.getProcessTime()){
                return 1;
            } else if (this.getProcessTime() < robot.getProcessTime()){
                return -1;
            }

            return 0;
        }
    }
}
