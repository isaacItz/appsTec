package pruebas;

public class Reloj {
	private String clave;
	private String marca;
	private String modelo;
	private int horas;
	private int minutos;
	private int segundos;
	//CONSTRUCTOR SIN PARAMENTROS
	public Reloj() {
	this("1000", "patito","canadiense", 24, 59, 59);	
	}
	//CONTRUCTOR CON PARAMETROS
	public Reloj(String clave, String marca, String modelo, int horas, int minutos, int segundos) {
		this.clave = clave;
		this.marca = marca;
		this.modelo = modelo;
		this.horas = horas;
		this.minutos = minutos;
		this.segundos= segundos;
	}
	//CONTRUCTOR COPIADOR
	public Reloj(Reloj reloj){
		this.clave = reloj.clave;
		this.marca = reloj.marca;
		this.modelo = reloj.modelo;
		this.horas = reloj.horas;
		this.minutos = reloj.minutos;
		this.segundos = reloj.segundos;
	}
	
	
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
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
	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	public int getMinutos() {
		return minutos;
	}
	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}
	public int getSegundos() {
		return segundos;
	}
	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}
	@Override
	public String toString() {
		return "Reloj [clave=" + clave + ", marca=" + marca + ", modelo="
				+ modelo + ", horas:" + horas + ":" + minutos
				+ ":" + segundos + "]";
	}
	public void incrementar(){
		if(segundos==59){
			segundos=0;
			if(minutos==59){
				minutos=0;
				if(horas==23){
					horas=0;
				}else horas++;
			}else minutos++;
		}else segundos++;
	}

	public void decrementar(){
		if(segundos==0){
			segundos=59;
			if(minutos==0){
				minutos=59;
				if(horas==0){
					horas=23;
				}else horas--;
			}else minutos--;
		}else segundos--;
	}


}
