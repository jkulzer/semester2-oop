package chat;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
* Server eines ganz einfachen Chats
*/
public class Server {
	/**
	* Port, unter dem der Server auf eingehenden Verbindungen wartet
	*/
	public static int ANMELDEPORT = 7777;
	
	/**
	* startet den Server
	* @param args wird nicht verwendet
	*/
	public static void main(String[] args)
	{
		Socket verbindung = Chat.aufEingehendeClientWarten(ANMELDEPORT);
		String text;
		Scanner tastatur = new Scanner(System.in);
		tastatur.useDelimiter(System.lineSeparator());
		
		do 
		{
			text = Chat.empfangen(verbindung);
			System.out.println(text);
			if(!text.equals("END"))
			{
				System.out.println("Server: ");
				text = tastatur.nextLine();
				Chat.senden(verbindung, text);
			}
		} while (!text.equals("END"));
		try {
			verbindung.close();
		} catch (IOException e) {
			System.out.println("I/O error when closing socket");
		}
	}

}
