package p10;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
 * 比如输入 3，则打印出 1、2、3 一直到最大的 3 位数即 999
 * @author ZSM
 *
 * @time 2019年10月6日下午3:15:43
 */
public class PrintUntilMaxNumber {
	public void print1ToMaxOfNDigits(int n) {
	    if (n <= 0)
	        return;
	    char[] number = new char[n];
	    print1ToMaxOfNDigits(number, 0);
	}

	private void print1ToMaxOfNDigits(char[] number, int digit) {
	    if (digit == number.length) {
	        printNumber(number);
	        return;
	    }
	    for (int i = 0; i < 10; i++) {
	        number[digit] = (char) (i + '0');
	        print1ToMaxOfNDigits(number, digit + 1);
	    }
	}

	private void printNumber(char[] number) {
	    int index = 0;
	    while (index < number.length && number[index] == '0')
	        index++;
	    while (index < number.length)
	        System.out.print(number[index++]);
	    System.out.println();
	}
	
	public static void main(String[] args) {
		PrintUntilMaxNumber number = new PrintUntilMaxNumber();
		number.print1ToMaxOfNDigits(3);
	}

	
}
