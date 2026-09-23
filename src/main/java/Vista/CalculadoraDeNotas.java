/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package vista;
import logica.Calculadora;
import javax.swing.JOptionPane;

public class CalculadoraDeNotas {

    public static void main(String[] args) {
        String nombre = JOptionPane.showInputDialog("Ingrese su Nombre");
        String id = JOptionPane.showInputDialog("Ingrese su id");
        double notaDesarrollo = Double.parseDouble(JOptionPane.showInputDialog("digite la nota de Desarrollo"));
        double notaMatematica = Double.parseDouble(JOptionPane.showInputDialog("digite la nota de Matemáticas"));

        Calculadora estudiante = new Calculadora(id, nombre, notaDesarrollo, notaMatematica);
        estudiante.calcularDefinitiva();
        estudiante.mostrarNota();

        if (estudiante.getDefinitiva() < 3.5) {
            JOptionPane.showMessageDialog(null, "REPROBADO");
        } else {
            JOptionPane.showMessageDialog(null, "APROBADO");
        }
    }
}