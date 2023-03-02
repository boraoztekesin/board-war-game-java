public class Ork extends Zorde{

    public Ork(String id,int hp, int ap,int initial_hp)  {
        super(id,hp, ap,initial_hp);
    }
    @Override
    public void move(Object[][] board, Characters c, String moves) {
        String[] arr= moves.split(";");
        try {
            if (arr.length != Constants.orkMaxMove * 2) {
                throw new MoveCountException("Error : Move sequence contains wrong number of move steps. Input line ignored.");
            } else {
                for (int i=0;i<1; i++) {
                    int x = Integer.parseInt(arr[0]);
                    int y = Integer.parseInt(arr[1]);


                    c.hp += Constants.orkHealPoints;
                    if (c.hp > c.initial_hp) {
                        c.hp = c.initial_hp;
                    }
                    if (c.get_row(board, c) != board.length - 1 && c.get_col(board, c) != board.length - 1) {
                        if (board[c.get_row(board, c) + 1][c.get_col(board, c) + 1] instanceof Zorde) {
                            ((Zorde) board[c.get_row(board, c) + 1][c.get_col(board, c) + 1]).hp += Constants.orkHealPoints;
                            if (((Zorde) board[c.get_row(board, c) + 1][c.get_col(board, c) + 1]).hp > ((Zorde) board[c.get_row(board, c) + 1][c.get_col(board, c) + 1]).initial_hp) {
                                ((Zorde) board[c.get_row(board, c) + 1][c.get_col(board, c) + 1]).hp = ((Zorde) board[c.get_row(board, c) + 1][c.get_col(board, c) + 1]).initial_hp;
                            }
                        }
                    }
                    if (c.get_row(board, c) != board.length - 1) {
                        if (board[c.get_row(board, c) + 1][c.get_col(board, c)] instanceof Zorde) {
                            ((Zorde) board[c.get_row(board, c) + 1][c.get_col(board, c)]).hp += Constants.orkHealPoints;
                            if (((Zorde) board[c.get_row(board, c) + 1][c.get_col(board, c)]).hp > ((Zorde) board[c.get_row(board, c) + 1][c.get_col(board, c)]).initial_hp) {
                                ((Zorde) board[c.get_row(board, c) + 1][c.get_col(board, c)]).hp = ((Zorde) board[c.get_row(board, c) + 1][c.get_col(board, c)]).initial_hp;
                            }
                        }
                    }
                    if (c.get_row(board, c) != board.length - 1 && c.get_col(board, c) != 0) {
                        if (board[c.get_row(board, c) + 1][c.get_col(board, c) - 1] instanceof Zorde) {
                            ((Zorde) board[c.get_row(board, c) + 1][c.get_col(board, c) - 1]).hp += Constants.orkHealPoints;
                            if (((Zorde) board[c.get_row(board, c) + 1][c.get_col(board, c) - 1]).hp > ((Zorde) board[c.get_row(board, c) + 1][c.get_col(board, c) - 1]).initial_hp) {
                                ((Zorde) board[c.get_row(board, c) + 1][c.get_col(board, c) - 1]).hp = ((Zorde) board[c.get_row(board, c) + 1][c.get_col(board, c) - 1]).initial_hp;
                            }
                        }
                    }
                    if (c.get_col(board, c) != board.length - 1) {
                        if (board[c.get_row(board, c)][c.get_col(board, c) + 1] instanceof Zorde) {
                            ((Zorde) board[c.get_row(board, c)][c.get_col(board, c) + 1]).hp += Constants.orkHealPoints;
                            if (((Zorde) board[c.get_row(board, c)][c.get_col(board, c) + 1]).hp > ((Zorde) board[c.get_row(board, c)][c.get_col(board, c) + 1]).initial_hp) {
                                ((Zorde) board[c.get_row(board, c)][c.get_col(board, c) + 1]).hp = ((Zorde) board[c.get_row(board, c)][c.get_col(board, c) + 1]).initial_hp;
                            }
                        }
                    }
                    if (c.get_col(board, c) != 0) {
                        if (board[c.get_row(board, c)][c.get_col(board, c) - 1] instanceof Zorde) {
                            ((Zorde) board[c.get_row(board, c)][c.get_col(board, c) - 1]).hp += Constants.orkHealPoints;
                            if (((Zorde) board[c.get_row(board, c)][c.get_col(board, c) - 1]).hp > ((Zorde) board[c.get_row(board, c)][c.get_col(board, c) - 1]).initial_hp) {
                                ((Zorde) board[c.get_row(board, c)][c.get_col(board, c) - 1]).hp = ((Zorde) board[c.get_row(board, c)][c.get_col(board, c) - 1]).initial_hp;
                            }
                        }
                    }
                    if (c.get_row(board, c) != 0 && c.get_col(board, c) != board.length - 1) {
                        if (board[c.get_row(board, c) - 1][c.get_col(board, c) + 1] instanceof Zorde) {
                            ((Zorde) board[c.get_row(board, c) - 1][c.get_col(board, c) + 1]).hp += Constants.orkHealPoints;
                            if (((Zorde) board[c.get_row(board, c) - 1][c.get_col(board, c) + 1]).hp > ((Zorde) board[c.get_row(board, c) - 1][c.get_col(board, c) + 1]).initial_hp) {
                                ((Zorde) board[c.get_row(board, c) - 1][c.get_col(board, c) + 1]).hp = ((Zorde) board[c.get_row(board, c) - 1][c.get_col(board, c) + 1]).initial_hp;
                            }
                        }
                    }
                    if (c.get_row(board, c) != 0 && c.get_col(board, c) != 0) {
                        if (board[c.get_row(board, c) - 1][c.get_col(board, c) - 1] instanceof Zorde) {
                            ((Zorde) board[c.get_row(board, c) - 1][c.get_col(board, c) - 1]).hp += Constants.orkHealPoints;
                            if (((Zorde) board[c.get_row(board, c) - 1][c.get_col(board, c) - 1]).hp > ((Zorde) board[c.get_row(board, c) - 1][c.get_col(board, c) - 1]).initial_hp) {
                                ((Zorde) board[c.get_row(board, c) - 1][c.get_col(board, c) - 1]).hp = ((Zorde) board[c.get_row(board, c) - 1][c.get_col(board, c) - 1]).initial_hp;
                            }
                        }
                    }
                    if (c.get_row(board, c) != 0) {
                        if (board[c.get_row(board, c) - 1][c.get_col(board, c)] instanceof Zorde) {
                            ((Zorde) board[c.get_row(board, c) - 1][c.get_col(board, c)]).hp += Constants.orkHealPoints;
                            if (((Zorde) board[c.get_row(board, c) - 1][c.get_col(board, c)]).hp > ((Zorde) board[c.get_row(board, c) - 1][c.get_col(board, c)]).initial_hp) {
                                ((Zorde) board[c.get_row(board, c) - 1][c.get_col(board, c)]).hp = ((Zorde) board[c.get_row(board, c) - 1][c.get_col(board, c)]).initial_hp;
                            }

                        }
                    }
                    try {
                        if (c.get_row(board, c) + y < 0 || c.get_row(board, c) + y > board.length - 1 || c.get_col(board, c) + x < 0 || c.get_col(board, c) + x > board.length - 1) {
                            throw new BoundaryException("Error : Game board boundaries are exceeded. Input line ignored.");
                        } else {
                            if (board[c.get_row(board, c) + y][c.get_col(board, c) + x] == "  ") {

                                int tempx = c.get_col(board, c);
                                int tempy = c.get_row(board, c);
                                Object character = board[c.get_row(board, c)][c.get_col(board, c)];
                                board[c.get_row(board, c)][c.get_col(board, c)] = board[c.get_row(board, c) + y][c.get_col(board, c) + x];
                                board[tempy + y][tempx + x] = character;

                            } else if (board[c.get_row(board, c) + y][c.get_col(board, c) + x] instanceof Calliance) {
                                ((Calliance) board[c.get_row(board, c) + y][c.get_col(board, c) + x]).hp -= c.ap;
                                if(((Calliance) board[c.get_row(board, c) + y][c.get_col(board, c) + x]).hp<=0){
                                    int tempx=c.get_col(board,c);
                                    int tempy=c.get_row(board, c);
                                    Object character=board[c.get_row(board,c)][c.get_col(board,c)];
                                    board[c.get_row(board,c)][c.get_col(board,c)]="  ";
                                    board[tempy+y][tempx+x]=character;
                                    break;
                                }
                                if (c.hp > ((Calliance) board[c.get_row(board, c) + y][c.get_col(board, c) + x]).hp) {

                                    c.hp -= ((Calliance) board[c.get_row(board, c) + y][c.get_col(board, c) + x]).hp;
                                    ((Calliance) board[c.get_row(board, c) + y][c.get_col(board, c) + x]).hp = 0;

                                    int tempx = c.get_col(board, c);
                                    int tempy = c.get_row(board, c);
                                    Object character = board[c.get_row(board, c)][c.get_col(board, c)];
                                    board[c.get_row(board, c)][c.get_col(board, c)] = "  ";
                                    board[tempy + y][tempx + x] = character;

                                } else if (((Calliance) board[c.get_row(board, c) + y][c.get_col(board, c) + x]).hp > c.hp) {
                                    ((Calliance) board[c.get_row(board, c) + y][c.get_col(board, c) + x]).hp -= c.hp;
                                    c.hp = 0;
                                    int tempx = c.get_col(board, c);
                                    int tempy = c.get_row(board, c);
                                    Object character = board[c.get_row(board, c) + y][c.get_col(board, c) + x];
                                    board[c.get_row(board, c)][c.get_col(board, c)] = "  ";
                                    board[tempy + y][tempx + x] = character;
                                } else if (((Calliance) board[c.get_row(board, c) + y][c.get_col(board, c) + x]).hp == c.hp) {
                                    c.hp = 0;
                                    ((Calliance) board[c.get_row(board, c) + y][c.get_col(board, c) + x]).hp = 0;
                                    board[c.get_row(board, c) + y][c.get_col(board, c) + x] = "  ";
                                    board[c.get_row(board, c)][c.get_col(board, c)] = "  ";
                                }

                            } else if (board[c.get_row(board, c) + y][c.get_col(board, c) + x] instanceof Zorde) {
                                break;

                            }
                            // ATTTACKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK
                            attack_z(board,c);

                        }
                    } catch (Exception e) {
                        errorexists=true;
                        System.out.println(e.getMessage());
                        break;
                    }
                }
            }
        }catch (Exception ex){
            errorexists=true;
            System.out.println(ex.getMessage());
        }

    }

}
