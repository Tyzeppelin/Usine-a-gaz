package compilateur;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

//quelques primitives d'écriture à l'ecran  ou dans un fichier
/**
 * Classe i/o d'ecriture dans un fichier ou sur la sortie standard
 * @author Francois
 *
 */
public class Ecriture {   
	
	/**
	 * Methode static d'ecriture du message d'une exception sur la sortie std
	 * @param e : une exception
	 */
    private static void erreur(IOException e) {
    System.out.println(e.getMessage());
	System.out.println("Erreur fatale");
	System.exit(1);
    }

    /**
     * Methode static qui délivre un outpustream sur le fichier de nom passe en parametre
     * @param nomFich : fichier a ouvrir
     * @return : outputstream sur le fichier de nom passe en parametre (null si erreur)
     */
    public static OutputStream ouvrir(String nomFich) {
	//délivre un pointeur sur le fichier de nom nomFich (null si erreur)
	OutputStream f;
	try {f=new DataOutputStream(new FileOutputStream(nomFich));
	}
	catch (IOException e) {f=null;}
	return f;
    }
     
    /**
     * Methode static de fermeture du stream f
     * @param f : l'outputstream a fermer
     */
    public static void fermer(OutputStream f) {
	//fermeture d'un fichier                                          
	try {f.close();}
	catch (IOException e) {erreur(e);}
    }               
    
    /**
     * Methode d'ecriture d'un caractere dans la fichier passe en paramtre
     * @param f : le fichier où ecrire
     * @param c : le caractere a ecrire
     */
    public static void ecrireChar(OutputStream f,char c) {
	try {f.write(c);}
        catch(IOException e) {erreur(e);}
    }
    
    /**
     * Methode d'ecriture d'un caractere sur la sortie std
     * @param c : le caractere a ecrire
     */
    public static void ecrireChar(char c) {ecrireChar(System.out,c);}

    /**
     * Methode d'ecriture d'une chaine de caracteres dans le fichier passe en parametre
     * @param f : le fichier a ecrire
     * @param s : la chaine a ecrire
     */
    public static void ecrireString(OutputStream f,String s) {
	try {for (int i=0;i<s.length();i++) f.write(s.charAt(i));}
        catch(IOException e) {erreur(e);}
    }
    
    /**
     * Methode d'ecriture d'une chaine de caracteres sur la sortie std
     * @param s : la chaine de caracteres a ecrire
     */
    public static void ecrireString(String s) {
	ecrireString(System.out,s);
    }

    /**
     * Methode d'ecriture d'une chaine de caracteres avec retour a la ligne dans le fichier passe en parametre
     * @param f : le fichier a ecrire
     * @param s : la chaine a ecrire
     */
    public static void ecrireStringln(OutputStream f,String s) {
	ecrireString(f,s+"\r\n");
    }

    /**
     * Methode d'ecriture d'une chaine de caracteres avec retour a la ligne sur la sortie std
     * @param s : la chaine de caracteres a ecrire
     */
    public static void ecrireStringln(String s) {
	ecrireStringln(System.out,s);
    }



    /**
     * Methode d'ecriture d'un entier dans le fichier passe en parametre
     * @param f : le fichier a ecrire
     * @param x : l'entier a ecrire
     */
    public static void ecrireInt(OutputStream f,int x) {
	ecrireString(f,Integer.toString(x));
    }

    /**
     * Methode d'ecriture d'un entier sur la sortie std
     * @param x : l'entier a ecrire
     */
    public static void ecrireInt(int x) {ecrireInt(System.out,x);}
    
    /**
     * Methode d'ecriture d'un entier dans le fichier passe en parametre avec la longueur en plus (?)
     * @param f : le fichier a ecrire
     * @param x : l'entier a ecrire
     * @param longueur : la longueur
     */
    public static void ecrireInt(OutputStream f,int x,int longueur) {
	String s=Integer.toString(x);
	int k=longueur-s.length();
	for (int i=0;i<k;i++) ecrireChar(f,' ');
	ecrireString(f,s);
    }

    /**
     * Methode d'ecriture d'un entier sur la sortie std avec la longueur en pluls (?)
     * @param x : l'entier a ecrire
     * @param longueur : la longueur
     */
    public static void ecrireInt(int x,int longueur) {
	ecrireInt(System.out,x,longueur);
    }


    /**
     * Methode d'ecriture d'un double dans le fichier passe en parametre
     * @param f : le fichier a ecrire
     * @param s : le double a ecrire
     */
    public static void ecrireDouble(OutputStream f,double d) {
	ecrireString(f,Double.toString(d));
    }

    /**
     * Methode d'ecriture d'un double sur la sortie std
     * @param d : le double a ecrire
     */
    public static void ecrireDouble(double d) {ecrireDouble(System.out,d);}

    /**
     * Methode d'ecriture d'un double dans le fichier passe en parametre avec la longueur en plus (?)
     * @param f : le fichier a ecrire
     * @param d : le double a ecrire
     * @param longueur : la longueur
     */
    public static void ecrireDouble(OutputStream f,double d,int longueur) {
	String s=Double.toString(d);
	int k=longueur-s.length();
	for (int i=0;i<k;i++) ecrireChar(f,' ');
	ecrireString(f,s);
    }

    /**
     * Methode d'ecriture d'un double sur la sortie std avec la longueur en pluls (?)
     * @param d : le double a ecrire
     * @param longueur : la longueur
     */
    public static void ecrireDouble(double d,int longueur) {
	ecrireDouble(System.out,d,longueur);
    }

}//class Ecriture

