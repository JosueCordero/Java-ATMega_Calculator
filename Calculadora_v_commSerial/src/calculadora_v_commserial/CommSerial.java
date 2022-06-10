/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora_v_commserial;

import com.fazecast.jSerialComm.SerialPort;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author Josue Cordero
 */
public class CommSerial {
    SerialPort sp;   
    public CommSerial(String port){
        sp = SerialPort.getCommPort(port);
    }
    public void setconfiguration(){
        sp.setComPortParameters(1200, 8, 1, 0); // default connection settings for Arduino
        sp.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING , 20, 0); // block until bytes can be written
       // sp.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_SEMI_BLOCKING, 2000, 2000);
    }
    
    public void openPort(){
        if (sp.openPort()) {
          System.out.println("Port is open :)");
        } else {
          System.out.println("Failed to open port :(");
        }
    }
    
    public void closePort(){
        if (sp.closePort()) {
          System.out.println("Port is closed :)");
        } else {
          System.out.println("Failed to close port :(");
        }
    }
    
    public void sendString(String data)throws IOException, InterruptedException{
        for (int i = 0; i < data.length(); i++) {
            sp.getOutputStream().write(data.charAt(i));
            //TimeUnit.MILLISECONDS.sleep(500);
        }
         System.out.println("Data enviada");
    }
    
    public String reciveString()  throws IOException, InterruptedException{
        String recived;
        int nread;
        do{
           byte[] readbuffer = new byte[200];
           nread = sp.readBytes(readbuffer, readbuffer.length);        
           recived = new String(readbuffer);
   
        }while(nread==0);
        return recived;
    }
    

}
