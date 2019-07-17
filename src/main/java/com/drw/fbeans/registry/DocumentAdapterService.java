package com.drw.fbeans.registry;


public interface DocumentAdapterService<T> {
    String upload(T request);
    String download(String name);
}
