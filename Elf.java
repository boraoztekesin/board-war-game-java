import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Elf extends Calliance{

    public Elf(String id,int hp, int ap,int initial_hp)  {
        super(id,hp, ap,initial_hp);

    }

    @Override
    public void move(Object[][] board, Characters c, String moves) {
        String[] arr= moves.split(";");

        try {
            if(arr.length!=Constants.elfMaxMove*2){
                throw new MoveCountException("Error : Move sequence contains wrong number of move steps. Input line ignored.");
            }else {

                ArrayList<String> arrayList=new ArrayList<>();
                arrayList.addAll(Arrays.asList(arr));


                int partitionSize = 2;
                List<List<String>> partitions = new LinkedList<List<String>>();
                for (int i = 0; i < arrayList.size(); i += partitionSize) {
                    partitions.add(arrayList.subList(i,
                            Math.min(i + partitionSize, arrayList.size())));
                }
                for (int i=0;i<partitions.size(); i++){
                    int x=Integer.parseInt(partitions.get(i).get(0));
                    int y=Integer.parseInt(partitions.get(i).get(1));





                    try {
                        if(c.get_row(board,c)+y<0 ||c.get_row(board,c)+y >board.length-1 || c.get_col(board,c)+x<0 ||c.get_col(board,c)+x>board.length-1){
                            throw new BoundaryException("Error : Game board boundaries are exceeded. Input line ignored.");
                        }else {
                            if(board[c.get_row(board,c)+y][c.get_col(board,c)+x]=="  "){
                                int tempx=c.get_col(board,c);
                                int tempy=c.get_row(board, c);
                                Object character=board[c.get_row(board,c)][c.get_col(board,c)];

                                board[c.get_row(board,c)][c.get_col(board,c)]=board[c.get_row(board, c) + y][c.get_col(board, c) + x];

                                board[tempy+y][tempx+x]=character;


                            }
                            else if(board[c.get_row(board,c)+y][c.get_col(board,c)+x] instanceof Zorde){
                                ((Zorde) board[c.get_row(board, c) + y][c.get_col(board, c) + x]).hp -= c.ap;
                                if(((Zorde) board[c.get_row(board, c) + y][c.get_col(board, c) + x]).hp<=0){
                                    int tempx=c.get_col(board,c);
                                    int tempy=c.get_row(board, c);
                                    Object character=board[c.get_row(board,c)][c.get_col(board,c)];
                                    board[c.get_row(board,c)][c.get_col(board,c)]="  ";
                                    board[tempy+y][tempx+x]=character;
                                    break;
                                }

                                if (c.hp > ((Zorde) board[c.get_row(board, c) + y][c.get_col(board, c) + x]).hp) {

                                    c.hp -= ((Zorde) board[c.get_row(board, c) + y][c.get_col(board, c) + x]).hp;
                                    ((Zorde) board[c.get_row(board, c) + y][c.get_col(board, c) + x]).hp = 0;
//                                board[c.get_row(board, c) + y][c.get_col(board, c) + x] = c;
//                                board[c.get_row(board, c)][c.get_col(board, c)] = "  ";
                                    int tempx=c.get_col(board,c);
                                    int tempy=c.get_row(board, c);
                                    Object character=board[c.get_row(board,c)][c.get_col(board,c)];
                                    board[c.get_row(board,c)][c.get_col(board,c)]="  ";
                                    board[tempy+y][tempx+x]=character;
                                } else if (((Zorde) board[c.get_row(board, c) + y][c.get_col(board, c) + x]).hp > c.hp) {
                                    ((Zorde) board[c.get_row(board, c) + y][c.get_col(board, c) + x]).hp -= c.hp;
                                    c.hp = 0;
                                    int tempx=c.get_col(board,c);
                                    int tempy=c.get_row(board, c);
                                    Object character=board[c.get_row(board,c)+y][c.get_col(board,c)+x];
                                    board[c.get_row(board,c)][c.get_col(board,c)]="  ";
                                    board[tempy+y][tempx+x]=character;
                                }
                                else if (((Zorde) board[c.get_row(board, c) + y][c.get_col(board, c) + x]).hp == c.hp) {
                                    c.hp = 0;
                                    ((Zorde) board[c.get_row(board, c) + y][c.get_col(board, c) + x]).hp = 0;
                                    board[c.get_row(board, c) + y][c.get_col(board, c) + x] = "  ";
                                    board[c.get_row(board, c)][c.get_col(board, c)] = "  ";
                                }
                                break;
                            }
                            else if(board[c.get_row(board,c)+y][c.get_col(board,c)+x] instanceof Calliance){
                                break;
                            }
                            // ATTTACKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK
                            if(i==partitions.size()-1){
                                // first 8 neighbour squares
                                attack(board,c);
                                //other 16 sqaures which only elf can attack with special attack
                                if(c.get_row(board,c)>1 && c.get_col(board,c)>1){
                                    if(board[c.get_row(board,c)-2][c.get_col(board,c)-2] instanceof Zorde){
                                        ((Zorde) board[c.get_row(board, c) -2][c.get_col(board, c) -2]).hp -=15;
                                        if(((Zorde) board[c.get_row(board, c) -2][c.get_col(board, c) -2]).hp <=0){
                                            board[c.get_row(board, c) -2][c.get_col(board, c) -2]="  ";
                                        }
                                    }
                                }
                                if(c.get_row(board,c)>0 && c.get_col(board,c)>1){
                                    if(board[c.get_row(board,c)-1][c.get_col(board,c)-2] instanceof Zorde){
                                        ((Zorde) board[c.get_row(board, c) -1][c.get_col(board, c) -2]).hp -=15;
                                        if(((Zorde) board[c.get_row(board, c) -1][c.get_col(board, c) -2]).hp <=0){
                                            board[c.get_row(board, c) -1][c.get_col(board, c) -2]="  ";
                                        }
                                    }
                                }
                                if( c.get_col(board,c)>1){
                                    if(board[c.get_row(board,c)][c.get_col(board,c)-2] instanceof Zorde){
                                        ((Zorde) board[c.get_row(board, c) ][c.get_col(board, c) -2]).hp -=15;
                                        if(((Zorde) board[c.get_row(board, c) ][c.get_col(board, c) -2]).hp <=0){
                                            board[c.get_row(board, c) ][c.get_col(board, c) -2]="  ";
                                        }
                                    }
                                }
                                if(c.get_row(board,c)!=board.length-1&& c.get_col(board,c)>1){
                                    if(board[c.get_row(board,c)+1][c.get_col(board,c)-2] instanceof Zorde){
                                        ((Zorde) board[c.get_row(board, c) +1][c.get_col(board, c) -2]).hp -=15;
                                        if(((Zorde) board[c.get_row(board, c) +1][c.get_col(board, c) -2]).hp <=0){
                                            board[c.get_row(board, c) +1][c.get_col(board, c) -2]="  ";
                                        }
                                    }
                                }
                                if(c.get_row(board,c)<board.length-2&& c.get_col(board,c)>1){
                                    if(board[c.get_row(board,c)+2][c.get_col(board,c)-2] instanceof Zorde){
                                        ((Zorde) board[c.get_row(board, c) +2][c.get_col(board, c) -2]).hp -=15;
                                        if(((Zorde) board[c.get_row(board, c) +2][c.get_col(board, c) -2]).hp <=0){
                                            board[c.get_row(board, c) +2][c.get_col(board, c) -2]="  ";
                                        }
                                    }
                                }

                                if(c.get_row(board,c)>1 && c.get_col(board,c)<board.length-2){
                                    if(board[c.get_row(board,c)-2][c.get_col(board,c)+2] instanceof Zorde){
                                        ((Zorde) board[c.get_row(board, c) -2][c.get_col(board, c) +2]).hp -=15;
                                        if(((Zorde) board[c.get_row(board, c) -2][c.get_col(board, c) +2]).hp <=0){
                                            board[c.get_row(board, c) -2][c.get_col(board, c) +2]="  ";
                                        }
                                    }
                                }
                                if(c.get_row(board,c)>0 && c.get_col(board,c)<board.length-2){
                                    if(board[c.get_row(board,c)-1][c.get_col(board,c)+2] instanceof Zorde){
                                        ((Zorde) board[c.get_row(board, c) -1][c.get_col(board, c) +2]).hp -=15;
                                        if(((Zorde) board[c.get_row(board, c) -1][c.get_col(board, c)+2]).hp <=0){
                                            board[c.get_row(board, c) -1][c.get_col(board, c) +2]="  ";
                                        }
                                    }
                                }
                                if( c.get_col(board,c)<board.length-2){
                                    if(board[c.get_row(board,c)][c.get_col(board,c)+2] instanceof Zorde){
                                        ((Zorde) board[c.get_row(board, c) ][c.get_col(board, c) +2]).hp -=15;
                                        if(((Zorde) board[c.get_row(board, c) ][c.get_col(board, c) +2]).hp <=0){
                                            board[c.get_row(board, c) ][c.get_col(board, c) +2]="  ";
                                        }
                                    }
                                }
                                if(c.get_row(board,c)!=board.length-1&& c.get_col(board,c)<board.length-2){
                                    if(board[c.get_row(board,c)+1][c.get_col(board,c)+2] instanceof Zorde){
                                        ((Zorde) board[c.get_row(board, c) +1][c.get_col(board, c) +2]).hp -=15;
                                        if(((Zorde) board[c.get_row(board, c) +1][c.get_col(board, c) +2]).hp <=0){
                                            board[c.get_row(board, c) +1][c.get_col(board, c) +2]="  ";
                                        }
                                    }
                                }
                                if(c.get_row(board,c)<board.length-2&& c.get_col(board,c)<board.length-2){
                                    if(board[c.get_row(board,c)+2][c.get_col(board,c)+2] instanceof Zorde){
                                        ((Zorde) board[c.get_row(board, c) +2][c.get_col(board, c) +2]).hp -=15;
                                        if(((Zorde) board[c.get_row(board, c) +2][c.get_col(board, c) +2]).hp <=0){
                                            board[c.get_row(board, c) +2][c.get_col(board, c) +2]="  ";
                                        }
                                    }
                                }

                                if(c.get_row(board,c)<board.length-2&& c.get_col(board,c)!=board.length-1){
                                    if(board[c.get_row(board,c)+2][c.get_col(board,c)+1] instanceof Zorde){
                                        ((Zorde) board[c.get_row(board, c) +2][c.get_col(board, c) +1]).hp -=15;
                                        if(((Zorde) board[c.get_row(board, c) +2][c.get_col(board, c) +1]).hp <=0){
                                            board[c.get_row(board, c) +2][c.get_col(board, c) +1]="  ";
                                        }
                                    }
                                }
                                if(c.get_row(board,c)>1&& c.get_col(board,c)!=board.length-1){
                                    if(board[c.get_row(board,c)-2][c.get_col(board,c)+1] instanceof Zorde){
                                        ((Zorde) board[c.get_row(board, c) -2][c.get_col(board, c) +1]).hp -=15;
                                        if(((Zorde) board[c.get_row(board, c) -2][c.get_col(board, c) +1]).hp <=0){
                                            board[c.get_row(board, c) -2][c.get_col(board, c) +1]="  ";
                                        }
                                    }
                                }


                                if(c.get_row(board,c)<board.length-2&& c.get_col(board,c)!=0){
                                    if(board[c.get_row(board,c)+2][c.get_col(board,c)-1] instanceof Zorde){
                                        ((Zorde) board[c.get_row(board, c) +2][c.get_col(board, c) -1]).hp -=15;
                                        if(((Zorde) board[c.get_row(board, c) +2][c.get_col(board, c) -1]).hp <=0){
                                            board[c.get_row(board, c) +2][c.get_col(board, c) -1]="  ";
                                        }
                                    }
                                }
                                if(c.get_row(board,c)>1&& c.get_col(board,c)!=0){
                                    if(board[c.get_row(board,c)-2][c.get_col(board,c)-1] instanceof Zorde){
                                        ((Zorde) board[c.get_row(board, c) -2][c.get_col(board, c) -1]).hp -=15;
                                        if(((Zorde) board[c.get_row(board, c) -2][c.get_col(board, c) -1]).hp <=0){
                                            board[c.get_row(board, c) -2][c.get_col(board, c) -1]="  ";
                                        }
                                    }
                                }
                                if(c.get_row(board,c)<board.length-2){
                                    if(board[c.get_row(board,c)+2][c.get_col(board,c)] instanceof Zorde){
                                        ((Zorde) board[c.get_row(board, c) +2][c.get_col(board, c) ]).hp -=15;
                                        if(((Zorde) board[c.get_row(board, c) +2][c.get_col(board, c) ]).hp <=0){
                                            board[c.get_row(board, c) +2][c.get_col(board, c) ]="  ";
                                        }
                                    }
                                }
                                if(c.get_row(board,c)>1){
                                    if(board[c.get_row(board,c)-2][c.get_col(board,c)] instanceof Zorde){
                                        ((Zorde) board[c.get_row(board, c) -2][c.get_col(board, c) ]).hp -=15;
                                        if(((Zorde) board[c.get_row(board, c) -2][c.get_col(board, c) ]).hp <=0){
                                            board[c.get_row(board, c) -2][c.get_col(board, c) ]="  ";
                                        }
                                    }
                                }




                            }else{
                                attack(board,c);
                            }





                        }
                    } catch (Exception e) {

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

