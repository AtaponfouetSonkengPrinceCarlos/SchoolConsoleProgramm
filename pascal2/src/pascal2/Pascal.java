package pascal2;
import java.util.Scanner;

public class Pascal {
	public static void main(String[],args)
	{
		sc scanner = new scanner(System.in);
		int N = 100;
	    int n,j,i;
	    int ligne1[N];
	    int ligne2 [N];
	   System.out.println println("entrer n");
	    n = sc.Int();
	    for(i=0;i<n;i++)
	    {
	        ligne1[i] = 1;
	        ligne2[j] = 1;
	        for(j=0;j<i;j++)
	        {
	            if(i==j)
	            {
	                ligne2[j] = 1;
	            } else
	            {
	                ligne2[j] = ligne1[j-1] + ligne1[j];
	            }
	        }
	        for(j=0;j<=i;j++)
	        {
	            ligne1[j] = ligne2[j];
	            System,out.println(ligne1[j]);
	        }
	        System.out.println("");
	    }
	}

}
