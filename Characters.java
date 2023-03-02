public class Characters {
    int hp;
    int ap;
    String id;
    public int roww;
    public int coll;
    boolean errorexists=false;

    int initial_hp;



    public Characters(String id,int hp,int ap,int initial_hp){
        this.id=id;
        this.ap=ap;
        this.hp=hp;
        this.initial_hp=initial_hp;


    }

    public void move(Object[][] board, Characters c, String moves){
    }

    public int get_row(Object[][] board, Characters c) {
        boolean boolx=false;
        int rowke = 9;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (board[row][col] == c) {
                    rowke=row;
                    boolx=true;

                    break;
                }

            }
        }
        if (boolx){
            return rowke;
        }else {
            return -5000;
        }
    }

    public int get_col(Object[][] board, Characters c) {
        boolean bool=false;
        int colke = 7;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (board[row][col] == c) {
                    colke=col;
                    bool=true;
                    break;
                }

            }
        }
        if (bool) {
            return colke;
        }else {
            return -1000;
        }

    }

}
