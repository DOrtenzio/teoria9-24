package persona;

public class Persona {
    private String nome;
    private String indirizzo;

    //Costruttore
    public Persona(String nome,String indirizzo){
        this.nome=nome;
        this.indirizzo = indirizzo;
    }
    public Persona(){
        this("NON INSERITO","NON INSERITO");
    }
    //Metodi richiesti
    public String getNome() { return this.nome; }
    public String getIndirizzo() { return this.indirizzo; }

    public void setIndirizzo(String indirizzo) { this.indirizzo = indirizzo; }

    public void visualizza(){
        System.out.println("Nome: "+this.nome+" Indirizzo: "+this.indirizzo);
    }
    @Override
    public String toString() {
        return "Nome: "+this.nome+" Indirizzo: "+this.indirizzo;
    }
}