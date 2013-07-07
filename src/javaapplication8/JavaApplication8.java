/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;

/**
 *
 * @author XiaoxuShen
 */
public class JavaApplication8 {
    private static int count = 0;
    private static int[][] array= {{1,1,0,1,1},{1,0,0,1,0},{1,1,0,1,0},{0,0,1,0,0}};
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*
         * Count the number of shapes in a given (1/0) matrix. A cluster of consecutive (not diagonal) 1's defines one shape. 
            eg 
            1 1 0 1 1 
            1 0 0 1 0 
            1 1 0 1 0 
            0 0 1 0 0 

            No of shapes = 4
            * solution: touch every element. let it traverse the neighbor element which can locate up down left or right. 
            * turn element into two from 1 after it's being touched. 
            * If all elements's neighbor are 0, touch element which has 1 in it. 
         */
        System.out.println(shapeMatrix(array));
    }
    public static int shapeMatrix(int[][] array){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j< array[0].length; j++){
                if(array[i][j] == 1){
                    search(i,j,array);
                    count++;
                }
            }
        }
       return count;
    }
    public static void search(int row, int column, int[][] array){
        if(row - 1 >= 0 && array[row - 1][column] == 1 ) {array[row - 1][column] = 2; search(row - 1, column, array);}
        if(row + 1 < array.length && array[row + 1][column] == 1) {array[row + 1][column] = 2; search(row + 1, column, array);}
        if(column + 1 < array[0].length && array[row][column + 1] == 1 ) {array[row][column + 1] = 2; search(row, column + 1, array);}
        if(column - 1 >= 0 && array[row][column - 1] == 1) {array[row][column - 1] = 2; search(row, column - 1, array);}
    }
}
