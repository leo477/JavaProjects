package sql.demo.repository;

import java.sql.SQLException;

public class TraidersActions extends BaseTable implements TableOperations{

    public TraidersActions() throws SQLException {
        super("traidersActions");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS traidersActions(" +
                "id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                "operation INTEGER NOT NULL," +
                "traider_id  INTEGER NOT NULL," +
                "share_rate_id BIGINT NOT NULL," +
                "amount LONG NOT NULL)","Созданная таблица " + getTableName());
    }

    @Override
    public void createForeignKeys() throws SQLException {
        super.executeSqlStatement("ALTER TABLE traidersActions ADD FOREIGN KEY (share_rate_id) REFERENCES share_rates(id)","share_rates foreign key" + getTableName());
    }
}
