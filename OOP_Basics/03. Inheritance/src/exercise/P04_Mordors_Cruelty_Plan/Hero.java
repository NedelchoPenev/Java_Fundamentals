package exercise.P04_Mordors_Cruelty_Plan;

public class Hero extends FoodFactory {

    private static final String MOOD_ANGRY = "Angry";
    private static final String MOOD_SAD = "Sad";
    private static final String MOOD_HAPPY = "Happy";
    private static final String MOOD_JAVASCRIPT = "JavaScript";

    String getMood(){
        return this.calculateMood();
    }

    private String calculateMood() {
        int points = super.getPoints();

        if (points < -5) {
            return MOOD_ANGRY;
        } else if (points < 0) {
            return MOOD_SAD;
        } else if (points <= 15) {
            return MOOD_HAPPY;
        } else if (points > 15) {
            return MOOD_JAVASCRIPT;
        }

        return null;
    }
}
