import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Materia {
    private String nombreMateria;
    private String codigoMateria;
    private List<Materia> materias = new ArrayList<>();

    public Materia(){

    }

    public Materia(String nombreMateria, String codigoMateria) {
        this.nombreMateria = nombreMateria;
        this.codigoMateria = codigoMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public String getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(String codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    public Materia crearMateria(){
        String n = JOptionPane.showInputDialog(null,"Nombre de la materia");
        String c = JOptionPane.showInputDialog(null,"Código de la materia");
        return new Materia(n,c);
    }
    public void addMateria(){
        Materia m1 = crearMateria();
        if(!materias.contains(m1)){
            materias.add(m1);
        }else{
            JOptionPane.showMessageDialog(null,"Materia ya en la lista!");
        }

    }
    public void verMaterias() {
        System.out.println("----------------------------------------------------");
        System.out.printf("%-20s | %-10s\n", "Nombre de la Materia", "Código");
        System.out.println("----------------------------------------------------");
        for (Materia m : materias) {
            System.out.printf("%-20s | %-10s\n", m.getNombreMateria(), m.getCodigoMateria());
        }
        System.out.println("----------------------------------------------------");
    }
    public void addprofe(Professor profesor){
        profesor.addProfesor(materias);
    }

}
