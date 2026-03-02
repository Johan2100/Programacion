package examenesPractica.ejerEmpresa.model;

import java.util.Comparator;
public class ComparatorFechas implements Comparator<GastoEmpresa> {

	@Override
	public int compare(GastoEmpresa o1, GastoEmpresa o2) {
		if(o1.getFecha().isAfter(o2.getFecha()))
			return 1;
		else if(o1.getFecha().isBefore(o2.getFecha()))
			return -1;
		else
			return 0;
	}

}
