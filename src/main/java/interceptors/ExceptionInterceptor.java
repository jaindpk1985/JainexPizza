package interceptors;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import common.UnexpectedException;



public class ExceptionInterceptor extends AbstractInterceptor
{

  private static final long serialVersionUID = 1L;
  static final Logger log = Logger.getLogger(ExceptionInterceptor.class);

  /*
   * (non-Javadoc)
   * @see com.opensymphony.xwork2.interceptor.AbstractInterceptor#intercept(com
   * .opensymphony.xwork2.ActionInvocation) This Method catches the Exception
   * and return Action.ERROR if an Exception Occurred While Invoking Action else
   * normal action execution proceeds.
   */
  @Override
  public String intercept(ActionInvocation invocation) throws UnexpectedException
  {
    try
    {
      invocation.invoke();
      return invocation.invoke();
    }
    catch (UnexpectedException e)
    {
      log.error("An exception caught while executing action "
        + invocation.getInvocationContext().getName() + " action " + "and exception type is :"
        + e.getMessage(), e.getExceptionType());
      return Action.ERROR;
    }
    catch (Exception e)
    {
      log.error("An exception caught while executing action "
        + invocation.getInvocationContext().getName() + " action", e);
      return Action.ERROR;
    }
  }
}
