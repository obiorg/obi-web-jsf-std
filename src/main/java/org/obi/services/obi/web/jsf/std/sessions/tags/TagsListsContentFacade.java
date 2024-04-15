package org.obi.services.obi.web.jsf.std.sessions.tags;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.obi.services.obi.web.jsf.std.entities.tags.TagsLists;
import org.obi.services.obi.web.jsf.std.entities.tags.TagsListsContent;
import org.obi.services.obi.web.jsf.std.sessions.Abstract.AbstractFacade;

/**
 *
 * @author r.hendrick
 */
@Stateless
public class TagsListsContentFacade extends AbstractFacade<TagsListsContent> {

    @PersistenceContext(unitName = "OBI_PU")
    private EntityManager em;

    private final String FINDBY_LIST_AND_CONTENT = "TagsListsContent.findByListAndContent"; //SELECT t FROM TagsListsContent t WHERE t.list = :list AND t.content = :content

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TagsListsContentFacade() {
        super(TagsListsContent.class);
    }

    /**
     * Find By List and Content use following request:
     * <p>
     * SELECT t FROM TagsListsContent t WHERE t.list = :list AND t.content =
     * :content
     *
     * @param tl the list to provide
     * @param content the number of the content to be consider
     * @return the tags list content
     */
    public TagsListsContent findByListAndContent(TagsLists tl, Integer content) {
        em.flush();
        Query q = em.createNamedQuery(FINDBY_LIST_AND_CONTENT)
                .setParameter("list", tl)
                .setParameter("content", content);

        List<TagsListsContent> l = q.getResultList();

        if (l == null) {
            return null;
        }
        if (l.isEmpty()) {
            return null;
        }

        return l.get(0);
    }

}
