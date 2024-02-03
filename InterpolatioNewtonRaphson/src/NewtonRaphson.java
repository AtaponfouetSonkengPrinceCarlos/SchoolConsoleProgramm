import java.util.ArrayList;
import java.util.Scanner;
public class NewtonRaphson {
public static void main(String[] args)
{
	System.out.println("--------------------------------------------");
	System.out.println("RESOLUTION EQUATION ALGEBRIQUE NON LINEAIRE DANS [a,b] N");
	System.out.println("--------------------------------------------");
	System.out.println("entrer l intervalle a");
	Scanner sc = new Scanner(System.in);
	double a =sc.nextDouble();
	System.out.println("entrer l intervalle");
	double b =sc.nextDouble();
	System.out.println("entrer le nombre de division");
	int n =sc.nextInt();
	double h = (b-a)/n;
	double x1 = b,E=0.01;
	double x0 = a,x=a;
	boolean bool = false;
	while(x<b)
	{
		x1 = x0-(f(x0)/g(x0));
		if(Math.abs(x1-x0)<E)
		{
			System.out.println("une solution est "+x1);
			bool = true;
		}
		x0 = x1;
		x = a+h;
		
	}
	if(bool = false)
		System.out.println("aucune solution dans l intervalle["+a+","+b+"]");
}
public static double f(double x)
{
	return Math.pow(x, 2)-x-1;
}
public static double g(double x)
{
	return 4*x-1;
}
}
