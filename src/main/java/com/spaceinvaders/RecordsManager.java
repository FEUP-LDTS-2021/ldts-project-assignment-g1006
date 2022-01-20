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

    public List<Map.Entry<String, Integer>> read(int number) throws FileNotFoundException {
        Scanner sc = getScanner();
        sc.useDelimiter("\n");
        while(sc.hasNext()){
            update(sc.next(), Integer.valueOf(sc.next()));
        }
        sort();
        return list;
    }

    public void sort(){
        list = new ArrayList<>(times.entrySet());
        list.sort(Map.Entry.comparingByValue());
    }

    public void write(String name, int time) throws FileNotFoundException {
        update(name,time);
        read(10);
        try {
            FileWriter myWriter = new FileWriter(path + file_name);
            BufferedWriter bufferedWriter = new BufferedWriter(myWriter);
            for(Map.Entry<String,Integer> pair : list){
                bufferedWriter.write(pair.getKey() + '\n');
                bufferedWriter.write(String.valueOf(pair.getValue()) + '\n');
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
