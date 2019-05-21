package com.utilapi.controller.response;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created by dagomanzano on 15/01/18.
 */
public class PrintWriteResponse extends PrintWriter {
    private Writer out;
    public PrintWriteResponse(Writer out) {
        super(out);
        this.out = out;
   }

    public StringWriter getStringWriter(){
        return (StringWriter) this.out;
    }


}
