package com.spaceinvaders;

import java.io.*;

public class RecordsManager {
    private String file_name;
    private String path;
    private File file;

    public RecordsManager(String file_name, String path) {
        this.file_name = file_name;
        this.path = "src/" + path + "/resources/";
    }

    public String getFileName(){
        return "";
    }

    public String getFilePath(){
        return "";
    }

    public File getFile(){
        return file;
    }

    public void createFile(){

    }
}
