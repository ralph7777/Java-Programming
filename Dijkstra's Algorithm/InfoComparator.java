package dijkstra;

import java.util.Comparator;

//Comparator for comparing two instance of Info Class based on the weight value.
public class InfoComparator implements Comparator<Info>{

	@Override
	public int compare(Info arg0, Info arg1) {
		if (arg0.getWeight() < arg1.getWeight()) {
			return -1;
		}
		if (arg0.getWeight() > arg1.getWeight()) {
			return 1;
		}
		return 0;
	}

}
