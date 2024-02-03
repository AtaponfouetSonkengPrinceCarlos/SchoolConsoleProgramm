import java.util.Scanner;
public class InterpolationPolynomial {
public static void main(String[] args)
{
	int n,i,k;
	float s1,s2;
	System.out.println("==================================================================");
	System.out.println("Interpolation polynomiale de la forme ax^n+bx^n-1+...........+c");
	System.out.println("==================================================================");
	System.out.println("veillez s il vous plait entrer le nombre de point de votre equation");
	Scanner sc = new Scanner(System.in);
	do
	{
		n = sc.nextInt();
		
	}while(n<=0);
    float x[] =new float [n];
	float y[] = new float [n];
	for(i =0;i<x.length;i++)
	{
		System.out.println("entrer les elements x"+(i+1)+"de vos experiences");
		x[i] = sc.nextFloat();
		System.out.println("entrer les elements y"+(i+1)+"de vos experiences");
		y[i] = sc.nextFloat();
	}
	System.out.println("entrer la valeurs x a calculer!!!!!!");
	float xp = sc.nextFloat();
	float f = 0;
	for(k=0;k<x.length;k++)
	{
		s1 = 1;
		s2 = 1;
		for(i =0;i<x.length;i++)
		{
			if(i!=k)
			{
			s1 = s1*(xp-x[i]);
			s2 = s2*(x[k] - x[i]);
			}
		}
	f= f+ (s1/s2)*y[k];
	}
	System.out.println("votre reponse est pret ");
		System.out.println("la solution est y = "+f);
	
}
}
