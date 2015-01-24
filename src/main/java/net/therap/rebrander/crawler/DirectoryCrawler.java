package net.therap.rebrander.crawler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mushfekur
 * @since Date: 9/26/13, Time: 9:14 AM
 */
public class DirectoryCrawler implements Crawler {
    private String rootDirectoryPath;

    public DirectoryCrawler() {
    }

    public DirectoryCrawler(String rootDirectoryPath) {
        setRootDirectoryPath(rootDirectoryPath);
    }

    @Override
    public List<File> getFilesList() {
        List<File> filesList = new ArrayList<File>();
        File rootDirectory = getCurrentDirectory(getRootDirectoryPath());
        crawlRecursively(rootDirectory, filesList);
        return filesList;
    }

    private File getCurrentDirectory(String rootDirectoryPath) {
        File file = new File(rootDirectoryPath);
        return file;
    }

    private void crawlRecursively(File currentDirectory, List<File> fileList) {
        if (currentDirectory.isDirectory()) {
            for (File file : currentDirectory.listFiles()) {
                crawlRecursively(file, fileList);
            }
        } else if (currentDirectory.isFile()) {
            fileList.add(currentDirectory);
        }
    }

    public String getRootDirectoryPath() {
        return rootDirectoryPath;
    }

    public void setRootDirectoryPath(String rootDirectoryPath) {
        this.rootDirectoryPath = rootDirectoryPath;
    }
}
