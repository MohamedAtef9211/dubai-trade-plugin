package ae.dubaitrade.mobile.dubaitradebackendplugin.business.validation;

import ae.dubaitrade.mobile.dubaitradebackendplugin.business.dialog.DubaiTradeMocksDialog;
import ae.dubaitrade.mobile.dubaitradebackendplugin.utils.JsonUtils;
import org.apache.commons.lang.StringUtils;

public class ValidateMockImpl implements ValidateMock{
    @Override
    public String validateMockRequest(DubaiTradeMocksDialog dialog) {
        String request = dialog.getRequestText();
        String response = dialog.getResponseText();
        String name = dialog.getName();
        String url = dialog.getURL();


        if(StringUtils.isEmpty(url)){
            return "Please Enter value in URL field";
        }

        if(StringUtils.isEmpty(name)){
            return "Please Enter value in name field";
        }
        //TODO: Validate request
        if(!JsonUtils.isValidJson(request)){
            return "Request Body is not a valid json";
        }
        //TODO: Validate response
        if(!JsonUtils.isValidJson(response)){
            return "Response Body is not a valid json";
        }
        return null;
    }
}
