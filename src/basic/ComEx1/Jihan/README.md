# 総合演習
自動販売機に投入された硬貨の合計金額を表示するプログラムを作成してみましょう!<br>
ソースコードを作成し、デバッグを繰り返しながら完成を目指しましょう。

## 要件
- 投入された「10円玉」「50円玉」「100円玉」「500円玉」の合計金額を以下のように表示する 
  - 「 ただいまの投入金額は(合計金額の値)円です 」
- 「1円玉」「5円玉」が投入された場合は合計金額に含めず、「警告:1円玉は使えません」「警告:5円玉は使えません」と警告する 
- 硬貨としてふさわしくない値は合計金額に含めず、「警告:(入力された値)は硬貨として適切な値ではありません」と警告する 
  - 例)入力値777 → 「警告:777は硬貨として適切な値ではありません」
- 最後に入力された数値が商品の値段となる。

## 使用例
```bash
$ java ComEx1.Jihan.Main 10 100 500 600
ただいまの投入金額は610円です
ありがとうございました。お釣りは10円です。

$ java ComEx1.Jihan.Main 1 15 100 500 700
警告:1円玉は使えません
警告:15は硬貨として適切な値ではありません
ただいまの投入金額は600円です
投入金額が不足しています。最初からやり直してください。
```