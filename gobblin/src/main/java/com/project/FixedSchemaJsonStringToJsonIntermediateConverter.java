package com.project;

import gobblin.configuration.WorkUnitState;
import gobblin.converter.Converter;
import gobblin.converter.DataConversionException;
import gobblin.converter.SchemaConversionException;
import gobblin.converter.SingleRecordIterable;

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class FixedSchemaJsonStringToJsonIntermediateConverter extends gobblin.converter.json.JsonStringToJsonIntermediateConverter {
  @Override
  public Iterable<JsonObject> convertRecord(JsonArray outputSchema, String strInputRecord, WorkUnitState workUnit) throws DataConversionException {
    JsonParser jsonParser = new JsonParser();
    JsonObject outputRecord = (JsonObject) jsonParser.parse(strInputRecord);
    return new SingleRecordIterable<JsonObject>(outputRecord);
  }
}
