package pruebas;

public class PincipalSobreCargas {

	public static void main(String[] args) {
	
		Punto punto = new Punto();
		Triangulo triangulo= new Triangulo();
       Vehiculo vehiculo = new  Vehiculo();
        int x = 10;
       float f = 14.16f;
       String cadena= "hola";
       punto.setX(100);
       punto.setY(50);
       triangulo.setAltura(30);
       triangulo.setBase(80);
       vehiculo.setMarca("nissan");
       vehiculo.setModelo("sentra");
       vehiculo.setPrecio(200.85f);
       vehiculo= null;
       punto =null;
       System.gc();
       visualizar(x);
       visualizar(f);
       visualizar(punto);
       visualizar(vehiculo);
       visualizar(cadena);
	}
       
	
	public static void visualizar(int dato) {
		System.out.println(dato);
	}
	public static void visualizar(float dato) {
		System.out.println(dato);

}
	public static void visualizar(String dato) {
		System.out.println(dato);
}
	public static void visualizar(Punto dato) {
		System.out.println(dato);
}
	public static void visualizar(Triangulo dato) {
		System.out.println(dato);
}
	public static void visualizar(Vehiculo dato) {
		System.out.println(dato);
}
	public static void mover (int x, float f) {
		
	}
public static void mover (float f, int x) {
		
	}
}