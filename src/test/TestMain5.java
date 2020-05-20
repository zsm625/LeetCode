package test;

public class TestMain5 extends HelloA {
	public TestMain5() {
	}

	{
		System.out.println("I’m B class");
	}
	static {
		System.out.println("static B");
	}

	public static void main(String[] args) {
		System.out.println("========");
		new TestMain5();
	}
}

class HelloA {
	public HelloA() {
	}

	{
		System.out.println("I’m A class");
	}
	static {
		System.out.println("static A");
	}
}
