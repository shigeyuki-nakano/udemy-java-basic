package Ex1_14;

/*-< 演習：Ex1_14_2 >---------------------------------
コマンドライン引数から1つ以上の数値を受け取り、この1つ1つの数値を購入した商品の定価としたとき、
合計金額を求め、その金額に応じた値引きを利かせ、最後に消費税（8％とする）をのせた金額を表示するプログラムを作りたい。
mainメソッドの内容は書き換えずに処理が通るようなメソッドを仕様に従って書いてください。
----------------------------------------------------*/
public class Ex1_14_2 {

	//！！！mainメソッドの処理は書き換えないでください！！！
	public static void main (String[] aargs) {
		String[] args = {"1000", "1000", "2000", "1000", "1000"};

		int totalPrice = 0 ;                                 //購入した商品の合計金額
		
		//コマンドライン引数から購入した商品の合計金額（定価）を取得
		for(int i = 0 ; i < args.length ; i++ ){
			totalPrice += Integer.parseInt( args[i] );
		}
		
		//discountメソッドを使って値引きを適用し、値引き後の金額を取得
		int discountedPrice = discount( totalPrice );        //値引き後の金額
		
		//calcTaxPaymentメソッドを使って支払金額（税込）を取得
		int taxPayment = calcTaxPayment( discountedPrice );  //支払金額（税込）
		
		//支払金額（税込）を表示
		System.out.println("値引き後の支払金額：" + taxPayment + "円" );
		
	}
	
	
	/*
	**以下の仕様を持つメソッドcalcTaxPaymentを作成してください。
	**  - 引数として受け取った値の税込価格（消費税は8％とする）を計算して返す
	**  - 税込価格は整数（小数点以下切り捨て）で返す
	*/
	static int calcTaxPayment(int discountedPrice){        //アンダーバーを適切な内容に書き換えてください
		double TAX = 1.08;
		return (int) (discountedPrice * TAX);
	}
	
	
	/*
	**以下の仕様を持つメソッドdiscountを作成してください。
	**  - 引数として受け取った値が1000円以上5000円以下の場合、1000円より大きい分について10％割引にする
	**  - 引数として受け取った値が5000円より大きい場合、1000円より大きく5000円以下の分について10％割引、5000円より大きい分について20％割引にする
	**  - 値引き額は小数点以下切り捨てで計算する（キャストを使いましょう）
	**  - 割引金額の上限は5000円とする
	*/
	static int discount(int totalPrice){            //アンダーバーを適切な内容に書き換えてください
		final int DISCOUNT_BORDER1 = 1000;
		final int DISCOUNT_BORDER2 = 5000;
		final double DISCOUNT_RATE1 = 0.1;
		final double DISCOUNT_RATE2 = 0.2;
		final int DISCOUNT_MAX_PRICE = 5000;

		int discountPrice = 0;

		if(totalPrice >= DISCOUNT_BORDER1 && totalPrice <= DISCOUNT_BORDER2) {
			discountPrice = (int) ((totalPrice - DISCOUNT_BORDER1) * DISCOUNT_RATE1);
		} else if (totalPrice > DISCOUNT_BORDER2) {
			discountPrice = (int) (
					(DISCOUNT_BORDER2 * DISCOUNT_RATE1)
							+ ((totalPrice - DISCOUNT_BORDER2) * DISCOUNT_RATE2)
			);
		}

		if(discountPrice > DISCOUNT_MAX_PRICE) {
			discountPrice = DISCOUNT_MAX_PRICE;
		}

		return totalPrice - discountPrice;
	}
}
