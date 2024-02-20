package ladder.model;

import ladder.utils.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> row;

    private Line(List<Boolean> row) {
        this.row = row;
    }

    public static Line of(int length, BooleanGenerator bg) {
        List<Boolean> row = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            row.add(bg.generate());
        }

        return new Line(row);
    }

    public boolean isLeftPathExist(int position) {
        if (position == 0) {
            return false;
        }
        return row.get(position - 1);
    }

    public int size() {
        return row.size();
    }
}
