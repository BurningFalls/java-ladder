package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;

import ladder.utils.BooleanGenerator;
import ladder.utils.RandomBooleanGenerator;

public class LadderMaker {

    private final LadderProperty ladderProperty;
    private final BooleanGenerator booleanGenerator;

    public LadderMaker(final LadderProperty ladderProperty) {
        this.ladderProperty = ladderProperty;
        this.booleanGenerator = new RandomBooleanGenerator();
    }

    public Ladder generate() {
        List<Line> lines = new ArrayList<>();

        for (int generatedCount = 0; generatedCount < ladderProperty.getHeight(); generatedCount++) {
            lines.add(new Line(ladderProperty.getWidth(), booleanGenerator));
        }

        return new Ladder(lines);
    }
}