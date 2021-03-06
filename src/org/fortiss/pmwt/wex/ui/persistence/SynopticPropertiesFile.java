/***************************************************************************
 * Copyright (c) 2016 the WESSBAS project
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
 ***************************************************************************/

package org.fortiss.pmwt.wex.ui.persistence;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.fortiss.pmwt.wex.ui.utils.FileUtils;

/**
 * Property file for synoptic.
 */

public class SynopticPropertiesFile extends AbstractProperties {
	private static final long serialVersionUID = 1L;

	public static final String EXPRESSION = "synoptic.expression";
	public static final String EXPRESSION_VALUE = "synoptic.expression.value";
	public static final String SEPARATOR = "synoptic.separator";
	public static final String SEPARATOR_VALUE = "synoptic.separator.value";
	public static final String DUMP_INVARIANTS = "synoptic.dumpinvariants";
	public static final String DUMP_INVARIANTS_VALUE = "synoptic.dumpinvariants.value";
	public static final String LOGFILE = "synoptic.logfile";

	/**
	 * Constructor.
	 */

	public SynopticPropertiesFile() {
		this.put(EXPRESSION, "-r");
		this.put(EXPRESSION_VALUE, "(?<TYPE>.*)");
		this.put(SEPARATOR, "-s");
		this.put(SEPARATOR_VALUE, "^---$");
		this.put(DUMP_INVARIANTS, "-i");
		this.put(DUMP_INVARIANTS_VALUE, "--dumpInvariants=false");
		this.put(LOGFILE, ""); // Source
	}

	/**
	 * Constructor.
	 * 
	 * @param properties
	 *            Untyped properties to read from.
	 */

	private SynopticPropertiesFile(Properties properties) {
		Iterator<Map.Entry<Object, Object>> iterator = properties.entrySet()
				.iterator();
		while (iterator.hasNext()) {
			Map.Entry<Object, Object> mapEntry = iterator.next();
			put(mapEntry.getKey(), mapEntry.getValue());
		}
	}

	/**
	 * Read property file of certain type.
	 * 
	 * @param fInputFile
	 *            Property file to be read.
	 * @return A synoptic property file instance.
	 * @throws IOException
	 *             Occurs, when something unexpected happens.
	 */

	public static SynopticPropertiesFile read(File fInputFile)
			throws IOException {
		return new SynopticPropertiesFile(
				FileUtils.restoreProperties(fInputFile));
	}
}
