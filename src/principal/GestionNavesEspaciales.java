package principal;

import java.time.LocalDate;
import java.util.*;

import clase.NaveEspacial;

public class GestionNavesEspaciales {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		ArrayList<NaveEspacial>naves=new ArrayList<>();
		
		int opcion;

		do {
			System.out.println("\n----- MENÚ -----");
			System.out.println("1. Añadir naves espaciales");
			System.out.println("2. Mostrar naves cuya antigüedad sea superior a una dada");
			System.out.println("3. Ordenar naves por año de lanzamiento");
			System.out.println("4. Modificar capacidad total de naves que admiten pasajeros");
			System.out.println("5. Mostrar todas las naves espaciales registradas");
			System.out.println("6. Eliminar una nave espacial");
			System.out.println("7. Salir");
			System.out.print("Elige una opción: ");
			opcion = scanner.nextInt();
			scanner.nextLine(); // Limpiar el buffer del scanner

			if (naves.isEmpty() && opcion > 1 && opcion < 7) {
				System.out.println("No hay naves registradas.");
			} else {
				switch (opcion) {
				case 1:
					añadirNaves(naves,scanner);
					break;
				case 2:
					mostrarNavesAntiguedad(naves, scanner);
					break;
				case 3:
					ordenarNavesPorLanzamiento(naves);
					break;
				case 4:
					modificarCapacidadPasajeros(naves, scanner);
					break;
				case 5:
					mostrarTodasNaves(naves);
					break;
				case 6:
					eliminarNave(naves, scanner);
					break;
				case 7:
					System.out.println("Saliendo del programa...");
					break;
				default:
					System.out.println("Opción inválida. Intenta de nuevo.");
				}
			}
		} while (opcion != 7);
	}

	// Método para añadir una nave
	private static void añadirNaves(ArrayList<NaveEspacial> naves, Scanner scanner) {
		String nombre;
		NaveEspacial nave;
		boolean seguir = true;
		int posicionNave;

		for (; seguir;) {
			System.out.print("Introduce el nombre de la nave: ");
			nombre = scanner.next();

			// Verificar que no se repite el nombre. Para ello buscamos la nave en el array
			// y devolvemos su posición
			posicionNave = buscarNavePorNombre(naves, nombre);

			if (posicionNave == -1) {
				nave = new NaveEspacial();
				nave.setDatos(nombre);
				naves.add(nave);
				System.out.println("Nave añadida exitosamente.");
			}else {
				System.out.println("Ya existe una nave con ese nombre.");
			}
			
			System.out.println("Quieres seguir introduciendo naves?");
			seguir=scanner.next().equalsIgnoreCase("SI");
		}

		/*if (numeroNaves >= 50) {
			System.out.println("No se pueden añadir más de 50 naves.");
		}
		*/
	}

	private static int buscarNavePorNombre(ArrayList<NaveEspacial> naves, String nombre) {
		// Si no lo encuentra, devuelve como posición -1
		for (int i = 0; i < naves.size(); i++) {
			if (naves.get(i).getNombre().equalsIgnoreCase(nombre)) {
				return i;
			}
		} 
		return -1;
	}

	// Método para mostrar naves con antigüedad mayor a la dada
	private static void mostrarNavesAntiguedad(ArrayList<NaveEspacial> naves,  Scanner scanner) {
		boolean encontradas = false;
		int antiguedad;
		
		System.out.print("Introduce la antigüedad mínima: ");
		antiguedad = scanner.nextInt();
		scanner.nextLine(); // Limpiar el buffer del scanner

		for (int i=0; i< naves.size(); i++) {
			if (naves.get(i).calcularAntiguedad(LocalDate.now().getYear()) >= antiguedad) { // Usamos 2024 como el año actual
				System.out.println(naves.get(i));
				encontradas = true;
			}
		}
		/*For each
		for(NaveEspacial nav:naves) {
			if(nav.calcularAntiguedad(LocalDate.now().getYear())>=antiguedad) {
				System.out.println();
				encontradas= true;
			}
		}
		*/
		if (!encontradas) {
			System.out.println("No se encontraron naves con antigüedad superior a " + antiguedad);
		}
	}

	// Método para ordenar las naves por año de lanzamiento
	private static void ordenarNavesPorLanzamiento(ArrayList<NaveEspacial> naves) {
		NaveEspacial inter;
		
		System.out.println("************* NAVES ORDENADAS POR AÑO DE LANZAMIENTO ***************");
		//naves.sort(Comparator.comparingInt(NaveEspacial::getAnioLanzamiento).reversed());
		for (int i=0; i<naves.size();i++) {
			for(int j=i+1; j<naves.size();j++) {
				if(naves.get(j).getAnioLanzamiento()>naves.get(i).getAnioLanzamiento()) {
					inter = naves.get(j);
					naves.set(j, naves.get(i));
					naves.set(i, inter);
				}
			}
			System.out.println(naves.get(i));
		}
	}

	// Método para modificar la capacidad de las naves que admiten pasajeros
	private static void modificarCapacidadPasajeros(ArrayList<NaveEspacial> naves, Scanner scanner) {
	    boolean encontrado=false;
	    
		for (int i=0; i<naves.size(); i++) {
			if (naves.get(i).admitePasajeros()) {
				encontrado=true;
				System.out.println(naves.get(i));
				System.out.println("Desea cambiar la Capaciad Total de la nave?");
				if(scanner.next().equalsIgnoreCase("Si")) {
					naves.get(i).cambiarCapacidad();
				}	
			}
		}
		if(!encontrado) {
			System.out.println("No se ha encontrado ninguna nave que admita Pasajeros");
		}
	}
	// Método para mostrar todas las naves registradas
	private static void mostrarTodasNaves(ArrayList<NaveEspacial> naves) {
		System.out.println("*******************  NAVES DE LAS QUE DISPONEMOS ********************************************");
		for (int i=0; i<naves.size(); i++) {
            System.out.println(naves.get(i));
        }
	}
	 // Método para eliminar una nave
    private static void eliminarNave(ArrayList<NaveEspacial> naves, Scanner scanner) {
    	String nombre;

    	int posicionNave;
    	
        System.out.print("Introduce el nombre de la nave que deseas eliminar: ");
        nombre = scanner.nextLine();
        
        // Verificar que no se repite el nombre. Para ello buscamos la nave en el array
     	// y devolvemos su posición
     	posicionNave = buscarNavePorNombre(naves, nombre);
     	
            if (posicionNave!=-1) {
               naves.remove(posicionNave);
                System.out.println("Nave eliminada correctamente.");
            }else {
            	  System.out.println("No se encontró ninguna nave con ese nombre.");
            }
    }
}
