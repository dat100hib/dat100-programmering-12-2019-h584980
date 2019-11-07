package no.hvl.dat100.jplab12.oppgave2;

public class Bilde extends Tekst {

	private String url;

	public Bilde(int id, String bruker, String dato, String tekst, String url) {
		super(id, bruker, dato, tekst);
		this.url = url;
	}

	public Bilde(int id, String bruker, String dato, int likes, String tekst, String url) {
		super(id, bruker, dato, likes, tekst);
		this.url = url;
	}

	public String getUrl() {
		return url;

	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		String innlegg;
		innlegg = "BILDE" + "\n" + getId() + "\n" + getBruker() + "\n" + getDato() + "\n" + getLikes() + "\n"
				+ "et bilde" + "\n" + getUrl() + "\n";
		return innlegg;

	}

	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {

		String innleggHTML;

		innleggHTML = "		<h2>" + getBruker() + "@" + getDato() + " ["+getLikes()+"]" + "<h2>\n		<p>" + getTekst() + "<p>\n		<iframe src=\"" + getUrl() + "\" height=600 width=800></iframe>\n		<hr>\n";

		return innleggHTML;

	}
}
