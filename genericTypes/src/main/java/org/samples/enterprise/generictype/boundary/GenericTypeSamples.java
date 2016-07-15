
package org.samples.enterprise.generictype.boundary;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.samples.enterprise.generictype.entity.Employee;
import org.samples.enterprise.generictype.entity.EmployeeKey;

/**
 *
 * @author mmontel
 */
@Path("collections")
public class GenericTypeSamples {
    @GET
    @Path("map")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMap() {
        Map<EmployeeKey, Employee> map = new HashMap<>();
        Employee duke = new Employee();
        EmployeeKey dukeKey = new EmployeeKey();
        duke.setName("duke");
        dukeKey.setKey("1");
        
        map.put(dukeKey, duke);
        GenericEntity<Map<EmployeeKey, Employee>> genericEntity = new GenericEntity<Map<EmployeeKey, Employee>>(map) {};
        return Response.ok(genericEntity).build();
    }
    
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getList() {
        List<Employee> list = new ArrayList<>();
        Employee duke = new Employee();
        duke.setName("duke");
        list.add(duke);
        GenericEntity<List<Employee>> genericEntity = new GenericEntity<List<Employee>>(list) {};
        return Response.ok(genericEntity).build();
    }
    
    @GET
    @Path("date")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getDate() {
        return Response.ok(new Date().toString()).build();
    }
}

