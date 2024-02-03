import java.util.Scanner;
public class Jacobi {
public static void main(String args[])
{
	System.out.println("-------------------------------------------------------------------------------");
	System.out.println("CALCUL D EQUATION DE LA FORME:Jacobi");
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
	double A[][] = new double[n][n];
	double B[] = new double [n];
	double X[] = new double[n];
	double Y[] = new double[n];
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
	for(int i=0;i<X.length;i++)
	{
		X[i] = 0;
	}
	double E = 0.000001,d = E +1;
	while(d>=E)
	{
		for(int i=0;i<A.length;i++)
		{
			double s = 0;
			for(int j=0;j<A.length;j++)
			{
				if(i!=j)
				{
					s = s + A[i][j]*X[j];
				}
			}
				Y[i] = (B[i]-s)/A[i][i];
		}
				double s1 = 0,s2=0;
				for(int k=0;k<n;k++)
				{
					s1 =Math.abs(Y[k]-X[k]) + s1;
					s2 =Math.abs(Y[k]) +s2;
				}
				for(int t=0;t<A.length;t++)
				{
					X[t] = Y[t];
				}
				d = s1/s2;
	}
	for(int t=0;t<A.length;t++)
	{
		System.out.println("X"+(t+1)+"="+Y[t]);
	}
}
}
