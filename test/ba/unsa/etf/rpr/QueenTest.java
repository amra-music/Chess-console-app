package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class QueenTest {
    @Test
    void move() {
        Queen q = new Queen("D1", ChessPiece.Color.WHITE);
        assertThrows(
                IllegalChessMoveException.class,
                () -> q.move("C3")
        );
    }
}
