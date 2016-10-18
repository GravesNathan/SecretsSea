/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.secretsOfTheSea.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author SDababneh
 */
public class Map implements Serializable{
    
    //class instance variables
    private int xMax;
    private int yMax;
    private static char Difficulty;
    private static int [][] grid;
    private static char [][] visibleMap;
    
    public Map() {
    }
    
    
    
    /**
     * Get the value of xMax
     *
     * @return the value of xMax
     */
    public int getxMax() {
        return xMax;
    }

    /**
     * Set the value of xMax
     *
     * @param xMax new value of xMax
     */
    public void setxMax(int xMax) {
        this.xMax = xMax;
    }



    /**
     * Get the value of yMax
     *
     * @return the value of yMax
     */
    public int getyMax() {
        return yMax;
    }

    /**
     * Set the value of yMax
     *
     * @param yMax new value of yMax
     */
    public void setyMax(int yMax) {
        this.yMax = yMax;
    }



    /**
     * Get the value of Difficulty
     *
     * @return the value of Difficulty
     */
    public static char getDifficulty() {
        return Difficulty;
    }

    /**
     * Set the value of Difficulty
     *
     * @param Difficulty new value of Difficulty
     */
    public void setDifficulty(char Difficulty) {
        this.Difficulty = Difficulty;
    }

    public static int[][] getGrid() {
        return grid;
    }

    public static void setGrid(int[][] grid) {
        Map.grid = grid;
    }

    public static char[][] getVisibleMap() {
        return visibleMap;
    }

    public static void setVisibleMap(char[][] visibleMap) {
        Map.visibleMap = visibleMap;
    }

    public static int getSpot(int x, int y){
        return grid[x][y];
    }
    
    @Override
    public String toString() {
        return "Map{" + "xMax=" + xMax + ", yMax=" + yMax + ", Difficulty=" + Difficulty + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.xMax;
        hash = 13 * hash + this.yMax;
        hash = 13 * hash + Arrays.deepHashCode(Map.grid);
        hash = 13 * hash + Arrays.deepHashCode(Map.visibleMap);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Map other = (Map) obj;
        if (this.xMax != other.xMax) {
            return false;
        }
        if (this.yMax != other.yMax) {
            return false;
        }
        return true;
    }

    

    
    
}
