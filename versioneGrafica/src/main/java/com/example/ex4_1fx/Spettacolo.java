package com.example.ex4_1fx;

public class Spettacolo {
    private String titoloSpettacolo;
    private String nomeCompagnia;
    private String data;
    private String ora;
    private double prezzo;

    private final int posti;
    private Persona [] spettatori;
    private int postiOccupati;

    public Spettacolo(String titoloSpettacolo, String nomeCompagnia,String data,String ora,double prezzo,int posti) {
        this.titoloSpettacolo=titoloSpettacolo;
        this.nomeCompagnia=nomeCompagnia;
        this.data=data;
        this.ora=ora;
        this.prezzo=prezzo;
        this.posti = posti;
        this.postiOccupati=0;
        this.spettatori=new Persona[posti];
    }

    public Persona[] getSpettatori() {
        return spettatori;
    }
    public String getTitoloSpettacolo(){ return this.titoloSpettacolo; }

    public boolean aggiuntaSpettatore(Persona persona){
        if( postiOccupati < posti ){
            spettatori[postiOccupati]= persona;
            postiOccupati++;
            return true;
        }
        return false;
    }

    public String elencoPrenotazioni(){
        if( postiOccupati == 0 ){
            return "NESSUNA PRENOTAZIONE";
        } else {
            String s="PRENOTAZIONI ATTUALI PER "+this.titoloSpettacolo+" di "+this.nomeCompagnia+": \n";
            for (int i=0;i<postiOccupati;i++){
                s=s+this.spettatori[i].toString()+" Data e ora: "+this.data+" - "+this.ora+" Costo: "+getCostoBiglietto(this.spettatori[i])+"\n";
            }
            return s;
        }
    }

    public int getPostiLiberi() { return this.posti-this.postiOccupati; }

    public double getCostoBiglietto(Persona persona) {
        if (persona instanceof Studente || persona instanceof Professore)
            return (this.prezzo-(0.1*this.prezzo));
        else
            return this.prezzo;
    }

    @Override
    public String toString() {
        return "SPETTACOLO: "+this.titoloSpettacolo+" di "+this.nomeCompagnia+": \n"+ " Data e ora: "+this.data+" - "+this.ora;
    }
}