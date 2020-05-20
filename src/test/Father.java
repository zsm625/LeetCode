package test;

/**
 * 测试重写方法的原则：
 * 
 * 返回类型必须完全与被重写方法的返回类型相同；
 * （备注:这条信息是标准的重写方法的规则,
 * 但是在java 1.5 版本之前返回类型必须一样,
 * 1.5(包含)j 版本之后ava放宽了限制,
 * 返回类型必须小于或者等于父类方法的返回类型 ）。
 * 才有了子类返回类型小于等于父类方法返回类型。
 * 在java里面这个怎么样都是正确。
 * @author ZSM
 *
 * @time 2019年10月8日上午9:06:51
 */
public abstract class Father {

	public abstract double testAbInt(int a);
	public int testInt(int a) {
		return a;
	}
}
