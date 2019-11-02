package ba.unsa.etf.rpr;

public class Rook extends ChessPiece {


    public Rook(String position, Color color) {
        super(position, color);
    }

    @Override
    void move(String position) throws IllegalChessMoveException {
        if (!isCorrect(position)) {
            throw new IllegalArgumentException("Neispravna pozicija");
        }
        String oldPosition = getPosition().toUpperCase();
        position = position.toUpperCase();
        if (oldPosition.charAt(0) != position.charAt(0) && oldPosition.charAt(1) != position.charAt(1))
            throw new IllegalChessMoveException("Potez nije dozvoljen za ovu figuru");
        this.position = position;
    }
}
