package ae.dubaitrade.mobile.dubaitradebackendplugin.utils;

import ae.dubaitrade.mobile.dubaitradebackendplugin.base.DubaiTradeTemplates;
import ae.dubaitrade.mobile.dubaitradebackendplugin.business.pojo.DubaiTradePath;
import ae.dubaitrade.mobile.dubaitradebackendplugin.business.pojo.Module;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class DubaiTradeFileUtils {

    private final DubaiTradeTemplates dubaiTradeTemplates = new DubaiTradeTemplates();

    public void createJsonFile(Project project, DubaiTradePath dubaiTradePath, Module module,String responseBody) throws IOException {
        VirtualFile sourceRoot = LocalFileSystem.getInstance().findFileByPath(project.getBasePath());
        if (sourceRoot == null) {
            return;
        }

        // Get the package path and create directories if needed
        String packagePath = module.getMockoonDirectory();
        VirtualFile packageDir = createPackageDirectories(sourceRoot,packagePath);
        if (packageDir == null) {
            return;
        }

        // Create the file name
        String fileName = StringUtils.toSnakeCase(dubaiTradePath.getServiceName()) + ".json";
        // Create the file under the package directory
        VirtualFile file = packageDir.createChildData(this, fileName);
        file.setBinaryContent(responseBody.getBytes());

        // Refresh the project to see the new file
        sourceRoot.refresh(false, true);
    }
//    public void buildAndCreateDTO(Project project, DubaiTradePath dubaiTradePath, Module module,String requestBody) throws IOException {
//        VirtualFile sourceRoot = LocalFileSystem.getInstance().findFileByPath(project.getBasePath());
//        if (sourceRoot == null) {
//            return;
//        }
//
//        // Get the package path and create directories if needed
//        String packagePath = module.getDtoDirectory() + "/" + dubaiTradePath.getServiceName().toLowerCase();
//        VirtualFile packageDir = createPackageDirectories(sourceRoot,packagePath);
//        if (packageDir == null) {
//            return;
//        }
//
//        // Create the file name
//        String fileName = dubaiTradePath.getDtoClassName() + ".java";
//
//        // Create the file content from the template
//        String content = dubaiTradeTemplates.dtoTemplate
//                .replace("{PACKAGE}", dubaiTradePath.getDtoPackage() + "." + dubaiTradePath.getServiceName().toLowerCase())
//                .replace("{CLASS_NAME}", dubaiTradePath.getDtoClassName());
//
//        // Create the file under the package directory
//        VirtualFile file = packageDir.createChildData(this, fileName);
//        file.setBinaryContent(content.getBytes());
//
//        // Refresh the project to see the new file
//        sourceRoot.refresh(false, true);
//    }

    public void buildAndCreateDTO(Project project, DubaiTradePath dubaiTradePath, Module module,String requestBody) throws IOException {
        JsonUtils.convertJsonToJavaClass(requestBody,new File(project.getBasePath() + "/" + module.getAppPath() ),module.getDtoPackage() + "." + dubaiTradePath.getServiceName().toLowerCase(),dubaiTradePath.getDtoClassName());
    }

    public void buildAndCreateService(Project project, DubaiTradePath dubaiTradePath, Module module) throws IOException {
        VirtualFile sourceRoot = LocalFileSystem.getInstance().findFileByPath(project.getBasePath());
        if (sourceRoot == null) {
            return;
        }

        // Get the package path and create directories if needed
        String packagePath = module.getServiceDirectory() + "/" + dubaiTradePath.getServiceName().toLowerCase();
        VirtualFile packageDir = createPackageDirectories(sourceRoot,packagePath);
        if (packageDir == null) {
            return;
        }

        // Create the file name
        String fileName = dubaiTradePath.getServiceClassName() + ".java";

        // Create the file content from the template
        String content = dubaiTradeTemplates.serviceTemplate
                .replace("{PACKAGE}", dubaiTradePath.getServicePackage() + "." + dubaiTradePath.getServiceName().toLowerCase()) // Convert to Java package format
                .replace("{IMPORT_REQUEST_DTO}", dubaiTradePath.getDtoPackage()  + "." + dubaiTradePath.getServiceName().toLowerCase() + "." + dubaiTradePath.getDtoClassName()) // Example import
                .replace("{CLASS_NAME}", dubaiTradePath.getServiceClassName())
                .replace("{REQUEST_TYPE}", dubaiTradePath.getDtoClassName()) // Example request type
                .replace("{URL_PROPERTY}", dubaiTradePath.getMockName()); // Example URL property

        // Create the file under the package directory
        VirtualFile file = packageDir.createChildData(this, fileName);
        file.setBinaryContent(content.getBytes());

        // Refresh the project to see the new file
        sourceRoot.refresh(false, true);
    }

    public void buildAndCreateController(Project project, DubaiTradePath dubaiTradePath, Module module) throws IOException {
        VirtualFile sourceRoot = LocalFileSystem.getInstance().findFileByPath(project.getBasePath());
        if (sourceRoot == null) {
            return;
        }

        // Get the package path and create directories if needed
        String packagePath = module.getControllerDirectory();
        VirtualFile packageDir = createPackageDirectories(sourceRoot,packagePath);
        if (packageDir == null) {
            return;
        }

        // Create the file name
        String fileName = dubaiTradePath.getControllerClassName() + ".java";

        // Create the file content from the template
        String content = dubaiTradeTemplates.controllerTemplate
                .replace("{PACKAGE}", dubaiTradePath.getControllerPackage())
                .replace("{IMPORT_REQUEST_DTO}", dubaiTradePath.getDtoPackage() + "." + dubaiTradePath.getServiceName().toLowerCase() + "." +dubaiTradePath.getDtoClassName()) // Example import
                .replace("{IMPORT_SERVICE}", dubaiTradePath.getServicePackage() + "." + dubaiTradePath.getServiceName().toLowerCase() + "." + dubaiTradePath.getServiceClassName()) // Example import
                .replace("{CLASS_NAME}", dubaiTradePath.getControllerClassName())
                .replace("{CONTROLLER_BASE_CLASS}", module.getControllerBaseClassName())
                .replace("{SERVICE_CLASS}", dubaiTradePath.getServiceClassName())
                .replace("{SERVICE_OBJECT}", StringUtils.toCamelCase(dubaiTradePath.getServiceClassName(),false))
                .replace("{ENDPOINT}", dubaiTradePath.getMockValue())
                .replace("{METHOD_NAME}", StringUtils.toCamelCase(dubaiTradePath.getServiceName(),false))
                .replace("{REQUEST_CLASS}", dubaiTradePath.getDtoClassName()); // Example URL property

        // Create the file under the package directory
        VirtualFile file = packageDir.createChildData(this, fileName);
        file.setBinaryContent(content.getBytes());

        // Refresh the project to see the new file
        sourceRoot.refresh(false, true);
    }

    public void appendLinesToApplicationProperties(Project project, DubaiTradePath dubaiTradePath,Module module) {
        WriteCommandAction.runWriteCommandAction(project, () -> {
            VirtualFile applicationPropertiesFile = findApplicationPropertiesFile(project,module.getAppPropertiesPath());
            if (applicationPropertiesFile != null) {
                try {
                    PsiFile psiFile = PsiManager.getInstance(project).findFile(applicationPropertiesFile);
                    if (psiFile != null) {
                        PsiDocumentManager.getInstance(project).doPostponedOperationsAndUnblockDocument(psiFile.getViewProvider().getDocument());

                        // Append the new lines to the end of the file
                        psiFile.navigate(true);
                        psiFile.getContainingFile().getViewProvider().getDocument().
                                insertString(psiFile.getContainingFile().getViewProvider().getDocument().getTextLength(),
                                        "\n" + dubaiTradePath.getMockName() + "=" + dubaiTradePath.getMockValue());

                        PsiDocumentManager.getInstance(project).commitDocument(psiFile.getViewProvider().getDocument());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private VirtualFile findApplicationPropertiesFile(Project project , String applicationPropertiesPath) {
        String path = project.getBasePath() + "/" +applicationPropertiesPath;
        return LocalFileSystem.getInstance().findFileByIoFile(Paths.get(path).toFile());
    }
    private VirtualFile createPackageDirectories(VirtualFile sourceRoot, String packagePath) {
        String[] packageNames = packagePath.split("/");
        VirtualFile currentDir = sourceRoot;
        for (String packageName : packageNames) {
            VirtualFile child = currentDir.findChild(packageName);
            if (child == null) {
                try {
                    child = currentDir.createChildDirectory(this, packageName);
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
            currentDir = child;
        }
        return currentDir;
    }

}
