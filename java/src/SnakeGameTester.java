import static org.junit.jupiter.api.Assertions.*;

class SnakeGameTester {

    ///////////////////////////////////////////////////////////////////////////
    //                        FIND TAIL EXHAUSTIVE                           //
    ///////////////////////////////////////////////////////////////////////////

    /*
     * findTailExhaustive:
     * Test case 1:
     * array:
     * 10 x 10
     * {false, false, false, false, false, false, false, false, false, false},
     * {false, true, false, true, true, true, true, true, false, false},
     * {false, true, false, true, false, false, false, true, false, false},
     * {false, true, false, true, false, true, false, true, false, false},
     * {false, true, false, true, false, true, false, true, false, false},
     * {false, true, false, true, false, true, false, true, false, false},
     * {false, true, false, true, true, true, false, true, false, false},
     * {false, true, false, false, false, false, false, true, false, false},
     * {false, true, true, true, true, true, true, true, false, false},
     * {false, false, false, false, false, false, false, false, false, false}
     *
     * Reason: This test case's purpose is to recreate a normal game of snake in which
     *         all of the snake's positions are not in the edges and the exhaustive counter
     *         should end when the first position of the snake is found
     *
     * Details: headPosition = {1,1}
     *          length = 35
     *          exhaustive counters = 12
     *
     * Results: The function did return the expected results within the array.
     *
     */
    @org.junit.jupiter.api.Test
    void findTailExhaustive1() {
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
        assertArrayEquals(resultExp, snakeGame.findTailExhaustive());
        assertEquals(12, snakeGame.getExhaustiveChecks());

    }

    /*
     * findTailExhaustive:
     * Test case 2:
     * array:
     * 10 x 10
     * {true, true, true, true, true, true, true, true, true, true},
     * {true, false, false, false, false, false, false, false, false, true},
     * {true, false, false, false, false, false, false, false, false, true},
     * {true, false, false, false, false, false, false, false, false, true},
     * {true, false, false, false, false, false, false, false, false, true},
     * {true, false, false, false, false, false, false, false, false, true},
     * {true, false, false, false, false, false, false, false, false, true},
     * {true, false, false, false, false, false, false, false, false, true},
     * {true, false, false, false, false, false, false, false, false, true},
     * {false, false, true, true, true, true, true, true, true, true}
     *
     * Reason: This test case's purpose is to recreate a normal game of snake in which
     *         all of the snake's positions are within the edges and the exhaustive check
     *         should end after the first position of the snake is found
     *
     * Details: headPosition = {8,0}
     *          length = 34
     *          exhaustive checks = 93
     *
     * Results: The function did return the expected results within the array.
     */
    @org.junit.jupiter.api.Test
    void findTailExhaustive2() {
        boolean[][] array = {{true, true, true, true, true, true, true, true, true, true},
                {true, false, false, false, false, false, false, false, false, true},
                {true, false, false, false, false, false, false, false, false, true},
                {true, false, false, false, false, false, false, false, false, true},
                {true, false, false, false, false, false, false, false, false, true},
                {true, false, false, false, false, false, false, false, false, true},
                {true, false, false, false, false, false, false, false, false, true},
                {true, false, false, false, false, false, false, false, false, true},
                {true, false, false, false, false, false, false, false, false, true},
                {false, false, true, true, true, true, true, true, true, true}};

        SnakeGame snakeGame = new SnakeGame(array, 8, 0);
        int[] resultExp = {9, 2, 34};
        assertArrayEquals(resultExp, snakeGame.findTailExhaustive());
        assertEquals(93, snakeGame.getExhaustiveChecks());

    }

    /*
     * findTailExhaustive:
     * Test case 3:
     * array:
     * 1 x 1
     * {true}
     *
     * Reason: This test case's purpose is to test whether the method can work in a 1 x 1 array
     *         while properly returning the length and position of tail.
     *
     * Details: headPosition = {0,0}
     *          length = 1
     *
     * Results: The function did return the expected results within the array.
     */
    @org.junit.jupiter.api.Test
    void findTailExhaustive3() {

        SnakeGame snakeGame = new SnakeGame();
        int[] resultExp = {0, 0, 1};
        assertArrayEquals(resultExp, snakeGame.findTailExhaustive());
        assertEquals(1, snakeGame.getExhaustiveChecks());


    }

    /*
     * findTailExhaustive:
     * Test case 4:
     * array:
     * 10 x 10
     * {true, true, true, true, true, true, true, true, true, true},
     * {false, false, false, false, false, false, false, false, false, true},
     * {true, true, true, true, true, true, true, true, true, true},
     * {true, false, false, false, false, false, false, false, false, false},
     * {true, true, true, true, true, true, true, true, true, true},
     * {false, false, false, false, false, false, false, false, false, true},
     * {false, true, true, true, false, true, true, true, false, true},
     * {false, true, false, true, false, true, false, true, false, true},
     * {false, true, false, true, false, true, false, true, false, true},
     * {true, true, false, true, true, true, false, true, true, true}
     *
     * Reason: This test case's purpose is to recreate a normal game of snake in which
     *         the grid is mostly full and the snake's position changes in many directions
     *         which includes positions within th edges of the array and the tail is within a corner
     *
     *
     * Details: headPosition = {8,0}
     *          length = 34
     *          exhaustive checks = 1
     *
     * Results: The function did return the expected results within the array.
     */
    @org.junit.jupiter.api.Test
    void findTailExhaustive4() {
        boolean[][] array = {{true, true, true, true, true, true, true, true, true, true},
                {false, false, false, false, false, false, false, false, false, true},
                {true, true, true, true, true, true, true, true, true, true},
                {true, false, false, false, false, false, false, false, false, false},
                {true, true, true, true, true, true, true, true, true, true},
                {false, false, false, false, false, false, false, false, false, true},
                {false, true, true, true, false, true, true, true, false, true},
                {false, true, false, true, false, true, false, true, false, true},
                {false, true, false, true, false, true, false, true, false, true},
                {true, true, false, true, true, true, false, true, true, true}};

        SnakeGame snakeGame = new SnakeGame(array, 0, 0);
        int[] resultExp = {9, 0, 58};
        assertArrayEquals(resultExp, snakeGame.findTailExhaustive());
        assertEquals(91, snakeGame.getExhaustiveChecks());

    }

    /*
     * findTailExhaustive:
     * Test case 5:
     * array:
     * 3 x 3
     * {true, false, false},
     * {false, false, false},
     * {true, true, true}
     *
     * Reason: This test case's purpose is to check if the method would work with the
     *         smallest size of the snake which is of size three within a 3 x 3 array.
     *
     * Details: headPosition = {1,1}
     *          length = 35
     *          exhaustive checks = 7
     *
     * Results: The function did return the expected results within the array.
     */
    @org.junit.jupiter.api.Test
    void findTailExhaustive5() {
        boolean[][] array = {{false, false, false},
                {false, false, false},
                {true, true, true}};

        SnakeGame snakeGame = new SnakeGame(array, 2, 2);
        int[] resultExp = {2, 0, 3};
        assertArrayEquals(resultExp, snakeGame.findTailExhaustive());
        assertEquals(7, snakeGame.getExhaustiveChecks());

    }

    ///////////////////////////////////////////////////////////////////////////
    //                         FIND TAIL RECURSIVE                           //
    ///////////////////////////////////////////////////////////////////////////

    /*
     * findTailRecursive:
     * Test case 1:
     * array:
     * 10 x 10
     * {false, false, false, false, false, false, false, false, false, false},
     * {false, true, false, true, true, true, true, true, false, false},
     * {false, true, false, true, false, false, false, true, false, false},
     * {false, true, false, true, false, true, false, true, false, false},
     * {false, true, false, true, false, true, false, true, false, false},
     * {false, true, false, true, false, true, false, true, false, false},
     * {false, true, false, true, true, true, false, true, false, false},
     * {false, true, false, false, false, false, false, true, false, false},
     * {false, true, true, true, true, true, true, true, false, false},
     * {false, false, false, false, false, false, false, false, false, false}
     *
     * Reason: This test case's purpose is to recreate a normal game of snake in which
     *         all of the snake's positions are not in the edges.
     *
     * Details: headPosition = {1,1}
     *          length = 35
     *
     * Results: The function did return the expected results within the array.
     */
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

    /*
     * findTailRecursive:
     * Test case 2:
     * array:
     * 10 x 10
     * {true, true, true, true, true, true, true, true, true, true},
     * {true, false, false, false, false, false, false, false, false, true},
     * {true, false, false, false, false, false, false, false, false, true},
     * {true, false, false, false, false, false, false, false, false, true},
     * {true, false, false, false, false, false, false, false, false, true},
     * {true, false, false, false, false, false, false, false, false, true},
     * {true, false, false, false, false, false, false, false, false, true},
     * {true, false, false, false, false, false, false, false, false, true},
     * {true, false, false, false, false, false, false, false, false, true},
     * {false, false, true, true, true, true, true, true, true, true}
     *
     * Reason: This test case's purpose is to recreate a normal game of snake in which
     *         all of the snake's positions are within the edges.
     *
     * Details: headPosition = {8,0}
     *          length = 34
     *
     * Results: The function did return the expected results within the array.
     */
    @org.junit.jupiter.api.Test
    void findTailRecursive2() {
        boolean[][] array = {{true, true, true, true, true, true, true, true, true, true},
                {true, false, false, false, false, false, false, false, false, true},
                {true, false, false, false, false, false, false, false, false, true},
                {true, false, false, false, false, false, false, false, false, true},
                {true, false, false, false, false, false, false, false, false, true},
                {true, false, false, false, false, false, false, false, false, true},
                {true, false, false, false, false, false, false, false, false, true},
                {true, false, false, false, false, false, false, false, false, true},
                {true, false, false, false, false, false, false, false, false, true},
                {false, false, true, true, true, true, true, true, true, true}};

        SnakeGame snakeGame = new SnakeGame(array, 8, 0);
        int[] resultExp = {9, 2, 34};
        assertArrayEquals(resultExp, snakeGame.findTailRecursive());

    }

    /*
     * findTailRecursive:
     * Test case 3:
     * array:
     * 1 x 1
     * {true}
     *
     * Reason: This test case's purpose is to test whether the method can work in a 1 x 1 array
     *         while properly returning the length and position of tail.
     *
     * Details: headPosition = {0,0}
     *          length = 1
     *
     * Results: The function did return the expected results within the array.
     */
    @org.junit.jupiter.api.Test
    void findTailRecursive3() {

        SnakeGame snakeGame = new SnakeGame();
        int[] resultExp = {0, 0, 1};
        assertArrayEquals(resultExp, snakeGame.findTailRecursive());

    }

    /*
     * findTailRecursive:
     * Test case 4:
     * array:
     * 10 x 10
     * {true, true, true, true, true, true, true, true, true, true},
     * {false, false, false, false, false, false, false, false, false, true},
     * {true, true, true, true, true, true, true, true, true, true},
     * {true, false, false, false, false, false, false, false, false, false},
     * {true, true, true, true, true, true, true, true, true, true},
     * {false, false, false, false, false, false, false, false, false, true},
     * {false, true, true, true, false, true, true, true, false, true},
     * {false, true, false, true, false, true, false, true, false, true},
     * {false, true, false, true, false, true, false, true, false, true},
     * {true, true, false, true, true, true, false, true, true, true}
     *
     * Reason: This test case's purpose is to recreate a normal game of snake in which
     *         the grid is mostly full and the snake's position changes in many directions
     *         which includes positions within th edges of the array
     *
     * Details: headPosition = {8,0}
     *          length = 34
     *
     * Results: The function did return the expected results within the array.
     */
    @org.junit.jupiter.api.Test
    void findTailRecursive4() {
        boolean[][] array = {{true, true, true, true, true, true, true, true, true, true},
                {false, false, false, false, false, false, false, false, false, true},
                {true, true, true, true, true, true, true, true, true, true},
                {true, false, false, false, false, false, false, false, false, false},
                {true, true, true, true, true, true, true, true, true, true},
                {false, false, false, false, false, false, false, false, false, true},
                {false, true, true, true, false, true, true, true, false, true},
                {false, true, false, true, false, true, false, true, false, true},
                {false, true, false, true, false, true, false, true, false, true},
                {true, true, false, true, true, true, false, true, true, true}};

        SnakeGame snakeGame = new SnakeGame(array, 0, 0);
        int[] resultExp = {9, 0, 58};
        assertArrayEquals(resultExp, snakeGame.findTailRecursive());

    }

    /*
     * findTailRecursive:
     * Test case 5:
     * array:
     * 3 x 3
     * {true, false, false},
     * {false, false, false},
     * {true, true, true}
     *
     * Reason: This test case's purpose is to check if the method would work with the
     *         smallest size of the snake which is of size three within a 3 x 3 array.
     *
     * Details: headPosition = {1,1}
     *          length = 35
     *
     * Results: The function did return the expected results within the array.
     */
    @org.junit.jupiter.api.Test
    void findTailRecursive5() {
        boolean[][] array = {{false, false, false},
                {false, false, false},
                {true, true, true}};

        SnakeGame snakeGame = new SnakeGame(array, 2, 2);
        int[] resultExp = {2, 0, 3};
        assertArrayEquals(resultExp, snakeGame.findTailRecursive());

    }


}