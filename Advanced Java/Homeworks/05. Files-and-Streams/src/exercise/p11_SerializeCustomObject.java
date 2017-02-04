package exercise;

import java.io.*;

public class p11_SerializeCustomObject {

    final static String inputOutputPath = "resources/input/course.ser";
    private static Course[] courses;

    public static void main(String[] args) throws IOException {
        courses = new Course[3];
        courses[0] = new Course("Java Advanced", 198);
        courses[1] = new Course("PHP", 156);
        courses[2] = new Course("Web Basics", 320);

        saveObject();
        loadObject();
    }

    private static void saveObject() {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(inputOutputPath)))) {

            for (Course c : courses) {
                oos.writeObject(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadObject() throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(inputOutputPath)))){

            Object obj;

            while ((obj = ois.readObject()) != null) {
                System.out.println("Course: " + obj);
            }

        } catch (EOFException eof) {
            System.out.println("END OF FILE!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



    public static class Course implements Serializable{
        private String name;
        private int numberOfStudents;

        public Course (String name, int numberOfStudents){
            this.setName(name);
            this.setNumberOfStudents(numberOfStudents);
        }

        public String getName(){
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNumberOfStudents(){
            return numberOfStudents;
        }

        public void setNumberOfStudents(int numberOfStudents) {
            this.numberOfStudents = numberOfStudents;
        }

        @Override
        public String toString() {
            return "{Name: " + this.getName() +
                    ", Number of students: " + this.getNumberOfStudents() + "}";
        }
    }
}

