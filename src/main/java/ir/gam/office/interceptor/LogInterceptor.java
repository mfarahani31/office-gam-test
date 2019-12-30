package ir.gam.office.interceptor;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Component
public class LogInterceptor implements HandlerInterceptor {
    private final org.slf4j.Logger Logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Logger.info("\n\n\n----------------LogInterceptor PreHandle (Start)--------------------------");

        Logger.info("IP         : {}", request.getRemoteAddr());
        Logger.info("URI         : {}", request.getRequestURI());
        Logger.info("Method      : {}", request.getMethod());
        Logger.info("Headers     : {}", request.getHeaderNames());
        Logger.info("Request Processing starts on : {}", getCurrentTime());


        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime); //inject new attribute 'startTime' in request header
        Logger.info("----------------LogInterceptor PreHandle(End)--------------------------");
        //responseHeader can be modified similarly as per need

        // TODO : Example for redirect interceptor
        /*Take action base on incoming IP
        Suppose you want to redirect all ip to auth-failed which ip value starts with "192"
        */
        if (request.getRemoteAddr().startsWith("192")) {
            response.sendRedirect("/error"); //redirect to default
            return false; //returning false ensure that the request is not further required to be intercepted,
            // response is directly send to the user hereafter.
        }
        return true;
        //return new LogInterceptor().preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        Logger.info("\n\n\n----------------LogInterceptor postHandle (Start)--------------------------");

        Logger.info("Status code  : {}", response.getStatus());
        Logger.info("Headers      : {}", response.getHeaderNames());
        Logger.info("Request Processing ends on  : {}", getCurrentTime());
        //Logger.info("Response body: {}", StreamUtils.copyToString(response.toString(), Charset.defaultCharset()));
        Logger.info("----------------LogInterceptor postHandle (End)--------------------------");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        Logger.info("\n\n\n----------------LogInterceptor after view is rendered (Start)--------------------------");

        long endTime = System.currentTimeMillis();
        long startTime = Long.parseLong(request.getAttribute("startTime") + "");
        Logger.info("Total time taken to process request (in milliseconds(ms)) : {} ", (endTime - startTime) + " ms");
        Logger.info("----------------LogInterceptor after view is rendered (End)--------------------------");
    }

    private String getCurrentTime() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy 'at' hh:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        return formatter.format(calendar.getTime());
    }
}
