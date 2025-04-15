//extends permite que CocheKm gerede de Coche e implements permite integrar la interfaz Vendible.

import java.util.Scanner;

public class CocheSegundaMano extends Coche implements Vendible {

	//atributos específicos subclase
	
	private String antiguoPropietario;
	private boolean vendido;
	
	//constructores
	
	public CocheSegundaMano() {
		super();
	}
	
	public CocheSegundaMano (String matricula, String color, String modelo, double precio, int kms, String antiguoPropietario) {
		super.setMatricula(matricula);
		super.setColor(color);
		super.setModelo(modelo);
		super.setPrecio(precio);
		super.setKms(kms);
		this.antiguoPropietario = antiguoPropietario;
		vendido = false;
	}

	//getter y setter de los atributos específicos de la subclase
	public boolean getVendido() {
		return vendido;
	}

	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}
	
	public String getAntiguoPropietario() {
		return antiguoPropietario;
	}

	public void setAntiguoPropietario(String antiguoPropietario) {
		this.antiguoPropietario = antiguoPropietario;
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
		return getColor();
	}

	public void setColor(String color) {
		super.setColor(color);
	}
	
	//modelo

	public String getModelo() {
		return super.getColor();
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
		return super.toString() + "Antiguo propietario: " + antiguoPropietario +  ". Estado: " + estado + ".";
	}

	//Este método sobreescrito proviene de la interfaz Vendible
	
	@Override
	public void vender() {
		super.setNumCochesStock(numCochesStock--);
		vendido =  true;
		System.out.println("El coche " + super.getModelo() + " se ha vendido.");
		
	}
	public void registroCoche(Scanner sc) {
		super.registroCoche(sc);
		setAntiguoPropietario(super.pedirCadenaNoVacia(sc, "Introduce el nombre del antiguo propietario:"));
	}
	
	//método abstracto heredado de la superclase.
	public void registrar(Scanner sc) {
		System.out.println("Vamos a registrar el coche de segunda mano.");
		registroCoche(sc);
		System.out.println("Vehículo correctamente registrado. Estos son los datos:");
	}
}
