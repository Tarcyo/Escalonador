
public class Processo {

	private String id;
	private int prioridade;
	private int tempo;

	public String getID() {
		return this.id;
	}
	
	public void setID(String id) {
		this.id = id;
	}
	
	public int getPrioridade() {
		return this.prioridade;
	}
	
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	
	public int getTempo() {
		return this.tempo;
	}
	
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	@Override
	public String toString() {
		return "Processo [id=" + id + ", prioridade=" + prioridade + ", tempo=" + tempo + "]";
	}
	
}
