package tests.steps;

import aquality.appium.mobile.application.AqualityServices;
import screenobjects.loginscreenobjects.*;

public class LoginSteps {

    public static void login(String server, String email, String password) {

        LoginScreen loginScreen = new LoginScreen();
        loginScreen.clickLoginButton();
        ServerAddressScreen serverAddressScreen = new ServerAddressScreen();
        serverAddressScreen.EnterAndSubmitServerAddress(server);
        ServerPreLoginScreen serverPreLoginScreen = new ServerPreLoginScreen();
        serverPreLoginScreen.clickLoginButton();
        ServerLoginScreen serverLoginScreen = new ServerLoginScreen();
        serverLoginScreen.submitEmailAndPassword(email, password);
        AccountAccessScreen accountAccessScreen = new AccountAccessScreen();
        accountAccessScreen.clickGrantAccessButton();
        AqualityServices.getLogger().info("Logged on");
    }
}
