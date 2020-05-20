package p10;
/**
 * 数值的整数次方
 * 给定一个double类型的浮点数base和int类型的整数exponent。
 * 求base的exponent次方。

 * @author ZSM
 *
 * @time 2019年10月6日上午10:54:06
 */
public class Power {
	public double power(double base,int exponent) {
		if(exponent ==0) {
			return 1;
		}
		if(exponent ==1) {
			return base;
		}
		boolean flag = false;
		if(exponent <0) {
			exponent = -exponent;
			flag = true;
		}
		int n=2;
		double temp = base;
		while(n <=exponent) {
			n++;
			base*=temp;
		}
		base = flag?1/base:base;
		
		return base;
	}
	public static void main(String[] args) {
		Power power = new Power();
		System.out.println(power.power(2.0, -2));
		
	}
	
	public double power2(double base ,int exponent) {
		if(exponent>0) {
			if(exponent==1) {
				return base;
			}
			if(exponent%2 ==0) {
				return power2(base,exponent/2)*power2(base,exponent/2);
			}else {
				return power2(base,exponent/2)*power2(base,exponent/2+1);
			}
		}else if(exponent==0) {
			return 1;
		}
		else if(exponent<0) {
			return 1/power2(base,0-exponent);
		}
		
		return 0;
	}
}
