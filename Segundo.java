import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
public class Segundo {
	 public static void main(String[] args) {
	        HashMap<String, ArrayList<Double>> estudiantes = new HashMap<>();
	        HashMap<String, Double> promedios = new HashMap<>();

	        
	        estudiantes.put("Juan", new ArrayList<>(Arrays.asList(3.5, 4.0, 3.8)));
	        estudiantes.put("María", new ArrayList<>(Arrays.asList(4.2, 3.9, 4.5)));
	        estudiantes.put("Carlos", new ArrayList<>(Arrays.asList(2.8, 3.1, 2.9)));
	        estudiantes.put("Ana", new ArrayList<>(Arrays.asList(4.8, 4.9, 4.7)));
	        estudiantes.put("Pedro", new ArrayList<>(Arrays.asList(1.5, 2.0, 1.8)));

	 
	        for (String nombre : estudiantes.keySet()) {
	            ArrayList<Double> notas = estudiantes.get(nombre);
	            double promedio = notas.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
	            promedios.put(nombre, promedio);
	        }

	        System.out.println("Cantidad total de estudiantes: " + estudiantes.size());
	        System.out.println("Cantidad total de notas ingresadas: " + (estudiantes.size() * 3));

	        int ganan = 0, pierden = 0, recuperan = 0, pierdenSinRecuperacion = 0;
	        double sumaPromedios = 0;

	        for (Double promedio : promedios.values()) {
	            if (promedio >= 3.5) {
	                ganan++;
	            } else {
	                pierden++;
	                if (promedio > 2) {
	                    recuperan++;
	                } else {
	                    pierdenSinRecuperacion++;
	                }
	            }
	            sumaPromedios += promedio;
	        }

	        System.out.println("Cantidad de estudiantes que ganan la materia: " + ganan);
	        System.out.println("Cantidad de estudiantes que pierden la materia: " + pierden);
	        System.out.println("Cantidad de estudiantes que pueden recuperar: " + recuperan);
	        System.out.println("Cantidad de estudiantes que pierden sin recuperación: " + pierdenSinRecuperacion);
	        System.out.println("Promedio de las notas finales obtenidas: " + (sumaPromedios / promedios.size()));

	        System.out.println("\nListado de estudiantes y sus notas finales:");
	        for (String nombre : promedios.keySet()) {
	            System.out.printf("%s: %.2f%n", nombre, promedios.get(nombre));
	        }
	    }
}

