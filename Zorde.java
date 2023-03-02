public abstract class Zorde extends  Characters{


    public Zorde(String id,int hp,int ap,int initial_hp){
        super(id,hp,ap,initial_hp);
    }

    public void attack_z(Object[][] board, Characters c){
        if (c.get_row(board, c) != board.length - 1 && c.get_col(board, c) != board.length - 1) {
            if (board[c.get_row(board, c) + 1][c.get_col(board, c) + 1] instanceof Calliance) {
                ((Calliance) board[c.get_row(board, c) + 1][c.get_col(board, c) + 1]).hp -= c.ap;
                if (((Calliance) board[c.get_row(board, c) + 1][c.get_col(board, c) + 1]).hp <= 0) {
                    board[c.get_row(board, c) + 1][c.get_col(board, c) + 1] = "  ";
                }
            }
        }
        if (c.get_row(board, c) != board.length - 1) {
            if (board[c.get_row(board, c) + 1][c.get_col(board, c)] instanceof Calliance) {
                ((Calliance) board[c.get_row(board, c) + 1][c.get_col(board, c)]).hp -= c.ap;
                if (((Calliance) board[c.get_row(board, c) + 1][c.get_col(board, c)]).hp <= 0) {
                    board[c.get_row(board, c) + 1][c.get_col(board, c)] = "  ";
                }
            }
        }
        if (c.get_row(board, c) != board.length - 1 && c.get_col(board, c) != 0) {
            if (board[c.get_row(board, c) + 1][c.get_col(board, c) - 1] instanceof Calliance) {
                ((Calliance) board[c.get_row(board, c) + 1][c.get_col(board, c) - 1]).hp -= c.ap;
                if (((Calliance) board[c.get_row(board, c) + 1][c.get_col(board, c) - 1]).hp <= 0) {
                    board[c.get_row(board, c) + 1][c.get_col(board, c) - 1] = "  ";
                }
            }
        }
        if (c.get_col(board, c) != board.length - 1) {
            if (board[c.get_row(board, c)][c.get_col(board, c) + 1] instanceof Calliance) {
                ((Calliance) board[c.get_row(board, c)][c.get_col(board, c) + 1]).hp -= c.ap;
                if (((Calliance) board[c.get_row(board, c)][c.get_col(board, c) + 1]).hp <= 0) {
                    board[c.get_row(board, c)][c.get_col(board, c) + 1] = "  ";
                }
            }
        }
        if (c.get_col(board, c) != 0) {
            if (board[c.get_row(board, c)][c.get_col(board, c) - 1] instanceof Calliance) {
                ((Calliance) board[c.get_row(board, c)][c.get_col(board, c) - 1]).hp -= c.ap;
                if (((Calliance) board[c.get_row(board, c)][c.get_col(board, c) - 1]).hp <= 0) {
                    board[c.get_row(board, c)][c.get_col(board, c) - 1] = "  ";
                }
            }
        }
        if (c.get_row(board, c) != 0 && c.get_col(board, c) != board.length - 1) {
            if (board[c.get_row(board, c) - 1][c.get_col(board, c) + 1] instanceof Calliance) {
                ((Calliance) board[c.get_row(board, c) - 1][c.get_col(board, c) + 1]).hp -= c.ap;
                if (((Calliance) board[c.get_row(board, c) - 1][c.get_col(board, c) + 1]).hp <= 0) {
                    board[c.get_row(board, c) - 1][c.get_col(board, c) + 1] = "  ";
                }
            }
        }
        if (c.get_row(board, c) != 0 && c.get_col(board, c) != 0) {
            if (board[c.get_row(board, c) - 1][c.get_col(board, c) - 1] instanceof Calliance) {
                ((Calliance) board[c.get_row(board, c) - 1][c.get_col(board, c) - 1]).hp -= c.ap;
                if (((Calliance) board[c.get_row(board, c) - 1][c.get_col(board, c) - 1]).hp <= 0) {
                    board[c.get_row(board, c) - 1][c.get_col(board, c) - 1] = "  ";
                }
            }
        }
        if (c.get_row(board, c) != 0) {
            if (board[c.get_row(board, c) - 1][c.get_col(board, c)] instanceof Calliance) {
                ((Calliance) board[c.get_row(board, c) - 1][c.get_col(board, c)]).hp -= c.ap;
                if (((Calliance) board[c.get_row(board, c) - 1][c.get_col(board, c)]).hp <= 0) {
                    board[c.get_row(board, c) - 1][c.get_col(board, c)] = "  ";
                }
            }
        }
    }


}