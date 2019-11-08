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
		int innleggPos = -1;
		for (int i = 0; i < innleggtabell.length; i++) {
			if (innlegg.erLik(innleggtabell[i])) {
				innleggPos = i;
				return innleggPos;
			}
		}
		return innleggPos;
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
		boolean lagtTil = false;
		if (!finnes(innlegg) && ledigPlass() && innleggtabell[nesteLedig] == null) {
			innleggtabell[nesteLedig] = innlegg;
			lagtTil = true;
			nesteLedig++;
		}
		return lagtTil;
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
		boolean lagtInn = false;
		if (ledigPlass() && !finnes(innlegg)) {
			leggTil(innlegg);
			lagtInn = true;
		} else if (!ledigPlass() && !finnes(innlegg)) {
			utvid();
			leggTil(innlegg);
			lagtInn = true;
		}
		return lagtInn;
	}

	public boolean slett(Innlegg innlegg) {
		boolean slettet = false;
		if (finnes(innlegg)) {
			int pos = finnInnlegg(innlegg);
			int antall = getAntall();
			innleggtabell[pos] = null;
			slettet = true;
			for (; pos < (antall - 1); pos++) {
				innleggtabell[pos] = innleggtabell[pos + 1];
			}
			innleggtabell[antall - 1] = null;
			nesteLedig--;
		}
		return slettet;
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