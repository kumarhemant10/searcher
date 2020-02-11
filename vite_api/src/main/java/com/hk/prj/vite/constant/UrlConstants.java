package com.hk.prj.vite.constant;

public class UrlConstants {

	 private UrlConstants() {
		 throw new IllegalStateException("Utility class");
	 }
	 
	public static final  String V1_API_BASE = "/v1/api";
    
	public static final  String INDICES = V1_API_BASE+"/indices";
    public static final  String INDICES_BY_ID = INDICES+"/{id}";
    
    public static final  String COLUMNS= INDICES_BY_ID+"/columns";
    public static final  String COLUMNS_BY_ID= COLUMNS+"/{id}";
    
    public static final  String INDEX_DATA_BY_ID= "/indices/{id}/data";

}
