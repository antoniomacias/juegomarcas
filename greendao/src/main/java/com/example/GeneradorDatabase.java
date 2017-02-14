package com.example;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class GeneradorDatabase {
    public static void main(String args[]) {
        // Definimos el esquema de la base de datos
        // PARAM 1: códigeo de versión: 1, 2, 3, 4
        // PARAM 2: el nombre del paquete del módule app de Android
        // donde queremos volcar los POJOS y demás ficheros de la base de datos
        Schema schema = new Schema(1, "com.example.ammacias.juegomarcas.localdb");

        // Definimos las entidades (tablas) de la base de datos
        Entity marcaDB = schema.addEntity("MarcaDB");
        marcaDB.addIdProperty().autoincrement().primaryKey();
        marcaDB.addStringProperty("nombre").notNull();
        marcaDB.addIntProperty("nivel").notNull();
        marcaDB.addStringProperty("foto").notNull();
        marcaDB.addBooleanProperty("acertado").notNull();


        try {
            new DaoGenerator().generateAll(schema, "./app/src/main/java/");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
