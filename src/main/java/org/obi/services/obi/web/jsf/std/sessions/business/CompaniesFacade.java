/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.obi.services.obi.web.jsf.std.sessions.business;

import org.obi.services.obi.web.jsf.std.sessions.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.obi.services.obi.web.jsf.std.entities.business.Companies;

/**
 *
 * @author r.hendrick
 */
@Stateless
public class CompaniesFacade extends AbstractFacade<Companies> {

    @PersistenceContext(unitName = "OBI_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CompaniesFacade() {
        super(Companies.class);
    }
    
}
