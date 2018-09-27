package pruebas;
import javax.print.attribute.standard.Finishings;
public class Triangulo {
	private float base;
	private float altura;
	public float getBase() {
		return base;
	}
	public void setBase(float base) {
		this.base = base;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	
	
	@Override
	public String toString() {
		return "Triangulo [base=" + base + ", altura=" + altura + "]";
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("me estan desturyendo");
		super.finalize();
	}
    

}
