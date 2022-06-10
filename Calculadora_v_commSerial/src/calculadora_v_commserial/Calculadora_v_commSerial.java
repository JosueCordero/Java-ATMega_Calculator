/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadora_v_commserial;

/**
 *
 * @author Josue Cordero
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.lang.NumberFormatException;

//import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Calculadora_v_commSerial extends JFrame implements ActionListener {
    CommSerial serial = new CommSerial("COM4");
    String dataSend;
    String n1,n2; int ban,ban3=0,cban=2;int aux=1,aux2=1; boolean ban2=false,borrar=false;public int r=0,wait=0; 
    public JButton boton1,boton2,boton3,boton4,boton5,boton6,boton7,boton8,boton9,boton10,boton11,boton12,boton13,boton14,boton15,boton17,boton16,boton18;
    public JTextField text1;
    public int x = 300;
    public int y = (x*9)/8;
    
    public Calculadora_v_commSerial(String tittle){
        setLayout(null);
        setTitle(tittle);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(244,244,244));
        Font fuente = new Font("Arial Unicode MS",Font.PLAIN,20);
        //Buttons
       
        boton1 = new JButton("1"); boton1.setBounds(0,(y*2)/6,x/4,y/6); add(boton1);
        boton1.addActionListener(this); boton1.setBackground(new Color(255,255,255)); boton1.setFont(fuente);
        boton2 = new JButton("2"); boton2.setBounds(x/4,(y*2)/6,x/4,y/6); add(boton2);
        boton2.addActionListener(this); boton2.setBackground(new Color(255,255,255)); boton2.setFont(fuente);
        boton3 = new JButton("3"); boton3.setBounds((x*2)/4,(y*2)/6,x/4,y/6); add(boton3);
        boton3.addActionListener(this); boton3.setBackground(new Color(255,255,255));boton3.setFont(fuente);
        boton4 = new JButton("4"); boton4.setBounds(0,(y*3)/6,x/4,y/6); add(boton4);
        boton4.addActionListener(this); boton4.setBackground(new Color(255,255,255));boton4.setFont(fuente);
        boton5 = new JButton("5"); boton5.setBounds((x)/4,(y*3)/6,x/4,y/6); add(boton5);
        boton5.addActionListener(this); boton5.setBackground(new Color(255,255,255));boton5.setFont(fuente);
        boton6 = new JButton("6"); boton6.setBounds((x*2)/4,(y*3)/6,x/4,y/6); add(boton6);
        boton6.addActionListener(this); boton6.setBackground(new Color(255,255,255));boton6.setFont(fuente);
        boton7 = new JButton("7"); boton7.setBounds(0,(y*4)/6,x/4,y/6); add(boton7);
        boton7.addActionListener(this); boton7.setBackground(new Color(255,255,255));boton7.setFont(fuente);
        boton8 = new JButton("8"); boton8.setBounds((x)/4,(y*4)/6,x/4,y/6); add(boton8);
        boton8.addActionListener(this);boton8.setBackground(new Color(255,255,255));boton8.setFont(fuente);
        boton9 = new JButton("9"); boton9.setBounds((x*2)/4,(y*4)/6,x/4,y/6); add(boton9);
        boton9.addActionListener(this);boton9.setBackground(new Color(255,255,255));boton9.setFont(fuente);
        boton10 = new JButton("0"); boton10.setBounds(x/4,(y*5)/6,x/4,y/6); add(boton10);
        boton10.addActionListener(this);boton10.setBackground(new Color(255,255,255));boton10.setFont(fuente);
        boton11 = new JButton("."); boton11.setBounds(0,(y*5)/6,x/4,y/6); add(boton11);
        boton11.addActionListener(this);boton11.setBackground(new Color(255,255,255));boton11.setFont(fuente);
        boton12 = new JButton("="); boton12.setBounds((x*2)/4,(y*5)/6,x/4,y/6); add(boton12);
        boton12.addActionListener(this);boton12.setBackground(new Color(153,204,255));boton12.setFont(fuente);
        boton13 = new JButton("/"); boton13.setBounds((x*3)/4,(y*2)/6,x/4,y/6); add(boton13);
        boton13.addActionListener(this);boton13.setBackground(new Color(220,220,220));boton13.setFont(fuente);
        boton14 = new JButton("*"); boton14.setBounds((x*3)/4,(y*3)/6,x/4,y/6); add(boton14);
        boton14.addActionListener(this);boton14.setBackground(new Color(220,220,220));boton14.setFont(fuente);
        boton15 = new JButton("-"); boton15.setBounds((x*3)/4,(y*4)/6,x/4,y/6); add(boton15);
        boton15.addActionListener(this);boton15.setBackground(new Color(220,220,220));boton15.setFont(fuente);
        boton16 = new JButton("+"); boton16.setBounds((x*3)/4,(y*5)/6,x/4,y/6); add(boton16);
        boton16.addActionListener(this); boton16.setBackground(new Color(220,220,220));boton16.setFont(fuente);
        ImageIcon imagen = new ImageIcon("backspace-128.png");
        boton17 = new JButton(imagen); Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(x/(4*4), y/(6*3), Image.SCALE_DEFAULT));
        boton17.setIcon(icono);
        boton17.setBounds((x*3)/4,(y)/6,x/4,y/6); add(boton17);
        boton17.addActionListener(this);boton17.setBackground(new Color(220,220,220));boton17.setFont(fuente);
        
        
        boton18 = new JButton("CE"); boton18.setBounds((x*3)/4,0,x/4,y/6); add(boton18);
        boton18.addActionListener(this);boton18.setBackground(new Color(220,220,220));boton18.setFont(fuente);
        text1 = new JTextField();text1.setBounds(0,0,(x*3)/4,(y*2)/6); add(text1); text1.setFont(fuente);
        
        serial.setconfiguration();
        serial.openPort();
        
    }
    public void operations(int ban){
        
        try{
            if(ban==1){
                if(aux==1) {
                    n1 = text1.getText();
                text1.setText(n1);
            }
            if(wait==0){
                if((aux==2&&r==0)){
                    n2 = text1.getText();
                    dataSend = n1 + " " + n2 + " 1D";
                    serial.sendString(dataSend);
                    n1 = serial.reciveString();
                    n1 = n1.trim();
                    text1.setText(n1);
                }}
            } 
            if(ban==2){
                if(aux==1) {
                    n1 = text1.getText();
                text1.setText(n1);
            }
            if(wait==0){
                if((aux==2&&r==0)){
                    n2 = text1.getText();
                    dataSend = n1 + " " + n2 + " 2D";
                    serial.sendString(dataSend);
                    n1 = serial.reciveString();
                    n1 = n1.trim();
                    text1.setText(n1);
                }}
            } 
            if(ban==3) {
                if(aux==1) {
                    n1 = text1.getText();
                text1.setText(n1);
            }
            if(wait==0){
                if((aux==2&&r==0)){
                    n2 = text1.getText();
                    dataSend = n1 + " " + n2 + " 3D";
                    serial.sendString(dataSend);
                    n1 = serial.reciveString();
                    n1 = n1.trim();
                    text1.setText(n1);
                }}
            } 
            if(ban==4){
                if(aux==1) {
                    n1 = text1.getText();
                text1.setText(n1);
            }
            if(wait==0){
                if((aux==2&&r==0)){
                    n2 = text1.getText();
                    dataSend = n1 + " " + n2 + " 4D";
                    serial.sendString(dataSend);
                    n1 = serial.reciveString();
                    n1 = n1.trim();
                    text1.setText(n1);
                }}
            } 

            aux=2; 
            cban = 1;
            ban2 = true;
            r=0;
        }
        catch (InterruptedException | IOException error){
            System.out.println(error);
        }
    }
    

    public void actionPerformed(ActionEvent accion){   
        
        try{
            if(ban2==true){
                text1.setText(""); ban2=false;
        }
            
            if(accion.getSource()==boton1) {
                text1.setText(text1.getText()+"1");wait=0;cban=2;
            }
                
            if(accion.getSource()==boton2){
                text1.setText(text1.getText()+"2");wait=0;cban=2;
            }
                
            if(accion.getSource()==boton3) 
            {text1.setText(text1.getText()+"3");wait=0;cban=2;}
                
            if(accion.getSource()==boton4) 
            {text1.setText(text1.getText()+"4");wait=0;cban=2;}
                
            if(accion.getSource()==boton5) 
            {text1.setText(text1.getText()+"5");wait=0;cban=2;}
                
            if(accion.getSource()==boton6) 
            {text1.setText(text1.getText()+"6");wait=0;cban=2;}
                
            if(accion.getSource()==boton7) 
            {text1.setText(text1.getText()+"7");wait=0;cban=2;}
                
            if(accion.getSource()==boton8) 
            {text1.setText(text1.getText()+"8");wait=0;cban=2;}
                
            if(accion.getSource()==boton9) 
            {text1.setText(text1.getText()+"9");wait=0;cban=2;}
                
            if(accion.getSource()==boton10) 
            {text1.setText(text1.getText()+"0");wait=0;cban=2;}
                
            if(accion.getSource()==boton11) 
            {text1.setText(text1.getText()+".");wait=0;cban=2;}
                
            if(accion.getSource()==boton12) {
                
                if(r==0){
                operations(ban); r=1; ban2 = false;cban=3;
            }
                
            }
                
            if(accion.getSource()==boton13) {
                //divicion
                if(aux2==1) {
                    ban = 4;
                    System.out.println("Entre a division");
                }
                operations(ban);
                ban=4; aux2 = 0;
            }
                
                
            if(accion.getSource()==boton14){
                //multiplicacion
                if(aux2==1) {
                    ban = 3;
                    System.out.println("Entre a Multiplicacion");
                }
                operations(ban);
                ban=3; aux2 = 0;
                
            }
                
                
            if(accion.getSource()==boton15){
                //resta
                if(aux2==1) {
                    ban = 2;
                    System.out.println("Entre a resta");
                }
                operations(ban);
                ban=2;aux2=0;
                
            }
                
                
            if(accion.getSource()==boton16){
                //Suma
                if(aux2==1) {
                    ban = 1;
                    System.out.println("Entre a suma");
                }
                operations(ban);
                ban=1; aux2 = 0;
            
               
                
                }
            
            if(accion.getSource()==boton17){
                System.out.println("Entre a borrar un digito");
                if(cban!=3){String cadena = text1.getText();
                if(cadena.length()>0){
                    String auxCadena = cadena.substring(0,cadena.length()-1);
                    text1.setText(auxCadena);
                    if(cadena.length()==1){
                        wait=1;
                        ban3=1;
                    }
                    else{
                        n2=auxCadena;
                    }
                    
                }
            }else borrar=true;
            }//Borrar un Caracter
            if(accion.getSource()==boton18 || borrar){
                System.out.println("Estre a borrar todo");
                text1.setText("");
                n1= "0";
                n2= "0";
                aux=1;
                aux2 = 1;
                borrar=false;
            }//Borrar todo
            }
            catch(NumberFormatException error){
                System.out.println("Esperando a que el usuario Ingrese otro numero");
                /*if(ban3==1){
                    n1= 0.0;
                    n2= 0.0;
                    ban3=0;
                }
                else{
                text1.setText(Double.toString(n1));}*/ wait=1;
            


            }
            finally{
             if(ban3==0){ 
                if(wait==1) text1.setText(n1);
            }
            ban3=0; 
            }
            
        }
    
    public static void main(String[] args) throws IOException, InterruptedException{
        Calculadora_v_commSerial ceti = new Calculadora_v_commSerial("Calculadora");
        ceti.setBounds(960,540,ceti.x+16,ceti.y+45);
        ceti.setVisible(true);
    }
}