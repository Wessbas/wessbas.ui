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

package org.fortiss.pmwt.wex.ui;

import java.awt.EventQueue;
import java.io.File;

import org.fortiss.pmwt.wex.ui.implementation.MainFrame;
import org.fortiss.pmwt.wex.ui.utils.PCMUtils;

/**
 * Main class for WESSBAS UI.
 */

public class MainUI implements Runnable {
	/**
	 * Path to project file.
	 */

	private File m_fProjectFile = null;

	/**
	 * Constructor.
	 * 
	 * @param fProjectFile
	 *            Path to project file.
	 */

	public MainUI(File fProjectFile) {
		this.m_fProjectFile = fProjectFile;
	}

	/**
	 * Main entry point for WESSBAS UI.
	 * 
	 * @param args
	 *            Command line arguments. None yet.
	 */

	public static void main(String args[]) {
		// -- Register factory for ECore
		PCMUtils.registerFactoryForECore();

		// --
		File fProjectFile = null;

		// Simple parameter handling -> <project file>
		if (args != null && args.length >= 1) {
			String strValue = args[0];

			File file = new File(strValue);
			if (file.exists() && file.isFile()) {
				fProjectFile = file;
			}
		}

		// -- Launch UI
		MainUI main = new MainUI(fProjectFile);
		EventQueue.invokeLater(main);
	}

	/**
	 * UI thread for the WESSBAS UI.
	 */

	@Override
	public void run() {
		MainFrame mainFrame = new MainFrame();
		if (this.m_fProjectFile != null) {
			mainFrame.openProject(this.m_fProjectFile);
		}

		mainFrame.setVisible(true);
	}
}