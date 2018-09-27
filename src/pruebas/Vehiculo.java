package pruebas;

public class Vehiculo {
private String marca;
private String modelo;
private float precio;
public String getMarca() {
	return marca;
}
public void setMarca(String marca) {
	this.marca = marca;
}
public String getModelo() {
	return modelo;
}
public void setModelo(String modelo) {
	this.modelo = modelo;
}
public float getPrecio() {
	return precio;
}
public void setPrecio(float precio) {
	this.precio = precio;
}
@Override
public String toString() {
	return "Vehiculo [marca=" + marca + ", modelo=" + modelo + ", precio=" + precio + "]";
}
@Override
protected void finalize() throws Throwable {
	System.out.println("me estan destruyendo");
	super.finalize();
}


}