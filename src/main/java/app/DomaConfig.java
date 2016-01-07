package app;

import java.util.logging.Level;

import javax.sql.DataSource;

import org.seasar.doma.SingletonConfig;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.JdbcLogger;
import org.seasar.doma.jdbc.UtilLoggingJdbcLogger;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.H2Dialect;
import org.seasar.doma.jdbc.tx.LocalTransactionDataSource;
import org.seasar.doma.jdbc.tx.LocalTransactionManager;
import org.seasar.doma.jdbc.tx.TransactionManager;

@SingletonConfig
public class DomaConfig implements Config {

    private static final DomaConfig SINGLETON = new DomaConfig();

    private final LocalTransactionDataSource dataSource;

    private final H2Dialect dialect = new H2Dialect();

    private final JdbcLogger jdbcLogger = new UtilLoggingJdbcLogger(
            Level.CONFIG);

    private DomaConfig() {
        this.dataSource = new LocalTransactionDataSource(
                "jdbc:h2:mem:sample;DB_CLOSE_DELAY=-1", "sa", "secret");
    }

    @Override
    public DataSource getDataSource() {
        return dataSource;
    }

    @Override
    public Dialect getDialect() {
        return dialect;
    }

    @Override
    public JdbcLogger getJdbcLogger() {
        return jdbcLogger;
    }

    @Override
    public TransactionManager getTransactionManager() {
        return new LocalTransactionManager(
                dataSource.getLocalTransaction(getJdbcLogger()));
    }

    public static DomaConfig singleton() {
        return SINGLETON;
    }
}
