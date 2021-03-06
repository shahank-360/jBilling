package com.jbilling.test;

import java.util.HashMap;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jbilling.framework.globals.Logger;
import com.jbilling.framework.pageclasses.GlobalEnumsPage.PageConfigurationItems;
import com.jbilling.framework.testrails.TestRailsListener;
import com.jbilling.framework.utilities.browserutils.BrowserApp;
import com.jbilling.framework.utilities.xmlutils.ConfigPropertiesReader;

@Listeners({ TestRailsListener.class })
@Test(groups = { "automation" })
public class VerifyPluginsNotVisibleWithoutPermissions extends BrowserApp {
	private static Logger logger = new Logger().getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	ConfigPropertiesReader pr = new ConfigPropertiesReader();
	ITestResult result;

	HashMap<String, String> runTimeVariables = new HashMap<String, String>();

	@Test(description = "TC 03 : Verify, Plug-ins are not visible for users without permission")
	public void TC03_EditViewPluginPermissionForUser() throws Exception {

		logger.enterMethod();
		Reporter.log("<br> Test Begins");

		this.result = Reporter.getCurrentTestResult();
		this.result.setAttribute("tcid", "");

		this.confPage = this.navPage.navigateToConfigurationPage();
		logger.debug("Navigate to Configuration Page");

		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.Users);
		logger.debug("Select Users from Configuration list");

		this.confPage = this.confPage.removeUserPluginPermission("pluginPermissions", "pp");
		logger.debug("Remove Plugin Permissions for User");

		this.loginPage = this.navPage.logoutApplication();
		logger.debug("Logout From The Application");

		this.runTimeVariables.put("ENVIRONMENT_UNDER_TEST", this.pr.readConfig("EnvironmentUnderTest"));
		this.runTimeVariables.put("ENVIRONMENT_URL_UNDER_TEST",
				this.pr.readConfig(this.runTimeVariables.get("ENVIRONMENT_UNDER_TEST") + "_URL"));

		this.homePage = this.loginPage.login(this.runTimeVariables.get("ENVIRONMENT_UNDER_TEST"));
		logger.debug("Login Into Application");

		this.confPage = this.navPage.navigateToConfigurationPage();
		logger.debug("Login Into Application And Navigate to Configuration Page");

		this.confPage = this.confPage.selectConfiguration(PageConfigurationItems.Plugins);
		logger.debug("Select plugins from Configuration list");

		this.confPage = this.confPage.verifyDeniedPluginPermissionMessage("pluginPermissions", "pp");
		logger.debug("User Not Able To Access Plugins");

        this.navPage.navigateToConfigurationPage();
        this.confPage.selectConfiguration(PageConfigurationItems.Users);
        this.confPage.restoreUserPluginPermission("pluginPermissions", "pp");
        logger.debug("Remove Plugin Permissions for User");

		Reporter.log("<br> Test Passed");
		logger.exitMethod();
	}
}
