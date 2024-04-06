package org.obi.services.obi.web.jsf.std.jsf.util;

import javax.faces.model.DataModel;

public abstract class PaginationHelper {

    private int pageSize;
    private int page;

    public PaginationHelper(int pageSize) {
        this.pageSize = pageSize;
    }

    public abstract int getItemsCount();

    public abstract DataModel createPageDataModel();

    public int getPageFirstItem() {
        return page * pageSize;
    }

    public int getPageLastItem() {
        int i = getPageFirstItem() + pageSize - 1;
        int count = getItemsCount() - 1;
        if (i > count) {
            i = count;
        }
        if (i < 0) {
            i = 0;
        }
        return i;
    }

    public boolean isHasNextPage() {
        return (page + 1) * pageSize + 1 <= getItemsCount();
    }

    /**
     * Check if a next page by count from active page exit.
     *
     * Ex: if active page is 5 :
     *
     * if count = 1 => 5+1 = 6 => does page 6 exist ? yes smaller than
     * getItemsCount()
     *
     * @see PaginationHelper#isHasNextPage()
     * @see PaginationHelper#isHasPreviousPage()
     *
     * @param count page step from active page
     * @return true if next page from count exist
     */
    public boolean isHasNextPage(int count) {
        return (page + count) * pageSize + 1 <= getItemsCount();
    }

    public void nextPage() {
        if (isHasNextPage()) {
            page++;
        }
    }

    /**
     * Access next Page
     *
     * Go to next page define by count from active page
     *
     * @see PaginationHelper#nextPage()
     * @see PaginationHelper#isHasNextPage(int)
     *
     * @param count page from which to see from active page
     */
    public void nextPage(int count) {
        if (isHasNextPage(count)) {
            page += count;
        }
    }

    public boolean isHasPreviousPage() {
        return page > 0;
    }

    /**
     * Check if a previous page by count from active page exit.
     *
     * Ex: if active page is 5 :
     *
     * if count = 1 => 5-1 = 4 => does page 4 exist ? yes bigger than 0
     *
     * @see PaginationHelper#isHasPreviousPage()
     * @see PaginationHelper#isHasNextPage()
     *
     * @param count page step from active page
     * @return true if previous page from count exist
     */
    public boolean isHasPreviousPage(int count) {
        return (page - count) > 0;
    }

    public void previousPage() {
        if (isHasPreviousPage()) {
            page--;
        }
    }

    /**
     * Access previous Page
     *
     * Go to previous page define by count from active page
     *
     * @see PaginationHelper#previousPage()
     * @see PaginationHelper#isHasPreviousPage(int)
     *
     * @param count page from which to see from active page
     */
    public void previousPage(int count) {
        if (isHasPreviousPage(count)) {
            page -= count;
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPage() {
        return page;
    }

    public void firstPage() {
        if (getItemsCount()>0) {
            page = 0;
        }
    }    

    public void lastPage() {
        if (getItemsCount()>0) {
            int nbpp = (int) Math.floor((getItemsCount()-1) / pageSize);
            page = nbpp;
        }
    }

}
