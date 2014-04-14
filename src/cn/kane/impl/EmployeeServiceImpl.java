package cn.kane.impl;

import java.util.ArrayList;
import java.util.List;

import cn.kane.pojo.Employee;
import cn.kane.services.IEmployeeService;

public class EmployeeServiceImpl implements IEmployeeService {

	private List<Employee> allEmloyees = null ;
	
	private void initAllEmployees(){
		this.allEmloyees = new ArrayList<Employee>() ;
		String[] employeeNames = {"t-mac","kids","iven","webb","steven","james","anthony","kobe"};
		for(int i=1;i<employeeNames.length+1;i++){
			Employee employee = new Employee() ;
			employee.setId(i);
			employee.setName(employeeNames[i-1]);
			employee.setAge(i*5);
			allEmloyees.add(employee);
		}
	}
	
	public EmployeeServiceImpl(){
		initAllEmployees();
	}
	
	@Override
	public List<Employee> getOwnDatas(int curNo, int account) {
		List<Employee> subEmployes = new ArrayList<Employee>() ;
		if(curNo > account){
			//return 0;
		}else{
			for(Employee em : allEmloyees){
				if(account == 1){
					subEmployes.add(em) ;
				}else{
					int id = em.getId();
					if( id % account == curNo-1){
						subEmployes.add(em);
					}else{
						//go on
					}
				}
			}
		}
		return subEmployes;
	}

}
