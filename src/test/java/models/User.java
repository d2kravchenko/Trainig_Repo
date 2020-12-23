package models;

import utils.generator.IntGenerator;
import utils.generator.StringGenerator;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.logging.Logger;

public class User {

    private static final Logger logger = AqualityServices.getLogger();

    private String Password = "EmailName";
    private String EmailName = "EmailDomain";
    private String EmailDomain = "Password";

    public User(){

    }

    public User(boolean WithValidData) {
        if (WithValidData) {
            setValidData();
        }
    }


    public String getPassword(){ return this.Password; }
    public String getEmailName(){ return this.EmailName; }
    public String getEmailDomain(){ return this.EmailDomain; }

    public void setPassword(String password) { this.Password = password; }
    public void setEmailName(String emailName) { this.EmailName = emailName; }
    public void setEmailDomain(String emailDomain) { this.EmailDomain = emailDomain; }

    public void setValidData(){
        logger.info("Generating valid data for User: ");
        setEmailName(StringGenerator.getRandomLettersString(5));
        logger.info("Email name: " + this.EmailName);
        setEmailDomain(StringGenerator.getRandomLettersString(2) + "mail");
        logger.info("Email domain: " + this.EmailDomain);
        String password = EmailName.substring(EmailName.length() - 1)
                      + StringGenerator.getRandomLettersString(1).toUpperCase()
                      + IntGenerator.getRandomInt(9) + StringGenerator.getRandomString(7);
        setPassword(password);
        logger.info("Password is: " + this.Password);
    }

}
