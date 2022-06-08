/*
 * Tarea4_Atmega328p.c
 *
 * Created: 07/06/2022 01:04:11 a. m.
 * Author : Josue Cordero
 */ 

#define F_CPU 1000000
#define BAUD 1200
#define BRC ((F_CPU/(16*BAUD))-1)
#define MAXIMA_LONGITUD_BUFFER 40

#include <stdlib.h>
#include <string.h>
#include <avr/interrupt.h>
#include <avr/io.h>
#include <util/delay.h>
#include <stdio.h>

void regiterSerial(int dato);
void nextLine();
void writeSerial(char *str,char next);

char buffer[MAXIMA_LONGITUD_BUFFER];
char bufferAux[MAXIMA_LONGITUD_BUFFER];
char sendData[MAXIMA_LONGITUD_BUFFER];
char work = '0';
int opc = 0;
int pos=0;
float digit1 = 0, digit2 = 0;

int main(void)
{
	DDRB = (1<<PORTB0);
    UBRR0H = (BRC>>8);
    UBRR0L = BRC;
    UCSR0B = (1<<TXEN0) | (1<<RXEN0) | (1<<RXCIE0);
    UCSR0C = (1<<UCSZ01) | (1<<UCSZ00);
    
    
	
	memset(buffer, 0, MAXIMA_LONGITUD_BUFFER);
	memset(bufferAux, 0, MAXIMA_LONGITUD_BUFFER); //Limpio el buffer
	sei();
	
	//writeSerial("Inicia la calculadora",'T');
    while (1) 
    {
		//_delay_ms(30);
		//writeSerial(sendData,'T');
		//writeSerial(buffer,'T');
		if (work == '1'){
			PORTB = 0x01;
			//writeSerial("Entro a operacion",'T');
			char separador[] = " ";
			strcpy(bufferAux,buffer);
			char *token = strtok(bufferAux,separador);
			if(token != NULL){
				
				digit1 = atof(token);
				token =strtok(NULL,separador);
				digit2 = atof(token);
				token = strtok(NULL,separador);
				opc = atoi(token);
				
				if(opc == 1){
					//char temp[MAXIMA_LONGITUD_BUFFER]; 
					//memset(temp,0,MAXIMA_LONGITUD_BUFFER);
					//writeSerial("Entro a suma",'T');
					digit1 = digit1 + digit2; 
				}
				if(opc == 2){
					digit1 -= digit2; 
				}
				if(opc == 3){
					digit1 *= digit2; 
				}
				if(opc == 4){
					digit1 /= digit2; 
				}
				
				sprintf(sendData,"Resultado: %.2f",digit1);
				writeSerial(sendData,'T');
				work='0';
				pos = 0;
			}
		}
    }
}

void regiterSerial(int dato){
	UDR0 = dato;
	_delay_ms(30);
}

void nextLine(){
	regiterSerial(10);
	regiterSerial(13);
}

void writeSerial(char *str,char next){
	while(*str) regiterSerial(*str++);
	if (next == 'T'){
		nextLine();
	}
	
}

ISR(USART_RX_vect){
	PORTB = 0x01;
	buffer[pos] = UDR0;
	
	if(buffer[pos]=='D'){
			PORTB = 0x00;
			//writeSerial("Detecto la D",'T');
			//writeSerial(buffer,'T');
			buffer[pos]= ' ';
			//writeSerial(buffer,'T');
			work = '1';
			//writeSerial(&work,'T');
			
	}
	else{
		pos++;
	}
		
	
}

