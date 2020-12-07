import screenObjects.loginScreenObjects.*;
import aquality.appium.mobile.application.AqualityServices;
import com.google.common.collect.ImmutableMap;

public class Steps {

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

    public static void acceptFormWithScript(){
        AqualityServices.getApplication().getDriver().executeScript("mobile:performEditorAction", ImmutableMap.of("action", "done"));
    }
}
