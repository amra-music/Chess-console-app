package ba.unsa.etf.rpr;


import java.util.ArrayList;

public class Board {

    private ChessPiece[][] board;

    public ChessPiece[][] getBoard() {
        return board;
    }

    public Board() {
        board = new ChessPiece[8][8];
        // bijele figure
        board[0][0] = new Rook("A1", ChessPiece.Color.WHITE);
        board[0][1] = new Knight("B1", ChessPiece.Color.WHITE);
        board[0][2] = new Bishop("C1", ChessPiece.Color.WHITE);
        board[0][3] = new King("D1", ChessPiece.Color.WHITE);
        board[0][4] = new Queen("E1", ChessPiece.Color.WHITE);
        board[0][5] = new Bishop("F1", ChessPiece.Color.WHITE);
        board[0][6] = new Knight("G1", ChessPiece.Color.WHITE);
        board[0][7] = new Rook("H1", ChessPiece.Color.WHITE);

        //bijeli pijuni
        for (int j = 0; j < 8; j++) {
            board[1][j] = new Pawn((char) (j + 'A') + "2", ChessPiece.Color.WHITE);
        }

        //crni pijuni

        for (int j = 0; j < 8; j++) {
            board[6][j] = new Pawn((char) (j + 'A') + "7", ChessPiece.Color.BLACK);
        }

        // crne figure
        board[7][0] = new Rook("A8", ChessPiece.Color.BLACK);
        board[7][1] = new Knight("B8", ChessPiece.Color.BLACK);
        board[7][2] = new Bishop("C8", ChessPiece.Color.BLACK);
        board[7][3] = new Queen("D8", ChessPiece.Color.BLACK);
        board[7][4] = new King("E8", ChessPiece.Color.BLACK);
        board[7][5] = new Bishop("F8", ChessPiece.Color.BLACK);
        board[7][6] = new Knight("G8", ChessPiece.Color.BLACK);
        board[7][7] = new Rook("H8", ChessPiece.Color.BLACK);

        // ostala polja
        for (int i = 2; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = null;
            }
        }
    }

    public boolean isCheck(ChessPiece.Color color) {

        return false;
    }

    /* void move(Class type, ChessPiece.Color color, String position) ​pomjera
    figuru koja pripada klasi type, boje color, na poziciju datu stringom position. Ova
    metoda treba najprije pronaći figuru tipa ​type date boje među aktivnim figurama.
    Zatim treba pozvati njenu metodu ​move da provjeri da li je poziv legalan. Pošto
    može biti više figura iste boje i tipa, treba pronaći prvu za koju je potez legalan i
    povući potez. U slučaju da ne postoji niti jedna figura za koju je potez legalan
    treba baciti IllegalChessMoveException. Konačno treba provjeriti da li se na
    odredišnoj poziciji već nalazi figura. Ako se nalazi figura druge boje, ona je
    "pojedena" i treba je izbaciti, a ako se nalazi figura iste boje treba baciti
    IllegalChessMoveException. Također treba voditi računa da kraljica, lovac, top i
    pijuni ne mogu preskakati druge figure.
    */
    public void move(Class type, ChessPiece.Color color, String position) throws IllegalChessMoveException {

        //polje u ploci na novoj poziciji

        int novaPozicijaX = position.charAt(1) - '1';
        int novaPozicijaY = position.charAt(0) - 'A';


        //ista boja
        if (board[novaPozicijaX][novaPozicijaY] != null) {
            if (board[novaPozicijaX][novaPozicijaX].getColor() == color) throw new IllegalChessMoveException();
        }

        ArrayList<ChessPiece> figure = new ArrayList<>(8);
        boolean pomakFigure = false;
        String staraPozicija = null;

        //trazim figuru
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] != null && board[i][j].getClass() == type && board[i][j].getColor() == color) {
                    figure.add(board[i][j]);
                }
            }
        }
       /* System.out.println("FIGURE U LISTI");
        for(int i=0;i<figure.size();i++){

            figure.get(i).ispisi();
        }
        System.out.println("*****");*/

        switch (figure.size()) {
            case 0:
                throw new IllegalChessMoveException();
            case 1:
                try {
                    staraPozicija = figure.get(0).getPosition();
                    figure.get(0).move(position);
                    board[figure.get(0).getPosition().charAt(1) - '1'][figure.get(0).getPosition().charAt(0) - 'A'] = figure.get(0);
                    pomakFigure = true;
                    int staraPozicijaX = staraPozicija.charAt(1) - '1';
                    int staraPozicijaY = staraPozicija.charAt(0) - 'A';
                    board[staraPozicijaX][staraPozicijaX] = null;

                } catch (Exception e) {
                    throw new IllegalChessMoveException();
                }
                break;
            case 2:
                try {
                    staraPozicija = figure.get(0).getPosition();
                    figure.get(0).move(position);
                    board[figure.get(0).getPosition().charAt(1) - '1'][figure.get(0).getPosition().charAt(0) - 'A'] = figure.get(0);
                    pomakFigure = true;
                    int staraPozicijaX = staraPozicija.charAt(1) - '1';
                    int staraPozicijaY = staraPozicija.charAt(0) - 'A';
                    board[staraPozicijaX][staraPozicijaX] = null;
                } catch (Exception e) {
                    try {
                        staraPozicija = figure.get(1).getPosition();
                        figure.get(1).move(position);
                        board[figure.get(1).getPosition().charAt(1) - '1'][figure.get(1).getPosition().charAt(0) - 'A'] = figure.get(1);
                        pomakFigure = true;
                        int staraPozicijaX = staraPozicija.charAt(1) - '1';
                        int staraPozicijaY = staraPozicija.charAt(0) - 'A';
                        board[staraPozicijaX][staraPozicijaX] = null;
                    } catch (Exception k) {
                        throw new IllegalChessMoveException();
                    }
                }
                break;
            default:
                for (int i = 0; i < figure.size(); i++) {
                    try {
                        staraPozicija = figure.get(i).getPosition();
                        figure.get(i).move(position);
                        board[figure.get(i).getPosition().charAt(1) - '1'][figure.get(i).getPosition().charAt(0) - 'A'] = figure.get(i);
                        pomakFigure = true;
                        int staraPozicijaX = staraPozicija.charAt(1) - '1';
                        int staraPozicijaY = staraPozicija.charAt(0) - 'A';
                        board[staraPozicijaX][staraPozicijaY] = null;
                        break;
                    } catch (IllegalChessMoveException e) {
                    }
                }
                if (!pomakFigure) throw new IllegalChessMoveException();
        }

        boolean queenAsBishop = false;
        if (Queen.class.equals(type)) {
            if (staraPozicija.charAt(0) != position.charAt(0) && staraPozicija.charAt(1) != position.charAt(1))
                queenAsBishop = true;
        }

        if (Pawn.class.equals(type)) {
            if (Math.abs(staraPozicija.charAt(1) - position.charAt(1)) == 2) {
                if (board[staraPozicija.charAt(1) - '1' + 1][staraPozicija.charAt(0) - 'A'] != null) {
                    board[position.charAt(1) - '1'][position.charAt(0) - 'A'].move(staraPozicija);
                    board[staraPozicija.charAt(1) - '1'][staraPozicija.charAt(0) - 'A'] = board[position.charAt(1) - '1'][position.charAt(0) - 'A'];
                    board[position.charAt(1) - '1'][position.charAt(0) - 'A'] = null;
                    throw new IllegalChessMoveException();
                }
            }

        } else if (Rook.class.equals(type) || (!queenAsBishop && Queen.class.equals(type))) {
            boolean mijenjamPrvu = false;
            if (staraPozicija.charAt(0) != position.charAt(0)) mijenjamPrvu = true;
            int pomak = -1;
            int koordinata = 1;

            if (mijenjamPrvu) koordinata = 0;


            if (staraPozicija.charAt(koordinata) < position.charAt(koordinata))
                pomak = 1;
            int i = staraPozicija.charAt(koordinata) + pomak;
            while (i != position.charAt(koordinata)) {
                if (mijenjamPrvu) {
                    if (board[staraPozicija.charAt(1) - '1'][i - 'A'] != null) {
                        board[position.charAt(1) - '1'][position.charAt(0) - 'A'].move(staraPozicija);
                        board[staraPozicija.charAt(1) - '1'][staraPozicija.charAt(0) - 'A'] = board[position.charAt(1) - '1'][position.charAt(0) - 'A'];
                        board[position.charAt(1) - '1'][position.charAt(0) - 'A'] = null;
                        throw new IllegalChessMoveException();

                    }
                } else {
                    if (board[i - '1'][staraPozicija.charAt(0) - 'A'] != null) {
                        board[position.charAt(1) - '1'][position.charAt(0) - 'A'].move(staraPozicija);
                        board[staraPozicija.charAt(1) - '1'][staraPozicija.charAt(0) - 'A'] = board[position.charAt(1) - '1'][position.charAt(0) - 'A'];
                        board[position.charAt(1) - '1'][position.charAt(0) - 'A'] = null;

                        throw new IllegalChessMoveException();
                    }
                }
                i += pomak;
            }
        } else {
            int pomakX = -1;
            int pomakY = -1;

            if (staraPozicija.charAt(0) < position.charAt(0))
                pomakX = 1;
            if (staraPozicija.charAt(1) < position.charAt(1))
                pomakY = 1;

            int i = staraPozicija.charAt(0) + pomakX;
            int j = staraPozicija.charAt(1) + pomakY;

            while (i != position.charAt(0) && j != position.charAt(1)) {
                if (board[j - '1'][i - 'A'] != null) {
                    board[position.charAt(1) - '1'][position.charAt(0) - 'A'].move(staraPozicija);
                    board[staraPozicija.charAt(1) - '1'][staraPozicija.charAt(0) - 'A'] = board[position.charAt(1) - '1'][position.charAt(0) - 'A'];
                    board[position.charAt(1) - '1'][position.charAt(0) - 'A'] = null;
                    throw new IllegalChessMoveException();
                }
                i += pomakX;
                j += pomakY;
            }
        }

    }

    public void move(String oldPosition, String newPosition) throws IllegalChessMoveException {
        ChessPiece chessPiece = board[oldPosition.charAt(1) - '1'][oldPosition.charAt(0) - 'A'];
        move(chessPiece.getClass(), chessPiece.color, newPosition);
    }
}