import net.therap.rebrander.filehandler.FileHandler;
import net.therap.rebrander.filehandler.XmlFileHandler;
import net.therap.rebrander.parser.XmlRebrander;

import java.io.File;
import java.util.List;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @author mushfekur
 * @since Date: 9/26/13, Time: 9:14 AM
 */
public class Rebrander {
    public static void main(String[] args) {
        String filePath = "resources/apache-demo.log";

        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String emailAddress = in.nextLine();

            System.out.println(isValidEmailAddress(emailAddress));
        }


//        modelMap.put("sample", sampleMap);

//        modelMap = new HashMap<String, Object>();
//        modelMap.put("simple", sampleMap);

//        integerSet.add(null);
//        integerSet.add(null);

//        for (Integer l : integerSet) {
//            System.out.println(l.intValue());
//        }

        FileHandler fileHandler = new XmlFileHandler(filePath);
    }

    public static boolean isValidEmailAddress(String email) {
        String ATOM = "[^\\x00-\\x1F^\\(^\\)^\\<^\\>^\\@^\\,^\\;^\\:^\\\\^\\\"^\\.^\\[^\\]^\\s]";
        String DOMAIN = "(" + ATOM + "+(\\." + ATOM + "+)*";
        String IP_DOMAIN = "\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\]";

        final Pattern emailPattern = Pattern.compile(
                "^" + ATOM + "+(\\." + ATOM + "+)*@"
                        + DOMAIN
                        + "|"
                        + IP_DOMAIN
                        + ")$",
                Pattern.CASE_INSENSITIVE
        );

        System.out.println("Email pattern: " + emailPattern);

        return emailPattern.matcher(email.trim()).matches();
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
