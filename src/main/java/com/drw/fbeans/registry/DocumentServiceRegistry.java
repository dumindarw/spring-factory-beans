package com.drw.fbeans.registry;

public interface DocumentServiceRegistry {

    <T> DocumentAdapterService<T> getService(String service);
}
