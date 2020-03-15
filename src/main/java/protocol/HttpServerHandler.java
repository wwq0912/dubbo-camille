package protocol;

import framework.Invocation;
import org.apache.commons.io.IOUtils;
import provider.LocalRegister;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;

public class HttpServerHandler {
    public void handler(HttpServletRequest req, HttpServletResponse res) {
        // 通过请求的接口 找到对应的实现类。 使用反射调用用户真正想调用的方法
        try {
            InputStream is = req.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            Invocation invocation = (Invocation)ois.readObject();

            Class implClass = LocalRegister.getInterfaceClass(invocation.getInterfaceName());
            Method method = implClass.getMethod(invocation.getMethodName(),invocation.getParamTypes());
            String result = (String) method.invoke(implClass.newInstance(),invocation.getParams());
            IOUtils.write(result, res.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
