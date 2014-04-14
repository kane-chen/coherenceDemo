package cn.kane.pojo;

import java.io.IOException;

import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;
import com.tangosol.io.pof.PortableObject;

public class Employee implements PortableObject {

	private int id = 0;
	private String name = null ;
	private int age = 0 ;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Employee[id="+id
				+",name"+name
				+",age="+age
				+"]";
	}
	/*
	 //using for implementing PofSerializer
	public Object deserialize(PofReader in) throws IOException {
		this.setId(in.readInt(ID));
		this.setName(in.readString(NAME));
		this.setAge(in.readInt(AGE));
		return this;
	}
	public void serialize(PofWriter out, Object o) throws IOException {
		Employee em = (Employee) o ;
		out.writeInt(ID, em.getId());
		out.writeString(NAME, em.getName());
		out.writeInt(AGE, em.getAge());
		out.writeRemainder(null);
	}
	 */
	
	private static final int ID = 0 ;
	private static final int NAME = 1 ;
	private static final int AGE = 2 ;

	@Override
	public void readExternal(PofReader in) throws IOException {
		this.setId(in.readInt(ID));
		this.setName(in.readString(NAME));
		this.setAge(in.readInt(AGE));
	}
	@Override
	public void writeExternal(PofWriter out) throws IOException {
		out.writeInt(ID, this.getId());
		out.writeString(NAME, this.getName());
		out.writeInt(AGE, this.getAge());
	}
}
