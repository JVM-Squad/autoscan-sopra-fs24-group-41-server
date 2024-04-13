package ch.uzh.ifi.hase.soprafs24.game;

import ch.uzh.ifi.hase.soprafs24.entity.Player;
import ch.uzh.ifi.hase.soprafs24.entity.Word;
import ch.uzh.ifi.hase.soprafs24.service.CombinationService;
import ch.uzh.ifi.hase.soprafs24.service.PlayerService;
import ch.uzh.ifi.hase.soprafs24.service.WordService;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Word> startingWords;
    PlayerService playerService;
    WordService wordService;
    CombinationService combinationService;

    public Game(PlayerService playerService, CombinationService combinationService, WordService wordService) {
        this.playerService = playerService;
        this.combinationService = combinationService;
        this.wordService = wordService;
        setup();
    }

    void setup() {
        this.startingWords = new ArrayList<>();
        startingWords.add(wordService.getWord(new Word("water")));
        startingWords.add(wordService.getWord(new Word("earth")));
        startingWords.add(wordService.getWord(new Word("fire")));
        startingWords.add(wordService.getWord(new Word("air")));
    }

    public void setupPlayers(List<Player> players) {
        for (Player player : players) {
            player.setWords(startingWords);
            playerService.updatePlayer(player);
        }
    }

    public void makeCombination(Player player, List<Word> words) {
    }

    public boolean winConditionReached(Player player) {
        return false;
    }
}