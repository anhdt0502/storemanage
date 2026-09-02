package com.ministore;

import com.ministore.controller.HomeServlet;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws Exception {

        Tomcat tomcat = new Tomcat();

        tomcat.setPort(8080);
        tomcat.getConnector();
        String webappPath = Paths
                .get("src/main/webapp")
                .toAbsolutePath()
                .toString();

        Context context = tomcat.addContext("", webappPath);

        Tomcat.addServlet(
                context,
                "homeServlet",
                new HomeServlet()
        );

        context.addServletMappingDecoded(
                "/home",
                "homeServlet"
        );


        tomcat.start();

        System.out.println(
                "Mini Store running at http://localhost:8080"
        );

        tomcat.getServer().await();
    }
}