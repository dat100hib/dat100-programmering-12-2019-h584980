package no.hvl.dat100.jplab12.oppgave2;

import no.hvl.dat100.jplab12.oppgave1.*;

public class Tekst extends Innlegg {

	protected String tekst;

	public Tekst() {

	}

	public Tekst(int id, String bruker, String dato, String tekst) {
		super(id, bruker, dato);
		this.tekst = tekst;
	}

	public Tekst(int id, String bruker, String dato, int likes, String tekst) {
		super(id, bruker, dato, likes);
		this.tekst = tekst;
	}

	public String getTekst() {
		return tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	@Override
	public String toString() {
		String innlegg;
		innlegg = "TEKST" + "\n" + getId() + "\n" + getBruker() + "\n" + getDato() + "\n" + getLikes() + "\n" + getTekst()
				+ "\n";
		return innlegg;

	}

	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {

		String innleggHTML;
		
		innleggHTML = "		<h2>" + getBruker() + "@" + getDato() + " ["+getLikes()+"]" + "<h2>\n		<p>" + getTekst() + "<p>\n		<hr>\n";
		
		return innleggHTML;

	}
}
