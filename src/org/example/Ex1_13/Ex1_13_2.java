package org.example.Ex1_13;

/*-< 演習：Ex1_13_2 >---------------------------------
コマンドライン引数で受け取った整数（A型：1, B型：2, O型：3, AB型：4）に応じて、
以下の実行結果を表示するプログラムを作成してください。
ただし、switch文を必ず使用してください。

  (A型)が入力された場合 ："あなたは几帳面な性格の方ですね？"
  (B型)が入力された場合 ："あなたはマイペースな性格の方ですね？"
  (O型)が入力された場合 ："あなたは大雑把な性格ですね？"
  (AB型)が入力された場合："あなたは天才肌な方ですね？"
  上記以外              ："数字の1～4で答えてください"

----------------------------------------------------*/
public class Ex1_13_2 {
	public static void main (String[] args) {
		try {
			int input = Integer.parseInt(args[0]);

			BloodType bd = BloodType.getByInt(input);
			if(bd == null) {
				throw new IllegalArgumentException("数字の1～4で答えてください");
			}

			System.out.println(judge(bd));
		} catch (Exception e) {
			System.out.println("数字の1～4で答えてください");
		}
	}

	private static String judge(BloodType bd) {
		switch (bd) {
			case A:
				return "あなたは几帳面な性格の方ですね？";
			case B:
				return "あなたはマイペースな性格の方ですね？";
			case O:
				return "あなたは大雑把な性格ですね？";
			case AB:
				return "あなたは天才肌な方ですね？";
			default:
				throw new IllegalArgumentException("引数に不正なBloodTypeが指定されています");
		}
	}

	enum BloodType {
		A(1),
		B(2),
		O(3),
		AB(4);

		private final int id;

		BloodType(int id) {
			this.id = id;
		}

		public int getId() {
			return this.id;
		}

		public static BloodType getByInt(int id) {
			for(BloodType bd : BloodType.values()) {
				if(id == bd.getId()) {
					return bd;
				}
			}

			return null;
		}
	}
}

