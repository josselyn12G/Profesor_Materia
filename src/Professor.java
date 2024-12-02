import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Professor {
    private String nombreProfesor;
    private String idProfesor;
    private String materia;
    private String codigoMateria;
    private List<Professor> profesores = new ArrayList<>();

    public Professor(){

    }

    public Professor(String nombreProfesor, String idProfesor, String materia, String codigoMateria) {
        this.nombreProfesor = nombreProfesor;
        this.idProfesor = idProfesor;
        this.materia = materia;
        this.codigoMateria = codigoMateria;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public String getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(String codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    public void addProfesor(List<Materia> materias) {
        if (materias.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay materias disponibles. Por favor, añádalas primero.");
            return;
        }

        // Pedir datos del profesor
        String nombre = JOptionPane.showInputDialog(null, "Nombre del profesor:");
        String codigo = JOptionPane.showInputDialog(null, "Código del profesor:");

        // Construir el menú de materias para mostrarlo directamente
        String menuMaterias = "Seleccione una materia:\n";
        for (int i = 0; i < materias.size(); i++) {
            menuMaterias += (i + 1) + ". " + materias.get(i).getNombreMateria() + " ("
                    + materias.get(i).getCodigoMateria() + ")\n";
        }

        // Mostrar menú y obtener la elección
        String seleccion = JOptionPane.showInputDialog(null, menuMaterias);
        int opcion;
        try {
            opcion = Integer.parseInt(seleccion) - 1;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Selección inválida. Intente nuevamente.");
            return;
        }

        // Validar selección
        if (opcion < 0 || opcion >= materias.size()) {
            JOptionPane.showMessageDialog(null, "Opción no válida. Intente nuevamente.");
            return;
        }

        // Obtener la materia seleccionada
        Materia materiaSeleccionada = materias.get(opcion);

        // Crear objeto de tipo Professor
        Professor profesor = new Professor(nombre, codigo, materiaSeleccionada.getNombreMateria(), materiaSeleccionada.getCodigoMateria());

        // Agregar a la lista de profesores
        profesores.add(profesor);
        JOptionPane.showMessageDialog(null, "Profesor agregado exitosamente.");
    }
    public void mostrarProfesores() {
        if (profesores.isEmpty()) {
            System.out.println("No hay profesores registrados.");
            return;
        }

        // Encabezados de la tabla
        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-20s | %-10s | %-20s | %-10s\n",
                "Nombre del Profesor", "ID", "Materia", "Código Materia");
        System.out.println("---------------------------------------------------------------");

        // Contenido de la tabla
        for (Professor profesor : profesores) {
            System.out.printf("%-20s | %-10s | %-20s | %-10s\n",
                    profesor.nombreProfesor,
                    profesor.idProfesor,
                    profesor.materia,
                    profesor.codigoMateria);
        }
        System.out.println("---------------------------------------------------------------");
    }

    public void mostrarProfesorPorMateria() {
        if (profesores.isEmpty()) {
            System.out.println("No hay profesores registrados.");
            return;
        }

        // Pedir el ID de la materia
        String idMateria = JOptionPane.showInputDialog(null, "Ingrese el ID de la materia:");

        // Filtrar y mostrar los profesores que imparten esa materia
        boolean encontrado = false;
        System.out.println("---------------------------------------------------");
        System.out.printf("%-20s | %-10s\n", "Nombre del Profesor", "ID");
        System.out.println("---------------------------------------------------");

        for (Professor profesor : profesores) {
            if (profesor.codigoMateria.equalsIgnoreCase(idMateria)) {
                System.out.printf("%-20s | %-10s\n",
                        profesor.nombreProfesor,
                        profesor.idProfesor);
                encontrado = true;
            }
        }

        System.out.println("---------------------------------------------------");

        if (!encontrado) {
            System.out.println("No se encontraron profesores para la materia con ID: " + idMateria);
        }
    }



}
