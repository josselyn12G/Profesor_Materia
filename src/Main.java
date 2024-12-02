import javax.swing.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Materia materia = new Materia();
        Professor profesor = new Professor();
        while (true) {
            String menu = "Menú:\n"
                    + "1. Añadir Profesor\n"
                    + "2. Mostrar Profesores\n"
                    + "3. Mostrar Profesores por Materia\n"
                    + "4. Añadir Materia\n"
                    + "5. Ver Materias\n"
                    + "6. Salir\n"
                    + "Elija una opción:";

            int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "Menú Principal", JOptionPane.QUESTION_MESSAGE));

            switch (opcion) {
                case 1:
                    materia.addprofe(profesor);
                    break;
                case 2:
                    profesor.mostrarProfesores();
                    break;
                case 3:
                    profesor.mostrarProfesorPorMateria();
                    break;
                case 4:
                    materia.addMateria();
                    break;
                case 5:
                    materia.verMaterias();
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        }
    }
}