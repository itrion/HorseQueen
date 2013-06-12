package gameengine;

import gameengine.model.Board;
import gameengine.model.Monkey;
import gameengine.model.Player;
import gameengine.model.Queen;

public class BoardFactory {

    public static Board getExperiment01(Player[] players, int turnIndicator) {
        Board initialBoard = new Board(turnIndicator);
        int[] playerOneMonkeyPositions = new int[]{0, 10, 17, 27, 37};
        int[] playerTwoMonkeyPositions = new int[]{13, 29, 40, 60};
        putQueens(players, initialBoard, new QueenParameters(2, 5), new QueenParameters(45, 5));
        putMonkeysOfPlayer(players[0], playerOneMonkeyPositions, initialBoard);
        putMonkeysOfPlayer(players[1], playerTwoMonkeyPositions, initialBoard);
        return initialBoard;
    }
    
    public static Board getExperiment02(Player[] players, int turnIndicator) {
        Board initialBoard = new Board(turnIndicator);
        int[] playerOneMonkeyPositions = new int[]{0, 10, 17, 27, 37};
        int[] playerTwoMonkeyPositions = new int[]{19, 29, 40, 60};
        putQueens(players, initialBoard, new QueenParameters(2, 5), new QueenParameters(45, 5));
        putMonkeysOfPlayer(players[0], playerOneMonkeyPositions, initialBoard);
        putMonkeysOfPlayer(players[1], playerTwoMonkeyPositions, initialBoard);
        return initialBoard;
    }

    public static Board getExperiment03(Player[] players, int turnIndicator) {
        Board initialBoard = new Board(turnIndicator);
        int[] playerOneMonkeyPositions = new int[]{2, 7, 9, 12, 13, 19, 22, 34};
        int[] playerTwoMonkeyPositions = new int[]{17, 33, 40, 44, 57};
        putQueens(players, initialBoard, new QueenParameters(18, 2), new QueenParameters(57, 5));
        putMonkeysOfPlayer(players[0], playerOneMonkeyPositions, initialBoard);
        putMonkeysOfPlayer(players[1], playerTwoMonkeyPositions, initialBoard);
        return initialBoard;
    }
    
    public static Board getInitialState(Player[] players, int turnIndicator){
        Board initialBoard = new Board(turnIndicator);
        putQueens(players, initialBoard, new QueenParameters(3, 10), new QueenParameters(60, 10));
        return initialBoard;
    }

    private static void putQueens(Player[] players, Board initialBoard, QueenParameters queenAParameters, QueenParameters queenBParameters) {
        Queen queenPlayerA = new Queen(players[0], queenAParameters.position);
        Queen queenPlayerB = new Queen(players[1], queenBParameters.position);
        queenPlayerA.setSons(queenAParameters.sons);
        queenPlayerB.setSons(queenBParameters.sons);
        initialBoard.addChip(queenPlayerA);
        initialBoard.addChip(queenPlayerB);
    }

    private static void putMonkeysOfPlayer(Player player, int[] monkeyPositions, Board initialBoard) {
        for (int position : monkeyPositions) {
            Monkey monkey = new Monkey(player, 0);
            monkey.setPosition(position);
            initialBoard.addChip(monkey);
        }
    }

    private static class QueenParameters {

        private int position;
        private int sons;

        public QueenParameters(int position, int sons) {
            this.position = position;
            this.sons = sons;
        }
    }
}
