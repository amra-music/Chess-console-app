package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class RookTest {

    @Test
    void move(){
        Rook rook = new Rook("A1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalChessMoveException.class,
                () -> rook.move("F8")
        );
    }
}
