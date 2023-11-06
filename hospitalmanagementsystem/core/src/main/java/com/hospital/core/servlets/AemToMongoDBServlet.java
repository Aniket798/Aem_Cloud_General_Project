package com.hospital.core.servlets;

import com.hospital.core.service.AEMToMongoDB;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.logging.Logger;

@Component(
        immediate = true,
        service = Servlet.class,
        property = {
                Constants.SERVICE_DESCRIPTION + "=MongoDB Integration",
                "sling.servlet.methods=" + HttpConstants.METHOD_GET,
                "sling.servlet.paths=" + "/bin/aemToMongo",
                "sling.servlet.extensions={\"json\"}"
        }
)
public class AemToMongoDBServlet extends SlingSafeMethodsServlet {
    private static final Logger LOGGER = Logger.getLogger(AemToMongoDBServlet.class.getName());

    @Reference
    private transient AEMToMongoDB aemToMongoDB;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        String res = aemToMongoDB.writeDataToMongoDB();
        response.getWriter().println(res);
    }
}

