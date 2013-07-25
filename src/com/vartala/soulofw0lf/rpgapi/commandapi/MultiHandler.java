package com.vartala.soulofw0lf.rpgapi.commandapi;

public interface MultiHandler {
    /**
     *
     * @param info
     * @throws MultiException
     */
    public void handle(SubInfo info) throws MultiException;
    //
}
