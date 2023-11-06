package com.hospital.core.servlets;

import com.hospital.core.service.AddPatientDetails;
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

@Component(
        immediate = true,
        service = Servlet.class,
        property = {
                Constants.SERVICE_DESCRIPTION + "=Add Patient Details",
                "sling.servlet.methods=" + HttpConstants.METHOD_GET,
                "sling.servlet.paths=" + "/bin/addPatientDetails",
                "sling.servlet.extensions={\"json\"}"
        }
)
public class AddPatientDetailsServlet extends SlingSafeMethodsServlet {

    @Reference
    AddPatientDetails addPatientDetails;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {

        String patientName = request.getParameter("patientName");
        String patientId = request.getParameter("patientId");
        String assignedRoomNumber = request.getParameter("assignedRoomNumber");
        String res = addPatientDetails.addPatientDetails(patientName, patientId, assignedRoomNumber);
        if(res != null) {
            response.setStatus(200);
        } else {
            response.setStatus(400);
        }
        response.setContentType("text/plain");
        response.getWriter().println(res);
    }
}
