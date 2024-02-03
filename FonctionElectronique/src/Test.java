
public class Test {
public static void main(String[] args)
{
	double B[] = {100,200,300,400,500,600,700,800,900,1000,1591.5,2000,3000,4000,5000,6000,7000,9000,10000,20000,30000,40000,50000,60000,70000,80000,90000,100000,200000,300000,400000,500000,600000,700000,800000,900000,1000000};
	System.out.println("gain_______________________");
	for(int i=0;i<B.length;i++)
	{
		System.out.println(B[i]+"="+gain(B[i]));
	}
	System.out.println("angle_______________________");
	for(int j=0;j<B.length;j++)
	{
		System.out.println(B[j]+"="+arg(B[j]));
	}
}
public static double gain(double f)
{
	return -10*Math.log10(1+Math.pow(2*Math.PI*Math.pow(10, 3)*Math.pow(10, -7)*f, 2));
}
public static double arg(double f)
{
	return -Math.atan(Math.pow(2*f*Math.PI*Math.pow(10, 3)*Math.pow(10, -7),2));
}
}
