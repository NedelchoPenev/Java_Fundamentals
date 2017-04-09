package lab.P02_FileStream;

public class Main {

    public static void main(String[] args) {

        StreamProgressInfo streamProgressInfo = new StreamProgressInfo(new WebVideo(100, 50));
        System.out.println(streamProgressInfo.calculateCurrentPercent());
    }
}
