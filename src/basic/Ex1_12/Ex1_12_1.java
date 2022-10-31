package basic.Ex1_12;

/*-< 演習：Ex1_12_1 >---------------------------------
コマンドライン引数から数値を1つ受け取り、これをテストの点数とします。

(1)以下のプログラムを作成してください。
  - 点数が0～100以外の数字だった場合「不正な点数です！」と表示する

(2)以下の機能を(1)のプログラムに追加してください。
  - 点数が0～59の数字だった場合「赤点です！」と表示する
  - 点数が60～79の数字だった場合「普通です！」と表示する
  - 点数が80～100の数字だった場合「優秀です！」と表示する

(3)以下の機能を(1)(2)のプログラムに追加してください。
  - 点数の数字が100だった場合のみ「満点だったので宿題免除です！！」と最後に表示する
----------------------------------------------------*/
class Ex1_12_1 {
	public static void main (String[] args) {
		try {
			int input = Integer.parseInt(args[0]);

			String result = judge(input);

			System.out.println(result);
			if(input == 100) {
				System.out.println("満点だったので宿題免除です！！");
			}
		} catch(Exception e) {
			System.out.println("不正な点数です！");
		}
	}

	private static String judge(int point)
			throws IllegalArgumentException {
		if(point >= 0 && point < 60) {
			return "赤点です！";
		} else if (point >= 60 && point < 80) {
			return "普通です！";
		} else if(point >= 80 && point <= 100) {
			return "優秀です！";
		} else {
			throw new IllegalArgumentException("不正な値が指定されました。: " + point);
		}
	}
}
