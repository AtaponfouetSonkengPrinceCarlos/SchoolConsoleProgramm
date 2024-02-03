import java.util.Scanner;
public class DiagonalisationResolutionSystemequa {
public static void main(String[] args)
{
	System.out.println("-------------------------------------------------------------------------------");
	System.out.println("CALCUL D EQUATION DE LA FORME:");
	System.out.println("a11X1 + a12X2+...a1nXn= b1");
	System.out.println(".                     .");
	System.out.println(".                     .");
	System.out.println(".                     .");
	System.out.println("an1Xn + an2X2+...annXn= bn");
	System.out.println("-------------------------------------------------------------------------------");
	System.out.println("Entrer le nombre de ligne de votre equation");
	int n;
	Scanner sc = new Scanner(System.in);
	do
	{
		n = sc.nextInt();
	}while(n<=0);
	float A[][] = new float[n][n];
	float B[] = new float [n];
	float X[] = new float[n];
	Scanner sc1 = new Scanner(System.in);
	for(int i=0;i<A.length;i++)
	{
		for(int j=0;j<A.length;j++)
		{
			System.out.println("Entrer le coefficient a"+(i+1)+(j+1));
			
			A[i][j] = sc1.nextFloat();;
		}
		System.out.println("Entrer le coefficient b"+(i+1));
		B[i]=sc1.nextFloat();
	}
	System.out.println("votre Systemes est!!!!");
	System.out.println("-----------------------");
	
	for(int i=0;i<A.length;i++)
	   {
	       for(int j=0;j<A.length;j++)
	       {
	           System.out.print("\t"+A[i][j]+"x"+(j+1));
	       }
	       System.out.println("=\t"+B[i]);
	       System.out.println();
	   }
	for(int k=0 ;k<(A.length-1);k++)
	{
		for(int i=k+1;i<A.length;i++)
		{
			B[i] =B[i]-(A[i][k]*B[k])/A[k][k];
			for(int j=k+1;j<A.length;j++)
			{
				A[i][j] = A[i][j]-(A[i][k]*A[k][j])/(A[k][k]);
			}
		}
	}
	A[1][0] = 0;
	for(int k=(A.length-1);k>=0;k--)
	{
		for(int i=k-1;i>=0;i--)
		{
			B[i] =B[i]-(A[i][k]*B[k])/A[k][k];
			for(int j=k-1;j>=0;j--)
			{
				A[i][j] = (A[i][j]-(A[i][k]*A[k][j]))/(A[k][k]);
			}
		}
	}
	for(int t=0;t<A.length;t++)
	{
		X[t] = A[t][t]/B[t];
		System.out.println("X"+(t+1)+"="+X[t]);
	}
}
}
