package com.brianmacgiolladhuibh.sudoku;

public class SudokuSolver {
    public static void main(String[] args){
        System.out.println("Hello");

        System.out.println("We are going to solve a sudoku here");

        // Sample Sudoku puzzle
        int[][]  sudoku  = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0} };


        System.out.println("Going to solve this sudoku puzzle");

        // Print the puzzle before solving it
        printSudoku(sudoku);

        // Call the method to solve the puzzle
        boolean isSudokusolved = solveSudoku(sudoku);
        if(isSudokusolved){
            System.out.println("This Sudoku is solved");
        } else {
            System.out.println("This Sudoku is not solved");
        }

        // Print the completed puzzle
        printSudoku(sudoku);

    }

    // Method to solve the sudoku
    public static boolean solveSudoku(int[][] sudoku){

        // Check if all the squares are full
        int row = 0;
        int col = 0;
        boolean isSudokoComplete = true;
        for(int indexRow = 0; indexRow < 9; indexRow++){
            for(int indexCol = 0; indexCol < 9; indexCol++){

                // if the value is zero then it is not assigned a value yet
                if(sudoku[indexRow][indexCol] == 0) {
                    isSudokoComplete = false;

                    row = indexRow;
                    col = indexCol;

                    break;
                }
            }
        }

        // Check if the sudoku is complete
        if(isSudokoComplete){
            // The sudoku is complete
            return true;
        }

        // The sudoku is not complete
        // loop to find which numbers fit
        for(int thisNumber = 1; thisNumber <= 9; thisNumber++){

            // Check if the number (1-9) fits in the square
            // If if it fits, set it's value to the square
            if(numberFitsHere(sudoku, thisNumber, row, col)) {
                sudoku[row][col] = thisNumber;

                // Move to the next square
                if (solveSudoku(sudoku)) {
                    return true;
                } else {
                    // The number did not fit and the method backtracks, reset it to 0
                    sudoku[row][col] = 0;
                }
            }
        }

        // No number fit here, backtrack the algorithm
        return false;

    }

    // method to check if a number fits in a square
    private static boolean numberFitsHere(int[][] sudoku, int number, int row, int col) {

        // check if the number fits in the row, col and square
        if(!numberFitsInRow(sudoku, number, row) || !numberFitsInCol(sudoku, number, col)  || !numberFitsInSquare(sudoku, number, row, col)){
            // The number does not fit here
            return false;
        } else {
            // The number does fit here
            return true;
        }
    }

    // Method to check if a number fits in a row
    public static boolean numberFitsInRow(int[][] sudoku, int number, int row) {
        // check if the number fits in the row
        for (int colIndex = 0; colIndex < 9; colIndex++) {
            if (sudoku[row][colIndex] == number) {
                System.out.println("The number " + number + " is already in the row " + row);
                // The number does not fit
                return false;
            }
        }
        // The number does fit
        return true;
    }

    // Method to check if a number fits in a column
    public static boolean numberFitsInCol(int[][] sudoku, int number, int col) {
        // check if the number fits in the column
        for (int rowIndex = 0; rowIndex < 9; rowIndex++) {
            if (sudoku[rowIndex][col] == number) {
                System.out.println("The number " + number + " is already in the column " + col);
                // The number does not fit
                return false;
            }
        }
        // The number does fit
        return true;
    }

    // Check to see if the number fits in the 3x3 square
    public static boolean numberFitsInSquare(int[][] sudoku, int number, int row, int col) {
        // check if the number fits in the square
        // top left square
        if(row < 3 && col < 3){
            for(int thisRow = 0; thisRow < 3; thisRow++ ){
                for(int thisCol = 0; thisCol < 3; thisCol++ ){
                    if(sudoku[thisRow][thisCol] == number){
                        System.out.println("The number " + number + " is already in the square for  row " + thisRow + ", col " + thisCol);
                        return false;
                    }
                }
            }
        }
        // top middle square
        if(row < 3 && col >= 3 && col < 6){
            for(int thisRow = 0; thisRow < 3; thisRow++ ){
                for(int thisCol = 3; thisCol < 6; thisCol++ ){
                    if(sudoku[thisRow][thisCol] == number){
                        System.out.println("The number " + number + " is already in the square for  row " + thisRow + ", col " + thisCol);
                        return false;
                    }
                }
            }
        }
        // top right square
        if(row < 3 && col >= 6){
            for(int thisRow = 0; thisRow < 3; thisRow++ ){
                for(int thisCol = 6; thisCol < 9; thisCol++ ){
                    if(sudoku[thisRow][thisCol] == number){
                        System.out.println("The number " + number + " is already in the square for  row " + thisRow + ", col " + thisCol);
                        return false;
                    }
                }
            }
        }
        // middle left square
        if(row >= 3 && row < 6 && col < 3){
            for(int thisRow = 3; thisRow < 6; thisRow++ ){
                for(int thisCol = 0; thisCol < 3; thisCol++ ){
                    if(sudoku[thisRow][thisCol] == number){
                        System.out.println("The number " + number + " is already in the square for  row " + thisRow + ", col " + thisCol);
                        return false;
                    }
                }
            }
        }
        // middle middle square
        if(row >= 3 && row < 6 && col >= 3 && col < 6){
            for(int thisRow = 3; thisRow < 6; thisRow++ ){
                for(int thisCol = 3; thisCol < 6; thisCol++ ){
                    if(sudoku[thisRow][thisCol] == number){
                        System.out.println("The number " + number + " is already in the square for  row " + thisRow + ", col " + thisCol);
                        return false;
                    }
                }
            }
        }
        // middle right square
        if(row >= 3 && row < 6 && col >= 6 ){
            for(int thisRow = 3; thisRow < 6; thisRow++ ){
                for(int thisCol = 6; thisCol < 9; thisCol++ ){
                    if(sudoku[thisRow][thisCol] == number){
                        System.out.println("The number " + number + " is already in the square for  row " + thisRow + ", col " + thisCol);
                        return false;
                    }
                }
            }
        }
        // bottom left square
        if(row >= 6 && col < 3){
            for(int thisRow = 6; thisRow < 9; thisRow++ ){
                for(int thisCol = 0; thisCol < 3; thisCol++ ){
                    if(sudoku[thisRow][thisCol] == number){
                        System.out.println("The number " + number + " is already in the square for  row " + thisRow + ", col " + thisCol);
                        return false;
                    }
                }
            }
        }
        // bottom middle square
        if(row >= 6 && col >= 3 && col < 6){
            for(int thisRow = 6; thisRow < 9; thisRow++ ){
                for(int thisCol = 3; thisCol < 6; thisCol++ ){
                    if(sudoku[thisRow][thisCol] == number){
                        System.out.println("The number " + number + " is already in the square for  row " + thisRow + ", col " + thisCol);
                        return false;
                    }
                }
            }
        }
        // bottom right square
        if(row >= 6 && col >= 6 ){
            for(int thisRow = 6; thisRow < 9; thisRow++ ){
                for(int thisCol = 6; thisCol < 9; thisCol++ ){
                    if(sudoku[thisRow][thisCol] == number){
                        System.out.println("The number " + number + " is already in the square for  row " + row + ", col " + col);
                        return false;
                    }
                }
            }
        }

        // It fits
        return true;
    }

    // Method to print the sudoku puzzle for the user to see
    private static void printSudoku(int[][] sudoku){
        for(int row = 0; row < 9; row++){
            System.out.print("\n");
            if(row % 3 == 0){
                System.out.print("\n");
            }
            for(int col = 0; col < 9; col++){
                if(col % 3 == 0){
                    System.out.print(" ");
                }
                if(sudoku[row][col] == 0){
                    System.out.print("? ");
                } else if (sudoku[row][col] == 1){
                    System.out.print("1 ");
                } else if (sudoku[row][col] == 2){
                    System.out.print("2 ");
                } else if (sudoku[row][col] == 3){
                    System.out.print("3 ");
                } else if (sudoku[row][col] == 4){
                    System.out.print("4 ");
                } else if (sudoku[row][col] == 5){
                    System.out.print("5 ");
                } else if (sudoku[row][col] == 6){
                    System.out.print("6 ");
                } else if (sudoku[row][col] == 7){
                    System.out.print("7 ");
                } else if (sudoku[row][col] == 8){
                    System.out.print("8 ");
                } else if (sudoku[row][col] == 9) {
                    System.out.print("9 ");
                }
            }
        }
        System.out.print("\n");
    }
}
