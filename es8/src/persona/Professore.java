package persona;

public class Professore extends Persona{
    private String codiceDocente;
    private String dipartimento;

    //Costruttore
    public Professore(String nome,String indirizzo,String codiceDocente,String dipartimento){
        super(nome,indirizzo);
        this.codiceDocente=codiceDocente;
        this.dipartimento=dipartimento;
    }
    public Professore(){
        this("NON INSERITO","NON INSERITO","NON INSERITO","NON INSERITO");
    }
    //Metodi
    public String getCodiceDocente() { return codiceDocente; }
    public String getDipartimento() { return dipartimento; }

    public void visualizza(){
        super.visualizza();
        System.out.println("Codice del docente: "+this.codiceDocente+" Dipartimento: "+this.dipartimento);
    }

    @Override
    public String toString() {
        return super.toString()+"Codice del docente: "+this.codiceDocente+" Dipartimento: "+this.dipartimento;
    }
}