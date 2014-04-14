package cn.kane.services;

import java.util.List;

import cn.kane.pojo.Employee;

public interface IEmployeeService {

	/**
	 * Using hash(curNo%account = curNo) get owning datas
	 * @param curNo
	 * @param account
	 * @return
	 */
	public List<Employee> getOwnDatas(int curNo ,int account) ;
	
}
