/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Calculadora
{
    private ArrayList<Double> arrNumero;
    private ArrayList<Character> arrOperador;
    
    private final char orden[] = {'%','*','/','+','-'};
    
    public Calculadora()
    {
        arrNumero = new ArrayList<>();
        arrOperador = new ArrayList<>();
    }
    
    public String vaciar()
    {
        arrNumero.clear();
        arrOperador.clear();
        return "";
    }
     
    
    private void agregarNumero(double num)
    {
        arrNumero.add(num);
    }
    
    private void agregarOperador(char operador)
    {
        arrOperador.add(operador);
    }
    
    public boolean verificar(String operacion)
    {
        String num = "";

        for (int i = 0; i < operacion.length(); i++)
        {
            if(Character.isDigit(operacion.charAt(i)))
            {
                num += operacion.charAt(i);
                if(i == operacion.length()-1)
                {
                    agregarNumero(Double.parseDouble(num));
                    num = "";
                }
            }
            else if(operacion.charAt(i) == '%' ||
                    operacion.charAt(i) == '*' ||
                    operacion.charAt(i) == '/' ||
                    operacion.charAt(i) == '+' ||
                    operacion.charAt(i) == '-')
            {
                agregarOperador(operacion.charAt(i)); 
                agregarNumero(Double.parseDouble(num));
                num = "";
            }
            else
            {
                return false;
            }
            
        }
        return arrNumero.size() >= 2;
        
    }
    
    private double sumar(double b, double a)
    {
        return a+b;
    }
    
    private double restar(double b, double a)
    {
        return a-b;
    }
    
    private double multiplicar(double b, double a)
    {
        return a*b;
    }
    
    private double dividir(double b, double a)
    {
        return a/b;
    }
    
    private double resto(double b, double a)
    {
        return a%b;
    }
    
    public Double obtenerResultado()
    {
        if(arrNumero.size()>=2)
        {
            for (char c : orden)
            {
                for (int i = 0; i < arrOperador.size(); i++)
                {
                    if(arrOperador.get(i) == c)
                    {
                        int  anterior = (i==0 ? 0: i);
                        int siguiente = (i==0 ? 1: i+1);
                    
                        double   numA = arrNumero.get(anterior);
                        double   numB = arrNumero.get(siguiente);
                    
                        switch(arrOperador.get(i))
                        {
                            case '%':
                                arrNumero.set(anterior, resto(numA, numB));
                                break;
                            case '*':
                                arrNumero.set(anterior, multiplicar(numA, numB));              
                                break;
                            case '/':
                                arrNumero.set(anterior, dividir(numA, numB));
                                break;
                            case '+':
                                arrNumero.set(anterior, sumar(numA, numB));
                                break;
                            case '-':
                                arrNumero.set(anterior, restar(numA, numB));
                                break;
                        }
                    
                        arrNumero.remove(siguiente);
                        arrOperador.remove(i);
                    }
                }
            }
            
            return arrNumero.get(0);
        }
        return null;
    }
}
