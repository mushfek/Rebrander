package net.therap.rebrander.parser;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

/**
 * @author mushfekur
 * @since Date: 9/26/13, Time: 9:14 AM
 */
public class XmlRebrander extends XmlParsingHandler {
    public XmlRebrander(String filePath) {
        super(filePath);
    }

    public void traverseNodes() {
        super.setDocumentBuilder();
        super.setDocument();
        if (super.getXmlFileHandler().getDocument().hasChildNodes()) {
            NodeList nodeList = super.getXmlFileHandler().getDocument().getChildNodes();
            visitChildNodes(nodeList);
        }
    }

    private void visitChildNodes(NodeList nodeList) {
        for (int nodeIndex = 0; nodeIndex < nodeList.getLength(); nodeIndex++) {
            Node currentNode = nodeList.item(nodeIndex);
            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                if (currentNode.hasAttributes()) {
                    updateAttributeValue(currentNode);
                }
                if (currentNode.hasChildNodes()) {
                    visitChildNodes(currentNode.getChildNodes());
                }
            } else if (currentNode.getNodeType() == Node.TEXT_NODE) {
                currentNode.setTextContent(replaceJavaWithOracleJava(currentNode.getTextContent()));
            }
        }
    }

    private void updateAttributeValue(Node node) {
        NamedNodeMap nodeMap = node.getAttributes();
        for (int attrIndex = 0; attrIndex < nodeMap.getLength(); attrIndex++) {
            Node attrNode = nodeMap.item(attrIndex);
            if (attrNode.getNodeName().equalsIgnoreCase("title")) {
                attrNode.setNodeValue(replaceJavaWithOracleJava(attrNode.getNodeValue()));
            }
        }
    }

    private String replaceJavaWithOracleJava(String textToBeModified) {
        return textToBeModified.replaceAll("((Oracle)(\\s*)Java)|Java", "Oracle Java");
    }
}
