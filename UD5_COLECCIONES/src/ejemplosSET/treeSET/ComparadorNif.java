package ejemplosSET.treeSET;

import java.util.Comparator;

public class ComparadorNif implements Comparator <TreeAlumnoSET>{

	@Override
	public int compare(TreeAlumnoSET o1, TreeAlumnoSET o2) {
		
		return o1.getNif().compareTo(o2.getNif());
	}

}
