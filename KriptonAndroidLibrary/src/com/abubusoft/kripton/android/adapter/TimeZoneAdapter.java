package com.abubusoft.kripton.android.adapter;

import java.util.TimeZone;

import android.content.ContentValues;
import android.database.Cursor;

/**
 * Transformer between a string and a java.util.TimeZone object
 * 
 * @author bulldog
 *
 */
public class TimeZoneAdapter implements SqliteAdapter<TimeZone> {
	@Override
	public TimeZone readCursor(Cursor cursor, int columnIndex) throws Exception {
		return TimeZone.getTimeZone(cursor.getString(columnIndex));
	}

	@Override
	public void writeValue(TimeZone value, ContentValues content, String columnKey) throws Exception {
		content.put(columnKey, value.getID());
	}

}