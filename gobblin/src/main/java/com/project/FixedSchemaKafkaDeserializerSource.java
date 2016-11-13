package com.project;

import gobblin.source.extractor.extract.kafka.*;

import java.io.IOException;
import gobblin.configuration.WorkUnitState;
import gobblin.source.extractor.Extractor;

public class FixedSchemaKafkaDeserializerSource extends gobblin.source.extractor.extract.kafka.KafkaSource<Object, Object> {

  @Override
  public Extractor<Object, Object> getExtractor(WorkUnitState state) throws IOException {
    try {
      return new FixedSchemaKafkaDeserializerExtractor(state);
    } catch (ReflectiveOperationException e) {
      throw new RuntimeException(e);
    }
  }
}
