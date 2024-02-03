import java.util.Scanner;

public class MoidreCarre {
public static void main(String[] args)
{
	int n;
	System.out.println("==================================================================");
	System.out.println("Interpolation quelquon de la forme a0g0(x)+a1g1(x)+.......+angn(x)");
	System.out.println("==================================================================");
	System.out.println("veillez s il vous plait entrer le nombre de point de votre equation");
	Scanner sc = new Scanner(System.in);
	do
	{
		n = sc.nextInt();
		
	}while(n<=0);
	float A[][] = new float[2][2];
	float B[] = new float[2];
	float X[] = new float[2];
    float x[] =new float [n];
	float y[] = new float [n];
	for(int i =0;i<x.length;i++)
	{
		System.out.println("entrer les elements x"+(i+1)+"de vos experiences");
		x[i] = sc.nextFloat();
		System.out.println("entrer les elements y"+(i+1)+"de vos experiences");
		y[i] = sc.nextFloat();
	}
	for(int k=0;k<A.length;k++)
	{
		for(int j=0;j<A.length;j++)
		{
			A[k][j] = 0;
			for(int i=0;i<x.length;i++)
			{
				A[k][j] = g(k,x[i])*g(j,x[i])+A[k][j];
			}
		}
	}
	for(int k=0;k<A.length;k++)
	{
		B[k]=0;
		for(int i=0;i<x.length;i++)
		{
			B[k] = B[k]+g(k,x[i])*y[i];
		}
	}
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
	X[A.length-1]=B[A.length-1]/A[A.length-1][A.length-1];
	for(int i=(A.length-1);i>=0;i--)
	{
		float som = 0;
		for(int j=i+1;j<A.length;j++)
		{
			som = som +A[i][j]*X[j];
		}
		X[i] = (B[i]-som)/A[i][i];
	}
	System.out.println("Les solutions sont:");
	System.out.println("--------------------");
	for(int i=0;i<A.length;i++)
	{
		System.out.println("X"+(i+1)+" ="+X[i]);
	}
}
public static float g(int k,float x)
{
	if(k==0)
	{
		return 1;
	}
	else 
	{
		if(k==1)
		{
			return -1/x;
		}
		else
		{
			return 0;
		}
	}
}
}
