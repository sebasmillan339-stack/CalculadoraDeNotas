/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package vista;
import logica.Calculadora;
import javax.swing.JOptionPane;

public class CalculadoraDeNotas {

    public static void main(String[] args) {

        int numeroEstudiantes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de estudiantes: "));
        Calculadora[] estudiantes = new Calculadora[numeroEstudiantes];

        for (int i = 0; i < numeroEstudiantes; i++) {
            String nombre = JOptionPane.showInputDialog("Estudiante " + (i + 1) + "\nIngrese su Nombre");
            String id = JOptionPane.showInputDialog("Estudiante " + (i + 1) + "\nIngrese su id");
            double notaDesarrollo = Double.parseDouble(JOptionPane.showInputDialog("digite la nota de Desarrollo"));
            double notaMatematica = Double.parseDouble(JOptionPane.showInputDialog("digite la nota de Matemáticas"));

            estudiantes[i] = new Calculadora(id, nombre, notaDesarrollo, notaMatematica);
            estudiantes[i].calcularDefinitiva();
        }

        for (int i = 0; i < numeroEstudiantes; i++) {
            estudiantes[i].mostrarNota();
            if (estudiantes[i].getDefinitiva() < 3.5) {
                JOptionPane.showMessageDialog(null, "REPROBADO");
            } else {
                JOptionPane.showMessageDialog(null, "APROBADO");
            }
        }

        double notaLimite = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota límite (0.0 a 4.9): "));
        while (notaLimite < 0.0 || notaLimite > 4.9) {
            notaLimite = Double.parseDouble(JOptionPane.showInputDialog("Valor inválido. Ingrese la nota límite (0.0 a 4.9): "));
        }
        mostrarSuperioresALimite(estudiantes, notaLimite);
    }

    public static void mostrarSuperioresALimite(Calculadora[] estudiantes, double notaLimite) {
        String mensaje = "Estudiantes con definitiva superior a " + notaLimite + ":\n";
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i].getDefinitiva() > notaLimite) {
                mensaje += "Id: " + estudiantes[i].getId()
                        + "  Nombre: " + estudiantes[i].getNombre()
                        + "  Definitiva: " + estudiantes[i].getDefinitiva() + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }
}