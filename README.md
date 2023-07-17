<h1 align="center"> Java-ATMega_Calculator </h1>

<p align="center">
  <img src="https://img.shields.io/badge/Frontend-Java-orange"/> 
  <img src="https://img.shields.io/badge/Backend-C%20(Atmel%20Studio)-blue" />
  <img src="https://img.shields.io/badge/Microcontroller-Atmega328p-53e9dc" />
</p>

## Project Description

This project consists of a Java-based graphical user interface (GUI) calculator that communicates through the serial port with USB-TTL to the Atmega328P microcontroller. The calculator performs mathematical operations on the microcontroller and then returns the results to the Java GUI.

![JAVA-Atmega328P](https://github.com/JosueCordero/Java-ATMega_Calculator/assets/97249861/006febfd-be38-4b54-97a9-93875903182f)

---
Explaining code and demonstration video (In Spanish):

<p align="center">
  <a href="https://youtu.be/SWOTswg0R6U">
    <img src="https://markdown-videos.vercel.app/youtube/SWOTswg0R6U" alt="Explaining video (Spanish)" />
  </a>  
</p>

The exact moment of the demostration is at [14:03](https://youtu.be/SWOTswg0R6U?t=843)

---

In this repository, you will find the source code and the necessary JSerialComm library to compile and run the calculator. 

## General Instructions

1. Open a new project in NetBeans with the files under the ![src folder](https://github.com/JosueCordero/Java-ATMega_Calculator/tree/main/Calculadora_v_commSerial/src/calculadora_v_commserial) and also, add the serial communication  library under the ![Libreria folder](https://github.com/JosueCordero/Java-ATMega_Calculator/tree/main/Calculadora_v_commSerial/Librerias).
2. Configure the serial communication with the microcontroller (Use a USB-TTL device and search for its drivers)
3. Upload the program to the microcontroller using Atmel Studio.
4. Run the application in NetBeans and enjoy the real-time

