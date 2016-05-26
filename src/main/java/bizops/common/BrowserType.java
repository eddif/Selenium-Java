package bizops.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Eddi Fey on 5/18/2016.
 */

public enum BrowserType {
    FIREFOX,
    IE,
    CHROME,
    OPERA,
    HTMLUNIT;

    private static Map<String, BrowserType> browsersMap = new HashMap<String, BrowserType>();

    static {
        browsersMap.put("firefox", BrowserType.FIREFOX);
        browsersMap.put("ie", BrowserType.IE);
        browsersMap.put("chrome", BrowserType.CHROME);
        browsersMap.put("opera", BrowserType.OPERA);
        browsersMap.put("htmlunit", BrowserType.HTMLUNIT);
    }

    public static BrowserType Browser(String name) {
        BrowserType browserType = browsersMap.get(name.toLowerCase().trim());
//        if (browserType == null) {
//            throw new UnknownBrowserException("Unknown browser [" + name + "]. Use one of following: "
//                    + StringUtils.join(browsersMap.keySet().toArray(), ", "));
//        }
        return browserType;
    }
}
