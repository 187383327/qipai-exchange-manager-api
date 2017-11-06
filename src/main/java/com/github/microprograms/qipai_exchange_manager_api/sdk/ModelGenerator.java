package com.github.microprograms.qipai_exchange_manager_api.sdk;

import com.github.microprograms.micro_relational_data_model_sdk.model.ModelerDefinition;
import com.github.microprograms.micro_relational_data_model_sdk.utils.IgniteDatabaseGeneratorUtils;
import com.github.microprograms.micro_relational_data_model_sdk.utils.ModelDocumentUtils;
import com.github.microprograms.micro_relational_data_model_sdk.utils.ModelGeneratorUtils;

public class ModelGenerator {
    public static void main(String[] args) throws Exception {
        String srcFolder = "src/main/java";
        ModelerDefinition modelerDefinition = ModelGeneratorUtils.buildModelerDefinition("design/model.json");
        ModelGeneratorUtils.deleteModelJavaFiles(srcFolder, modelerDefinition);
        ModelGeneratorUtils.createModelJavaFiles(srcFolder, modelerDefinition);
        IgniteDatabaseGeneratorUtils.deleteTables(modelerDefinition);
        IgniteDatabaseGeneratorUtils.createTables(modelerDefinition);
        ModelDocumentUtils.writeHtmlDocumentFile("doc", modelerDefinition);
    }
}
