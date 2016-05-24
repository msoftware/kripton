package com.abubusoft.kripton.processor.test04primary_key;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.abubusoft.kripton.android.KriptonLibrary;
import com.abubusoft.kripton.android.sqlite.AbstractBindDatabaseHelper;
import java.lang.Override;
import java.lang.String;

public class BindDummy01Database extends AbstractBindDatabaseHelper implements BindDummy01DaoFactory {
  private static BindDummy01Database instance;

  public static final String name = "dummy";

  public static final int version = 1;

  protected BindDaoBean01 daoBean01 = new BindDaoBean01();

  protected BindDummy01Database(Context context) {
    super(context, name, null, version);
  }

  public BindDaoBean01 getDaoBean01() {
    daoBean01.setDatabase(getWritableDatabase());
    return daoBean01;
  }

  @Override
  public BindDaoBean01 getDaoBean01(SQLiteDatabase database) {
    daoBean01.setDatabase(database);
    return daoBean01;
  }

  public void execute(BindDummy01DatabaseTransactionExecutor executor) {
    SQLiteDatabase database=getWritableDatabase();
    try {
      database.beginTransaction();
      if (executor!=null && executor.onExecute(this, database)) {
        database.setTransactionSuccessful();
      }
    } catch(Throwable e) {
    } finally {
      database.endTransaction();
    }
  }

  /**
   *
   * instance
   */
  public static BindDummy01Database instance() {
    if (instance==null) {
      instance=new BindDummy01Database(KriptonLibrary.context);
    }
    return instance;
  }

  /**
   *
   * onCreate
   *
   */
  @Override
  public void onCreate(SQLiteDatabase database) {
    database.execSQL(Bean01Table.CREATE_TABLE_SQL);
  }

  /**
   *
   * onUpgrade
   */
  @Override
  public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
    // drop tables
    database.execSQL(Bean01Table.DROP_TABLE_SQL);

    // generate tables
    database.execSQL(Bean01Table.CREATE_TABLE_SQL);
  }

  public interface BindDummy01DatabaseTransactionExecutor extends TransactionExecutor<BindDummy01DaoFactory> {
  }
}