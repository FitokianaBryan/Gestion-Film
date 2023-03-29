package com.aina.spring_mvc.fonction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Research {
    private StringBuilder buffer;
    private List<Object> obj;
    private boolean bool;

    public Research() {

    }
    public Research(String requete) {
        this.buffer = new StringBuilder(requete);
        this.obj = new ArrayList<Object>();
        this.bool = requete.matches("(?i)^.*?\\swhere\\s.*?$");
    }

    private String WhereOrAnd() {
        String str = this.bool ? " and " : " where ";
        this.bool = true;
        return str;
    }

    public void add(boolean bool, String request, Object obj) {
        if(bool) {
            if(!request.contains("limit") && !request.contains("offset")) {
                this.buffer.append(WhereOrAnd());
            }
            this.buffer.append(request);
            this.obj.add(obj);
        }
    }

    public PreparedStatement newStatement(Connection con) throws SQLException, ParseException {
        PreparedStatement stm = con.prepareStatement(this.buffer.toString());
        int i = 1;
        for(Object obj : this.obj) {
            if(obj instanceof java.util.Date) {
                stm.setDate(i, new java.sql.Date(((java.util.Date) obj).getTime()));
            }
            else {
                stm.setObject(i, obj);
            }
            i++;
        }
        return stm;
    }
}
