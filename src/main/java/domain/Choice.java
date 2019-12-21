package domain;

public enum Choice {
    ORDER(1),
    PAY(2),
    EXIT(3);

    private int posNumber;

    Choice(int posNumber){
        this.posNumber = posNumber;
    }

    public int getPosNumber(){
        return posNumber;
    }
}
