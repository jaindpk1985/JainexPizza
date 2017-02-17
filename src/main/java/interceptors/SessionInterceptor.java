package interceptors;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class SessionInterceptor implements Interceptor {
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void init() {
		// TODO Auto-generated method stub
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		 Map session = invocation.getInvocationContext().getSession();
		 	Object userId = 	session.get("userId");
		 	if(userId ==null){
		 		return "login";
		 	}
		    //if (session.isEmpty()) return "login";
		    return invocation.invoke();
	}

}
