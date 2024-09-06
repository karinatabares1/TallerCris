
import java.util.ArrayList;
import java.util.Arrays;
public class Principal {
  public static void main(String[] args) {
        class Estudiante {
            String nombre;
            ArrayList<Double> notas;
            double promedio;

            Estudiante(String nombre, Double... notas) {
                this.nombre = nombre;
                this.notas = new ArrayList<>(Arrays.asList(notas));
                calcularPromedio();
            }

            void calcularPromedio() {
                this.promedio = notas.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
            }
        }

        ArrayList<Estudiante> estudiantes = new ArrayList<>();

        
        estudiantes.add(new Estudiante("Juan", 3.5, 4.0, 3.8));
        estudiantes.add(new Estudiante("María", 4.2, 3.9, 4.5));
        estudiantes.add(new Estudiante("Carlos", 2.8, 3.1, 2.9));
        estudiantes.add(new Estudiante("Ana", 4.8, 4.9, 4.7));
        estudiantes.add(new Estudiante("Pedro", 1.5, 2.0, 1.8));

        System.out.println("Cantidad total de estudiantes: " + estudiantes.size());
        System.out.println("Cantidad total de notas ingresadas: " + (estudiantes.size() * 3));

        int ganan = 0, pierden = 0, recuperan = 0, pierdenSinRecuperacion = 0;
        double sumaPromedios = 0;

        for (Estudiante estudiante : estudiantes) {
            if (estudiante.promedio >= 3.5) {
                ganan++;
            } else {
                pierden++;
                if (estudiante.promedio > 2) {
                    recuperan++;
                } else {
                    pierdenSinRecuperacion++;
                }
            }
            sumaPromedios += estudiante.promedio;
        }

        System.out.println("Cantidad de estudiantes que ganan la materia: " + ganan);
        System.out.println("Cantidad de estudiantes que pierden la materia: " + pierden);
        System.out.println("Cantidad de estudiantes que pueden recuperar: " + recuperan);
        System.out.println("Cantidad de estudiantes que pierden sin recuperación: " + pierdenSinRecuperacion);
        System.out.println("Promedio de las notas finales obtenidas: " + (sumaPromedios / estudiantes.size()));

        System.out.println("\nListado de estudiantes y sus notas finales:");
        for (Estudiante estudiante : estudiantes) {
            System.out.printf("%s: %.2f%n", estudiante.nombre, estudiante.promedio);
        }
    }
}


  
