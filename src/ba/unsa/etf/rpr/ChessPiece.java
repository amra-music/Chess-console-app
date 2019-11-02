package ba.unsa.etf.rpr;

abstract public class ChessPiece {
    public static enum Color {BLACK, WHITE}

    abstract String getPosition();

    abstract Color getColor();

    abstract void move(String position);

}
