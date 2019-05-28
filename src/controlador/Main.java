/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Calculadora;
import vista.JFCalculadora;

/**
 *
 * @author user
 */
public class Main
{
    public static void main(String[] args)
    {
          Calculadora modelo = new Calculadora();
        JFCalculadora  vista = new JFCalculadora();
        vista.setVisible(true);
        Controlador controlador = new Controlador(modelo, vista);
    }
}
