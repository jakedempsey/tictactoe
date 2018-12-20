import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
   public static void main(String[] args) {
      Scoreboard game = new Scoreboard();
      game.fillArray();
      for (;;) {
         game.aiMove();
         game.printArray();
         game.checkWinners();
         game.playerMove();
         game.printArray();
         game.checkWinners();
      }
   }
}
class Scoreboard{
    private String array[][] = new String[3][3];
    Scanner scanner = new Scanner(System.in);

    public void fillArray(){
       for(int row = 0; row < 3; row++){
          for (int col = 0; col < 3; col++){
             array[row][col] = ".";
          }
       }
    }
    public void printArray() {
       for (int row = 0; row < 3; row++) {
          for (int col = 0; col < 3; col++) {
             System.out.print(array[row][col] + " ");
          }
          System.out.println();
       }
       System.out.println("\n");
    }
    public void aiMove(){
       for (;;){
          Random randomRow = new Random();
          Random randomCol = new Random();
          int row = randomRow.nextInt(3);
          int col = randomCol.nextInt(3);
          if (array[row][col].equals(".")){
             array[row][col] = "X";
             break;
          }
       }
    }
    public void playerMove(){
       for (;;) {
          System.out.println ("Enter coordinates with a space: eg 0 0");
          int row = scanner.nextInt();
          int col = scanner.nextInt();
          if (array[row][col].equals(".")) {
             array[row][col] = "O";
             break;
          }
       }
   }
   public void checkWinners(){
       for (int row = 0; row < 3; row++){
          //checks each row
          if (!array[row][0].equals(".")){
            if (array[row][0].equals(array[row][1]) && array[row][0].equals(array[row][2])) {
                System.out.println(array[row][0] + " WINS! (row)");
                System.exit(0);
            }
          }
       }
       for (int col = 0; col < 3; col++){
          //checks each column
          if (!array[0][col].equals(".")){
             if (array[0][col].equals(array[1][col]) && array[0][col].equals(array[2][col])) {
                System.out.println(array[0][col] + " WINS! (column)");
                System.exit(0);
             }
          }
       }
       //if the middle square DOESN'T equal "." (is taken by a move for diagonal)
       if (!array[1][1].equals(".")){
          if (array[1][1].equals(array[0][2]) && array[1][1].equals(array[2][0])){
             System.out.println(array[1][1] + " WINS! (positive slope)");
             System.exit(0);
          }
          if (array[1][1].equals(array[0][0]) && array[1][1].equals(array[2][2])){
             System.out.println(array[1][1] + " WINS! (negative slope)");
             System.exit(0);
          }
       }

   }
}

