package default_package;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// equal()与==的区别
		Integer a = new Integer(3);
		Integer b = new Integer(3);
		System.out.println(a == b);
		System.out.println(a.equals(b));

		String c = "abc";
		String d = "abc";
		System.out.println(c == d);
		String e = new String("abc");
		System.out.println(c == e);
		System.out.println(c.equals(e));
	}

}
