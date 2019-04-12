package com.fux.afk.support.core;

import java.text.MessageFormat;

/**
 * Created by fuxj on 2019-3-15
 */
public class LocalSQLUtil {

    public static String generateLocalPageSQL(String sql, int page, int rows) {
        return LocalSQLUtil.getDBType().generatePageSQL(sql, page, rows);
    }

    static DBType getDBType() {
        return DBType.mysql;
    }

    public enum DBType {
        mysql {
            private static final String PAGE_SQL_TEMPLATE = " {0} limit {1,number,#},{2,number,#}";

            @Override
            public String generatePageSQL(String sql, int page, int rows) {
                return MessageFormat.format(PAGE_SQL_TEMPLATE, sql, (page - 1) * rows, rows);
            }

        };

        public abstract String generatePageSQL(String sql, int page, int rows);
    }

}
