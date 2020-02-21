public class SnakeGame {

    //Attributes
    private boolean[][] game;
    private int[] headPosition;
    //headPosition[0] = xPosition = Collumn
    //headPosition[1] = yPosition = Row
    private static int exhaustiveChecks;
    private static int recursiveChecks;

    //Constructors

    public SnakeGame() {

        this.game = new boolean[1][1];

    }

    public SnakeGame(boolean[][] game, int xPosition, int yPosition) {

        this.game = new boolean[game.length][game.length];
        copyArray(game,this.game);
        this.headPosition = new int[2];
        this.headPosition[0] = xPosition;
        this.headPosition[1] = yPosition;

    }

    //Main Methods

    public int[] findTailExhaustive() {

        int count = 0;
        int[] tail = new int[3];
        //tail[0] = x = col
        //tail[1] = y = row
        //tail[2] = length of the snake

        for (int row = 0; row < this.game.length; row++) {

            for (int col = 0; col < this.game.length; col++) {
                //Checks for the snakes length
                if (this.game[row][col]) {
                    count++;
                }
                //checks for tail's position
                if (findNeighbors(row, col) == 1 && (col != headPosition[0] || row != headPosition[1])) {
                    tail[0] = row;
                    tail[1] = col;
                }
            }

        }
        tail[2] = count;
        return tail;
    }

    public int[] findTailRecursive(){


    }


    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition){


    }

    private void resetCounters(){


    }

    private static int getRecursiveChecks(){


    }

    private static int getExhaustiveChecks(){


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
        if (row > 0 && this.game[row][col]) {
            neighborCounter++;
        }
        //Bottom
        if (row < this.game.length - 1 && this.game[row][col]) {
            neighborCounter++;
        }
        //Left
        if (col > 0 && this.game[row][col]) {
            neighborCounter++;
        }
        //Right
        if (col < this.game.length - 1 && this.game[row][col]) {
            neighborCounter++;
        }
        return neighborCounter;

    }


}
