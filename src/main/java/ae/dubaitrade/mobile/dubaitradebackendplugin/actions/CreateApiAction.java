package ae.dubaitrade.mobile.dubaitradebackendplugin.actions;

import ae.dubaitrade.mobile.dubaitradebackendplugin.business.dialog.DubaiTradeMocksDialog;
import ae.dubaitrade.mobile.dubaitradebackendplugin.business.pojo.DubaiTradePath;
import ae.dubaitrade.mobile.dubaitradebackendplugin.business.pojo.Module;
import ae.dubaitrade.mobile.dubaitradebackendplugin.business.service.DubaiTradeService;
import ae.dubaitrade.mobile.dubaitradebackendplugin.business.validation.ValidateMock;
import ae.dubaitrade.mobile.dubaitradebackendplugin.business.validation.ValidateMockImpl;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

public class CreateApiAction extends AnAction {

    private final ValidateMock validateMock = new ValidateMockImpl();
    DubaiTradeService dubaiTradeService = new DubaiTradeService();
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {

        DubaiTradeMocksDialog dialog = new DubaiTradeMocksDialog();
        dialog.show();

        if (dialog.isOK()) {
            String validateMockRequest = validateMock.validateMockRequest(dialog);
            if(validateMockRequest != null){
                Messages.showMessageDialog(e.getProject(), validateMockRequest , "Validation Error" , Messages.getErrorIcon());
                return;
            }

            Module module = dialog.getModule();
            DubaiTradePath dubaiTradePath = new DubaiTradePath(dialog.getName(),dialog.getURL(),module);

            try {
                dubaiTradeService.addDubaiTradeClasses(e.getProject(),dubaiTradePath, module ,dialog);
                dubaiTradeService.createJsonFile(e.getProject(),dubaiTradePath, module,dialog.getResponseText());
                dubaiTradeService.appendLinesToApplicationProperties(e.getProject(),dubaiTradePath, module);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            dialog.close(0);
        }
    }

    /**
     * This method used for rendering action on Directory only
     * @param e Carries information on AnActionEvent
     */
    @Override
    public void update(@NotNull AnActionEvent e) {
        VirtualFile file = e.getData(CommonDataKeys.VIRTUAL_FILE);
        boolean visible = file != null && file.isDirectory();
        e.getPresentation().setEnabledAndVisible(visible);
    }
}
