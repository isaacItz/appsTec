package pruebas;

public class SobreCarga {

	public static void main(String[] args) {
		 System.out.println(sumar( 20,10));
		 System.out.println(sumar( 20));
		 System.out.println(sumar( 0));
		 System.out.println(sumar(1,2,3));
		 System.out.println(sumar (1,2,3,4));
	}
	public static  int sumar (int a, int b) {
		return a+b;
	}
	public static  int sumar (int a, int b, int c) {
		return c;
	}
	public static  int sumar (int a, int b , int c , int d) {
		return d;
	}
	
	public static  int sumar (int a) {
		return a;	
	}
	public static  int sumar () {
		return 0;	
		
	}	
	public static int sumar (int...numeros) {
	int suma=0;
	for (int i :numeros) {
		suma+=i;
	}
	return suma;
	}
}
