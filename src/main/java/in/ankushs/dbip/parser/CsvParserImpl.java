package in.ankushs.dbip.parser;

import java.util.Arrays;
import java.util.Optional;

import in.ankushs.dbip.utils.PreConditions;

public final class CsvParserImpl implements CsvParser {

    public static CsvParserImpl parser = null;

    private CsvParserImpl() {
    }

    public static CsvParserImpl getInstance() {
        return Optional.ofNullable(parser).orElse(new CsvParserImpl());
    }

    @Override
    public String[] parseRecord(final String csvRecord) {
        PreConditions.checkEmptyString(csvRecord, "null or empty csvRecord was passed");

        return Arrays.stream(csvRecord.split(","))
                .map(str -> str.replace("\"", "").trim())
                .toArray(String[]::new);
    }

}
