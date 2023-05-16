package org.example.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.example.util.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConfigManager {
    private static ConfigManager myConfigManager;
    private static Config myCurrentConfig;

    private ConfigManager() {
    }

    public static ConfigManager getInstance(){
        if (myConfigManager==null)
            myConfigManager = new ConfigManager();
        return myConfigManager;
    }

    //загрузка
    public void loadConfigManager(String filePath) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            throw new HttpConfigException(e);
        }
        StringBuffer sb = new StringBuffer();
        int i;
        try {
            while ( (i = fileReader.read() ) != -1){
                sb.append((char)i);
            }
        } catch (IOException e){
            throw new HttpConfigException(e);
        }
        JsonNode conf = null;
        try {
            conf = json.parse(sb.toString());
        } catch (IOException e) {
            throw new HttpConfigException("Ошибка при передаче файла конфигурации", e);
        }
        try {
            myCurrentConfig = json.fromJson(conf, Config.class);
        } catch (JsonProcessingException e) {
            throw new HttpConfigException("Ошибка при передаче файла конфигурации являеться внутренним" ,e);
        }
    }

    //возвращаем текущуюю загружуную конфигурацию
    public Config getCurrentConfig(){
        if(myConfigManager==null){
            throw new HttpConfigException();
        }
        return myCurrentConfig;
    }
}
