
public class TennisGame1 implements TennisGame {
    private Player player1;
    private Player player2;

    public TennisGame1(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
    }

    public void playerScored(String playerName) {
        if (playerName.equals(player1.getName())) {
            player1.incrementScore();
        } else if (playerName.equals(player2.getName())) {
            player2.incrementScore();
        }
    }

    public String getScore() {
        String score = "";
        int player1Score = player1.getScore();
        int player2Score = player2.getScore();

        if (player1Score == player2Score) {
            score = getEvenScore(player1Score);
        } else if (player1Score >= 4 || player2Score >= 4) {
            score = getAdvantageOrWinningScore(player1Score, player2Score);
        } else {
            score = getRegularScore(player1Score, player2Score);
        }

        return score;
    }

    private String getEvenScore(int player1Score) {
        switch (player1Score) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }

    private String getAdvantageOrWinningScore(int player1Score, int player2Score) {
        int difference = player1Score - player2Score;

        if (difference == 1) {
            return "Advantage " + player1.getName();
        } else if (difference == -1) {
            return "Advantage " + player2.getName();
        } else if (difference >= 2) {
            return "Win for " + player1.getName();
        } else {
            return "Win for " + player2.getName();
        }
    }

    private String getRegularScore(int player1Score, int player2Score) {
        StringBuilder score = new StringBuilder();

        for (int i = 1; i <= 2; i++) {
            Player currentPlayer = (i == 1) ? player1 : player2;
            int currentScore = currentPlayer.getScore();

            switch (currentScore) {
                case 0:
                    score.append("Love");
                    break;
                case 1:
                    score.append("Fifteen");
                    break;
                case 2:
                    score.append("Thirty");
                    break;
                case 3:
                    score.append("Forty");
                    break;
            }

            if (i == 1 && player1Score != player2Score) {
                score.append("-");
            }
        }

        return score.toString();
    }
}
