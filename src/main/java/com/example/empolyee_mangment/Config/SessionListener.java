package com.example.empolyee_mangment.Config;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@Slf4j
public class SessionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent event) {
try{
    event.getSession().setMaxInactiveInterval(60*60);
}catch (Exception e){
    log.error("Exception while getting the Max Inactive Interval " + e);
}

    }
    public void sessionDestroyed(HttpSessionEvent event) {

        log.warn("==== Session is destroyed ====");
    }
}
