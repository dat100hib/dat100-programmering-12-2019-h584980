package no.hvl.dat100.jplab12.oppgave1;

public abstract class Innlegg {

	protected int id;
	protected String bruker;
	protected String dato;
	protected int likes;
	
	public Innlegg() {
		
	}

	public Innlegg(int id, String bruker, String dato) {
		this.id = id;
		this.bruker = bruker;
		this.dato = dato;
		this.likes = 0;
	}

	public Innlegg(int id, String bruker, String dato, int likes) {
		this.id = id;
		this.bruker = bruker;
		this.dato = dato;
		this.likes = likes;
	}

	public String getBruker() {
		return bruker;
	}

	public void setBruker(String bruker) {
		this.bruker = bruker;
	}

	public String getDato() {
		return dato;
	}

	public void setDato(String dato) {
		this.dato = dato;
	}

	public int getId() {
		return id;
	}

	public int getLikes() {
		return likes;
	}

	public void doLike() {
		this.likes++;
	}

	public boolean erLik(Innlegg innlegg) {

		if (this == innlegg) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {

		String innlegg;
		innlegg = getId() + "\n" + getBruker() + "\n" + getDato() + "\n" + getLikes() + "\n";
		return innlegg;

	}

	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {
		String innleggHTML;
		
		innleggHTML = "		<h2>" + getBruker() + "@" + getDato() + " ["+getLikes()+"]" + "<h2>";
		
		return innleggHTML;

	}
}
