package no.hvl.dat100.jplab12.oppgave3;

import no.hvl.dat100.jplab12.oppgave1.*;
import no.hvl.dat100.jplab12.oppgave2.Tekst;

public class Blogg {

	private Innlegg[] innleggtabell;
	private int nesteLedig;

	public Blogg() {
		this.innleggtabell = new Innlegg[20];
		this.nesteLedig = 0;
	}

	public Blogg(int lengde) {
		this.innleggtabell = new Innlegg[lengde];
		this.nesteLedig = 0;
	}

	public int getAntall() {
		int antall = 0;
		for (Innlegg innlegg : innleggtabell) {
			if (innlegg != null) {
				antall++;
			}
		}
		return antall;
	}

	public Innlegg[] getSamling() {
		return innleggtabell;
	}

	public int finnInnlegg(Innlegg innlegg) {
		for (int i = 0; i < innleggtabell.length; i++) {
			if (innlegg.erLik(innleggtabell[i])) {
				return i;
			}
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		for (Innlegg innleggTab : innleggtabell) {
			if (innleggTab != null && innleggTab.getId() == innlegg.getId()) {
				return true;
			}
		}
		return false;
	}

	public boolean ledigPlass() {
		for (Innlegg innlegg : innleggtabell) {
			if (innlegg == null) {
				return true;
			}
		}
		return false;
	}

	public boolean leggTil(Innlegg innlegg) {
		if (!finnes(innlegg) && ledigPlass() && innleggtabell[nesteLedig] == null) {
			innleggtabell[nesteLedig] = innlegg;
			nesteLedig++;
			return true;
		}
		return false;
	}

	public String toString() {
		String string = getAntall() + "\n";
		for (Innlegg innlegg : innleggtabell) {
			if (innlegg != null) {
				string = string + innlegg.toString();
			}
		}
		return string;
	}

	// valgfrie oppgaver nedenfor

	public void utvid() {
		Innlegg[] innleggtabell2 = new Innlegg[innleggtabell.length * 2];
		for (int i = 0; i < innleggtabell.length; i++) {
			innleggtabell2[i] = innleggtabell[i];
		}
		innleggtabell = innleggtabell2;
	}

	public boolean leggTilUtvid(Innlegg innlegg) {
		if (ledigPlass() && !finnes(innlegg)) {
			leggTil(innlegg);
			return true;
		} else if (!ledigPlass() && !finnes(innlegg)) {
			utvid();
			leggTil(innlegg);
			return true;
		}
		return false;
	}

	public boolean slett(Innlegg innlegg) {
		if (finnes(innlegg)) {
			int pos = finnInnlegg(innlegg);
			int antall = getAntall();
			innleggtabell[pos] = null;
			for (; pos < (antall - 1); pos++) {
				innleggtabell[pos] = innleggtabell[pos + 1];
			}
			innleggtabell[antall - 1] = null;
			nesteLedig--;
			return true;
		}
		return false;
	}

	public int[] search(String keyword) {
		int[] IDer = new int[innleggtabell.length];
		int pos = 0;
		for (int i = 0; i < innleggtabell.length; i++) {
			if (innleggtabell[i] != null) {
				String tekst = ((Tekst) innleggtabell[i]).getTekst();
				if (tekst.contains(keyword)) {
					IDer[pos] = innleggtabell[i].getId();
					pos++;
				}
			}
		}
		return IDer;
	}
}