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

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] attachScreenshot(){
        return AqualityServices.getBrowser().getScreenshot();
    }

    public static void copyAllureCategories(){
        String sourcePath = "src\\test\\resources\\categories.json";
        String destinationPath = "target\\allure-results\\categories.json";

        File destinationFile = new File(destinationPath);
        File sourceFile = new File(sourcePath);
        try {
            Files.copy(sourceFile.toPath(), destinationFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void allureEnvironmentWriter(ImmutableMap<String, String> environmentValuesSet)  {
        String allureResultsDirPath = "/target/allure-results";
        String destinationPath = "/target/allure-results/environment.xml";

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
                    + allureResultsDirPath);
            if (!allureResultsDir.exists()) allureResultsDir.mkdirs();
            StreamResult result = new StreamResult(
                    new File( System.getProperty("user.dir")
                            + destinationPath));
            transformer.transform(source, result);
            AqualityServices.getLogger().info("Allure environment data saved.");
        } catch (ParserConfigurationException | TransformerException pce) {
            AqualityServices.getLogger().warn(pce.getMessage());
        }
    }


    public static void allureEnvironmentWriter(ImmutableMap<String, String> environmentValuesSet,
                                               String customResultsPath)  {
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

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            File allureResultsDir = new File(customResultsPath);
            if (!allureResultsDir.exists()) allureResultsDir.mkdirs();
            StreamResult result = new StreamResult(
                    new File( customResultsPath + "environment.xml"));
            transformer.transform(source, result);
            AqualityServices.getLogger().info("Allure environment data saved.");
        } catch (ParserConfigurationException | TransformerException pce) {
            AqualityServices.getLogger().warn(pce.getMessage());
        }
    }
}