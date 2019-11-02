package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BishopTest {

    @Test
    void move() {
        Bishop bishop = new Bishop("B1", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> bishop.move("F5")
        );
    }
}
