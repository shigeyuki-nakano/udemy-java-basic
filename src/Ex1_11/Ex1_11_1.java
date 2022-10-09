package Ex1_11;

/*-< 演習：Ex1_11_1 >---------------------------------
while文を使用して、6の目がでるまでサイコロを降り続けるプログラムを作成してください。
※1～6までのランダムなint型の値を取得する方法 ： 1 + (int)(Math.random() * 6.0)
※6の目が出たら「6が出たので終了します」と表示してください
----------------------------------------------------*/
class Ex1_11_1 {
	public static void main (String[] args) {
		System.out.println("6が出るまでサイコロを降り続けます。\n");

		int count = 0;
		while(true) {
			count++;
			int result = 1 + (int)(Math.random() * 6.0);

			System.out.printf("第%d目: %d\n", count, result);

			if(result == 6) {
				System.out.println("6が出たので終了します");
				return;
			}
		}
	}
}
