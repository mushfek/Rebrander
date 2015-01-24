package net.therap.rebrander.filehandler;

import net.therap.rebrander.customexceptions.RebrandingExceptions;
import org.w3c.dom.Document;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * @author mushfekur
 * @since Date: 9/26/13, Time: 9:14 AM
 */
public class XmlFileHandler implements FileHandler {
    private String filePath;
    private File file;
    private Document document;
    private Transformer transformer;

    public XmlFileHandler(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void loadFile() {
        try {
            File file = new File(filePath);
            this.file = file;
        } catch (Exception e) {
            new RebrandingExceptions("Exception while file loading." + e);
        }
    }

    @Override
    public void backupExistingFile() {
        File sourceFile = this.file;
        FileChannel sourceFileChannel = null;
        try {
            sourceFileChannel = new FileInputStream(sourceFile).getChannel();
        } catch (Exception e) {
            new RebrandingExceptions("Exception while opening source file channel." + e);
        }

        String sourceFileName = sourceFile.getAbsolutePath();
        String backupFileName = changeFileNameExtension(sourceFileName);

        try {
            File backupFile = new File(backupFileName);
            FileChannel backupFileChannel = new FileOutputStream(backupFile).getChannel();
            backupFileChannel.transferFrom(sourceFileChannel, 0, sourceFileChannel.size());
        } catch (Exception e) {
            new RebrandingExceptions("Exception while copying source file data." + e);
        }
    }

    private String changeFileNameExtension(String fileName) {
        int extensionLength = 4; // including dot (.)
        int beginIndex = 0;
        int endIndex = fileName.length() - extensionLength;
        String fileNameWithoutExtension = fileName.substring(beginIndex, endIndex);

        String backupFileExtension = ".bak";
        String backupFileName = fileNameWithoutExtension.concat(backupFileExtension);
        return backupFileName;
    }

    @Override
    public void writeFileToDisk() {
        createNewTransformer();
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(file);
        try {
            transformer.transform(domSource, streamResult);
        } catch (Exception e) {
            new RebrandingExceptions("Exception while writing file to disk." + e);
        }
    }

    private void createNewTransformer() {
        TransformerFactory tFactory = TransformerFactory.newInstance();
        try {
            transformer = tFactory.newTransformer();
        } catch (Exception e) {
            new RebrandingExceptions("Exception while creating new Transformer." + e);
        }
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
