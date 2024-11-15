package persona;

public class Studente extends Persona{
    private int matricola;
    private int anno;
    private static int ultimaMatricola=0;

    //Costruttore
    public Studente(String nome,String indirizzo){
        super(nome,indirizzo);
        this.anno=1;
        this.matricola=ultimaMatricola+1;
        ultimaMatricola++;
    }
    //Metodi
    public int getMatricola() { return this.matricola; }
    public int getAnno() { return this.anno; }

    public void setAnno(int anno) { this.anno = anno; }

    public void visualizza(){
        super.visualizza();
        System.out.println("Matricola: "+this.matricola+" Anno: "+this.anno);
    }

    @Override
    public String toString() {
        return super.toString()+"Matricola: "+this.matricola+" Anno: "+this.anno;
    }
}