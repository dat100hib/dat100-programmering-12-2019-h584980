package no.hvl.dat100.jplab12.oppgave4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import no.hvl.dat100.jplab12.oppgave3.*;

public class SkrivBlogg {

	private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/jplab12/tests/";

	public static boolean skriv(Blogg samling, String filnavn) {
		boolean skrevetUt = true;
		 PrintWriter skriver;	// Åpner filen
		try {
			File file = new File(MAPPE + filnavn);
			skriver = new PrintWriter(file);
	        skriver.println(samling.toString());
	        skriver.close();	// Lukker filen
		} catch (FileNotFoundException e) {
			skrevetUt = false;
			JOptionPane.showMessageDialog(null, "Filen " + filnavn + " finnes ikke. \n" + e.getMessage());
		}
		return skrevetUt;
	}
}
