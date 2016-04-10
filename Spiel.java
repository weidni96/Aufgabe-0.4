/**
 * Spielverlauf, der in der Main Instanziert wird
 * 
 * @author (Christian Staudte) 
 * @version (1)
 */
public class Spiel {

	private long newInp;
	private long number;
	private Eingabe eingabe;
	private Ausgabe ausgabe;
	private Wuerfel wuerfel;
	private boolean inGame;
	
	/**
     * Kostruktor, erzeugt ein Spiel 
	 * mit einem einfachen Wuerfel und einem Eingabe-, Ausgabeobjekt.
	 * Auch werden die Regeln ausgegeben
     */
	public Spiel(){
		wuerfel = new Wuerfel(0,9);
		eingabe = new Eingabe();
		ausgabe = new Ausgabe();
		
		initNumber();
		inGame = true;
		
		ausgabe.rules(); 
		eingabe.weiterSpielen(); 
	}
	
	/**
     * Das Spiel wird hier gestartet
     */
	public void start(){
		while(inGame == true){
			ausgabe.clearScreen();
			wait(250);
			System.out.println(number);
			wait(500);
			ausgabe.clearScreen();
			newInp = eingabe.validInput();
			
			if(newInp == number){
				if(number >= 100000000){
					ausgabe.youWin(number);
					continueGame();
				}else{
					number = number * 10 + wuerfel.wuerfeln();
				}
			}else{
				ausgabe.youLose(number, newInp);
				continueGame();
			}
		}
	}
	
	/**
     * Initialisiere eine neue Zufallszahl
	 * mit genau zwei Stellen
     */
	public void initNumber(){
		int a = wuerfel.wuerfeln();
		while(a == 0){
			a = wuerfel.wuerfeln();
		}
		number = a*10 + wuerfel.wuerfeln();
	}
	
	/**
     * Warte eine Gewisse Zeit bevor der folgende Code ausgefuehrt wird
	 * @param time Zeit in Millisekunden die gewartet werden soll
     */
	public void wait(int time){
		try {
		    Thread.sleep(1000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}
	
	/**
     * Abfrage, ob eine neues Spiel gestartet werden soll
	 * Falls nicht, setzte inGame = false
     */
	public void continueGame(){
		System.out.println("Neues Spiel?");
		System.out.println("Wenn ja, geben sie etwas ein und druecken Enter...");
		if(eingabe.weiterSpielen().equals("")){
			inGame = false;
		}else{
			initNumber();
		}
	}
}
