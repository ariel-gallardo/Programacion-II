/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Calculadora;
import vista.JFCalculadora;

/**
 *
 * @author user
 */
public class Controlador implements ActionListener
{
    private   Calculadora modelo;
    private JFCalculadora vista;
    
    public Controlador(Calculadora modelo, JFCalculadora vista)
    {
        this.modelo = modelo;
         this.vista =  vista;
         
         vista.getjBRResultado().addActionListener(this);
         vista.getjBRBorrar().addActionListener(this);
         
         vista.getjB0().addActionListener(this);
         vista.getjB1().addActionListener(this);
         vista.getjB2().addActionListener(this);
         vista.getjB3().addActionListener(this);
         vista.getjB4().addActionListener(this);
         vista.getjB5().addActionListener(this);
         vista.getjB6().addActionListener(this);
         vista.getjB7().addActionListener(this);
         vista.getjB8().addActionListener(this);
         vista.getjB9().addActionListener(this);
         
         vista.getjBResto().addActionListener(this);
         
         vista.getjBDividir().addActionListener(this);
         vista.getjBMultiplicar().addActionListener(this);
         
         vista.getjBRestar().addActionListener(this);
         vista.getjBSumar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(Character.isDigit(e.getActionCommand().charAt(0)))
        {
            vista.getjTPantalla().setText(vista.getjTPantalla().getText() +
                    String.valueOf(
                            e.getActionCommand().charAt(0)));
        }
        else
        {
            switch(e.getActionCommand())
            {
                case "=":
                    if(modelo.verificar(vista.getjTPantalla().getText()))
                    {
                        vista.getjTPantalla()
                                    .setText( 
                                            String.valueOf( 
                                                    modelo.obtenerResultado() ));
                    }
                    else
                    {
                        modelo.vaciar();
                        vista.getjTPantalla().setText("");
                    }

                    break;
                case "AC":
                        modelo.vaciar();
                        vista.getjTPantalla().setText("");
                    break;
                default:
                        vista.getjTPantalla().setText(
                                vista.getjTPantalla().getText()
                                        + String.valueOf(e.getActionCommand()));
                    break;
            }
        }
    }
}
