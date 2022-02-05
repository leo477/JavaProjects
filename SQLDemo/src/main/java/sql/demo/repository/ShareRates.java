package sql.demo.repository;

import java.sql.SQLException;

public class ShareRates extends BaseTable implements TableOperations{

    public ShareRates() throws SQLException {
        super("share_rates");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS share_rates(" +
                "id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                "operDate DATETIME NOT NULL," +
                "share_id  BIGINT NOT NULL," +
                "rate DECIMAL (8,2) NOT NULL)","Созданная таблица " + getTableName());
    }

    @Override
    public void createForeignKeys() throws SQLException {
        super.executeSqlStatement("ALTER TABLE share_rates ADD FOREIGN KEY (share_id) REFERENCES shares(id)","share_rates foreign key" + getTableName());
    }
}
