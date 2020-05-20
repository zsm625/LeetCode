package array;

import java.util.Arrays;

/**
 * 构造数组，增加、删除、访问元素、包含
 * @author ZSM
 *
 * @time 2019年10月26日下午4:14:54
 */
public class ArrayDemo<E> {
	private Object[] element = null;
	private  int size;
	private int count = 0;
//	private 
	
	public ArrayDemo(int capacity) {
		element  = new Object[capacity];
		this.size = capacity;
		this.count=0;
	}
	
	/**
	 * 根据 下标找指定元素
	 *@author ZSM
	 * @param index
	 * @return
	 * @throws Exception
	 */
	public Object get(int index) throws Exception {
		if(index>=size||index<0) {
			throw new Exception("ArrayOutOfBoundException");
		}
		return element[index];
	}
	
	/**
	 * 插入数据，数组最后插入
	 *@author ZSM
	 * @param obj
	 * @return
	 * @throws Exception 
	 */
	public boolean insertTrail(Object obj) throws Exception {
		return this.insert(size-1, obj);
	}
	
	public boolean insertHead(Object obj) {
		return this.insert(0, obj);
	}
	
	
	/**
	 * 在指定位置插入数据
	 *@author ZSM
	 * @param index
	 * @param obj
	 * @return
	 */
	public boolean insert(int index,Object obj) {
		if(size==element.length) {
			resize(2*element.length);
		}
		if(index>size||index<0) {
			return false;
		}
		Object[] newElement = Arrays.copyOf(element, size+1);
		//从后面倒着往后移动一位
		for(int i=element.length-1;i>index;i--) {
			newElement[i+1]=element[i];
		}
		newElement[index]=obj;
		element=newElement;
		this.size++;
		return true;	
	}
	
	public boolean contain(Object obj) {
		if(obj==null) {
			return false;
		}
		for(int i=0;i<size;i++) {
			if(obj.equals(element[i])) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 删除指定位置的元素，并返回该元素
	 *@author ZSM
	 * @param index
	 * @return
	 * @throws Exception 
	 */
	public Object remove(int index) throws Exception {
		Object result = null;
		if(index >=size||index<0) {
			throw new Exception("IndexOutOfBoundException");
		}
		result = element[index];
		Object[] newElement = new Object[size-1];
		for(int i=0;i<newElement.length;i++) {
			newElement[i]=element[i];
			if(i>=index) {
				newElement[i]=element[i+1];
			}
		}
		
		
		element=newElement;
		size--;
		return result;
	}
	public boolean remove2(int index) {
		if(index>=size||index<0) {
			return false;
		}
		for(int i=index+1;i<size;i++) {
			element[i-1]=element[i];
		}
		size--;
		
		return true;
	}
	/**
	 * 动态数组扩容
	 *@author ZSM
	 * @param newCapacity
	 */
	private void resize(int newCapacity) {
		Object[] newData = new Object[newCapacity];
		for(int i=0;i<size;i++) {
			newData[i]=element[i];
		}
		element= newData;
	}
	
	public static void main(String[] args) {
		ArrayDemo<Object> demo = new ArrayDemo<Object>(10);
		
		
	}
}
