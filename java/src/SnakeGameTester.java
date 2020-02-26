import static org.junit.jupiter.api.Assertions.*;

class SnakeGameTester {

    @org.junit.jupiter.api.Test
    void findTailExhaustive1() {
    }

    @org.junit.jupiter.api.Test
    void findTailRecursive1() {
        boolean[][] array = {{false, false, false, false, false, false, false, false, false, false},
                {false, true, false, true, true, true, true, true, false, false},
                {false, true, false, true, false, false, false, true, false, false},
                {false, true, false, true, false, true, false, true, false, false},
                {false, true, false, true, false, true, false, true, false, false},
                {false, true, false, true, false, true, false, true, false, false},
                {false, true, false, true, true, true, false, true, false, false},
                {false, true, false, false, false, false, false, true, false, false},
                {false, true, true, true, true, true, true, true, false, false},
                {false, false, false, false, false, false, false, false, false, false}};

        SnakeGame snakeGame = new SnakeGame(array, 3, 5);
        int[] resultExp = {1, 1, 35};

        assertArrayEquals(resultExp, snakeGame.findTailRecursive());

    }
}