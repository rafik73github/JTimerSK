package pl.timersk;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.File;
import java.io.IOException;

public class XML {


    public XML() throws IOException {
    }

    public void createXML() {

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
        } catch (ParserConfigurationException parserConfigurationException) {
            parserConfigurationException.printStackTrace();
        }
        assert dBuilder != null;
        Document doc = dBuilder.newDocument();

        //root
        Element rootElement = doc.createElement("cars");
        doc.appendChild(rootElement);

        // supercars element
        Element supercar = doc.createElement("supercars");
        rootElement.appendChild(supercar);

        //setting attribute to element
        Attr attr = doc.createAttribute("company");
        attr.setValue("Ferrari");
        supercar.setAttributeNode(attr);

        //carname element
        Element carname = doc.createElement("carname");
        Attr attrType = doc.createAttribute("type");
        attrType.setValue("formula one");
        carname.setAttributeNode(attrType);
        carname.appendChild((doc.createTextNode("Ferrari 101")));
        supercar.appendChild(carname);

        Element carname1 = doc.createElement("carname");
        Attr attrType1 = doc.createAttribute("type");
        attrType1.setValue("sports");
        carname1.setAttributeNode(attrType1);
        carname1.appendChild((doc.createTextNode("Ferrari 202")));
        supercar.appendChild(carname1);

        // write a content into xml file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
        try {
            transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        } catch (TransformerConfigurationException transformerConfigurationException) {
            transformerConfigurationException.printStackTrace();
        }
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("D:\\cars.xml"));
        try {
            assert transformer != null;
            transformer.transform(source, result);
        } catch (TransformerException transformerException) {
            transformerException.printStackTrace();
        }

        // Output to console for testing
        StreamResult consoleResult = new StreamResult(System.out);
        try {
            transformer.transform(source, consoleResult);
        } catch (TransformerException transformerException) {
            transformerException.printStackTrace();
        }

    }


}
