package org.obi.services.obi.web.jsf.std.jsf.analyses;

import org.obi.services.obi.web.jsf.std.entities.analyses.AnalyseMethods;
import org.obi.services.obi.web.jsf.std.jsf.util.JsfUtil;
import org.obi.services.obi.web.jsf.std.jsf.util.PaginationHelper;
import org.obi.services.obi.web.jsf.std.sessions.analyses.AnalyseMethodsFacade;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("analyseMethodsController")
@SessionScoped
public class AnalyseMethodsController implements Serializable {

    private AnalyseMethods current;
    private DataModel items = null;
    @EJB
    private org.obi.services.obi.web.jsf.std.sessions.analyses.AnalyseMethodsFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public AnalyseMethodsController() {
    }

    public AnalyseMethods getSelected() {
        if (current == null) {
            current = new AnalyseMethods();
            selectedItemIndex = -1;
        }
        return current;
    }

    private AnalyseMethodsFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (AnalyseMethods) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new AnalyseMethods();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.setDeleted(Boolean.FALSE);
            current.setChanged(Date.from(Instant.now()));
            current.setCreated(Date.from(Instant.now()));
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/OBI").getString("AnalyseMethodsCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/OBI").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (AnalyseMethods) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.setChanged(Date.from(Instant.now()));
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/OBI").getString("AnalyseMethodsUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/OBI").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (AnalyseMethods) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/OBI").getString("AnalyseMethodsDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/OBI").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public AnalyseMethods getAnalyseMethods(java.lang.Integer id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = AnalyseMethods.class)
    public static class AnalyseMethodsControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            AnalyseMethodsController controller = (AnalyseMethodsController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "analyseMethodsController");
            return controller.getAnalyseMethods(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof AnalyseMethods) {
                AnalyseMethods o = (AnalyseMethods) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + AnalyseMethods.class.getName());
            }
        }

    }

}
