package sqlite.quickstart.model;

import com.abubusoft.kripton.android.ColumnType;
import com.abubusoft.kripton.android.annotation.BindColumn;
import com.abubusoft.kripton.annotation.BindType;

/**
 * Created by xcesco on 12/01/2017.
 */
@BindType
public class Todo {

    @BindColumn(columnType = ColumnType.PRIMARY_KEY)
    public long id;

    public long userId;

    public String title;

    public boolean completed;
}
