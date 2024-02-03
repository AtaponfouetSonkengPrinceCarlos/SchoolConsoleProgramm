import java.util.Scanner;
public class pascal {
	
public static void main(String[] args)
{
	  final int N = 100;
	    int i,j;
	    System.out.println("entrer la profondeur de votre tableau");
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int[][] tab = new int[n][n];
	    for(i=0;i<tab.length;++i)
	    {
	           
	    	 tab[i][0] = 1;
	            tab[i][i] = 1;
	    }
   for(i=2;i<tab.length;i++)
	    {
	   
	        for(j=1;j<tab.length;j++)
	        {

	            tab[i][j] = tab[i-1][j-1] + tab[i-1][j];
	        }
	    }
	    
   for(i=0;i<tab.length;i++)
   {
       for(j=0;j<tab.length;j++)
       {
           System.out.print("\t"+tab[i][j]+" ");
       }
       System.out.println();
   }
	}
}

