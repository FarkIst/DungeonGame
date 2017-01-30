/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HighScore;

/**
 *
 * @author Farkas
 */
public class HighscoreEntry implements Comparable<HighscoreEntry>
{
    private final String name;
    private final int score;

    public HighscoreEntry(String name, int score)
    {
        this.name = name;
        this.score = score;
    }

    public String getName()
    {
        return name;
    }

    public int getScore()
    {
        return score;
    }

    @Override
    public int compareTo(HighscoreEntry other)
    {
       
        int c = other.score - score;
        if(c != 0) return c;
        return name.compareTo(other.name);
    }
    
}
