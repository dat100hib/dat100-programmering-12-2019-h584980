package no.hvl.dat100.jplab12.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

import no.hvl.dat100.jplab12.oppgave1.*;
import no.hvl.dat100.jplab12.oppgave2.*;
import no.hvl.dat100.jplab12.oppgave3.*;

public class LesBlogg {

	private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/jplab12/tests/";
	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String filnavn) {
		Blogg samling = null;
		boolean filFunnet = false;
			try {
				File file = new File(MAPPE + filnavn);
				BufferedReader leser = new BufferedReader(new FileReader(file));
				String line = leser.readLine();
				samling = new Blogg(Integer.parseInt(line));
				
				while (!filFunnet) {
					line = leser.readLine();
					if (line == null){
						leser.close();
						filFunnet = true;
					} else if (line.contentEquals(TEKST)) {
						int 	id = Integer.parseInt(leser.readLine());
						String 	bruker = leser.readLine();
						String 	dato = leser.readLine();
						int 	likes = Integer.parseInt(leser.readLine());
						String 	tekst = leser.readLine();
	
						Innlegg innlegg = new Tekst(id, bruker, dato, likes, tekst);
						samling.leggTilUtvid(innlegg);		
					} else if (line.contentEquals(BILDE)) {
						int 	id = Integer.parseInt(leser.readLine());
						String 	bruker = leser.readLine();
						String 	dato = leser.readLine();
						int 	likes = Integer.parseInt(leser.readLine());
						String 	tekst = leser.readLine();
						String 	url = (leser.readLine());
	
						Innlegg innlegg = new Bilde(id, bruker, dato, likes, tekst, url);
						samling.leggTilUtvid(innlegg);
					} 	
				}
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Filen " + filnavn + " finnes ikke. \n" + e.getMessage());
		}
		return samling;
	}
}