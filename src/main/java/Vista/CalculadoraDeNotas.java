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
    }
}