package com.project;

import gobblin.source.extractor.extract.kafka.*;

import java.io.IOException;
import gobblin.configuration.WorkUnitState;
import java.util.Properties;

public class FixedSchemaKafkaDeserializerExtractor extends gobblin.source.extractor.extract.kafka.KafkaDeserializerExtractor {

  public static final String FIXED_JSON_SCHEMA = "project.avro.schema";

  private final String jsonSchema;

  public FixedSchemaKafkaDeserializerExtractor(WorkUnitState state) throws ReflectiveOperationException {
    super(state);
    this.jsonSchema = getJsonSchema(state.getProperties());
  }

  private String getJsonSchema(Properties props) {
    return props.getProperty(FIXED_JSON_SCHEMA, "NO_SCHEMA_FOUND_ERROR");
  }

  @Override
  public Object getSchema() {
    return this.jsonSchema;
  }

}
