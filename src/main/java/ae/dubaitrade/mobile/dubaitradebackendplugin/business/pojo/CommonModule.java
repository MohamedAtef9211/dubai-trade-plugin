package ae.dubaitrade.mobile.dubaitradebackendplugin.business.pojo;

import ae.dubaitrade.mobile.dubaitradebackendplugin.base.PluginConst;

public class CommonModule extends Module {

    private static final String MODULE_PACKAGE = "client-commons/common-module/";
    private static final String DTO_PACKAGE = PluginConst.Packages.BASE_PACKAGE + ".dtos";
    private static final String DTO_DIRECTORY = MODULE_PACKAGE + MAIN_PACKAGE_PATH + BASE_DIRECTORY + "dtos";
    private static final String SERVICE_PACKAGE = PluginConst.Packages.BASE_PACKAGE + ".services";
    private static final String SERVICE_DIRECTORY = MODULE_PACKAGE + MAIN_PACKAGE_PATH + BASE_DIRECTORY + "services";
    private static final String CONTROLLER_PACKAGE = PluginConst.Packages.BASE_PACKAGE + ".controllers";
    private static final String CONTROLLER_DIRECTORY = MODULE_PACKAGE + MAIN_PACKAGE_PATH + BASE_DIRECTORY + "controllers";
    private static final String MOCKOON_DIRECTORY = MODULE_PACKAGE + RESOURCE_PACKAGE_PATH + "mockoon/";
    private static final String APP_PROPERTIES_PATH = MODULE_PACKAGE + RESOURCE_PACKAGE_PATH + "application-aws.properties";
    private static final String BASE_CONTROLLER_CLASS_NAME = "MobileController";

    public CommonModule() {
        super(MODULE_PACKAGE, DTO_PACKAGE, DTO_DIRECTORY, SERVICE_PACKAGE,
                SERVICE_DIRECTORY, CONTROLLER_PACKAGE, CONTROLLER_DIRECTORY,
                MOCKOON_DIRECTORY, APP_PROPERTIES_PATH,BASE_CONTROLLER_CLASS_NAME);
    }
    @Override
    public String getAppPath(){
        return MODULE_PACKAGE + MAIN_PACKAGE_PATH;
    }

}
