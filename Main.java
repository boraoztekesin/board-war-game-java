import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static ArrayList<Characters> zordes = new ArrayList<>();
    static ArrayList<Characters> calliances = new ArrayList<>();
    public static Object[][] board;
    static String outputt;
    static PrintStream out ;


    public static void main(String[] args) throws IOException {
        BufferedReader in;
        outputt=args[2];
        out= new PrintStream(new FileOutputStream(outputt));
        System.setOut(out);

        in = new BufferedReader(new FileReader(args[0]));

        String str;
        ArrayList<Characters> characters = new ArrayList<>();

        int[] board_size = new int[2];
        while ((str = in.readLine()) != null) {
            String[] arr = str.split(" ");
            if (str.contains("x")) {
                String[] temp = str.split("x");
                for (int i = 0; i < 2; i++) {
                    board_size[i] = Integer.parseInt(temp[i]);
                }

            }
            if (arr[0].equals("ELF")) {
                Characters elf = new Elf(arr[1], 70, Constants.elfAP,70);
                elf.coll= Integer.parseInt(arr[2]);
                elf.roww = Integer.parseInt(arr[3]);
                characters.add(elf);
                calliances.add(elf);


            }
            if (arr[0].equals("HUMAN")) {
                Characters human = new Human(arr[1], 100, Constants.humanAP,100);
                human.coll= Integer.parseInt(arr[2]);
                human.roww = Integer.parseInt(arr[3]);
                characters.add(human);
                calliances.add(human);
            }
            if (arr[0].equals("DWARF")) {
                Characters dwarf = new Dwarf(arr[1], 120, Constants.dwarfAP,120);
                dwarf.coll = Integer.parseInt(arr[2]);
                dwarf.roww = Integer.parseInt(arr[3]);
                characters.add(dwarf);
                calliances.add(dwarf);
            }
            if (arr[0].equals("ORK")) {
                Characters ork = new Ork(arr[1], 200, Constants.orkAP,200);
                ork.coll = Integer.parseInt(arr[2]);
                ork.roww = Integer.parseInt(arr[3]);
                characters.add(ork);
                zordes.add(ork);
            }
            if (arr[0].equals("GOBLIN")) {
                Characters goblin = new Goblin(arr[1], 80, Constants.goblinAP,80);
                goblin.coll = Integer.parseInt(arr[2]);
                goblin.roww = Integer.parseInt(arr[3]);
                characters.add(goblin);
                zordes.add(goblin);
            }
            if (arr[0].equals("TROLL")) {
                Characters troll = new Troll(arr[1], 150, Constants.trollAP,150);
                troll.coll = Integer.parseInt(arr[2]);
                troll.roww =Integer.parseInt(arr[3]);
                characters.add(troll);
                zordes.add(troll);
            }

        }
         board = new Object[board_size[0]][board_size[1]];
        for (Characters characters1:characters){
            board[characters1.roww][characters1.coll]=characters1;
        }


        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == null) {
                    board[row][col] = "  ";
                }
            }
        }
        Collections.sort(characters, new Comparator<Characters>() {
            @Override
            public int compare(Characters o1, Characters o2) {
                return o1.id.compareTo(o2.id);
            }
        });

        print_board(board,characters);

        in = new BufferedReader(new FileReader(args[1]));


        String str2;
        while ((str2 = in.readLine()) != null) {
            String[] arr = str2.split(" ");
            String idd=arr[0];
            String move_seq=arr[1];
            boolean zordes_alive=false;
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board.length; col++) {
                    for (Characters z:zordes){
                        if(board[row][col].equals(z)){
                            zordes_alive=true;
                        }
                    }
                }

            }
            boolean calliances_alive=false;
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board.length; col++) {
                    for (Characters cali:calliances){
                        if(board[row][col].equals(cali)){
                            calliances_alive=true;
                        }
                    }
                }

            }
           if(zordes_alive && calliances_alive){
               for (Characters c: characters){
                   if(c.id.equals(idd) && c.hp>0){
                       c.move(board,c,move_seq);
                       if(!c.errorexists){
                           print_board(board,characters);
                       }
                       c.errorexists=false;

                   }
               }
           }else {
               break;
           }

        }



in.close();






    }
    public static void print_board(Object[][] board, ArrayList<Characters> characters) {


        boolean zordes_alive=false;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                for (Characters z:zordes){
                    if(board[row][col].equals(z)){
                        zordes_alive=true;
                    }
                }
            }

        }
        boolean calliances_alive=false;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                for (Characters cali:calliances){
                    if(board[row][col].equals(cali)){
                        calliances_alive=true;
                    }
                }
            }

        }

            int row_len=board.length;
            int col_len=board.length;
            Object[][] temp_board=new Object[row_len][col_len];
            for (int r = 0; r < board.length; r++) {
                for (int cl = 0; cl < board.length; cl++) {
                    temp_board[r][cl]=board[r][cl];


                }}
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board.length; col++) {
                    for (Characters c : characters) {
                        if (c.equals(board[row][col])) {
                            temp_board[row][col] = c.id;
                        }
                    }
                }

            }
            Object[][] new_matrix=new Object[row_len+2][col_len+2];

            for (int row = 0; row < new_matrix.length; row++) {
                for (int col = 0; col < new_matrix[row].length; col++) {
                    if( (col==0&& row!=0 &&row !=new_matrix.length-1) ||(col==new_matrix[new_matrix.length-1].length-1 && row!=0 &&row !=new_matrix.length-1)){
                        new_matrix[row][col]="*";
                    }
                    if((row==0 && col<new_matrix.length-1 )||(row==new_matrix.length-1 && col<new_matrix.length-1 )){
                        new_matrix[row][col]="**";
                    }
                    if(new_matrix[row][col]==null){
                        new_matrix[row][col]="";
                    }

                }
            }
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {
                    new_matrix[row+1][col+1]=temp_board[row][col];
                }
            }

            for (int i=0;i<new_matrix.length;i++){
                System.out.println(Arrays.deepToString(new_matrix[i]).replace("[","").replace("]","").replace(", ",""));
            }


        System.out.println("");

            for (Characters characters1: characters){
                if(characters1.hp>0){
                    System.out.println(characters1.id+"  "+characters1.hp+"  "+"("+characters1.initial_hp+")");
                }
            }
        System.out.println("");

        if(!zordes_alive){
            System.out.println("");
            System.out.println("Game Finished");
            System.out.println("Calliance Wins");

    }
if(!calliances_alive){
    System.out.println("");
    System.out.println("Game Finished");
    System.out.println("Zorde Wins");

}



    }

}