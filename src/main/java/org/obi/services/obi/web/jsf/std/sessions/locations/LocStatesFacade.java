/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.obi.services.obi.web.jsf.std.sessions.locations;

import org.obi.services.obi.web.jsf.std.sessions.Abstract.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.obi.services.obi.web.jsf.std.entities.locations.LocStates;

/**
 *
 * @author r.hendrick
 */
@Stateless
public class LocStatesFacade extends AbstractFacade<LocStates> {

    @PersistenceContext(unitName = "OBI_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LocStatesFacade() {
        super(LocStates.class);
    }
    
}
