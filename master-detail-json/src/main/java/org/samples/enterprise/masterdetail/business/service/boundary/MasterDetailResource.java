/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.samples.enterprise.masterdetail.business.service.boundary;

import org.samples.enterprise.masterdetail.business.service.entity.Detail;
import org.samples.enterprise.masterdetail.business.service.entity.Master;
import org.samples.enterprise.masterdetail.business.service.entity.MasterDTO;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author mmontel
 */
@Stateless
@Path("master")
public class MasterDetailResource {
    @PersistenceContext
    EntityManager em;
    
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getMasters() {
        List<Master> masters = em.createNamedQuery("findAllMasters", Master.class).getResultList();
        return Response.ok(masters).build();
    }
    
    @Path("dto")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getMasterDTO() {
        List<MasterDTO> masterDTOs = em.createNamedQuery("findAllMasterDTOs", MasterDTO.class).getResultList();
        
        return Response.ok(masterDTOs).build();
    }
    
    @Path("create")
    @POST
    public void create() {
        Master master = new Master();
        master.setName("first master");
        master.setDescription("This is the first master");
        master.setStartDate(new Date());
        master.setStopDate(new Date());
        
        Detail detail = new Detail();
        detail.setName("first detail");
        detail.setAddress("infinite loop");
        detail.setCity("Cupertino");
        detail.setCountry("California");
        
        master.addDetail(detail);
        
        Detail detail2 = new Detail();
        detail2.setName("second detail");
        detail2.setAddress("infinite loop");
        detail2.setCity("Cupertino");
        detail2.setCountry("California");
        
        master.addDetail(detail2);
        
        em.persist(master);
    }
}
