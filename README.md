# Domaでimmutableなエンティティを使うサンプル

Domaで `immutable=true` なエンティティを使う場合、
自動生成される主キーにマッピングされたフィールドの扱いについて考えました。

`master` ブランチは最も単純なサンプルです。
`nextstep` ブランチは一歩だけ考えを進めたサンプルです。
順番に確認してみてください。

## 動かし方

次のコマンドでmainメソッドを実行します。

```
gradle bootRun
```

## SQLログを見たい場合

`DomaConfig.jdbcLogger` のインスタンス化時に渡している
`Level` を `INFO` に変更してください。

