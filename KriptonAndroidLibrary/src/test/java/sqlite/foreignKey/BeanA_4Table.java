package sqlite.foreignKey;

import java.lang.String;

/**
 * <p>
 * Entity <code>BeanA_4</code> is associated to table <code>bean_a_4</code>
 * This class represents table associated to entity.
 * </p>
 *  @see BeanA_4
 */
public class BeanA_4Table {
  /**
   * Costant represents name of table bean_a_4
   */
  public static final String TABLE_NAME = "bean_a_4";

  /**
   * <p>
   * DDL to create table bean_a_4
   * </p>
   *
   * <pre>CREATE TABLE bean_a_4 (id INTEGER PRIMARY KEY AUTOINCREMENT, bean_a2_id INTEGER NOT NULL, value_string TEXT, FOREIGN KEY(bean_a2_id) REFERENCES bean_a_3(pk));</pre>
   */
  public static final String CREATE_TABLE_SQL = "CREATE TABLE bean_a_4 (id INTEGER PRIMARY KEY AUTOINCREMENT, bean_a2_id INTEGER NOT NULL, value_string TEXT, FOREIGN KEY(bean_a2_id) REFERENCES bean_a_3(pk));";

  /**
   * <p>
   * DDL to drop table bean_a_4
   * </p>
   *
   * <pre>DROP TABLE IF EXISTS bean_a_4;</pre>
   */
  public static final String DROP_TABLE_SQL = "DROP TABLE IF EXISTS bean_a_4;";

  /**
   * Entity's property <code>id</code> is associated to table column <code>id</code>. This costant represents column name.
   *
   *  @see BeanA_4#id
   */
  public static final String COLUMN_ID = "id";

  /**
   * Entity's property <code>beanA2Id</code> is associated to table column <code>bean_a2_id</code>. This costant represents column name.
   *
   *  @see BeanA_4#beanA2Id
   */
  public static final String COLUMN_BEAN_A2_ID = "bean_a2_id";

  /**
   * Entity's property <code>valueString</code> is associated to table column <code>value_string</code>. This costant represents column name.
   *
   *  @see BeanA_4#valueString
   */
  public static final String COLUMN_VALUE_STRING = "value_string";
}
