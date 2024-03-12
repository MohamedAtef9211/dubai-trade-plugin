package ae.dubaitrade.mobile.dubaitradebackendplugin.business.pojo;

public abstract class Module {
    public static final String MAIN_PACKAGE_PATH = "src/main/java/";
    public static final String RESOURCE_PACKAGE_PATH = "src/main/resources/";
    public static final String BASE_DIRECTORY = "ae/dubaitrade/mobile/";
    private String modulePackage;
    private String dtoPackage;
    private String dtoDirectory;
    private String servicePackage;
    private String serviceDirectory;
    private String controllerPackage;
    private String controllerDirectory;
    private String mockoonDirectory;
    private String appPropertiesPath;
    private String controllerBaseClassName;

    public Module(String modulePackage, String dtoPackage, String dtoDirectory, String servicePackage, String serviceDirectory, String controllerPackage, String controllerDirectory, String mockoonDirectory, String appPropertiesPath, String controllerBaseClassName) {
        this.modulePackage = modulePackage;
        this.dtoPackage = dtoPackage;
        this.dtoDirectory = dtoDirectory;
        this.servicePackage = servicePackage;
        this.serviceDirectory = serviceDirectory;
        this.controllerPackage = controllerPackage;
        this.controllerDirectory = controllerDirectory;
        this.mockoonDirectory = mockoonDirectory;
        this.appPropertiesPath = appPropertiesPath;
        this.controllerBaseClassName = controllerBaseClassName;
    }

    public String getModulePackage() {
        return modulePackage;
    }

    public String getDtoPackage() {
        return dtoPackage;
    }

    public String getServicePackage() {
        return servicePackage;
    }

    public String getControllerPackage() {
        return controllerPackage;
    }

    public String getDtoDirectory() {
        return dtoDirectory;
    }

    public String getServiceDirectory() {
        return serviceDirectory;
    }

    public String getControllerDirectory() {
        return controllerDirectory;
    }

    public String getMockoonDirectory() {
        return mockoonDirectory;
    }

    public String getAppPropertiesPath() {
        return appPropertiesPath;
    }

    public String getControllerBaseClassName() {
        return controllerBaseClassName;
    }

    public abstract String getAppPath();
}
