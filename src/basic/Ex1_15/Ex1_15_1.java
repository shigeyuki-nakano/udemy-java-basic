package basic.Ex1_15;

/*-< 演習：Ex1_15_1 >---------------------------------
BigDecimalの扱いについてAPIドキュメントなどで調べながら
以下の結果が表示されるプログラムを作ってみましょう！
----------------------------------------------------*/
import java.math.BigDecimal;
import java.math.RoundingMode;

class Ex1_15_1{
	public static void main (String[] args) {
		
		//(1) 0.2 * 83 - 10.6
		question1();
		
		
		//(2) 0.2 * 83 - 10.6 / 3　※小数第4位までで表示（小数第5位以下は四捨五入）
		//<補足>
		// BigDecimalによる割り算は丸めの指定が必要です！
		// XXX ÷ YYYをして小数第2位で表示（小数第3位以下は切り捨て）
		// XXX.divide(YYY, 2, RoundingMode.DOWN);
		question2();

	}

	private static void question1() {
		//(1) 0.2 * 83 - 10.6
		BigDecimal b1 = new BigDecimal("0.2");
		BigDecimal b2 = new BigDecimal("83");
		BigDecimal b3 = new BigDecimal("10.6");

		BigDecimal result1 = b1.multiply(b2).subtract(b3);

		System.out.println(result1);
	}

	private static void question2() {
		//(2) 0.2 * 83 - 10.6 / 3　※小数第4位までで表示（小数第5位以下は四捨五入）
		//<補足>
		// BigDecimalによる割り算は丸めの指定が必要です！
		// XXX ÷ YYYをして小数第2位で表示（小数第3位以下は切り捨て）
		// XXX.divide(YYY, 2, RoundingMode.DOWN);

		BigDecimal b1 = BigDecimal.valueOf(0.2);
		BigDecimal b2 = BigDecimal.valueOf(83);
		BigDecimal b3 = BigDecimal.valueOf(10.6);
		BigDecimal b4 = BigDecimal.valueOf(3);

		BigDecimal result = b1.multiply(b2).subtract(b3.divide(b4, 4, RoundingMode.CEILING));

		System.out.println(result);
	}
}
