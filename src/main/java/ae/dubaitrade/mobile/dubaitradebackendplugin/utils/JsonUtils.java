package ae.dubaitrade.mobile.dubaitradebackendplugin.utils;

import ae.dubaitrade.mobile.dubaitradebackendplugin.config.DefaultGenerationConfigImpl;
import org.jsonschema2pojo.*;
import org.jsonschema2pojo.rules.RuleFactory;
import org.json.JSONObject;
import com.sun.codemodel.JCodeModel;
import java.io.File;
import java.io.IOException;

public class JsonUtils {
    public static boolean isValidJson(String json) {
        try {
            new JSONObject(json);
            return true;
        } catch (Exception e) {
            System.err.println("Invalid JSON: " + e.getMessage());
            return false;
        }
    }

//    public void convertJsonToJavaClass(URL inputJsonUrl, File outputJavaClassDirectory, String packageName, String javaClassName) throws IOException {
//        JCodeModel jcodeModel = new JCodeModel();
//
//        GenerationConfig config = new DefaultGenerationConfig() {
//            @Override
//            public boolean isGenerateBuilders() {
//                return true;
//            }
//
//            @Override
//            public SourceType getSourceType() {
//                return SourceType.JSON;
//            }
//        };
//
//        SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new Jackson2Annotator(config), new SchemaStore()), new SchemaGenerator());
//        mapper.generate(jcodeModel, javaClassName, packageName, inputJsonUrl);
//
//        jcodeModel.build(outputJavaClassDirectory);
//    }

    public static void convertJsonToJavaClass(String inputJsonUrl, File outputJavaClassDirectory, String packageName, String javaClassName) throws IOException {
        JCodeModel jcodeModel = new JCodeModel();

        GenerationConfig config = new DefaultGenerationConfigImpl();

        SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new AbstractAnnotator() {}, new SchemaStore()), new SchemaGenerator());
        mapper.generate(jcodeModel, javaClassName, packageName, inputJsonUrl);

        jcodeModel.build(outputJavaClassDirectory);
    }

    public static void main(String[] args) {
        String inputJsonUrl = "{\n" +
                "    \"requestContext\": {\n" +
                "        \"sourceSystem\": \"DUBAITRADE\",\n" +
                "        \"sourceObject\": \"DTMobile\",\n" +
                "        \"customerCode\": \"A180\",\n" +
                "        \"customerType\": \"A\",\n" +
                "        \"txnUserName\": \"mhs006\",\n" +
                "        \"transactionDate\": \"2023-07-25T13:02:00Z\",\n" +
                "        \"email\": \"dummy@test.com\"\n" +
                "    },\n" +
                "    \"transactionId\": 8200170265,\n" +
                "    \"reportType\": \"eReceipt\",\n" +
                "    \"reprintFlag\": true\n" +
                "}\n";
        File outputJavaClassDirectory = new File("E:\\WorkingOn\\jsonschema2pojo");
        String packageName = "com.example.generated";
        String javaClassName = "GeneratedClass";

        try {
            convertJsonToJavaClass(inputJsonUrl, outputJavaClassDirectory, packageName, javaClassName);
            System.out.println("Java classes generated successfully!");
        } catch (IOException e) {
            System.err.println("Error generating Java classes: " + e.getMessage());
        }
    }


}
