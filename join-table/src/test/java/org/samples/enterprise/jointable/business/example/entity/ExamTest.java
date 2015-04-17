/*
 * Copyright (C) 2015 mmontel
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package org.samples.enterprise.jointable.business.example.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mmontel
 */
public class ExamTest {
    private EntityManager em;
    private EntityTransaction tx;
    
    public ExamTest() {
    }
    
    @Before
    public void setUp() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("it");
        this.em = emf.createEntityManager();
        this.tx = this.em.getTransaction();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSomeMethod() {
        tx.begin();
        Exam exam1 = new Exam();
        exam1.setDescription("Some examination 1 description");
        exam1.setVisitDate(new Date());
        em.persist(exam1);

        Exam exam2 = new Exam();
        exam2.setDescription("Some examination 2 description");
        exam2.setVisitDate(new Date());
        em.persist(exam2);
        
        Report report1 = new Report();
        report1.setText("Some examination 1 and 2 Report description");
        em.persist(report1);
        
        exam1.addReport(report1);
        exam2.addReport(report1);
        
        tx.commit();
        
        // Test
        
        tx.begin();
        
        Query examReportNativeQuery = em.createNativeQuery("SELECT * from EXAM_REPORT");
        List examReportsJoinTable = examReportNativeQuery.getResultList();
        assertTrue(examReportsJoinTable.size() == 2);

        List<Exam> exams = em.createQuery("SELECT e FROM Exam e", Exam.class).getResultList();

        for (Exam exam : exams) {
            assertTrue(exam.getDescription().equalsIgnoreCase("Some examination " + exam.getId() + " description"));
            List<Report> reports = exam.getReports();
            assertTrue(reports.size() == 1);
            Report report = reports.get(0);
            assertTrue(report.getText().equalsIgnoreCase("Some examination 1 and 2 Report description"));
        }
        
        tx.commit();
        
    }
    
}
