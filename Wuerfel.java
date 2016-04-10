/**
 * Beschreiben Sie hier die Klasse Wuerfel.
 * 
 * @author (Rainer Hofmann) 
 * @version (1)
 * @param min Minimale Augenzahl
 * @param max Maximale Augenzahl
 * @param augen Aktuelle Augenzahl
 */
public class Wuerfel{
    private int min;
    private int max;
    private int augen;
    /**
     * Kostruktor, erzeugt Wuerfel min .. max.
     * @param min minimale Augenzahl
     * @param max maximale Augenzahl
     */
    public Wuerfel(int min, int max){
        this.min = min;
        this.max = max;
    }
    /**
     * Kostruktor, erzeugt Standardwuerfel 1 .. 6.
     * 
     */
    public Wuerfel(){
        this.min = 1;
        this.max = 6;
    }
    /**
     *@override 
     *Darstellen eines Wuerfels als String der Form "Wuerfel 1 .. 6 gewuerfelt: 3".
     */
    public String toString(){
        return "Wuerfel " + min + " .. " + max + "gewuerfelt: " + augen; 
        
    }
    /**
     * Liest aktuelle Augenzahl
     * @return Augenzahl
     */
    public int getAugen(){
        return augen;
    }
    /**
     * Wuerfeln, setzt zufällig Augenzahl als ganze Zahl zwischen Minimalzahl und Maximalzahl.
     * @return Augenzahl
     */
    public int wuerfeln(){
        int temp = (int)(Math.random() * 10);
        while(temp < min || temp > max){
            temp = (int)(Math.random() * 10);
            
        }
        this.augen = temp;
        return temp;
    }
}
