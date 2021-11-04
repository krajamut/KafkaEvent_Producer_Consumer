package com.kiruthika.pojoavro;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.avro.AvroFactory;
import com.fasterxml.jackson.dataformat.avro.AvroSchema;
import com.fasterxml.jackson.dataformat.avro.schema.AvroSchemaGenerator;
import com.kiruthika.pojoavro.model.Swipe;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PojoToAvroApplication {


    public static void main(String args[]) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new AvroFactory());
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        AvroSchemaGenerator gen = new AvroSchemaGenerator();
        mapper.acceptJsonFormatVisitor(Swipe.class, gen);
        AvroSchema schemaWrapper = gen.getGeneratedSchema();
        org.apache.avro.Schema avroSchema = schemaWrapper.getAvroSchema();
        String asJson = avroSchema.toString(true);
        System.out.println(asJson);

        Files.write(Paths.get("src/main/resources/Swipe.avro"), asJson.getBytes());

    }
}