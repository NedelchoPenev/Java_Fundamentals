package rpg_lab;

import java.util.Random;

public interface RandomProvider {

    int nextInt(int max);

    class Implementation implements RandomProvider {

        Random random;

        public Implementation() {
            this.random = new Random();
        }

        @Override
        public int nextInt(int max) {
            return this.random.nextInt(max);
        }
    }
}
