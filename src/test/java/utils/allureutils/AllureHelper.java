package utils.allureutils;

import aquality.selenium.browser.AqualityServices;
import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Attachment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class AllureHelper {

    //copyAllureCategories
    private static final String CATEGORIES_SOURCE_PATH = "src\\test\\resources\\categories.json";
    private static final String CATEGORIES_DESTINATION_PATH = "target\\allure-results\\categories.json";

    //allureEnvironmentWriter
    private static final String ALLURE_RESULTS_DIR = "/target/allure-results";
    private static final String ENVIRONMENT_PATH = "/target/allure-results/environment.xml";

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] attachScreenshot(){
        return AqualityServices.getBrowser().getScreenshot();
    }

    public static void copyAllureCategories(){

        File sourceFile = new File(CATEGORIES_SOURCE_PATH);
        File destinationFile = new File(CATEGORIES_DESTINATION_PATH);
        try {
            Files.copy(sourceFile.toPath(), destinationFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void allureEnvironmentWriter(ImmutableMap<String, String> environmentValuesSet)  {


        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            Element environment = doc.createElement("environment");
            doc.appendChild(environment);
            environmentValuesSet.forEach((k, v) -> {
                Element parameter = doc.createElement("parameter");
                Element key = doc.createElement("key");
                Element value = doc.createElement("value");
                key.appendChild(doc.createTextNode(k));
                value.appendChild(doc.createTextNode(v));
                parameter.appendChild(key);
                parameter.appendChild(value);
                environment.appendChild(parameter);
            });

            // Write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            File allureResultsDir = new File( System.getProperty("user.dir")
                    + ALLURE_RESULTS_DIR);
            if (!allureResultsDir.exists()) allureResultsDir.mkdirs();
            StreamResult result = new StreamResult(
                    new File( System.getProperty("user.dir")
                            + ENVIRONMENT_PATH));
            transformer.transform(source, result);
            AqualityServices.getLogger().info("Allure environment data saved.");
        } catch (ParserConfigurationException | TransformerException pce) {
            AqualityServices.getLogger().warn(pce.getMessage());
        }
    }
}