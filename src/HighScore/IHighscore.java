/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HighScore;

import HighScore.HighscoreEntry;
import java.util.Collection;

/**
 *
 * @author Tobias Grundtvig
 */
public interface IHighscore
{
    public void addScore(String name, int score);
    public Collection<HighscoreEntry> getTopTen();
}
