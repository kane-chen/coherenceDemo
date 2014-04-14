package cn.kane.cache.observer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.tangosol.net.NamedCache;

public class ObServerOfEmListener {

	private static Map<NamedCache,EmployeeListener> mapping = new ConcurrentHashMap<NamedCache,EmployeeListener>() ;
	
	public static void regCache(NamedCache cache){
		System.out.println("REG CACHE-"+cache.getCacheName());
		cache.addMapListener( new EmployeeListener());
	}
	
	public static void unRegCache(NamedCache cache){
		System.out.println("UNREG CACHE-"+cache.getCacheName());
		EmployeeListener emListener = mapping.get(cache) ;
		if(null!=emListener)
			cache.removeMapListener(emListener);
	}
}
