package org.example.myapp.exception.mapper;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.lang3.exception.ExceptionUtils;

@Provider
public class GlobalExceptionMapper implements ExceptionMapper<Throwable> {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public Response toResponse(Throwable ex) {
        logger.error(makeLogString(ex));

        return Response.status(getStatusType(ex))
                        .type(MediaType.TEXT_HTML)
                        .build();
    }

    private String makeLogString(Throwable ex) {
        StringBuilder logString = new StringBuilder();
        logString.append("[Exception message] ");
        logString.append(ex.getMessage());
        logString.append(System.getProperty("line.separator"));
        logString.append("[Stack trace] ");
        logString.append(ExceptionUtils.getStackTrace(ex));
        return logString.toString();
    }

    private Response.StatusType getStatusType(Throwable ex) {
        if (ex instanceof WebApplicationException) {
            return((WebApplicationException)ex).getResponse().getStatusInfo();
        } else {
            return Response.Status.INTERNAL_SERVER_ERROR;
        }
    }
}
