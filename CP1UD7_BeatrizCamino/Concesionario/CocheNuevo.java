//extends permite que CocheKm gerede de Coche e implements permite integrar la interfaz Vendible.

import java.util.Scanner;

public class CocheNuevo extends Coche implements Vendible {

	//atributos específicos subclase
	
	private int garantia;
	private boolean vendido;
	
	//constructores
	
	public CocheNuevo() {
		super();
	}
	
	public CocheNuevo (String matricula, String color, String modelo, double precio, int kms) {
		super.setMatricula(matricula);
		super.setColor(color);
		super.setModelo(modelo);
		super.setPrecio(precio);
		super.setKms(kms);
		garantia = 3;
		vendido = false;
	}

	//getter y setter de los atributos específicos de la subclase
	public boolean getVendido() {
		return vendido;
	}

	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}
	
	public int getGarantia() {
		return garantia;
	}

	public void setGarantia(int garantia) {
		this.garantia = garantia;
	}
	
	//SETTERS Y GETTERS DE LA SUPERCLASE
	
	//matricula

	public void setMatricula(String matricula){
		super.setMatricula(matricula);
	}
	
	public String getMatricula(){
		return super.getMatricula();
	}
	
	//color
	
	public String getColor() {
		return super.getColor();
	}

	public void setColor(String color) {
		super.setColor(color);
	}
	
	//modelo

	public String getModelo() {
		return super.getModelo();
	}

	public void setModelo(String modelo) {
		super.setModelo(modelo);;
	}

	//precio
	
	public double getPrecio() {
		return super.getPrecio();
	}

	public void setPrecio(double precio) {
		super.setPrecio(precio);;
	}

	//kms
	
	public int getKms() {
		return super.getKms();
	}

	public void setKms(int kms) {
		super.setKms(kms);
	}

	//sobreescritura del método toString en subclase.
	public String toString() {
		
		String estado;
		if (!vendido)
			estado = "Disponible";
		else
			estado = "Vendido";
		return super.toString() + "Garantía: " + garantia +  ". Estado: " + estado + ".";
	}

	//Este método sobreescrito proviene de la interfaz Vendible. Produce un decremento en el stock de coches del concesionario.
	@Override
	public void vender() {
		if (vendido) {
			System.out.println("El coche ya ha sido vendido y no está disponible.");
		}
		else {
			super.setNumCochesStock(--numCochesStock); //realiza el decremento en la variable y envía posteriormente el valor
			vendido =  true;
			System.out.println("El coche " + super.getModelo() + " se ha vendido.");
		}
	}

	public void registroCoche(Scanner sc) {
		super.registroCoche(sc);
		setGarantia(super.pedirEntero(sc, "Introduce los años de garantía:"));
	}
	
	//método abstracto heredado de la superclase.
	public void registrar(Scanner sc) {
		System.out.println("Vamos a registrar el coche nuevo.");
		registroCoche(sc);
		System.out.println("Vehículo correctamente registrado. Estos son los datos:");
	}
}
