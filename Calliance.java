public abstract class Calliance extends Characters{

    public Calliance(String id,int hp,int ap,int initial_hp){
        super(id,hp,ap,initial_hp);
    }

    public void attack(Object[][] board, Characters c){
        if(c.get_row(board,c)!=board.length-1 && c.get_col(board,c)!=board.length-1){
            if(board[c.get_row(board,c)+1][c.get_col(board,c)+1] instanceof Zorde){
                ((Zorde) board[c.get_row(board, c) + 1][c.get_col(board, c) + 1]).hp -=c.ap;
                if(((Zorde) board[c.get_row(board, c) + 1][c.get_col(board, c) + 1]).hp <=0){
                    board[c.get_row(board, c) + 1][c.get_col(board, c) + 1]="  ";
                }
            }
        }
        if(c.get_row(board,c)!=board.length-1){
            if(board[c.get_row(board,c)+1][c.get_col(board,c)] instanceof Zorde){
                ((Zorde) board[c.get_row(board,c)+1][c.get_col(board,c)]).hp -=c.ap;
                if ( ((Zorde) board[c.get_row(board,c)+1][c.get_col(board,c)]).hp<=0){
                    board[c.get_row(board,c)+1][c.get_col(board,c)]="  ";
                }
            }
        }
        if(c.get_row(board,c)!=board.length-1 && c.get_col(board,c)!=0){
            if(board[c.get_row(board,c)+1][c.get_col(board,c)-1] instanceof Zorde){
                ((Zorde) board[c.get_row(board,c)+1][c.get_col(board,c)-1]).hp -=c.ap;
                if(((Zorde) board[c.get_row(board,c)+1][c.get_col(board,c)-1]).hp<=0){
                    board[c.get_row(board,c)+1][c.get_col(board,c)-1]="  ";
                }
            }
        }
        if(c.get_col(board,c)!=board.length-1){
            if(board[c.get_row(board,c)][c.get_col(board,c)+1] instanceof Zorde){
                ((Zorde) board[c.get_row(board,c)][c.get_col(board,c)+1]).hp -=c.ap;
                if(((Zorde) board[c.get_row(board,c)][c.get_col(board,c)+1]).hp<=0){
                    board[c.get_row(board,c)][c.get_col(board,c)+1]="  ";
                }
            }
        }
        if(c.get_col(board,c)!=0){
            if(board[c.get_row(board,c)][c.get_col(board,c)-1] instanceof Zorde){
                ((Zorde) board[c.get_row(board,c)][c.get_col(board,c)-1]).hp -=c.ap;
                if(((Zorde) board[c.get_row(board,c)][c.get_col(board,c)-1]).hp<=0){
                    board[c.get_row(board,c)][c.get_col(board,c)-1]="  ";
                }
            }
        }
        if(c.get_row(board,c)!=0 && c.get_col(board,c)!=board.length-1){
            if(board[c.get_row(board,c)-1][c.get_col(board,c)+1] instanceof Zorde){
                ((Zorde) board[c.get_row(board,c)-1][c.get_col(board,c)+1]).hp -=c.ap;
                if(((Zorde) board[c.get_row(board,c)-1][c.get_col(board,c)+1]).hp<=0){
                    board[c.get_row(board,c)-1][c.get_col(board,c)+1]="  ";
                }
            }
        }
        if (c.get_row(board,c)!=0 && c.get_col(board,c)!=0){
            if(board[c.get_row(board,c)-1][c.get_col(board,c)-1] instanceof Zorde){
                ((Zorde) board[c.get_row(board,c)-1][c.get_col(board,c)-1]).hp -=c.ap;
                if(((Zorde) board[c.get_row(board,c)-1][c.get_col(board,c)-1]).hp<=0){
                    board[c.get_row(board,c)-1][c.get_col(board,c)-1]="  ";
                }
            }
        }
        if(c.get_row(board,c)!=0){
            if(board[c.get_row(board,c)-1][c.get_col(board,c)] instanceof Zorde){
                ((Zorde) board[c.get_row(board,c)-1][c.get_col(board,c)]).hp -=c.ap;
                if(((Zorde) board[c.get_row(board,c)-1][c.get_col(board,c)]).hp<=0){
                    board[c.get_row(board,c)-1][c.get_col(board,c)]="  ";
                }
            }
        }
    }
}
