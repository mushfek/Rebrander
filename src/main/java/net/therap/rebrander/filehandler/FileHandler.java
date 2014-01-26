package net.therap.rebrander.filehandler;

/**
 * Created with IntelliJ IDEA.
 * User: mushfekur
 * Date: 9/26/13
 * Time: 9:29 AM
 * To change this template use File | Settings | File Templates.
 */

public interface FileHandler {
    void loadFile();

    void backupExistingFile();

    void writeFileToDisk();
}
