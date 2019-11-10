package ba.unsa.etf.rpr;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Board board = new Board();
        Scanner ulaz = new Scanner(System.in);
        boolean white = true;
        for (; ; ) {

            if (white)
                System.out.print("White move: ");
            else
                System.out.print("Black move: ");
            String unos = ulaz.nextLine();
            if (unos.equals("X"))
                break;

            if (unos.length() != 3 && unos.length() != 2) {
                System.out.println("Illegal move");
                continue;
            }
            if (unos.length() == 3 && (!(unos.charAt(0) == 'K' || unos.charAt(0) == 'Q' || unos.charAt(0) == 'B' || unos.charAt(0) == 'N' || unos.charAt(0) == 'R') ||
                    !(unos.charAt(1) >= 'a' && unos.charAt(1) <= 'h') || !(unos.charAt(2) > '0' && unos.charAt(2) < '9'))) {
                System.out.println("Illegal move");
                continue;
            } else if (unos.length() == 2 && (!(unos.charAt(0) >= 'a' && unos.charAt(0) <= 'h') || !(unos.charAt(1) > '0' && unos.charAt(1) < '9'))) {
                System.out.println("Illegal move");
                continue;
            }
            Class type = Pawn.class;
            switch (unos.charAt(0)) {
                case 'K':
                    type = King.class;
                    break;
                case 'Q':
                    type = Queen.class;
                    break;
                case 'B':
                    type = Bishop.class;
                    break;
                case 'R':
                    type = Rook.class;
                    break;
                case 'N':
                    type = Knight.class;
                    break;
            }
            ChessPiece.Color color = ChessPiece.Color.WHITE;
            if (!white)
                color = ChessPiece.Color.BLACK;
            try {
                board.move(type, color, unos.substring(unos.length() - 2));
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
            if (white) {
                color = ChessPiece.Color.BLACK;
                white = false;
            } else {
                color = ChessPiece.Color.WHITE;
                white = true;
            }
            if (board.isCheck(color))
                System.out.println("CHECK!!!");

        }
        System.out.println("Korisnik je predao partiju");
    }
}




