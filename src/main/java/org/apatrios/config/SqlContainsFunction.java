package org.apatrios.config;

import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.spi.MetadataBuilderContributor;
import org.hibernate.dialect.function.SQLFunctionTemplate;

import static org.hibernate.type.StandardBasicTypes.BOOLEAN;

public class SqlContainsFunction implements MetadataBuilderContributor {

    @Override
    public void contribute(MetadataBuilder metadataBuilder) {
        metadataBuilder.applySqlFunction(
                "jsonb_array_contains_text",
                new SQLFunctionTemplate(BOOLEAN, """
                        EXISTS (
                            SELECT 1 FROM jsonb_array_elements_text(?1) AS elem
                            WHERE elem ILIKE concat('%', ?2, '%')
                        )
                        """));
    }
}