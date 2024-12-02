package clase;

	import java.util.Scanner;

	public class NaveEspacial {
		private String nombre;
		private int anioCreacion;
		private int anioLanzamiento;
		private int capacidadTotal;
		private int tripulantesNecesarios;

		Scanner scanner = new Scanner(System.in);

		// Constructor con parámetros
		public NaveEspacial(String nombre, int anioCreacion, int anioLanzamiento, int capacidadTotal,
				int tripulantesNecesarios) {
			this.nombre = nombre;
			this.anioCreacion = anioCreacion;
			this.anioLanzamiento = anioLanzamiento;
			this.capacidadTotal = capacidadTotal;
			this.tripulantesNecesarios = tripulantesNecesarios;
		}

		// Constructor sin parámetros
		public NaveEspacial() {
			this.nombre = "";
			this.anioCreacion = 0;
			this.anioLanzamiento = 0;
			this.capacidadTotal = 0;
			this.tripulantesNecesarios = 0;
		}

		// Métodos get y set
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public int getAnioCreacion() {
			return anioCreacion;
		}

		public void setAnioCreacion(int anioCreacion) {
			this.anioCreacion = anioCreacion;
		}

		public int getAnioLanzamiento() {
			return anioLanzamiento;
		}

		public void setAnioLanzamiento(int anioLanzamiento) {
			this.anioLanzamiento = anioLanzamiento;
		}

		public int getCapacidadTotal() {
			return capacidadTotal;
		}

		public void setCapacidadTotal(int capacidadTotal) {
			this.capacidadTotal = capacidadTotal;
		}

		public int getTripulantesNecesarios() {
			return tripulantesNecesarios;
		}

		public void setTripulantesNecesarios(int tripulantesNecesarios) {
			this.tripulantesNecesarios = tripulantesNecesarios;
		}

		// Método toString
		@Override
		public String toString() {
			return "Nave Espacial: " + nombre + ", Año de Creación: " + anioCreacion + ", Año de Lanzamiento: "
					+ anioLanzamiento + ", Capacidad Total: " + capacidadTotal + ", Tripulantes Necesarios: "
					+ tripulantesNecesarios;
		}

		// Método para calcular la antigüedad de la nave
		public int calcularAntiguedad(int anioActual) {
			return anioActual - anioCreacion;
		}

		// Método para verificar si la nave admite pasajeros
		public boolean admitePasajeros() {
			return capacidadTotal > tripulantesNecesarios;
		}

		public void setDatos(String nombre) {
			this.nombre = nombre;

			System.out.print("Introduce el año de creación: ");
			anioCreacion = scanner.nextInt();

			do {
				System.out.print("Introduce el año de lanzamiento: ");
				anioLanzamiento = scanner.nextInt();

				if (anioLanzamiento < anioCreacion) {
					System.out.println("Error: El año de lanzamiento no puede ser anterior al año de creación.");

				}
			} while (anioLanzamiento < anioCreacion);

			System.out.print("Introduce la capacidad total de personas: ");
			capacidadTotal = scanner.nextInt();

			System.out.print("Introduce el número de tripulantes necesarios: ");
			tripulantesNecesarios = scanner.nextInt();
			scanner.nextLine(); // Limpiar el buffer del scanner

		}

		public void cambiarCapacidad() {
			int nuevaCapacidad;
			
			System.out.print("Introduce la nueva capacidad para la nave " + nombre + ": ");
			nuevaCapacidad = scanner.nextInt();

			if (nuevaCapacidad <tripulantesNecesarios) {
				System.out.println(
				"Error: La nueva capacidad no puede ser menor que el número de tripulantes necesarios.");
			} else {
				capacidadTotal=nuevaCapacidad;
				System.out.println("Capacidad modificada exitosamente.");
			}	
		}
	}


