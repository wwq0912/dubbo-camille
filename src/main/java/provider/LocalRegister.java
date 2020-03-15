package provider;

import java.util.HashMap;
import java.util.Map;

public class LocalRegister {
    // 这里存的是暴露出去接口的名字和实现类的关系。
    // 因为期待所有的线程都往一个map对象中存储对应关系，所以类型为static。
    private static Map<String, Class> registerList = new HashMap<String, Class>();

    public static void regist(String interfaceName, Class interfaceClass) {
        registerList.put(interfaceName, interfaceClass);
    }

    public static Class getInterfaceClass (String interfaceName) {
        return registerList.get(interfaceName);
    }

}
