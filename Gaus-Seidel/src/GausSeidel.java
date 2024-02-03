//importation de la bibliotheque entrer/sortir
import java.util.Scanner;
public class GausSeidel {
public static void main(String args[])
{
	//Affichage de la forme du Systeme
	System.out.println("-------------------------------------------------------------------------------");
	System.out.println("RESOLUTIONS SYSTEMES LINEAIRES:GS");
	System.out.println("a11X1 + a12X2+...a1nXn= b1");
	System.out.println(".                     .");
	System.out.println(".                     .");
	System.out.println(".                     .");
	System.out.println("an1Xn + an2X2+...annXn= bn");
	System.out.println("-------------------------------------------------------------------------------");
	System.out.println("Entrer le nombre de ligne de votre equation");
	//declaration de la taille du tableau
	int n;
	Scanner sc = new Scanner(System.in);
	//verification du signe du nombre 
	do
	{
		n = sc.nextInt();
	}while(n<=0);
	double s,s1,s2;
	double A[][] = new double[n][n];
	double B[] = new double [n];
	double X[] = new double[n];
	double Y[] = new double[n];
	Scanner sc1 = new Scanner(System.in);
	//affichage du System entré par 
	for(int i=0;i<A.length;i++)
	{
		for(int j=0;j<A.length;j++)
		{
			System.out.println("Entrer le coefficient a"+(i+1)+(j+1));
			A[i][j] = sc1.nextFloat();
		}
		System.out.println("Entrer le coefficient b"+(i+1));
		B[i]=sc1.nextFloat();
	}
	System.out.println("votre Systemes est");
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
	//initialisation du tableau a zero
	for(int i=0;i<A.length;i++)
	{
		X[i] =0;
	}
	//declaration et initialisation de la precision
	double E = Math.pow(10, -15),d=E+1;
	int k =0;
	//debut du calcul
	while(d>E)
	{
		k++;
        s = 0;
        s2 =0;
        s1=0;
		for(int j=1;j<A.length;j++)
		{
			s = s + A[0][j]*X[j];
		}
		Y[0] = (B[0]-s)/(A[0][0]);
		for(int i=1;i<A.length;i++)
		{
			for(int j=0;j<=i-1;j++)
			{
				s1 = s1 + A[i][j]*Y[j];
			}
			for(int j=i+1;j<X.length;j++)
			{
				s2 = s2 +A[i][j]*X[j];
			}
			Y[i] = (B[i]-s1-s2)/A[i][i];
			s = 0;
	        s2 =0;
	        s1=0;
		}
		double som1=0,som2=0;
		for(int i=0;i<X.length;i++)
		{
			som1 = som1 + Math.abs((Y[i]-X[i]));
			som2 =som2 + Math.abs(Y[i]);
		}
		d = som1/som2;
		for(int i=0;i<X.length;i++)
		{
			X[i] = Y[i];
		}
	}
	//affichage des solutions
	for(int i=0;i<X.length;i++)
	{
	System.out.println("vos solutions sont X["+(i+1)+"] ="+X[i]);
	}
	System.out.println("le nombre d'iteration est "+k);
}
}
