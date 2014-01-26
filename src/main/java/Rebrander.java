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
        Map<String, Object> sampleMap = new HashMap<String, Object>();

        sampleMap.put("dipto", "me");
        sampleMap.put("dipto2", true);
        sampleMap.put("dipto3", 0);
        Integer i = 5;
        sampleMap.put("dipto4", i);

        for (Map.Entry<String, Object> it : sampleMap.entrySet()) {
            System.out.println(it.getKey() + " " + it.getValue());
        }

//        modelMap.put("sample", sampleMap);

//        modelMap = new HashMap<String, Object>();
//        modelMap.put("simple", sampleMap);

//        integerSet.add(null);
//        integerSet.add(null);

//        for (Integer l : integerSet) {
//            System.out.println(l.intValue());
//        }


//        String targetDirectoryPath = args[0];
//
//        /* filtered file listing */
//        System.out.println("Listing .xml and .xsl files...");
//        List<String> extensionList = new ArrayList<String>();
//        extensionList.add(".xml");
//        extensionList.add(".xsl");
//
//        FilteredDirectoryCrawler fdCrawler = new FilteredDirectoryCrawler(targetDirectoryPath, extensionList);
//        List<File> filteredFilesList = fdCrawler.getFilteredFilesList();
//        for (File file : filteredFilesList) {
//            System.out.println(file);
//        }
//        System.out.println();
//
//        /* parsing and replacing 'Java' with 'Oracle Java' */
//        rebrandFiles(filteredFilesList);
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