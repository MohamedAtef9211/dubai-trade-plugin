package ae.dubaitrade.mobile.dubaitradebackendplugin.business.pojo;

import ae.dubaitrade.mobile.dubaitradebackendplugin.base.PluginConst;

public class DpWorldModule extends Module {

    private static final String MODULE_PACKAGE = "client-commons/dpworld-module/";
    private static final String DTO_PACKAGE = PluginConst.Packages.BASE_PACKAGE + ".dto";
    private static final String DTO_DIRECTORY = MODULE_PACKAGE + MAIN_PACKAGE_PATH + BASE_DIRECTORY + "dto";
    private static final String SERVICE_PACKAGE = PluginConst.Packages.BASE_PACKAGE + ".services";
    private static final String SERVICE_DIRECTORY = MODULE_PACKAGE + MAIN_PACKAGE_PATH + BASE_DIRECTORY + "services";
    private static final String CONTROLLER_PACKAGE = PluginConst.Packages.BASE_PACKAGE + ".controller";
    private static final String CONTROLLER_DIRECTORY = MODULE_PACKAGE + MAIN_PACKAGE_PATH + BASE_DIRECTORY + "controller";
    private static final String MOCKOON_DIRECTORY = MODULE_PACKAGE + RESOURCE_PACKAGE_PATH + "mockoon/";
    private static final String APP_PROPERTIES_PATH = MODULE_PACKAGE + RESOURCE_PACKAGE_PATH + "application-aws.properties";
    private static final String BASE_CONTROLLER_CLASS_NAME = "DPWorldController";

    public DpWorldModule() {
        super(MODULE_PACKAGE, DTO_PACKAGE, DTO_DIRECTORY, SERVICE_PACKAGE,
                SERVICE_DIRECTORY, CONTROLLER_PACKAGE, CONTROLLER_DIRECTORY,
                MOCKOON_DIRECTORY, APP_PROPERTIES_PATH,BASE_CONTROLLER_CLASS_NAME);
    }

}
