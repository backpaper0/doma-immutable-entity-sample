package app;

import org.seasar.doma.jdbc.Result;
import org.seasar.doma.jdbc.tx.TransactionManager;

import app.dao.PersonDao;
import app.dao.PersonDaoImpl;
import app.entity.Person;

public class Main {

    public static void main(String[] args) {
        //ローカルトランザクション内で実行する
        TransactionManager transactionManager = DomaConfig.singleton()
                .getTransactionManager();
        transactionManager.required(Main::run);
    }

    static void run() {

        PersonDao dao = new PersonDaoImpl();
        dao.createTable(); //テーブルの準備

        //最初は id を渡さないコンストラクタでインスタンス化する。
        Person entity = new Person("うらがみ", 31);
        System.out.printf("A: %s%n", entity);

        //insert すると id が付与されたエンティティが返ってくる。
        Result<Person> inserted = dao.insert(entity);
        entity = inserted.getEntity();
        System.out.printf("B: %s%n", entity);

        //値を変更するときは id を渡すコンストラクタの代わりに
        //定義した、変更用メソッドを呼ぶ。
        entity = entity.update("たいち", entity.age + 1);
        System.out.printf("C: %s%n", entity);

        Result<Person> updated = dao.update(entity);
        entity = updated.getEntity();
        System.out.printf("D: %s%n", entity);
    }
}
