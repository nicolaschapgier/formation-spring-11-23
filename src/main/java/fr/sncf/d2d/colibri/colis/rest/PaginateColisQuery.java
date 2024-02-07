package fr.sncf.d2d.colibri.colis.rest;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class PaginateColisQuery {
    
    @Min(0)
    private long page = 0;

    @Min(1)
    @Max(100)
    private long itemsPerPage = 10;

    public long getPage() {
        return this.page;
    }

    public void setPage(long page) {        
        this.page = page;
    }

    public long getItemsPerPage() {
        return this.itemsPerPage;
    }

    public void setItemsPerPage(long itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }
}
