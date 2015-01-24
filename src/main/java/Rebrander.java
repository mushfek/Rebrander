import net.therap.rebrander.crawler.FilteredDirectoryCrawler;
import net.therap.rebrander.parser.XmlRebrander;

import java.io.File;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: mushfekur
 * Date: 9/25/13
 * Time: 12:26 PM
 * To change this template use File | Settings | File Templates.
 */

public class Rebrander {
    public static void main(String[] args) {
        String name = "ddfjdlsfjd dlkfjdl";

        StringBuilder nameBuilder = new StringBuilder(name);

        String replacedName = nameBuilder.toString().replace('d', 'f');

        System.out.println(replacedName);
    }

    private static void rebrandFiles(List<File> filteredFilesList) {
        for (File file : filteredFilesList) {
            String filePath = file.getAbsolutePath();
            XmlRebrander xmlRebrander = new XmlRebrander(filePath);
            xmlRebrander.getXmlFileHandler().backupExistingFile();
            xmlRebrander.traverseNodes();
            xmlRebrander.getXmlFileHandler().writeFileToDisk();

            System.out.println("Rebrading complete: " + file.getName());
        }
    }
}