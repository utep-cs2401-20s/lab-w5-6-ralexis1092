public class SnakeGame {

    //Attributes
    private boolean[][] game;
    private int[] headPosition;
    private static int exhaustiveChecks;
    private static int recursiveChecks;

    //Constructors

    public SnakeGame() {

        this.game = new boolean[1][1];
        this.headPosition = new int[2];
        this.headPosition[0] = 0;
        this.headPosition[1] = 0;
        this.exhaustiveChecks = 0;
        this.recursiveChecks = 0;

    }

    public SnakeGame(boolean[][] game, int xPosition, int yPosition) {

        this.game = new boolean[game.length][game.length];
        copyArray(game, this.game);
        this.headPosition = new int[2];
        this.headPosition[0] = xPosition;
        this.headPosition[1] = yPosition;
        this.exhaustiveChecks = 0;
        this.recursiveChecks = 0;

    }

    //Main Methods

    public int[] findTailExhaustive() {

        int lengthCounter = 0;
        int[] tail = new int[3];
        int exhaustiveCounter = 0;
        //tail[0] = x = row
        //tail[1] = y = col
        //tail[2] = length of the snake

        for (int row = 0; row < this.game.length; row++) {

            for (int col = 0; col < this.game.length; col++) {

                exhaustiveCounter++;
                //Checks for the snakes length
                if (this.game[row][col]) {
                    lengthCounter++;
                }
                //checks for tail's position
                if (findNeighbors(row, col) == 1 && (row != headPosition[0] || col != headPosition[1])) {
                    tail[0] = row;
                    tail[1] = col;
                    this.exhaustiveChecks = exhaustiveCounter;

                }

            }

        }
        tail[2] = lengthCounter;
        return tail;
    }

    public int[] findTailRecursive(){

         return findTailRecursive(this.headPosition, this.headPosition);

    }


    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition) {

        int row1 = currentPosition[0];
        int col1 = currentPosition[1];
        int row2 = previousPosition[0];
        int col2 = previousPosition[1];
        int[] tail = new int[3];
        this.recursiveChecks++;
        int[] a = new int[2];

        //base case
        if (findNeighbors(row1, col1) == 1 && (row1 != headPosition[0] || col1 != headPosition[1])) {

            tail[0] = row1;
            tail[1] = col1;
            tail[2] = recursiveChecks;
            return tail;

        }
        //Head case
        if (row1 == headPosition[0] && col1 == headPosition[1]) {
            String direction = findHeadNeighbor(row1, col1);
            if (direction.equals("top")) {
                a[0] = row1 - 1;
                a[1] = col1;
            } else if (direction.equals("bottom")) {
                a[0] = row1 + 1;
                a[1] = col1;
            } else if (direction.equals("left")) {
                a[0] = row1;
                a[1] = col1 - 1;
            } else if (direction.equals("right")) {
                a[0] = row1;
                a[1] = col1 + 1;
            }
            return findTailRecursive(a, currentPosition);

        }
        //Other case TOP
        if (this.game[row1 - 1][col1] && (row1 - 1 != row2 || col1 != col2)) {
            a[0] = row1 - 1;
            a[1] = col1;
        }
        //Other case Bottom
        if (this.game[row1 + 1][col1] && (row1 + 1 != row2 || col1 != col2)) {
            a[0] = row1 + 1;
            a[1] = col1;
        }
        //Other case Left
        if (this.game[row1][col1 - 1] && (row1 != row2 || col1 - 1 != col2)) {
            a[0] = row1;
            a[1] = col1 - 1;
        }
        //Other case Right
        if (this.game[row1][col1 + 1] && (row1 != row2 || col1 + 1 != col2)) {
            a[0] = row1;
            a[1] = col1 + 1;
        }
        return findTailRecursive(a, currentPosition);

    }

    private void resetCounters() {

        this.exhaustiveChecks = 0;
        this.recursiveChecks = 0;

    }

    private int getRecursiveChecks() {

        return this.recursiveChecks;

    }

    private int getExhaustiveChecks() {

        return this.exhaustiveChecks;

    }

    //Side Methods
    public void copyArray(boolean[][] board, boolean [][] copy){
        for (int i = 0; i < board.length; i++) {

            for(int j = 0; j < board[i].length; j++){

                copy[i][j] = board[i][j];
            }
        }
    }

    public void printArray(){

        for(int i = 0; i < this.game.length; i++) {

            for (int j = 0; j < this.game[i].length; j++) {

                System.out.print(this.game[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int findNeighbors(int row, int col) {

        int neighborCounter = 0;

        //Top
        if (row > 0 && this.game[row - 1][col]) {
            neighborCounter++;
        }
        //Bottom
        if (row < this.game.length - 1 && this.game[row + 1][col]) {
            neighborCounter++;
        }
        //Left
        if (col > 0 && this.game[row][col - 1]) {
            neighborCounter++;
        }
        //Right
        if (col < this.game.length - 1 && this.game[row][col + 1]) {
            neighborCounter++;
        }
        return neighborCounter;

    }

    public String findHeadNeighbor(int row, int col) {

        String direction = "";
        //Top
        if (row > 0 && this.game[row - 1][col]) {
            direction = "top";
        }
        //Bottom
        if (row < this.game.length - 1 && this.game[row + 1][col]) {
            direction = "bottom";
        }
        //Left
        if (col > 0 && this.game[row][col - 1]) {
            direction = "left";
        }
        //Right
        if (col < this.game.length - 1 && this.game[row][col + 1]) {
            direction = "right";
        }
        return direction;

    }
}
