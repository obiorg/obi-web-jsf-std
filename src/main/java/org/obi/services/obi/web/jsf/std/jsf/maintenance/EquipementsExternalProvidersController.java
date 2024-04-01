package org.obi.services.obi.web.jsf.std.jsf.maintenance;

import org.obi.services.obi.web.jsf.std.entities.maintenance.EquipementsExternalProviders;
import org.obi.services.obi.web.jsf.std.jsf.util.JsfUtil;
import org.obi.services.obi.web.jsf.std.jsf.util.PaginationHelper;
import org.obi.services.obi.web.jsf.std.sessions.maintenance.EquipementsExternalProvidersFacade;

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

@Named("equipementsExternalProvidersController")
@SessionScoped
public class EquipementsExternalProvidersController implements Serializable {

    private EquipementsExternalProviders current;
    private DataModel items = null;
    @EJB
    private org.obi.services.obi.web.jsf.std.sessions.maintenance.EquipementsExternalProvidersFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public EquipementsExternalProvidersController() {
    }

    public EquipementsExternalProviders getSelected() {
        if (current == null) {
            current = new EquipementsExternalProviders();
            selectedItemIndex = -1;
        }
        return current;
    }

    private EquipementsExternalProvidersFacade getFacade() {
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
        current = (EquipementsExternalProviders) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new EquipementsExternalProviders();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.setDeleted(Boolean.FALSE);
            current.setChanged(Date.from(Instant.now()));
            current.setCreated(Date.from(Instant.now()));
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/OBI").getString("EquipementsExternalProvidersCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/OBI").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (EquipementsExternalProviders) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.setChanged(Date.from(Instant.now()));
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/OBI").getString("EquipementsExternalProvidersUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/OBI").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (EquipementsExternalProviders) getItems().getRowData();
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/OBI").getString("EquipementsExternalProvidersDeleted"));
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

    public EquipementsExternalProviders getEquipementsExternalProviders(java.lang.Integer id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = EquipementsExternalProviders.class)
    public static class EquipementsExternalProvidersControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EquipementsExternalProvidersController controller = (EquipementsExternalProvidersController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "equipementsExternalProvidersController");
            return controller.getEquipementsExternalProviders(getKey(value));
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
            if (object instanceof EquipementsExternalProviders) {
                EquipementsExternalProviders o = (EquipementsExternalProviders) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + EquipementsExternalProviders.class.getName());
            }
        }

    }

}
