package chat;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
* Client eines ganz einfachen Chats
*/
public class Client {

	/**
	* startet den Client
	* @param args wird nicht verwendet
	*/
	public static void main(String[] args) {
		Scanner tastatur = new Scanner(System.in);
		String serveradresse;
		Socket verbindung;
		String text;
		boolean connectionFailed;

		connectionFailed = false;

		do {
			System.out.println("Unter welcher IP-Adresse läuft der Server? ");
			serveradresse = tastatur.nextLine();
			try {
				verbindung = Chat.verbindungAufbauen(serveradresse, Server.ANMELDEPORT);
				connectionFailed = false;
			} catch (Exception e) {
				System.out.println("Failed to connect to the server, enter a correct address");
				connectionFailed = true;
				verbindung = null;
			}
		} while(connectionFailed);

		do {
			System.out.print("Client: ");
			text = tastatur.nextLine();
			try {
				Chat.senden(verbindung, text);
				if(!text.equals("END")) {
					text = Chat.empfangen(verbindung);
					System.out.println(text);
				}
			} catch (Exception e) {
				System.out.println("Failed to send message");
			}
		} while (!text.equals("END"));
		try {
			verbindung.close();
		} catch (IOException e) {
			System.out.println("I/O error when closing socket");
		}
	}
}
