package chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
* Client für einen ganz einfachen Chat
*/
public class Chat {
	
	/**
	* baut die Verbindung vom Client zum Server an der angegebenen Adresse auf
	* @param ip IP-Adresse des Servers
	* @param port die Portnummer des Servers
	* @return das Verbindungsobjekt zum Server
	*/
	public static Socket verbindungAufbauen(String ip, int port) throws IOException {
		InetAddress ipAdresse;
		Socket so = null;
		try {
			ipAdresse = InetAddress.getByName(ip);
			so = new Socket(ipAdresse, port);
		} catch (Exception e) {
			System.out.println("Failed to get IP Address");
			throw e;
		}
		return so;
	}
	
	/**
	 * wartet am angegebenen Port auf eingehende Verbindungsanfragen
	 * @param port die Portnummer, an der gewartet wird
	 * @return die Verbindung zum anfragenden Client
	 */
	public static Socket aufEingehendeClientWarten(int port) {
		ServerSocket seso = null;
		Socket so = null;
		try {
			seso = new ServerSocket(port);
		} catch (Exception e) {
			System.out.println("Failed to open server socket");
		}
		try {
			so = seso.accept();
		} catch (Exception e) {
			System.out.println("Failed to accept connection on listening server socket");
			e.printStackTrace();
		}
		return so;
	}
	
	/**
	 * sendet die Nachricht durch den übergebenen Socket
	 * @param verbindung das Verbindungsobjekt
	 * @param nachricht die zu sendende Nachricht
	 */
	public static void senden(Socket verbindung, String nachricht) {
		OutputStream aus;
		try {
			aus = verbindung.getOutputStream();
		} catch (IOException e) {
			System.out.println("I/O error when creating the output stream for socket");
			aus = null;
		}
		BufferedWriter bAus = new BufferedWriter(new OutputStreamWriter(aus));
		try {

		bAus.write(nachricht);
		bAus.newLine();
		bAus.flush();
		} catch (IOException e) {
			System.out.println("I/O error: Failed to write message");
		}
	}
	
	/**
	 * wartet auf eine auf dem Verbindungsobjekt eingehende Nachricht
	 * @param verbindung
	 * @return die empfangene Nachricht
	 */
	public static String empfangen(Socket verbindung) {
		String nachricht;
		InputStream ein;

		try {
			ein = verbindung.getInputStream();
		} catch (IOException e) {
			System.out.println("Failed to get input stream for socket");
			ein = null;
		}
		BufferedReader bEin
		= new BufferedReader(new InputStreamReader(ein));
		try {
			nachricht = bEin.readLine();
		} catch (IOException e) {
			System.out.println("Failed to read message");
			nachricht = null;
		}
		return nachricht;	
	}
}
