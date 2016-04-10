import java.util.*;
/**
 * Die Benutzereingabe
 * 
 * @author (Rainer Hofmann) 
 * @version (2)
 */

public class Eingabe{
    /**
     * @return  die Eingegebene Zahl vom Typ long
     */
    public long validInput(){
        System.out.println("Bitte die gemerkte Zahl eingeben");
        while(true){
            try{                
                Scanner keyboard = new Scanner(System.in);
                return keyboard.nextLong();
            }catch(InputMismatchException e){
                System.out.println("Bitte nur Zahlen eingeben");
            }
            
        }
    }
    /**
     * Abfrage ob weitergespielt werden soll oder nicht
     * @return den eingegeben String
     */
    public String weiterSpielen(){
        Scanner keyboard = new Scanner(System.in);
        return keyboard.nextLine();
    }
}

