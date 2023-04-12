public class TicTacToe
{
   //copy over your constructor from the Tic Tac Toe Board activity in the previous lesson!
	public TicTacToe() {
		this.board = getBoard();
		this.turn = getTurn();
		
	}
   public String[][] board;
   private int turn = 0;
   
   //this method returns the current turn
   public int getTurn()
   {
       
    	   return turn;
       
      
   }
   public String[][] getBoard() {
       if(this.board == null) {
    	   return blankBoard();
       }
       else {
    	   return board;
       }
   }
   public String[][] blankBoard(){
       String[][] newBoard = new String[3][3];
       for(int i=0;i<3;i++) {
           for(int j=0; j<3;j++) {
               newBoard[i][j] = "-";
           }
       }
       return newBoard;
   }
   /*This method prints out the board array on to the console
   */
   public void printBoard()
   {
       String[][] b = getBoard();
       for(int i = 0;i<3;i++) {
    	   for (int j = 0; j<3;j++) {
    		   System.out.print (b[i][j] + " ");
    	   }
    	   System.out.print("\n");
       }
   }
   
   //This method returns true if space row, col is a valid space
   public boolean pickLocation(int row, int col)
   {
       if(board[row][col] == "-") {
    	   return true;
       }
       else {
    	   return false;
       }
   }
   
   //This method places an X or O at location row,col based on the int turn
   public void takeTurn(int row, int col)
   {
       if(getTurn() == 0) {
    	   board[row][col] = "X";
    	   turn = 1;
    	   
       }
       else if(getTurn()== 1) {
    	   board[row][col] = "O";
    	   turn = 0;
       }
       
   }
   
   //This method returns a boolean that returns true if a row has three X or O's in a row
   public boolean checkRow()
   {
	   boolean win = false;
	   int cX = 0;
	   int cO = 0;
       for(int i = 0; i<board.length; i++) {
    	   for(int j = 0; j<board[i].length;j++) {
    		   if(board[i][j]=="X") {
    			   cX++;
    		   }
    		   if(board[i][j]=="O") {
    			   cO++;
    		   }
    	   }
    	   if(cX == 3 || cO == 3) {
    		   win = true;
    		   return win;
    	   }
    	   
       }
       return win;
   }
   
    //This method returns a boolean that returns true if a col has three X or O's
   public boolean checkCol()
   {
	   boolean win = false;
	   int cX = 0;
	   int cO = 0;
       for(int i = 0; i<board.length; i++) {
    	   
    	   for(int j = 0; j<board[i].length;j++) {
    		   if(board[j][i]=="X") {
    			   cX++;
    		   }
    		   if(board[j][i]=="O") {
    			   cO++;
    		   }
    	   }
    	   if(cX == 3 || cO == 3) {
    		   win = true;
    		   return win;
    	   }
    	   
       }
       return win;
   }
   
    //This method returns a boolean that returns true if either diagonal has three X or O's
   public boolean checkDiag()
   {
	   boolean win = false;
	   int cX = 0;
	   char mid = ' ';
	   int cO = 0;
       for(int i = 0; i<board.length; i++) {
    	   
    		  if(i==0) {
    			  if(board[i][0] == "O") {
    				  cO++;
    			  }
    			  else {
    				  if(board[i][0] == "X") {
    					cX++;  
    				  }
    				  else {
    					  if(board[i][2]=="O") {
    						  cO=2;
    					  }
    					  else {
    						  if(board[i][2]=="X") {
    							  cX=2;
    						  }
    					  }
    				  }
    				  
    			  }
    		  }
    		  else {
    			  if(i==1) {
    				  if(board[i][1] == "X") {
    					   mid = 'X';
    				  }
    				  if(board[i][1]== "O") {
    					  mid = 'O';
    				  }
    			  }
    			  else {
    				  if(mid == 'O') {
    					  if(board[i][0] == "O" && cO==1) {
    						  return true;
    					  }
    					  else {
    						  if(board[i][2]=="O" && cO==2) {
    							  return true;
    						  }
    			  
    					  }
    				  }
    				  else {
    					  if(mid == 'X') {
    						  if(board[i][0] == "X" && cX==1) {
        						  return true;
        					  }
        					  else {
        						  if(board[i][2]=="X" && cX==2) {
        							  return true;
        						  }
        			  
        					  }
    					  }
    					  else {
    						  return false;
    					  }
    				  }
    			  }
    		  }
       }
       return false;
   }
   
   //This method returns a boolean that checks if someone has won the game
   public boolean checkWin()
   {
       if(checkRow()) {
    	   return true;
       }
       else {
    	   if(checkCol()) {
    		   return true;
    	   }
    	   else {
    		   if(checkDiag()) {
    			   return true;
    		   }
    	   }
       }
       return false;
   }

}
