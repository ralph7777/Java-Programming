package dijkstra;

//A data structure to store pairs of vertex and weight value.
public class Info {
	char vertex;
	int weight;
	
	public Info(){
		this.vertex='A';
		this.weight=0;
	}
	
	public Info(char vertex, int weight){
		this.vertex=vertex;
		this.weight=weight;
	}
	
	public char getVertex(){
		return vertex;
	}
	
	public int getWeight(){
		return weight;
	}
	
}
