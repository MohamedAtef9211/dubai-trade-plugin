package ae.dubaitrade.mobile.dubaitradebackendplugin.business.service;

import ae.dubaitrade.mobile.dubaitradebackendplugin.business.dialog.DubaiTradeMocksDialog;
import ae.dubaitrade.mobile.dubaitradebackendplugin.business.pojo.DubaiTradePath;
import ae.dubaitrade.mobile.dubaitradebackendplugin.business.pojo.Module;
import ae.dubaitrade.mobile.dubaitradebackendplugin.utils.DubaiTradeFileUtils;
import com.intellij.openapi.project.Project;

import java.io.IOException;

public class DubaiTradeService {

    private final DubaiTradeFileUtils dubaiTradeFileUtils = new DubaiTradeFileUtils();

    public void addDubaiTradeClasses(Project project, DubaiTradePath dubaiTradePath, Module module, DubaiTradeMocksDialog dialog) throws Exception {

        //dubaiTradeFileUtils.buildAndCreateDTO(project, dubaiTradePath, module);
        dubaiTradeFileUtils.buildAndCreateDTO(project, dubaiTradePath, module,dialog.getRequestText());
        dubaiTradeFileUtils.buildAndCreateService(project, dubaiTradePath, module);
        dubaiTradeFileUtils.buildAndCreateController(project, dubaiTradePath, module);

    }

    public void createJsonFile(Project project, DubaiTradePath dubaiTradePath, Module module, String responseBody) throws IOException {
        dubaiTradeFileUtils.createJsonFile(project, dubaiTradePath, module, responseBody);
    }

    public void appendLinesToApplicationProperties(Project project, DubaiTradePath dubaiTradePath, Module module) {
        dubaiTradeFileUtils.appendLinesToApplicationProperties(project,dubaiTradePath,module);
    }
}