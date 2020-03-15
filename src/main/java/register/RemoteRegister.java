package register;

import framework.URL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoteRegister {
    private static Map<String, List<URL>> remoteRegisterList = new HashMap<String, List<URL>>();

    public static void regist(String interfaceName, URL url) {
        List<URL> urlList= remoteRegisterList.get(interfaceName);
        if (urlList == null) {
            urlList = new ArrayList<URL>();
        }
        urlList.add(url);
        remoteRegisterList.put(interfaceName, urlList);
    }

    public static List<URL> get(String interfaceName) {
        return remoteRegisterList.get(interfaceName);
    }
}
