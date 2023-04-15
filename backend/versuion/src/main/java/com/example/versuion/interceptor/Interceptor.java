package com.example.versuion.interceptor;

import org.hibernate.EmptyInterceptor;
import org.slf4j.MDC;
import org.springframework.util.StringUtils;

public class Interceptor extends EmptyInterceptor {

    /*public String onPrepareStatement(String sql) {
        if (StringUtils.hasLength(sql) && sql.toLowerCase().startsWith("select")) {

            final String entityName = sql.substring(7, sql.indexOf("."));
            final String idEntreprise = MDC.get("idEntreprise");

            if (StringUtils.hasLength(entityName)
                    && !entityName.toLowerCase().contains("entreprise")
                    && !entityName.toLowerCase().contains("roles")
                    && StringUtils.hasLength(idEntreprise)) {

                if (sql.contains("where")) {
                    sql = sql + " and " + entityName + ".identreprise = " + idEntreprise;
                } else {
                    sql = sql + " where " + entityName + ".identreprise = " + idEntreprise;
                }
            }
        }
        return super.onPrepareStatement(sql);
    }*/
}
