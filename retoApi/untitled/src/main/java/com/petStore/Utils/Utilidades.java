package com.petStore.Utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.stream.JsonReader;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import static com.petStore.Utils.ConstantesProyecto.PROPERTIES_FILE;

public class Utilidades {

    public static String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    public static String readJsonFromClasspath(String fileName) {
        ClassLoader classLoader = JsonReader.class.getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(fileName);
             Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8.name())) {
            return scanner.useDelimiter("\\A").next();
        } catch (Exception e) {
            throw new RuntimeException("No se pudo leer el archivo JSON desde el classpath: " + fileName, e);
        }
    }

    public static String replaceVariablesBodyMap(String body, Map<String, String> values) {
        for (Map.Entry<String, String> entry : values.entrySet()){
            String placeholder = "{" + entry.getKey() + "}";
            String replacement = entry.getValue();
            if(replacement.equals(ConstantesProyecto.NULLCONSTANT)){replacement = "";}
            body = body.replace(placeholder, replacement);

        }
        return body;
    }

    public static String getProperty(String key) {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream(PROPERTIES_FILE)) {
            properties.load(input);
            return properties.getProperty(key);
        } catch (IOException e) {
            throw new RuntimeException("Error al leer serenity.properties", e);
        }
    }

    public static void setProperty(String key, String value) {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream(PROPERTIES_FILE)) {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Error al leer serenity.properties", e);
        }

        properties.setProperty(key, value);

        try (FileOutputStream output = new FileOutputStream(PROPERTIES_FILE)) {
            properties.store(output, "Actualizado por SerenityPropertiesManager");
        } catch (IOException e) {
            throw new RuntimeException("Error al escribir en serenity.properties", e);
        }
    }

    public static Long getIdFromJson(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(json);
            return rootNode.get("id").asLong();
        } catch (Exception e) {
            throw new RuntimeException("Error al procesar el JSON", e);
        }
    }
}
