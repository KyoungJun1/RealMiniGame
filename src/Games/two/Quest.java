package Games.two;

import java.util.StringTokenizer;

public class Quest {

	private String a[] = new String[2];
	private String b[] = new String[2];
	private String c[] = new String[2];
	private String d[] = new String[2];
	private String e[] = new String[2];
	private String f[] = new String[2];

	public Quest() {
		// 가로문제
		a[0] = "다정하고 금실이 좋은 부부를 비유적으로 이르는 말";
		a[1] = "잉꼬부부";

		b[0] = "분홍색을 영어로 하면?";
		b[1] = "핑크";

		c[0] = "병의 상태나 형세";
		c[1] = "병세";

		// 세로 문제
		d[0] = "임부와 산부를 이르는 말 ";
		d[1] = "임산부";

		e[0] = "잉크를 담아두는 병";
		e[1] = "잉크";

		f[0] = "부과금과 같은 말";
		f[1] = "부금";

	}

	public String[] getA() {
		return a;
	}

	public String[] getB() {
		return b;
	}

	public String[] getC() {
		return c;
	}

	public String[] getD() {
		return d;
	}

	public String[] getE() {
		return e;
	}

	public String[] getF() {
		return f;
	}

}
