package hash;

import java.time.Duration;
import java.time.Instant;

/*
 * Dica de utilização da classe:
 * 
 * Criar um objeto Comparator no início do algoritmo sorteador
 * Comparator comparator = new Comparator();
 * 
 * Registrar trocas e comparações através dos métodos getNumComparations e addNumSwaps
 * comparator.getNumComparations()
 * comparator.addNumSwaps()
 * 
 * Finalizar o temporizador ao término do algoritmo de ordenação
 * comparator.finishComparation()
 * 
 * Obter os dados estatísticos através do método toString()
 * comparator.toString()
 */

public class Comparator {
	private int numSwaps;
	private int numComparations;
	private int numCollisions;
	private Duration processTime;
	private Instant startTime;
	private Instant endTime;
	
	public Comparator() {
		this.numCollisions = 0;
		this.numComparations = 0;
		this.numSwaps = 0;
		this.startTime = Instant.now();
	}
	
	public int getNumCollisions() {
		return this.numCollisions;
	}

	public int getNumComparations() {
		return this.numComparations;
	}
	
	public int getNumSwaps() {
		return this.numSwaps;
	}

	public String getProcessTime() {
		return processTime.toString().replace("PT", "");
	}
	
	public void addNumCollisions() {
		this.numCollisions++;
	}

	public void addNumComparations() {
		this.numComparations++;
	}
	
	public void addNumSwaps() {
		this.numSwaps++;
	}
	
	public void finishComparation() {
		this.endTime = Instant.now();
		this.processTime = Duration.between(this.startTime, this.endTime);
	}

	@Override
	public String toString() {
		return "Comparator [numSwaps=" + this.numSwaps + ", numComparations=" + this.numComparations 
				+ ", numCollisions=" + this.numCollisions + ", processTime=" + this.getProcessTime() + "]";
	}
	
	
}
