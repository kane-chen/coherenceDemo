package cn.kane.cache.observer;

import cn.kane.pojo.Employee;

import com.tangosol.util.MapEvent;
import com.tangosol.util.MapListener;
import com.tangosol.util.ObservableMap;

public class EmployeeListener implements MapListener {

	@Override
	public void entryDeleted(MapEvent evt) {
		System.out.println("DELETE NOTIFY");
		Employee em = (Employee)evt.getOldValue();
		System.out.println("REMOVED:"+em);
		ObservableMap obMaps = evt.getMap();
		System.out.println(obMaps);
	}

	@Override
	public void entryInserted(MapEvent evt) {
		System.out.println("INSERT NOTIFY");
		Employee em = (Employee)evt.getNewValue();
		System.out.println("ADD:"+em);
		System.out.println(evt.getNewEntry().getKey());
		System.out.println(evt.getNewEntry().getValue());
	}

	@Override
	public void entryUpdated(MapEvent evt) {
		System.out.println("UPDATE NOTIFY");
		Employee em = (Employee) evt.getSource() ;
		System.out.println(em);
		em = (Employee) evt.getOldValue() ;
		System.out.println(em);
		em = (Employee) evt.getNewValue() ;
		System.out.println(em);
	}

}
