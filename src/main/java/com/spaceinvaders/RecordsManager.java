package com.spaceinvaders;

import java.io.*;
import java.util.*;

public class RecordsManager {
    private String file_name;
    private String path;
    private File file;
    private Map<String, Integer> times = new HashMap<>();
    List<Map.Entry<String, Integer>> list;


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

    public Scanner getScanner() throws FileNotFoundException {
        return new Scanner(getFile());
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

    public List<Map.Entry<String, Integer>> read() throws FileNotFoundException {
        Scanner sc = getScanner();
        sc.useDelimiter("\n");
        while(sc.hasNext()){
            update(sc.next(), Integer.valueOf(sc.next()));
        }
        list = new ArrayList<>(times.entrySet());
        return list;
    }

    public void write(String name, int time) {

    }

    public void update(String name, Integer time){
        if(times.containsKey(name)){
            if(times.get(name) > time){
                times.replace(name,time);
            }
        }
        else
            times.put(name,time);
    }


}
