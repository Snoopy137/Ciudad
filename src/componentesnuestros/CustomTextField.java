/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentesnuestros;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

/**
 *
 * @author AlanDec
 */
public class CustomTextField extends JTextField implements KeyListener {
    private Texto texto = Texto.NORMAL;
    private int largo = 0;
    public CustomTextField (){
        this.addKeyListener(this);
    }
    @Override
    public void keyTyped(KeyEvent e) {
        if (largo != 0) if (this.getText().length() == largo) e.consume();
        switch (texto){
                case SOLOLETRAMAYUSCULAS:
                    if (e.getKeyChar() != ' '){
                        if ((e.getKeyChar() < 'a' || e.getKeyChar() > 'z') && (e.getKeyChar() < 'A' || e.getKeyChar() >'Z'))e.consume();
                        else if (e.getKeyChar() < 'A' || e.getKeyChar() > 'Z') e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
                    }
                    break;
                case SOLOLETRAMINUSCULA:
                    if (e.getKeyChar() != ' '){
                        if ((e.getKeyChar() < 'a' || e.getKeyChar() > 'z') && (e.getKeyChar() < 'A' || e.getKeyChar() >'Z'))e.consume();
                        else if (e.getKeyChar() < 'a' || e.getKeyChar() > 'z') e.setKeyChar(Character.toLowerCase(e.getKeyChar()));
                    }
                    break;
                case SOLONUMERO:
                    if (e.getKeyChar() != ' ')if (e.getKeyChar() < '0' || e.getKeyChar() >'9') e.consume();
                    break;
                case LETRAMAYUSCULA:
                    if (e.getKeyChar() < 'A' || e.getKeyChar() > 'Z') e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
                    break;
                case LETRAMINUSCULA:
                    if (e.getKeyChar() < 'a' || e.getKeyChar() > 'z') e.setKeyChar(Character.toLowerCase(e.getKeyChar()));
                    break;
            }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    public enum Texto {
        NORMAL,
        LETRAMAYUSCULA,
        LETRAMINUSCULA,
        SOLONUMERO,
        SOLOLETRAMINUSCULA,
        SOLOLETRAMAYUSCULAS;
    }

    public Texto getTexto() {
        return texto;
    }

    public void setTexto(Texto texto) {
        this.texto = texto;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }
}
