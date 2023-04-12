import java.util.Scanner;

public class TicTacToeTester
{
    public static void main(String[] args)
    {
        //This is to help you test your methods. Feel free to add code at the end to check
        //to see if your checkWin method works!
        TicTacToe game = new TicTacToe();
        System.out.println("Initial Game Board:");
        game.printBoard();
        
        Scanner ttt = new Scanner(System.in);
        while(!game.checkWin()) {
        	System.out.println("Enter Row Number then Column Number: ");
        	int row = ttt.nextInt();
        	int col = ttt.nextInt();
        	if(game.pickLocation(row-1, col-1)) {
        		game.takeTurn(row-1, col-1);
        	}
        	game.printBoard();
        }
        
    
    }
}