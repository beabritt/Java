import java.util.*;

public class MainConcesionario {
	
	//Caso 3, el usuario elige cocheS primero. Por lo tanto quedan la opción 1(cocheK) y 2(cocheN).
	public static void case3Resolution(Scanner sc, Coche cocheK, Coche cocheN) {
		int option = 0;
		boolean flag = true;
		while (flag) {
			try { 
				MenusConcesionario.menu4();
				option = sc.nextInt();
				sc.nextLine(); //limpiamos el buffer
				switch(option) {
					case 1:
						cocheK.registrar(sc);
						System.out.println(cocheK);
						cocheN.registrar(sc);
						System.out.println(cocheN);
						break;
					case 2:
						cocheN.registrar(sc);
						System.out.println(cocheN);
						cocheK.registrar(sc);
						System.out.println(cocheK);
						break;
				}
			} catch (InputMismatchException e){
	            System.out.println("Debes introducir uno de estos números.");
	            sc.nextLine(); //limpiamos buffer despúes del error.
			}
			flag = false;
		}
	}
	
	//Caso 2, el usuario elige cocheN primero. Por lo tanto quedan la opción 1(cocheK) y 3(cocheS).
	public static void case2Resolution(Scanner sc, Coche cocheK, Coche cocheS) {
		int option = 0;
		boolean flag = true;
		while (flag) {
			try { 
				MenusConcesionario.menu3();
				option = sc.nextInt();
				sc.nextLine(); //limpiamos el buffer
				switch(option) {
					case 1:
						cocheK.registrar(sc);
						System.out.println(cocheK);
						cocheS.registrar(sc);
						System.out.println(cocheS);
						break;
					case 3:
						cocheS.registrar(sc);
						System.out.println(cocheS);
						cocheK.registrar(sc);
						System.out.println(cocheK);
						break;
				}
			} catch (InputMismatchException e){
	            System.out.println("Debes introducir uno de estos números.");
	            sc.nextLine(); //limpiamos buffer despúes del error.
			}
			flag = false;
		}
	}
	
	//Caso 1, el usuario elige cocheK primero. Por lo tanto quedan la opción 2(cocheN) y 3(cocheS).
	public static void case1Resolution(Scanner sc, Coche cocheN, Coche cocheS) {
		int option = 0;
		boolean flag = true;
		while (flag) {
			try { 
				MenusConcesionario.menu2();
				option = sc.nextInt();
				sc.nextLine(); //limpiamos el buffer
				switch(option) {
					case 2:
						cocheN.registrar(sc);
						System.out.println(cocheN);
						cocheS.registrar(sc);
						System.out.println(cocheS);
						break;
					case 3:
						cocheS.registrar(sc);
						System.out.println(cocheS);
						cocheN.registrar(sc);
						System.out.println(cocheN);
						break;
				}
			} catch (InputMismatchException e){
	            System.out.println("Debes introducir uno de estos números.");
	            sc.nextLine(); //limpiamos buffer despúes del error.
			}
			flag = false;
		}
	}
	/*Instanciamos las tres subclases, mostramos el menú, creamos los objetos y realizamos las operaciones solicitadas.*/
	
	public static void main(String[] args) {
		
		System.out.println("Bienvenid@, primero vamos a registrar los tres primeros coches del inventario.");
		
		/*En primer lugar instanciamos un objeto de cada tipo. Lo vamos a hacer con la subclase en lugar de la superclase. De los contrario,
		 *  no nos permite acceder a los métodos de la interfaz.*/
		
		CocheKm cocheK = new CocheKm();
		CocheNuevo cocheN = new CocheNuevo();
		CocheSegundaMano cocheS = new CocheSegundaMano();
		Scanner sc = new Scanner(System.in);
		int option = 0;
		boolean flag = true;
		
		/*Utilizamos un bucle main para mostrar el menú y escanear la opción elegida por el usuario. Con switch redirigimos al usuario
		 * 		a otra función auxiliar que nos permite  contnuar con el registro de los coches sin hacer un main demasiado largo y redundante.*/
		System.out.println("Por favor, elige el número del tipo de coche que quieres registrar primero.");
		while (flag) {
			try { 
				MenusConcesionario.menu1();
				option = sc.nextInt();
				sc.nextLine(); //limpiamos el buffer
				switch(option) {
					case 1:
						cocheK.registrar(sc);
						System.out.println(cocheK);
						case1Resolution(sc, cocheN, cocheS);
						break;
					case 2:
						cocheN.registrar(sc);
						System.out.println(cocheN);
						case2Resolution(sc, cocheK, cocheS);
						break;
					case 3:
						cocheS.registrar(sc);
						System.out.println(cocheS);
						case3Resolution(sc, cocheK, cocheN);
						break;
				}
			} catch (InputMismatchException e){
	            System.out.println("Debes introducir uno de estos números.");
	            sc.nextLine(); //limpiamos buffer despúes del error.
			}
			flag = false;	//al llegar aquí cambiamos el valor de flag para salir del bucle y continuar con el resto de operaciones.
		}
		System.out.println("El número total de coches registrados es de " + Coche.getNumCochesStock() +  ". Ahora vamos a realizar las acciones solicitadas.\n");
		System.out.println("En primer lugar vamos a alquilar el coche KM 0 que tenemos registrado:");
		cocheK.alquilar();
		System.out.println();
		System.out.println("Estos son los datos finales del coche KM 0:" + cocheK.toString() + "\n");
		System.out.println("Ahora vamos a vender el coche nuevo que tenemos disponible, el " + cocheN.getModelo()+ " de color " + cocheN.getColor() + ".");
		cocheN.vender();
		System.out.println();

		System.out.println("Estos son los datos finales del coche nuevo: " + cocheN.toString() + "\n");
		System.out.println("Tras esta operación, el número total de coches en stock es de " + Coche.getNumCochesStock() +  ".\n");
		System.out.println("Por último vamos a vender el coche de segunda mano, el " + cocheS.getModelo() + " de color " + cocheS.getColor() + ".");
		cocheS.vender();
		System.out.println();

		System.out.println("Estos son los datos finales del coche de segunda mano: " + cocheS.toString() + "\n");
		System.out.println("Tras esta operación, el número total de coches en stock es de " + Coche.getNumCochesStock() +  ".");
		sc.close();
	}

		
}
