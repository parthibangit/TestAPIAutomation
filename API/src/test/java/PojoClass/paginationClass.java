package PojoClass;

public class paginationClass {
	
    private String total;
    private String pages;
    private String page;
    private String limit;
    
	public String getTotal() {
		return total;
	}
	
	public String getPages() {
		return pages;
	}

	public String getPage() {
		return page;
	}

	public String getLimit() {
		return limit;
	}
	
	@Override
	public String toString() {
		return "paginationClass [total=" + total + ", pages=" + pages + ", page=" + page + ", limit=" + limit + "]";
	}


}
