package org.obi.services.obi.web.jsf.std.jsf.locations;

import org.obi.services.obi.web.jsf.std.entities.locations.LocCountries;
import org.obi.services.obi.web.jsf.std.jsf.util.JsfUtil;
import org.obi.services.obi.web.jsf.std.jsf.util.PaginationHelper;
import org.obi.services.obi.web.jsf.std.sessions.locations.LocCountriesFacade;

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

@Named("locCountriesController")
@SessionScoped
public class LocCountriesController implements Serializable {

    private LocCountries current;
    private DataModel items = null;
    @EJB
    private org.obi.services.obi.web.jsf.std.sessions.locations.LocCountriesFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public LocCountriesController() {
    }

    public LocCountries getSelected() {
        if (current == null) {
            current = new LocCountries();
            selectedItemIndex = -1;
        }
        return current;
    }

    private LocCountriesFacade getFacade() {
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
        current = (LocCountries) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new LocCountries();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.setUpdatedAt(Date.from(Instant.now()));
            current.setCreatedAt(Date.from(Instant.now()));
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/OBI").getString("LocCountriesCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/OBI").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (LocCountries) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.setUpdatedAt(Date.from(Instant.now()));
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/OBI").getString("LocCountriesUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/OBI").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (LocCountries) getItems().getRowData();
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/OBI").getString("LocCountriesDeleted"));
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

    public LocCountries getLocCountries(java.lang.Integer id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = LocCountries.class)
    public static class LocCountriesControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            LocCountriesController controller = (LocCountriesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "locCountriesController");
            return controller.getLocCountries(getKey(value));
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
            if (object instanceof LocCountries) {
                LocCountries o = (LocCountries) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + LocCountries.class.getName());
            }
        }

    }

}
