/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.controller;

import java.util.List;

/**
 *
 * @author MS
 */
public class ApiBaseController {
    protected int statusCode = 200;
    
    protected String data_not_found_message="Data not Found";
    
    protected String validation_error_message = "Bad Input.Try Again!";
    
    protected String internal_error_message="Internal Server Error";

    /**
     * @return mixed
     */
    public int getStatusCode()
    {
        return statusCode;
    }

    /**
     * @param mixed $statusCode
     */
    public int setStatusCode(int statusCode)
    {
        this.statusCode = statusCode;
        return this.getStatusCode();
    }

    /**
     * @param string $message
     * @return mixed
     */
    public String respondNotFound(String data_not_found_message)
    {
        return this.respondWithError(data_not_found_message,404);
    }

    public String respondValidationError(String validation_error_message)
    {
        return this.respondWithError(validation_error_message,400);
    }
    
    public String respondInternalError(String internal_error_message)
    {
        return respondWithError(internal_error_message,500);
    }

    public String respondWithError(String message, int status_code)
    {
    	String error_bundle = "{\"error\":{\"message\":\""+message+"\",\"status_code\":\""+status_code+"\"}}";
        return error_bundle;

    }
    
    public String respondWithError(String message)
    {
    	int status_code=this.setStatusCode(500);
    	String error_bundle = "{\"error\":{\"message\":\""+message+"\",\"status_code\":\""+status_code+"\"}}";
        return error_bundle;

    }

    
    public String respondWithMessage(String message, List data)
    {
    	String data_bundle="{\"message\":\""+message+"\",\"data\":"+data+"}";
        return data_bundle;
    }
    public String respondWithMessage(String message, Object data)
    {
    String data_bundle="{\"message\": \""+message+"\",\"data\": \""+data+"\"}";
    return data_bundle;
    }
     public String respondWithMessage(String message, String data)
    {
    	String data_bundle="{\"message\":\""+message+"\",\"data\":"+data+"}";
        return data_bundle;
    }
       public String respondWithMessage(String message)
    {
    	String data_bundle="{\"message\":\""+message+"\"}";
        return data_bundle;
    }
}
