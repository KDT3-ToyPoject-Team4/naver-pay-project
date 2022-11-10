package org.toyproject.service;

public class ActionForward {
    private String path;
    private boolean isRedirect;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isRedirect() {
        return isRedirect;
    }

    public void setRedirect(boolean redirect) {
        isRedirect = redirect;
    }

    @Override
    public String toString() {
        return "ActionForward [path=" + path + ", isRedirect=" + isRedirect + "]";
    }
}
