package com.spaceinvaders;

import java.io.*;

public class RecordsManager {
    private String file_name;
    private String path;
    private File file;

    public RecordsManager(String file_name, String path) {
        this.file_name = file_name;
        this.path = "src/" + path + "/resources/";
        createFile();
    }

    public String getFileName(){
        return getFile().getName();
    }

    public String getFilePath(){
        return getFile().getPath();
    }

    public File getFile(){
        return file;
    }

    public void createFile() {
        file = new File(path + file_name);
        try {
            if (new File(path + file_name).createNewFile()) {
                System.out.println("File created.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
