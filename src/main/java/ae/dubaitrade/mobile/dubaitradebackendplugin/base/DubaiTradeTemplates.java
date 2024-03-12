package ae.dubaitrade.mobile.dubaitradebackendplugin.base;

public class DubaiTradeTemplates {
    public String dtoTemplate = "package {PACKAGE};\n" +
            "\n" +
            "import lombok.Data;\n" +
            "\n" +
            "@Data\n" +
            "public class {CLASS_NAME} {\n" +
            "}";
    public String serviceTemplate =
            "package {PACKAGE};\n" +
                    "\n" +
                    "import {IMPORT_REQUEST_DTO};\n" +
                    "import ae.dubaitrade.mobile.services.base.BaseCommonServices;\n" +
                    "import org.springframework.beans.factory.annotation.Value;\n" +
                    "import org.springframework.stereotype.Service;\n" +
                    "\n" +
                    "@Service\n" +
                    "public class {CLASS_NAME} extends BaseCommonServices<{REQUEST_TYPE}, String> {\n" +
                    "\n" +
                    "    @Value(\"${{URL_PROPERTY}}\")\n" +
                    "    private String url;\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public String getServicePath() {\n" +
                    "        return url;\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public Class<String> getTypeParameterClass() {\n" +
                    "        return String.class;\n" +
                    "    }\n" +
                    "}\n";

    public String controllerTemplate =
            "package {PACKAGE};\n" +
                    "\n" +
                    "import {IMPORT_REQUEST_DTO};\n" +
                    "import {IMPORT_SERVICE};\n" +
                    "import lombok.RequiredArgsConstructor;\n" +
                    "import org.springframework.http.ResponseEntity;\n" +
                    "import org.springframework.web.bind.annotation.RequestBody;\n" +
                    "import org.springframework.web.bind.annotation.RequestMapping;\n" +
                    "import org.springframework.web.bind.annotation.RequestMethod;\n" +
                    "import org.springframework.web.bind.annotation.RestController;\n" +
                    "\n" +
                    "@RestController\n" +
                    "@RequiredArgsConstructor\n" +
                    "public class {CLASS_NAME} extends {CONTROLLER_BASE_CLASS}{\n" +
                    "\n" +
                    "    private final {SERVICE_CLASS} {SERVICE_OBJECT};\n" +
                    "\n" +
                    "    @RequestMapping(method = RequestMethod.POST , path = \"{ENDPOINT}\")\n" +
                    "    public ResponseEntity {METHOD_NAME} (@RequestBody  {REQUEST_CLASS} request)  {\n" +
                    "        return responseOk({SERVICE_OBJECT}.callService(request));\n" +
                    "    }\n" +
                    "}\n";
}
