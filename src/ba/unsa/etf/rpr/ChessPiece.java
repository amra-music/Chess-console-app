package ba.unsa.etf.rpr;

abstract public class ChessPiece {
    public static enum Color {BLACK, WHITE}

    Color color;
    String position;

    public ChessPiece(String position, Color color){
        if(position.length()!=2 || !((position.charAt(0)>='A' && position.charAt(0)<='H') ||
                (position.charAt(0)>='a' && position.charAt(0)<='h')) || !(position.charAt(1)>='1' && position.charAt(1)<='8'))
            throw new IllegalArgumentException ("Neispravna pozicija");
        this.position=position;
        this.color=color;
    }

    public String getPosition() {
        return position;
    }

    public Color getColor() {
        return color;
    }

    abstract void move(String position);

}
