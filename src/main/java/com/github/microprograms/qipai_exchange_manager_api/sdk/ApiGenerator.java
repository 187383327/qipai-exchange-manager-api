package com.github.microprograms.qipai_exchange_manager_api.sdk;

import java.io.IOException;

import com.github.microprograms.micro_api_sdk.model.EngineDefinition;
import com.github.microprograms.micro_api_sdk.utils.ApiDocumentUtils;
import com.github.microprograms.micro_api_sdk.utils.ApiEngineGeneratorUtils;

public class ApiGenerator {
    public static void main(String[] args) throws IOException {
        String srcFolder = "src/main/java";
        EngineDefinition engineDefinition = ApiEngineGeneratorUtils.buildEngineDefinition("design/qipai-exchange-manager-api.json");
        ApiEngineGeneratorUtils.updateApiJavaFiles(srcFolder, engineDefinition);
        ApiEngineGeneratorUtils.deleteUnusedApiJavaFiles(srcFolder, engineDefinition);
        ApiEngineGeneratorUtils.updateErrorCodeJavaFile(srcFolder, engineDefinition);
        ApiDocumentUtils.writeApiHtmlDocumentFile("doc", engineDefinition);
    }
}
