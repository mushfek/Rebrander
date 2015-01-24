package net.therap.rebrander.crawler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mushfekur
 * @since Date: 9/26/13, Time: 9:14 AM
 */
public class FilteredDirectoryCrawler extends DirectoryCrawler {
    private String rootDirectoryPath;
    private List<String> acceptedExtensionList;

    public FilteredDirectoryCrawler(String rootDirectoryPath, List<String> extensionList) {
        super(rootDirectoryPath);
        setAcceptedExtensionList(extensionList);
    }

    public List<File> getFilteredFilesList() {
        List<File> fileList = super.getFilesList();
        List<File> filteredFileList = new ArrayList<File>();
        for (File file : fileList) {
            if (isAcceptableExtension(file)) {
                filteredFileList.add(file);
            }
        }
        return filteredFileList;
    }

    private boolean isAcceptableExtension(File file) {
        for (String extension : getAcceptedExtensionList()) {
            String fileName = file.getName();
            if (fileName.toLowerCase().endsWith(extension)) {
                return true;
            }
        }
        return false;
    }

    public String getRootDirectoryPath() {
        return rootDirectoryPath;
    }

    public void setRootDirectoryPath(String rootDirectoryPath) {
        this.rootDirectoryPath = rootDirectoryPath;
    }

    public List<String> getAcceptedExtensionList() {
        return acceptedExtensionList;
    }

    public void setAcceptedExtensionList(List<String> acceptedExtensionList) {
        this.acceptedExtensionList = acceptedExtensionList;
    }
}
