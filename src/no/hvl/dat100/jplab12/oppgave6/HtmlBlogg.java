package no.hvl.dat100.jplab12.oppgave6;


import no.hvl.dat100.jplab12.oppgave3.Blogg;


public class HtmlBlogg extends Blogg {

	public HtmlBlogg() {
		super();
	}
	
	private static String HTMLPREFIX = 
			"<html>\n\t<head>\n\t\t<title>DAT100 Blogg</title>\n\t</head>\n\t<body>\n";
	
	private static String HTMLPOSTFIX = 
			"\t</body>\n</html>";
	
	@Override
	public String toString() {
		String bloggHTML;
		
		String alleInnlegg = "";
		
		for (int i = 0; i < getAntall(); i++) {
			alleInnlegg = alleInnlegg + getSamling()[i].toHTML();
		}
		
		bloggHTML = HTMLPREFIX + alleInnlegg + HTMLPOSTFIX;
		
		System.out.println(bloggHTML);
		
		return bloggHTML;
		
	}
}
