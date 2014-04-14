package cn.kane.cache;

import java.util.List;

import cn.kane.cache.observer.ObServerOfEmListener;
import cn.kane.impl.EmployeeServiceImpl;
import cn.kane.pojo.Employee;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;

public class CacheEntrance {

	private static final String CACHE_NAME = "kane";

	private static final int ACCOUNT = 1 ;
	
	public static void main(String[] args) {
		System.out.println("main entrance");
		for(int i=1 ; i<ACCOUNT+1;i++){
			final int cacheNo = i ;
			new Thread(new Runnable(){
				@Override
				public void run() {
					System.out.println(cacheNo+"/"+ACCOUNT+"::: start");
					CacheEntrance.startCahce(cacheNo,ACCOUNT);
				}
			}).start() ;
			
		}
	}

	public static void startCahce(int cacheNo,int account){
		List<Employee> employees = new EmployeeServiceImpl().getOwnDatas(cacheNo, account);
		NamedCache cache = CacheFactory.getCache(CACHE_NAME);
		ObServerOfEmListener.regCache(cache) ;
		for(Employee em : employees){
			cache.put(em.getId(), em);
			System.out.println("PUT::"+CACHE_NAME+"-"+em);
			em.setName("newName"+em.getId());
			cache.put(em.getId(), em);
			cache.remove(em.getId());

			try {
				Thread.sleep(50000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		Employee em = (Employee)cache.get(cacheNo+1);
		System.out.println(em);
		
	}
}
