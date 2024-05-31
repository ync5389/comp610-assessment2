/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xhu
 */
public class Maze extends Thread{
    private char[][] grid; // The maze grid (2D array)
    private int numRows;   // Number of rows in the maze
    private int numCols;   // Number of columns in the maze

    public Maze(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.grid = new char[numRows][numCols];
        initializeMaze(); // Initialize the maze (e.g., set walls, open paths, etc.)
    }

    // Initialize the maze (example: set walls and open paths)
    private void initializeMaze() {
        // Example: Fill the entire grid with walls ('X')
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                grid[row][col] = 'X';
            }
        }
    }

    // Get the character at a specific position in the maze
    public char getCell(int row, int col) {
        if (isValidPosition(row, col)) {
            return grid[row][col];
        }
        return ' '; // Return an empty cell if position is invalid
    }

    // Check if a position is valid (within maze boundaries)
    private boolean isValidPosition(int row, int col) {
        return row >= 0 && row < numRows && col >= 0 && col < numCols;
    }

    // Example: Set an open path at a specific position
    public void setOpenPath(int row, int col) {
        if (isValidPosition(row, col)) {
            grid[row][col] = ' ';
        }
    }

    // Example: Set a wall at a specific position
    public void setWall(int row, int col) {
        if (isValidPosition(row, col)) {
            grid[row][col] = 'X';
        }
    }

    // Example: Print the maze (for debugging purposes)
    public void printMaze() {
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Example usage:
        Maze maze = new Maze(5, 5); // Create a 5x5 maze
        maze.setOpenPath(1, 1);    // Set an open path at (1, 1)
        maze.setOpenPath(3, 3);    // Set another open path at (3, 3)
        maze.setWall(2, 2);        // Set a wall at (2, 2)

        maze.printMaze(); // Print the maze to see the result
    }
        
}
