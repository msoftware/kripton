package sqlite.kripton84;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.abubusoft.kripton.android.KriptonLibrary;
import com.abubusoft.kripton.android.Logger;
import com.abubusoft.kripton.android.sqlite.AbstractDataSource;
import java.lang.Override;
import java.lang.String;

/**
 * <p>
 * Represents implementation of datasource Bean84ADataSource.
 * This class expose database interface through Dao attribute.
 * </p>
 *
 * @see Bean84ADataSource
 * @see BindBean84ADaoFactory
 * @see Bean84ADao
 * @see Bean84ADaoImpl
 * @see Bean84A
 */
public class BindBean84ADataSource extends AbstractDataSource implements BindBean84ADaoFactory, Bean84ADataSource {
  /**
   * <p><singleton of datasource,/p>
   */
  private static BindBean84ADataSource instance;

  /**
   * <p><file name used to save database,/p>
   */
  public static final String name = "dummy";

  /**
   * <p>database version</p>
   */
  public static final int version = 1;

  /**
   * <p>dao instance</p>
   */
  protected Bean84ADaoImpl bean84ADao = new Bean84ADaoImpl(this);

  protected BindBean84ADataSource(Context context) {
    super(context, name, null, version);
  }

  @Override
  public Bean84ADaoImpl getBean84ADao() {
    return bean84ADao;
  }

  /**
   * <p>executes a transaction. This method is synchronized to avoid concurrent problems. The database will be open in write mode.</p>
   *
   * @param transaction transaction to execute
   */
  public synchronized void execute(Transaction transaction) {
    SQLiteDatabase connection=openDatabase();
    try {
      connection.beginTransaction();
      if (transaction!=null && transaction.onExecute(this)) {
        connection.setTransactionSuccessful();
      }
    } finally {
      connection.endTransaction();
      close();
    }
  }

  /**
   * instance
   */
  public static synchronized BindBean84ADataSource instance() {
    if (instance==null) {
      instance=new BindBean84ADataSource(KriptonLibrary.context());
    }
    return instance;
  }

  /**
   * onCreate
   */
  @Override
  public void onCreate(SQLiteDatabase database) {
    // generate tables
    Logger.info("DDL: %s",Bean84ATable.CREATE_TABLE_SQL);
    database.execSQL(Bean84ATable.CREATE_TABLE_SQL);
  }

  /**
   * onUpgrade
   */
  @Override
  public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
    // drop tables
    Logger.info("DDL: %s",Bean84ATable.DROP_TABLE_SQL);
    database.execSQL(Bean84ATable.DROP_TABLE_SQL);

    // generate tables
    Logger.info("DDL: %s",Bean84ATable.CREATE_TABLE_SQL);
    database.execSQL(Bean84ATable.CREATE_TABLE_SQL);
  }

  /**
   * interface to define transactions
   */
  public interface Transaction extends AbstractTransaction<BindBean84ADaoFactory> {
  }
}