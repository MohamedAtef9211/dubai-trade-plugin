package ae.dubaitrade.mobile.dubaitradebackendplugin.business.pojo;

import ae.dubaitrade.mobile.dubaitradebackendplugin.base.PluginConst;
import ae.dubaitrade.mobile.dubaitradebackendplugin.utils.StringUtils;

public class DubaiTradePath {

    private String serviceName;
    private String mockValue;
    private String basePackage;
    private String dtoPackage;
    private String servicePackage;
    private String controllerPackage;
    private String mockName;
    private String dtoClassName;
    private String serviceClassName;
    private String controllerClassName;

    private Module module;

    public DubaiTradePath(String serviceName, String url, Module module) {
        this.serviceName = serviceName;
        this.mockValue = url;
        this.module = module;
        this.mockName = PluginConst.Packages.BASE_MOCK_KEY + StringUtils.toSnakeCase(serviceName);
        this.basePackage = PluginConst.Packages.BASE_PACKAGE;
        this.dtoPackage = module.getDtoPackage();
        this.servicePackage = module.getServicePackage();
        this.controllerPackage = module.getControllerPackage();
        String titleCase = serviceName.trim();
        this.dtoClassName = titleCase + PluginConst.Prefix.DTO_REQUEST_PREFIX;
        this.serviceClassName = titleCase + PluginConst.Prefix.SERVICE_PREFIX;
        this.controllerClassName = titleCase + PluginConst.Prefix.CONTROLLER_PREFIX;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getMockName() {
        return mockName;
    }

    public String getMockValue() {
        return mockValue;
    }

    public String getBasePackage() {
        return basePackage;
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

    public String getDtoClassName() {
        return dtoClassName;
    }

    public String getServiceClassName() {
        return serviceClassName;
    }

    public String getControllerClassName() {
        return controllerClassName;
    }
}
