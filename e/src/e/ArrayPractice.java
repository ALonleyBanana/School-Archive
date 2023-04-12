package e;

public class ArrayPractice
{
	 public static void main(String[] args)
	    {
		 	
	        int[][] array = {
	        		        {   32,  4,  14,  65,  23,  6},
	                        {    4,  2,  53,  31, 765, 34},
	                        {64235, 23, 522, 124,  42, 64}
	                        };
	        int[] sR = new int[array.length];
	        for(int c = 0; c<array.length;c++) {
	        	sR[c] = sumRow(array,c);
	        	
	        }
	        for(int q = 0; q<sR.length;q++) {
	        	System.out.println(sR[q]);
	        	
	        }
	        
	        
	    }
	    
	    public static int sumRow(int[][] array, int row)
	    {
	    	int s =0;
	        for(int i=0;i<array[row].length;i++) {
	        	
	        	s = s + array[row][i];
	        	
	        }
	        return s;
	    }
	}