package office66;

/**
 * 空格替换
 * @author ZSM
 *
 * @time 2020年3月17日下午7:25:35
 */
public class ReplaceSpace {

	public String replaceSpace(String s) {
		if(s==null || s.length()==0) {
			return s;
		}
		int size=0;
		char[] arr = new char[s.length()*3];
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)==' ') {
				arr[size++]='%';
				arr[size++]='2';
				arr[size++]='0';
			}else {
			arr[size++]=s.charAt(i);
			}
		}
		return new String(arr,0,size);
	}
	public static void main(String[] args) {
		ReplaceSpace space = new ReplaceSpace();
		String string = space.replaceSpace("   ");
		System.out.println(string);
	}
}
