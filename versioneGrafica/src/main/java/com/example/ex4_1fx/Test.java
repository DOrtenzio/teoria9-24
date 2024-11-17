package com.example.ex4_1fx;

public class Test {
    public static void main(String[] args) {
        Spettacolo spettacolo=new Spettacolo("la locandiera","pegadorCompany","25/12/2007","11:05",5.00,100);
        Persona p1=new Persona("Giovanni Rana","MI, via ciao 22");
        if (spettacolo.aggiuntaSpettatore(p1))
            System.out.println("INSERITO CORRETTAMENTE");
        else
            System.out.println("POSTI TUTTI OCCUPATI");
        Studente p2=new Studente("Longo Alessandro","Solza, via trota 23");
        if (spettacolo.aggiuntaSpettatore(p2))
            System.out.println("INSERITO CORRETTAMENTE");
        else
            System.out.println("POSTI TUTTI OCCUPATI");
        Professore p3=new Professore("Vizz Luca","VCO, via erminia 34","ABX009","Italiano");
        if (spettacolo.aggiuntaSpettatore(p3))
            System.out.println("INSERITO CORRETTAMENTE");
        else
            System.out.println("POSTI TUTTI OCCUPATI");

        System.out.println(spettacolo); // sono stampate le informazioni relative allo spettacolo: titolo, compagnia data e ora spettacolo
        System.out.println(spettacolo.elencoPrenotazioni()); //è stampato l’elenco di tutti gli spettatori con il relativo prezzo del biglietto
        System.out.println("POSTI LIBERI:"+spettacolo.getPostiLiberi());
    }
}