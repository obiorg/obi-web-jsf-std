package org.obi.services.obi.web.jsf.std.sessions.tags;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.obi.services.obi.web.jsf.std.entities.tags.TagsLists;
import org.obi.services.obi.web.jsf.std.sessions.Abstract.AbstractFacade;

/**
 *
 * @author r.hendrick
 */
@Stateless
public class TagsListsFacade extends AbstractFacade<TagsLists> {

    @PersistenceContext(unitName = "OBI_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TagsListsFacade() {
        super(TagsLists.class);
    }
    
}
