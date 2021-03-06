/*******************************************************************************
 * Copyright 2015, 2017 Francesco Benincasa.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
/**
 * 
 */
package com.abubusoft.kripton.processor.exceptions;

import com.abubusoft.kripton.processor.sqlite.model.SQLEntity;

/**
 * @author Francesco Benincasa (abubusoft@gmail.com)
 *
 */
public class CircularRelationshipException extends KriptonProcessorException {

	public CircularRelationshipException(SQLEntity entity)
	{			
		super("Table definition "+entity.getTableName()+" is in a circular dependency");
	}
	
	private static final long serialVersionUID = -7836720045039133374L;

}
