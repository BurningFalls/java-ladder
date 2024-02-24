package ladder.controller;

import ladder.model.*;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {
    private Players ladderPlayers;
    private Ladder ladder;
    private LadderResult ladderResult;

    public void makeLadder(){
        ladderPlayers = Players.from(InputView.inputPlayerNames());

        ladderResult = new LadderResult(InputView.inputLadderResult());
        ladderResult.isSameLengthWithLadderPlayers(ladderPlayers.getSize());

        LadderSize ladderSize = new LadderSize(InputView.inputLadderHeight(), ladderPlayers.getSize());

        ladder = Ladder.of(ladderSize);
    }

    public void showLadder() {
        OutputView.printLadderDescription();
        OutputView.printPlayerNames(ladderPlayers.getPlayerNames());
        OutputView.printLadder(ladder.toLineDtoList());
        OutputView.printLadderResult(ladderResult.getLadderResult());
    }

    public void showResultWithQuestion() {
        Player questionedPlayer = new Player(InputView.inputQuestionedPlayer());
        ladderPlayers.isContainsOrSameAsAll(questionedPlayer);

        showResult(questionedPlayer, calculateResult());
    }

    private LadderResult calculateResult() {
        Bars bars = new Bars(ladder.findBars());
        return ladderResult.moveThroughLadder(bars.getBars());
    }

    private void showResult(Player questionedPlayer, LadderResult changedLadderResult) {
        OutputView.printQuestionedPlayerResultDescription();

        if (questionedPlayer.isNameAll()) {
            OutputView.printAllPlayerResult(ladderPlayers.getPlayerNames(), changedLadderResult.getLadderResult());
            return;
        }

        int questionedPlayerIndex = ladderPlayers.getPlayerIndex(questionedPlayer);
        OutputView.printOnePlayerResult(questionedPlayerIndex, changedLadderResult.getLadderResult());
    }
}
