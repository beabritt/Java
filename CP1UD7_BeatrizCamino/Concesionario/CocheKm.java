import java.util.Scanner;

//extends permite que CocheKm gerede de Coche e implements permite integrar la interfaz Alquilable.

public class CocheKm extends Coche implements Alquilable {

	//atributos específicos subclase
	
	private boolean alquilado;
	
	//constructores
	
	public CocheKm() {
		super();
	}
	
	public CocheKm (String matricula, String color, String modelo, double precio, int kms) {
		super.setMatricula(matricula);
		super.setColor(color);
		super.setModelo(modelo);
		super.setPrecio(precio);
		super.setKms(kms);
		alquilado = false;
	}

	//getter y setter del atributo específico de la subclase
	public boolean getAlquilado() {
		return alquilado;
	}

	public void setAlquilado(boolean alquilado) {
		this.alquilado = alquilado;
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
		if (!alquilado)
			estado = "Disponible";
		else
			estado = "Alquilado";
		return super.toString() + "Estado: " + estado + ".";
	}

	/*Este método sobreescrito proviene de la interfaz Alquilable. Aunque el coche se encuentre
	 * 		alquilado, sigue siendo del concesionario, por lo que no decrementa el stock. */
	@Override
	public void alquilar() {
		if (alquilado) {
			System.out.println("El coche ya se encuentra alquilado.");
		}
		else {
			alquilado =  true;
			System.out.println("El coche " + super.getModelo() + " se ha alquilado.");
		}
	}
	
	public void registroCoche(Scanner sc) {
		super.registroCoche(sc);
	}
	
	//método abstracto heredado de la superclase.

	@Override
	public void registrar(Scanner sc) {
		System.out.println("Vamos a registrar el coche de kilómetro 0.");
		registroCoche(sc);
		System.out.println("Vehículo correctamente registrado. Estos son los datos:");
		
	}
}

