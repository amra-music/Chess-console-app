package ba.unsa.etf.rpr;

import static java.lang.Math.abs;

public class Pawn extends ChessPiece {


    public Pawn(String position, Color color) {
        super(position, color);
    }


    @Override
    void move(String position) throws IllegalChessMoveException {
        if (!isCorrect(position)) {
            throw new IllegalArgumentException("Neispravna pozicija");
        }
        String oldPosition = getPosition().toUpperCase();
        position = position.toUpperCase();
        int newPositionSecond = abs(oldPosition.charAt(1) - position.charAt(1));
        boolean jede = false;
        int razlika = abs(oldPosition.charAt(0) - position.charAt(0));
        if (color.equals(Color.WHITE) && position.charAt(1) - oldPosition.charAt(1) == 1 && razlika == 1) {
            jede = true;
        }
        if (color.equals(Color.BLACK) && oldPosition.charAt(1) - position.charAt(1) == 1 && razlika == 1) {
            jede = true;
        }
        if (position.charAt(0) != oldPosition.charAt(0) && !jede ||
                (newPositionSecond == 2 && oldPosition.charAt(1) != '2' && oldPosition.charAt(1) != '7')
                || (newPositionSecond > 2))
            throw new IllegalChessMoveException("Potez nije dozvoljen za ovu figuru");
        this.position = position;
    }
}
