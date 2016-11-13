package com.project;

import gobblin.converter.avro.*;
import org.apache.avro.Schema;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import gobblin.converter.SchemaConversionException;
import gobblin.configuration.WorkUnitState;

public class FixedSchemaJsonIntermediateToAvroConverter extends gobblin.converter.avro.JsonIntermediateToAvroConverter {
  @Override
  public Schema convertSchema(JsonArray schema, WorkUnitState workUnit) throws SchemaConversionException {
    return Schema.parse(schema.get(0).toString());
  }
}
