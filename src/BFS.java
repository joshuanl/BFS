import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.awt.*;
import java.util.ArrayList;


/**
 * Created by itsfunshine on 7/9/2016.
 */
public class BFS {
    static int[][] maze = {
            {0, 0, 0, 0, 0, 1, 1, 1},
            {0, 0, 0, 0, 0, 1, -1, 1},
            {0, 1, 1, 1, 0, 1, 1, 1},
            {0, 1, -1, 2, 1, 0, 0, 0},
            {0, 1, 2, -1, 1, 0, 0, 1},
            {0, 0, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 1},
            {0, 0, 0, 0, 0, 0, 1, -1}
    };
    static boolean[][] visited = new boolean[maze.length][maze.length];
    public static void main(String[] args){
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                visited[i][j] = false;
            }
        }
        BFS(maze, 0, 0);
        System.out.println(visited[0][0]);
        printGird(maze);
        System.out.println();
    }//end of main

    public static void BFS(int[][] grid, int x, int y){

        ArrayList<Point> list = new ArrayList<Point>();
        list.add(new Point(x, y));
        while(!list.isEmpty()) {
            Point p = list.get(0);
            System.out.println(p.x + " " + p.y);
            list.remove(0);
            int row = p.x;
            int col = p.y;
            if(visited[row][col] == true){
                continue;
            }
            visited[row][col] = true;
            if (grid[row][col] == -1) {
                System.out.println("Mine at " + row + " " + col);
                return;
            }//eo if
            if(grid[row][col] == 0) {
                if (row - 1 >= 0) {
                    if (col - 1 >= 0) {
                        list.add(new Point(row - 1, col - 1));
                    }//eo if top left
                    if (col + 1 < grid.length) {
                        list.add(new Point(row - 1, col + 1));
                    }//eo if top right
                    list.add(new Point(row - 1, col));
                    // adding directly above
                }//eo if not neg above
                if (row + 1 < grid.length) {
                    if (col - 1 >= 0) {
                        list.add(new Point(row + 1, col - 1));
                    }//eo if bot left
                    if (col + 1 < grid.length) {
                        list.add(new Point(row + 1, col + 1));
                    }//eo if bot right
                    list.add(new Point(row + 1, col));
                    // adding directly below
                }//end of if below
                if (col - 1 >= 0) {
                    list.add(new Point(row, col - 1));
                }//eo left
                if (col + 1 < grid.length) {
                    list.add(new Point(row, col + 1));
                }//eo right
            }
        }//eo while
    }//end of bfs

    public static void printGird(int[][] grid){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (visited[i][j] == true) {
                    if (grid[i][j] != 0) {
                        System.out.print(grid[i][j]);
                    }
                    else{
                        System.out.print(" ");
                    }
                }
                else{
                    System.out.print(" ");
                }
            }//eo inner for
            System.out.println();
        }//eo outer for
    }
}//end of class
