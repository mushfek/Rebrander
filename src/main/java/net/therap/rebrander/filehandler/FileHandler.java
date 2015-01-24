package net.therap.rebrander.filehandler;

/**
 * @author mushfekur
 * @since Date: 9/26/13, Time: 9:14 AM
 */
public interface FileHandler {
    void loadFile();

    void backupExistingFile();

    void writeFileToDisk();
}
